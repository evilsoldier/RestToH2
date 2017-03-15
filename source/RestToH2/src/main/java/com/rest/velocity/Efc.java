package com.rest.velocity;

import java.io.Serializable;

public class Efc implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5179722747622824019L;

	private String id;
	private String velocity;

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
