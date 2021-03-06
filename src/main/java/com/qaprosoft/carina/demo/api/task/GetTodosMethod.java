package com.qaprosoft.carina.demo.api.task;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/todos", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/todos/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetTodosMethod extends AbstractApiMethodV2 {
	public GetTodosMethod() {
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
}
