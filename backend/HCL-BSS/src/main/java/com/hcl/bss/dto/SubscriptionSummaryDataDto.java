package com.hcl.bss.dto;

import java.util.List;

public class SubscriptionSummaryDataDto {
	private List<SubscriptionSummaryDto> subscriptionSummaryList;
	private boolean isLastPage;
	private Long totalPages;
	public List<SubscriptionSummaryDto> getSubscriptionSummaryList() {
		return subscriptionSummaryList;
	}
	public void setSubscriptionSummaryList(List<SubscriptionSummaryDto> subscriptionSummaryList) {
		this.subscriptionSummaryList = subscriptionSummaryList;
	}
	public boolean isLastPage() {
		return isLastPage;
	}
	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
}
