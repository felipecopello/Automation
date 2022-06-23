package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/todos/201", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/todos/_patch/rq.json")
@ResponseTemplatePath(path = "api/todos/_patch/rs.schema")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchTodoMethod extends AbstractApiMethodV2 {
	public PatchTodoMethod() {
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
}
