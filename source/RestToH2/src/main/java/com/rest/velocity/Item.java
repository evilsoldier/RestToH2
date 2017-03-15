package com.rest.velocity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -784121363114915838L;

	@Id
//	@GeneratedValue
//	private Long id;
	private String itemId;
	private Efc efc;
	
	public Item() {
		super();
	}

	public Item(String itemId, Efc efc) {
		super();
		this.itemId = itemId;
		this.efc = efc;
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Efc getEfc() {
		return efc;
	}

	public void setEfc(Efc efc) {
		this.efc = efc;
	}
}
