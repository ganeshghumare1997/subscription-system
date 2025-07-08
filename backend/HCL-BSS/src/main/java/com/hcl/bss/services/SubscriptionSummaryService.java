package com.hcl.bss.services;

import org.springframework.data.domain.Pageable;

import com.hcl.bss.dto.SubscriptionSummaryDataDto;

/**
 * Interface for Subscription Summary services 
 */

public interface SubscriptionSummaryService {

	SubscriptionSummaryDataDto getAllSubscriptionSummaries(Pageable reqCount);
}
