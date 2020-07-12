package com.b2w.testebackend.response;

public enum TypeResponseEnum {

	SUCESS(0), INFO(1), ALERT(2), ERROR(3);

	private int value;

	private TypeResponseEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
