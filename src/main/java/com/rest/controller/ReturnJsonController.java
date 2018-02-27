package com.rest.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/post", 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JsonResponse processFormStuff(@RequestHeader HttpHeaders headers, HttpServletRequest request) {

		// do something with form variables, then return

		JsonResponse result = new JsonResponse();
		Map<String, String> args = new TreeMap<>();

		Map<String, String> files = new TreeMap<>();

		Map<String, String> form = new TreeMap<>((Comparator<String>) (o1, o2) -> o1.compareTo(o2));

		for (String key : request.getParameterMap().keySet()) {
			form.put(key, request.getParameterMap().get(key)[0]);
		}
		
		logger.info(request.getRemoteHost());


		Map<String, String> hdrs = new TreeMap<>();
		for (Entry<String, List<String>> mvm : headers.entrySet()) {
			hdrs.put(mvm.getKey(), mvm.getValue().get(0));
		}

		// LinkedHashMap<String, String> json = new LinkedHashMap<>();
		// json.put("json", "");

		// LinkedHashMap<String, String> origin = new LinkedHashMap<>();
		// origin.put("origin", headers.getOrigin());

		 Map<String, String> url = new TreeMap<>();
		 url.put("url", request.getRequestURL().toString());

		// result.set
		result.setArgs(args);
		result.setFiles(files);
		result.setForm(form);
		result.setHeaders(hdrs);
		result.setJson(null);
		result.setOrigin(request.getHeader("origin"));
		result.setUrl(request.getRequestURL().toString());
		return result;
	}
}
