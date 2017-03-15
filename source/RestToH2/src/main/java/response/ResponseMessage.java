package response;

public class ResponseMessage {

	private String message;
	
	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getResponse() {
		return message;
	}

	public void setResponse(String message) {
		this.message = message;
	}
}
