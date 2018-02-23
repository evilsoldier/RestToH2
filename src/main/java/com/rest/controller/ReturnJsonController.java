package com.rest.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import response.JsonResponse;

@RestController
public class ReturnJsonController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@RequestMapping(method = RequestMethod.POST, value = "/post", consumes = org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE,
	produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse processFormStuff(@RequestHeader HttpHeaders headers,
			@RequestBody final MultiValueMap<String, String> formVars) {

		// do something with form variables, then return

		JsonResponse result = new JsonResponse();
		LinkedHashMap<String, String> args = new LinkedHashMap<>();

		LinkedHashMap<String, String> files = new LinkedHashMap<>();

		LinkedHashMap<String, String> form = new LinkedHashMap<>();
		for (Entry<String, List<String>> multiValueMap : formVars.entrySet()) {
			form.put(multiValueMap.getKey(), multiValueMap.getValue().get(0));
		}

		LinkedHashMap<String, String> hdrs = new LinkedHashMap<>();
		for (Entry<String, List<String>> mvm : headers.entrySet()) {
			hdrs.put(mvm.getKey(), mvm.getValue().get(0));
		}

		// LinkedHashMap<String, String> json = new LinkedHashMap<>();
		// json.put("json", "");

		// LinkedHashMap<String, String> origin = new LinkedHashMap<>();
		// origin.put("origin", headers.getOrigin());

		// LinkedHashMap<String, String> url = new LinkedHashMap<>();
		// url.put("url", headers.getLocation().toString());

		// result.set
		result.setArgs(args);
		result.setFiles(files);
		result.setForm(form);
		result.setHeaders(hdrs);
		result.setJson(null);
		result.setOrigin(null);
		result.setUr(null);
		return result;
	}
}
