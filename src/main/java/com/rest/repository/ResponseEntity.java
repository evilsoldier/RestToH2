package com.rest.repository;

import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
@ResponseBody
public interface ResponseEntity<String> {
	
	ResponseEntity<String> processFormStuff(@RequestBody final MultiValueMap<String, String > formVars );

}
