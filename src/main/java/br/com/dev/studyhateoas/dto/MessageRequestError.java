package br.com.dev.studyhateoas.dto;

public class MessageRequestError {

	private String message;
	
	public MessageRequestError(){}

	
	public MessageRequestError(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
