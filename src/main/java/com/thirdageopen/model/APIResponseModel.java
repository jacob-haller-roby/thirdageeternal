package com.thirdageopen.model;

public class APIResponseModel {

	private String status;
	private Object returnObject;
	
	public APIResponseModel(Boolean success) {
		super();
		if(success){
			this.status = "success";
		} else {
			this.status = "failure";
		}
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
	
	
}
