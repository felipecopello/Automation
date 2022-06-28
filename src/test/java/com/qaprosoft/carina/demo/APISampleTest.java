/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.demo.api.DeleteCommentMethod;
import com.qaprosoft.carina.demo.api.DeletePostMethod;
import com.qaprosoft.carina.demo.api.GetCommentsMethod;
import com.qaprosoft.carina.demo.api.GetPostsMethod;
import com.qaprosoft.carina.demo.api.GetTodosMethod;
import com.qaprosoft.carina.demo.api.PatchTodoMethod;
import com.qaprosoft.carina.demo.api.PostCommentMethod;
import com.qaprosoft.carina.demo.api.PostPostMethod;
import com.qaprosoft.carina.demo.api.PostTodoMethod;
import com.qaprosoft.carina.demo.api.example.DeleteUserMethod;
import com.qaprosoft.carina.demo.api.example.GetUserMethods;
import com.qaprosoft.carina.demo.api.example.PostUserMethod;

import io.restassured.response.Response;

/**
 * This sample shows how create REST API tests.
 *
 * @author qpsdemo
 */
public class APISampleTest implements IAbstractTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreateUser() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostUserMethod api = new PostUserMethod();
		api.setProperties("api/users/user.properties");

		AtomicInteger counter = new AtomicInteger(0);

		api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
				.until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS)
				.execute();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreateUserMissingSomeFields() throws Exception {
		PostUserMethod api = new PostUserMethod();
		api.setProperties("api/users/user.properties");
		api.getProperties().remove("name");
		api.getProperties().remove("username");
		api.callAPIExpectSuccess();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testGetUsers() {
		GetUserMethods getUsersMethods = new GetUserMethods();
		getUsersMethods.callAPIExpectSuccess();
		getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P1)
	public void testDeleteUsers() {
		DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
		deleteUserMethod.setProperties("api/users/user.properties");
		deleteUserMethod.callAPIExpectSuccess();
		deleteUserMethod.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P1)
	public void testDeletePost() {
		DeletePostMethod deletePostMethod = new DeletePostMethod();
		deletePostMethod.setProperties("api/posts/post.properties");
		deletePostMethod.callAPIExpectSuccess();
		deletePostMethod.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testGetPosts() {
		GetPostsMethod getPostsMethod = new GetPostsMethod();
		getPostsMethod.callAPIExpectSuccess();
		getPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getPostsMethod.validateResponseAgainstSchema("api/posts/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreatePost() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostPostMethod api = new PostPostMethod();
		api.setProperties("api/posts/post.properties");

		AtomicInteger counter = new AtomicInteger(0);

		api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
				.until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS)
				.execute();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreatePostMissingSomeFields() throws Exception {
		PostPostMethod api = new PostPostMethod();
		api.setProperties("api/posts/post.properties");
		api.getProperties().remove("title");
		api.callAPIExpectSuccess();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	@TestPriority(Priority.P1)
	public void testDeleteComment() {
		DeleteCommentMethod deleteCommentMethod = new DeleteCommentMethod();
		deleteCommentMethod.setProperties("api/comments/comment.properties");
		deleteCommentMethod.callAPIExpectSuccess();
		deleteCommentMethod.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testGetComments() {
		GetCommentsMethod getCommentsMethod = new GetCommentsMethod();
		getCommentsMethod.callAPIExpectSuccess();
		getCommentsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getCommentsMethod.validateResponseAgainstSchema("api/comments/_get/rs.schema");
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreateComment() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostCommentMethod api = new PostCommentMethod();
		api.setProperties("api/comments/comment.properties");

		AtomicInteger counter = new AtomicInteger(0);

		api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
				.until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS)
				.execute();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreateCommentMissingSomeFields() throws Exception {
		PostCommentMethod api = new PostCommentMethod();
		api.setProperties("api/comments/comment.properties");
		api.getProperties().remove("email");
		api.callAPIExpectSuccess();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testPatchTodo() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostTodoMethod api = new PostTodoMethod();
		api.setProperties("api/todos/todo.properties");

		AtomicInteger counter = new AtomicInteger(0);

		api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
				.until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS)
				.execute();
		api.validateResponse();

		PatchTodoMethod apiPatch = new PatchTodoMethod();
		apiPatch.setProperties("api/todos/todo.properties");
		apiPatch.callAPIExpectSuccess();
		apiPatch.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testCreateTodo() throws Exception {
		LOGGER.info("test");
		setCases("4555,54545");
		PostTodoMethod api = new PostTodoMethod();
		api.setProperties("api/todos/todo.properties");

		AtomicInteger counter = new AtomicInteger(0);

		api.callAPIWithRetry().withLogStrategy(APIMethodPoller.LogStrategy.ALL).peek(rs -> counter.getAndIncrement())
				.until(rs -> counter.get() == 4).pollEvery(1, ChronoUnit.SECONDS).stopAfter(10, ChronoUnit.SECONDS)
				.execute();
		api.validateResponse();
	}

	@Test()
	@MethodOwner(owner = "qpsdemo")
	public void testGetTodos() {
		GetTodosMethod getTodosMethod = new GetTodosMethod();
		getTodosMethod.callAPIExpectSuccess();
		getTodosMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
		getTodosMethod.validateResponseAgainstSchema("api/todos/_get/rs.schema");
		Response response = getTodosMethod.callAPI();
		ReadContext ctx = JsonPath.parse(response.getBody());
		List<String> todos = ctx.read("$..*");
		todos.forEach(t -> LOGGER.info(t));
	}
}
