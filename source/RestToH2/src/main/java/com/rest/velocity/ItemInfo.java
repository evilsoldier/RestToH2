package com.rest.velocity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2750885479297781200L;

	@Id
	private String itemID;
	private String description;
	private String unitHeight;
	private String unitHeightUOM;
	private String unitLength;
	private String unitLengthUOM;
	private String unitWeight;
	private String unitWeightUOM;
	private String unitWidth;
	private String unitWidthUOM;
	private String extnBaggable;
	private String extnBreakable;
	private String extnCageItem;
	private String extnIsPlasticGiftCard;
	private String extnShipAlone;
	private String extnColorDesc;
	private String extnClass;
	private String extnDept;
	private String extnStyle;
	private String extnSubClass;
	private String extnIsVirtualGiftCard;
	private String extnRestrictedShipMethod;
	private String extnWebExclusiveIndicator;
	private String extnWebItem;
	private String hazmatClass;
	private String extnHazmatSubClass;

	public ItemInfo() {
		super();
	}

	public ItemInfo(String itemID, String description, String unitHeight, String unitHeightUOM, String unitLength,
			String unitLengthUOM, String unitWeight, String unitWeightUOM, String unitWidth, String unitWidthUOM,
			String extnBaggable, String extnBreakable, String extnCageItem, String extnIsPlasticGiftCard,
			String extnShipAlone, String extnColorDesc, String extnClass, String extnDept, String extnStyle,
			String extnSubClass, String extnIsVirtualGiftCard, String extnRestrictedShipMethod,
			String extnWebExclusiveIndicator, String extnWebItem, String hazmatClass, String extnHazmatSubClass) {
		super();
		this.itemID = itemID;
		this.description = description;
		this.unitHeight = unitHeight;
		this.unitHeightUOM = unitHeightUOM;
		this.unitLength = unitLength;
		this.unitLengthUOM = unitLengthUOM;
		this.unitWeight = unitWeight;
		this.unitWeightUOM = unitWeightUOM;
		this.unitWidth = unitWidth;
		this.unitWidthUOM = unitWidthUOM;
		this.extnBaggable = extnBaggable;
		this.extnBreakable = extnBreakable;
		this.extnCageItem = extnCageItem;
		this.extnIsPlasticGiftCard = extnIsPlasticGiftCard;
		this.extnShipAlone = extnShipAlone;
		this.extnColorDesc = extnColorDesc;
		this.extnClass = extnClass;
		this.extnDept = extnDept;
		this.extnStyle = extnStyle;
		this.extnSubClass = extnSubClass;
		this.extnIsVirtualGiftCard = extnIsVirtualGiftCard;
		this.extnRestrictedShipMethod = extnRestrictedShipMethod;
		this.extnWebExclusiveIndicator = extnWebExclusiveIndicator;
		this.extnWebItem = extnWebItem;
		this.hazmatClass = hazmatClass;
		this.extnHazmatSubClass = extnHazmatSubClass;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnitHeight() {
		return unitHeight;
	}

	public void setUnitHeight(String unitHeight) {
		this.unitHeight = unitHeight;
	}

	public String getUnitHeightUOM() {
		return unitHeightUOM;
	}

	public void setUnitHeightUOM(String unitHeightUOM) {
		this.unitHeightUOM = unitHeightUOM;
	}

	public String getUnitLength() {
		return unitLength;
	}

	public void setUnitLength(String unitLength) {
		this.unitLength = unitLength;
	}

	public String getUnitLengthUOM() {
		return unitLengthUOM;
	}

	public void setUnitLengthUOM(String unitLengthUOM) {
		this.unitLengthUOM = unitLengthUOM;
	}

	public String getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(String unitWeight) {
		this.unitWeight = unitWeight;
	}

	public String getUnitWeightUOM() {
		return unitWeightUOM;
	}

	public void setUnitWeightUOM(String unitWeightUOM) {
		this.unitWeightUOM = unitWeightUOM;
	}

	public String getUnitWidth() {
		return unitWidth;
	}

	public void setUnitWidth(String unitWidth) {
		this.unitWidth = unitWidth;
	}

	public String getUnitWidthUOM() {
		return unitWidthUOM;
	}

	public void setUnitWidthUOM(String unitWidthUOM) {
		this.unitWidthUOM = unitWidthUOM;
	}

	public String getExtnBaggable() {
		return extnBaggable;
	}

	public void setExtnBaggable(String extnBaggable) {
		this.extnBaggable = extnBaggable;
	}

	public String getExtnBreakable() {
		return extnBreakable;
	}

	public void setExtnBreakable(String extnBreakable) {
		this.extnBreakable = extnBreakable;
	}

	public String getExtnCageItem() {
		return extnCageItem;
	}

	public void setExtnCageItem(String extnCageItem) {
		this.extnCageItem = extnCageItem;
	}

	public String getExtnIsPlasticGiftCard() {
		return extnIsPlasticGiftCard;
	}

	public void setExtnIsPlasticGiftCard(String extnIsPlasticGiftCard) {
		this.extnIsPlasticGiftCard = extnIsPlasticGiftCard;
	}

	public String getExtnShipAlone() {
		return extnShipAlone;
	}

	public void setExtnShipAlone(String extnShipAlone) {
		this.extnShipAlone = extnShipAlone;
	}

	public String getExtnColorDesc() {
		return extnColorDesc;
	}

	public void setExtnColorDesc(String extnColorDesc) {
		this.extnColorDesc = extnColorDesc;
	}

	public String getExtnClass() {
		return extnClass;
	}

	public void setExtnClass(String extnClass) {
		this.extnClass = extnClass;
	}

	public String getExtnDept() {
		return extnDept;
	}

	public void setExtnDept(String extnDept) {
		this.extnDept = extnDept;
	}

	public String getExtnStyle() {
		return extnStyle;
	}

	public void setExtnStyle(String extnStyle) {
		this.extnStyle = extnStyle;
	}

	public String getExtnSubClass() {
		return extnSubClass;
	}

	public void setExtnSubClass(String extnSubClass) {
		this.extnSubClass = extnSubClass;
	}

	public String getExtnIsVirtualGiftCard() {
		return extnIsVirtualGiftCard;
	}

	public void setExtnIsVirtualGiftCard(String extnIsVirtualGiftCard) {
		this.extnIsVirtualGiftCard = extnIsVirtualGiftCard;
	}

	public String getExtnRestrictedShipMethod() {
		return extnRestrictedShipMethod;
	}

	public void setExtnRestrictedShipMethod(String extnRestrictedShipMethod) {
		this.extnRestrictedShipMethod = extnRestrictedShipMethod;
	}

	public String getExtnWebExclusiveIndicator() {
		return extnWebExclusiveIndicator;
	}

	public void setExtnWebExclusiveIndicator(String extnWebExclusiveIndicator) {
		this.extnWebExclusiveIndicator = extnWebExclusiveIndicator;
	}

	public String getExtnWebItem() {
		return extnWebItem;
	}

	public void setExtnWebItem(String extnWebItem) {
		this.extnWebItem = extnWebItem;
	}

	public String getHazmatClass() {
		return hazmatClass;
	}

	public void setHazmatClass(String hazmatClass) {
		this.hazmatClass = hazmatClass;
	}

	public String getExtnHazmatSubClass() {
		return extnHazmatSubClass;
	}

	public void setExtnHazmatSubClass(String extnHazmatSubClass) {
		this.extnHazmatSubClass = extnHazmatSubClass;
	}

}
