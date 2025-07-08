package com.hcl.bss.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SubscriptionSummaryDto implements java.io.Serializable {
	@NotNull(message = "ID cannot be null")
	@NotBlank(message = "ID cannot be blank")
	private Long id;

	private String stripeSubscriptionId;
	private String stripeCustomerId;
	private String customerName;
	private String customerEmail;
	private String status;
	private String createdOn;
	private String activatedOn;
	private String planName;
	private long planPrice;
	private String lastBilledOn;
	private String updatedAt;
	private String subscriptionEndDate;

	public SubscriptionSummaryDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStripeSubscriptionId() {
		return stripeSubscriptionId;
	}

	public void setStripeSubscriptionId(String stripeSubscriptionId) {
		this.stripeSubscriptionId = stripeSubscriptionId;
	}

	public String getStripeCustomerId() {
		return stripeCustomerId;
	}

	public void setStripeCustomerId(String stripeCustomerId) {
		this.stripeCustomerId = stripeCustomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getActivatedOn() {
		return activatedOn;
	}

	public void setActivatedOn(String activatedOn) {
		this.activatedOn = activatedOn;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public long getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(long planPrice) {
		this.planPrice = planPrice;
	}

	public String getLastBilledOn() {
		return lastBilledOn;
	}

	public void setLastBilledOn(String lastBilledOn) {
		this.lastBilledOn = lastBilledOn;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(String subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
