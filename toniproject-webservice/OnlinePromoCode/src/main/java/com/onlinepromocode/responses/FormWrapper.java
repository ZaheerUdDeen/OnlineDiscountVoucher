package com.onlinepromocode.responses;

import java.util.List;

import com.onlinepromocode.entities.Form;

public class FormWrapper {

	private List<Form> form;
	private String responseMessage;
	private String responseCode;
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public List<Form> getForm() {
		return form;
	}
	public void setForm(List<Form> form) {
		this.form = form;
	}
}
