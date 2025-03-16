package com.biztelai.crawler.repository;

import com.biztelai.crawler.model.CrawlResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawlResultRepository extends JpaRepository<CrawlResult,Long> {
}
