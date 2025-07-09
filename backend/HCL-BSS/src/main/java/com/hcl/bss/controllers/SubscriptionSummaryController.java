package com.hcl.bss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hcl.bss.dto.SubscriptionSummaryDataDto;
import com.hcl.bss.dto.SubscriptionSummaryDto;
import com.hcl.bss.services.SubscriptionSummaryService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@PropertySource("classpath:application.properties")
public class SubscriptionSummaryController {
	@Autowired
	SubscriptionSummaryService subscriptionSummaryService;
	@Value("${app.page.size}")
	Integer recordPerPage = 100;

	@ApiOperation(value = "Get All Subscription Summary", response = SubscriptionSummaryDto.class)
	@RequestMapping(value = "/subscriptionSummary/getSubscriptionSummaries/{pageNo}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<SubscriptionSummaryDataDto> getAllSubscriptionSummaries(@PathVariable("pageNo") String pageNo) {
		Integer pageNumber = Integer.valueOf(pageNo);
		
		Pageable reqCount = PageRequest.of(pageNumber, 100);
		SubscriptionSummaryDataDto SubscriptionSummaryData = new SubscriptionSummaryDataDto();
		SubscriptionSummaryData = subscriptionSummaryService.getAllSubscriptionSummaries(reqCount);
		return new ResponseEntity<>(SubscriptionSummaryData, HttpStatus.OK);
	}
}
