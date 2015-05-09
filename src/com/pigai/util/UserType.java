package com.pigai.util;

public enum UserType {
	TEACHER(1, "教师"), STUDENT(0, "学生");
	private String description;

	private UserType(Integer code, String description) {
		this.description = description;
		this.code = code;
	}

	private Integer code;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
