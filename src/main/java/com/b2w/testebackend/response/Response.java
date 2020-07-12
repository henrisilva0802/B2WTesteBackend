package com.b2w.testebackend.response;

public class Response {
	private Integer typeResponse;
	private String message;

	public Response(Integer typeResponse, String message) {
		super();
		this.typeResponse = typeResponse;
		this.message = message;
	}

	public Integer getTypeResponse() {
		return typeResponse;
	}

	public void setTypeResponse(Integer typeResponse) {
		this.typeResponse = typeResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
