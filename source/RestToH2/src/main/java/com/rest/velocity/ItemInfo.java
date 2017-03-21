package com.rest.velocity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2750885479297781200L;

	@Id
	private String itm_id;

	private String cage_itm;

	private String ship_alone_ind;

	private String brkbl_ind;

	public ItemInfo() {
		super();
	}

	public ItemInfo(String itm_id, String cage_itm, String ship_alone_ind, String brkbl_ind) {
		super();
		this.itm_id = itm_id;
		this.cage_itm = cage_itm;
		this.ship_alone_ind = ship_alone_ind;
		this.brkbl_ind = brkbl_ind;
	}

	public String getItm_id() {
		return itm_id;
	}

	public void setItm_id(String itm_id) {
		this.itm_id = itm_id;
	}

	public String getCage_itm() {
		return cage_itm;
	}

	public void setCage_itm(String cage_itm) {
		this.cage_itm = cage_itm;
	}

	public String getShip_alone_ind() {
		return ship_alone_ind;
	}

	public void setShip_alone_ind(String ship_alone_ind) {
		this.ship_alone_ind = ship_alone_ind;
	}

	public String getBrkbl_ind() {
		return brkbl_ind;
	}

	public void setBrkbl_ind(String brkbl_ind) {
		this.brkbl_ind = brkbl_ind;
	}
}
