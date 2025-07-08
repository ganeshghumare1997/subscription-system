package com.hcl.bss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bss.domain.SubscriptionSummary;

@Repository
public interface SubscriptionSummaryRepository extends JpaRepository<SubscriptionSummary, Long>, JpaSpecificationExecutor<SubscriptionSummary>,PagingAndSortingRepository<SubscriptionSummary, Long>{
	public List<SubscriptionSummary> findAll();
}
