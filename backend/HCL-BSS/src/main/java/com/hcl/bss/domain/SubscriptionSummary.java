package com.hcl.bss.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "TB_SUBSCRIPTION_SUMMARY")
public class SubscriptionSummary implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "my_sequence")
	@TableGenerator(name = "my_sequence", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", initialValue = 100000000, allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "stripe_subscription_id")
	private String stripeSubscriptionId;
	@Column(name = "stripe_customer_id")
	private String stripeCustomerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email")
	private String customerEmail;
	@Column(name = "status")
	private String status;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "activated_on")
	private Date activatedOn;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "plan_price")
	private long planPrice;
	@Column(name = "last_billed_on")
	private Date lastBilledOn;
	@Column(name = "updated_at")
	private Date updatedAt;
	@Column(name = "subscriptionEndDate")
	private Date subscriptionEndDate;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getActivatedOn() {
		return activatedOn;
	}

	public void setActivatedOn(Date activatedOn) {
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

	public Date getLastBilledOn() {
		return lastBilledOn;
	}

	public void setLastBilledOn(Date lastBilledOn) {
		this.lastBilledOn = lastBilledOn;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

	public SubscriptionSummary() {
	}
}
