package response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonResponse {

	@JsonProperty
	private Map<String, String> args;

	@JsonProperty
	private Map<String, String> data;

	@JsonProperty
	private Map<String, String> files;

	@JsonProperty
	private Map<String, String> form;

	@JsonProperty
	private Map<String, String> headers;

	@JsonProperty
	private Map<String, String> json;

	@JsonProperty
	private Map<String, String> origin;

	@JsonProperty
	private Map<String, String> ur;

	public Map<String, String> getForm() {
		return form;
	}

	public void setForm(Map<String, String> form) {
		this.form = form;
	}

	public Map<String, String> getArgs() {
		return args;
	}

	public void setArgs(Map<String, String> args) {
		this.args = args;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public Map<String, String> getFiles() {
		return files;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String> getJson() {
		return json;
	}

	public void setJson(Map<String, String> json) {
		this.json = json;
	}

	public Map<String, String> getOrigin() {
		return origin;
	}

	public void setOrigin(Map<String, String> origin) {
		this.origin = origin;
	}

	public Map<String, String> getUr() {
		return ur;
	}

	public void setUr(Map<String, String> ur) {
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
