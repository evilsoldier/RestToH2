package response;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonResponse {

	@JsonProperty
	private LinkedHashMap<String, String> args;
	
	@JsonProperty
	private LinkedHashMap<String, String> data;
	
	@JsonProperty
	private LinkedHashMap<String, String> files;
	
	@JsonProperty
	private LinkedHashMap<String, String> form;
	
	@JsonProperty
	private LinkedHashMap<String, String> headers;
	
	@JsonProperty
	private LinkedHashMap<String, String> json;
	
	@JsonProperty
	private LinkedHashMap<String, String> origin;
	
	@JsonProperty
	private LinkedHashMap<String, String> ur;

	public void setArgs(LinkedHashMap<String, String> args) {
		this.args = args;
	}

	public LinkedHashMap<String, String> getData() {
		return data;
	}

	public void setData(LinkedHashMap<String, String> data) {
		this.data = data;
	}

	public LinkedHashMap<String, String> getFiles() {
		return files;
	}

	public void setFiles(LinkedHashMap<String, String> files) {
		this.files = files;
	}

	public LinkedHashMap<String, String> getForm() {
		return form;
	}

	public void setForm(LinkedHashMap<String, String> form) {
		this.form = form;
	}

	public LinkedHashMap<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(LinkedHashMap<String, String> headers) {
		this.headers = headers;
	}

	public LinkedHashMap<String, String> getJson() {
		return json;
	}

	public void setJson(LinkedHashMap<String, String> json) {
		this.json = json;
	}

	public LinkedHashMap<String, String> getOrigin() {
		return origin;
	}

	public void setOrigin(LinkedHashMap<String, String> origin) {
		this.origin = origin;
	}

	public LinkedHashMap<String, String> getUr() {
		return ur;
	}

	public void setUr(LinkedHashMap<String, String> ur) {
		this.ur = ur;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";
		
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
}
