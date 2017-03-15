package com.rest.velocity;

import java.io.Serializable;

public class Efc implements Serializable {

	private String id;
	private String velocity;

	public Efc() {
		
	}
	
	public Efc(String id, String velocity) {
		this.id = id;
		this.velocity = velocity;
	}

	public String getId() {
		return id;
	}

	public String getVelocity() {
		return velocity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}
}
