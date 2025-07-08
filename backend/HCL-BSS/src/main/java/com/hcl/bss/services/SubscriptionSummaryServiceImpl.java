package com.hcl.bss.services;

import static com.hcl.bss.constants.ApplicationConstants.BLANK;
import static com.hcl.bss.constants.ApplicationConstants.DD_MM_YYYY;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;

import com.hcl.bss.repository.AppConstantRepository;
import com.hcl.bss.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hcl.bss.domain.SubscriptionSummary;
import com.hcl.bss.dto.SubscriptionSummaryDataDto;
import com.hcl.bss.dto.SubscriptionSummaryDto;
import com.hcl.bss.repository.ProductRepository;
import com.hcl.bss.repository.ProductTypeMasterRepository;
import com.hcl.bss.repository.RatePlanRepository;
import com.hcl.bss.repository.SubscriptionRatePlanRepository;
import com.hcl.bss.repository.SubscriptionSummaryRepository;

@Service
@Transactional
public class SubscriptionSummaryServiceImpl implements SubscriptionSummaryService {

	@Autowired
	AppConstantRepository appConstantRepository;
	@Autowired
	SubscriptionRatePlanRepository subscriptionRatePlanRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductTypeMasterRepository productTypeMasterRepository;
	@Autowired
	RatePlanRepository ratePlanRepository;
	@Autowired
	SubscriptionSummaryRepository subscriptionSummaryRepository;

	@Override
	public SubscriptionSummaryDataDto getAllSubscriptionSummaries(Pageable reqCount) {
		SubscriptionSummaryDataDto subscriptionSummaryData = new SubscriptionSummaryDataDto();

		// Get paged result from DB
		Page<SubscriptionSummary> subscriptionSummaryPage = subscriptionSummaryRepository.findAll(reqCount);
		List<SubscriptionSummary> subscriptionSummaryEntityList = subscriptionSummaryPage.getContent();

		// Convert entities to DTOs
		List<SubscriptionSummaryDto> subscriptionSummaaryDtoList = convertSubscriptionSummaryEntityToDto(subscriptionSummaryEntityList);

		// Set data in response DTO
		subscriptionSummaryData.setSubscriptionSummaryList(subscriptionSummaaryDtoList);
		subscriptionSummaryData.setTotalPages((long) subscriptionSummaryPage.getTotalPages());

		// Set lastPage flag
		if (subscriptionSummaryPage.isLast()) {
			subscriptionSummaryData.setLastPage(true);
			System.out.println("Last page to show");
		} else {
			subscriptionSummaryData.setLastPage(false);
		}

		return subscriptionSummaryData;
	}

	private List<SubscriptionSummaryDto> convertSubscriptionSummaryEntityToDto(Iterable<SubscriptionSummary> subscriptionSummaryEntityList) {
		List<SubscriptionSummaryDto> SubscriptionSummaryDtoList = new ArrayList<>();
		
		for(SubscriptionSummary subscriptionSummary :subscriptionSummaryEntityList) {
			SubscriptionSummaryDto subscriptionSum = new SubscriptionSummaryDto();
			String activatedOnDate = BLANK;
			String createdOnDate = BLANK;
			String lastBilledOnDate = BLANK;
			String subscriptionEndDateVar = BLANK;
			String updatedAtDate = BLANK;
			Date activatedOn = subscriptionSummary.getActivatedOn();
			Date createdOn = subscriptionSummary.getCreatedOn();
			Date lastBilledOn = subscriptionSummary.getLastBilledOn();
			Date subscriptionEndDate = subscriptionSummary.getSubscriptionEndDate();
			Date updatedAt = subscriptionSummary.getUpdatedAt();
			DateFormat dateFormat = new SimpleDateFormat(DD_MM_YYYY);
			if(activatedOn != null) {
			activatedOnDate = dateFormat.format(activatedOn); 
			}
			if(createdOn != null) {
			createdOnDate = dateFormat.format(createdOn);
			}
			if(lastBilledOn != null) {
			lastBilledOnDate = dateFormat.format(lastBilledOn);
			}
			if(subscriptionEndDate != null) {
			subscriptionEndDateVar = dateFormat.format(subscriptionEndDate);
			}
			if(updatedAt != null) {
			updatedAtDate = dateFormat.format(updatedAt);
			}
			subscriptionSum.setId(subscriptionSummary.getId());
			subscriptionSum.setStripeCustomerId(subscriptionSummary.getStripeCustomerId());
			subscriptionSum.setActivatedOn(activatedOnDate);
			subscriptionSum.setCreatedOn(createdOnDate);
			subscriptionSum.setCustomerEmail(subscriptionSummary.getCustomerEmail());
			subscriptionSum.setCustomerName(subscriptionSummary.getCustomerName());
			subscriptionSum.setLastBilledOn(lastBilledOnDate);
			subscriptionSum.setPlanName(subscriptionSummary.getPlanName());
			subscriptionSum.setPlanPrice(subscriptionSummary.getPlanPrice());
			subscriptionSum.setStatus(subscriptionSummary.getStatus());
			subscriptionSum.setStripeSubscriptionId(subscriptionSummary.getStripeSubscriptionId());
			subscriptionSum.setSubscriptionEndDate(subscriptionEndDateVar);
			subscriptionSum.setUpdatedAt(updatedAtDate);

			SubscriptionSummaryDtoList.add(subscriptionSum);
			
		}
		return SubscriptionSummaryDtoList;
	}
}
