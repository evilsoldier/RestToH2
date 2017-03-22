package com.rest.velocity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = -784121363114915838L;

	@Id
	private String itemId;
	private ArrayList<Efc> efcs;
	
	public Item() {
		super();
	}

	public Item(String itemId, ArrayList<Efc> efcs) {
		super();
		this.itemId = itemId;
		this.efcs = efcs;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public ArrayList<Efc> getEfcs() {
		return efcs;
	}

	public void setEfcs(ArrayList<Efc> efcs) {
		this.efcs = efcs;
	}
}
