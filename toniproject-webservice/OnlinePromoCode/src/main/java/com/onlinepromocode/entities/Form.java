package com.onlinepromocode.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Form {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@ManyToOne 
	Requester requester;
	
	@Override
	
	public String toString() {
		return "Form [requester=" + requester + ", eventDateLocation=" + eventDateLocation + ", quantity=" + quantity
				+ ", voucherTyper=" + voucherTyper + ", discountEconoy=" + discountEconoy + ", discountBusiness="
				+ discountBusiness + ", puchaseForm=" + puchaseForm + ", purchaseTo=" + purchaseTo
				+ ", outboundTravelFrom=" + outboundTravelFrom + ", outboundTravelTo=" + outboundTravelTo
				+ ", inbountTravelForm=" + inbountTravelForm + ", inboundTravelTo=" + inboundTravelTo + ", airportFrom="
				+ airportFrom + ", airportTo=" + airportTo + ", restrictionByFareFamily=" + restrictionByFareFamily
				+ ", passengerType=" + passengerType + ", justification=" + justification + "]";
	}
	@Transient
	private Customer customer;
	private String eventDateLocation;
	private double quantity;
	private String voucherTyper;
	private double discountEconoy;
	private double discountBusiness;
	private String puchaseForm;
	private Date purchaseTo;
	private Date outboundTravelFrom;
	private Date outboundTravelTo;
	private Date inbountTravelForm;
	private Date inboundTravelTo;
	private String airportFrom;
	private String airportTo;
	private String restrictionByFareFamily;
	private String passengerType;
	private String justification;
	private String aprovalStatus;

	private String sendTo;
	
	public Requester getRequester() {
		return requester;
	}
	public void setRequester(Requester requester) {
		this.requester = requester;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getEventDateLocation() {
		return eventDateLocation;
	}
	public void setEventDateLocation(String eventDateLocation) {
		this.eventDateLocation = eventDateLocation;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getVoucherTyper() {
		return voucherTyper;
	}
	public void setVoucherTyper(String voucherTyper) {
		this.voucherTyper = voucherTyper;
	}
	public double getDiscountEconoy() {
		return discountEconoy;
	}
	public void setDiscountEconoy(double discountEconoy) {
		this.discountEconoy = discountEconoy;
	}
	public double getDiscountBusiness() {
		return discountBusiness;
	}
	public void setDiscountBusiness(double discountBusiness) {
		this.discountBusiness = discountBusiness;
	}
	public String getPuchaseForm() {
		return puchaseForm;
	}
	public void setPuchaseForm(String puchaseForm) {
		this.puchaseForm = puchaseForm;
	}
	public Date getPurchaseTo() {
		return purchaseTo;
	}
	public void setPurchaseTo(Date purchaseTo) {
		this.purchaseTo = purchaseTo;
	}
	public Date getOutboundTravelFrom() {
		return outboundTravelFrom;
	}
	public void setOutboundTravelFrom(Date outboundTravelFrom) {
		this.outboundTravelFrom = outboundTravelFrom;
	}
	public Date getOutboundTravelTo() {
		return outboundTravelTo;
	}
	public void setOutboundTravelTo(Date outboundTravelTo) {
		this.outboundTravelTo = outboundTravelTo;
	}
	public Date getInbountTravelForm() {
		return inbountTravelForm;
	}
	public void setInbountTravelForm(Date inbountTravelForm) {
		this.inbountTravelForm = inbountTravelForm;
	}
	public Date getInboundTravelTo() {
		return inboundTravelTo;
	}
	public void setInboundTravelTo(Date inboundTravelTo) {
		this.inboundTravelTo = inboundTravelTo;
	}
	public String getAirportFrom() {
		return airportFrom;
	}
	public void setAirportFrom(String airportFrom) {
		this.airportFrom = airportFrom;
	}
	public String getAirportTo() {
		return airportTo;
	}
	public void setAirportTo(String airportTo) {
		this.airportTo = airportTo;
	}
	public String getRestrictionByFareFamily() {
		return restrictionByFareFamily;
	}
	public void setRestrictionByFareFamily(String restrictionByFareFamily) {
		this.restrictionByFareFamily = restrictionByFareFamily;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getAprovalStatus() {
		return aprovalStatus;
	}
	public void setAprovalStatus(String aprovalStatus) {
		this.aprovalStatus = aprovalStatus;
	}
	

}