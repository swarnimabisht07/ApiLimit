package com.techmojo.apilimit.beans;

public class APILimitResponse {

	private boolean status;
	private float time;

	public APILimitResponse(boolean status, float time) {
		super();
		this.status = status;
		this.time = time;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

}
