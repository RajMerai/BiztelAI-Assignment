package com.biztelai.crawler.service;

import com.biztelai.crawler.dto.CrawlResultDTO;
import com.biztelai.crawler.model.CrawlResult;
import com.biztelai.crawler.model.CrawlStatus;
import com.biztelai.crawler.repository.CrawlResultRepository;
import com.biztelai.crawler.util.WebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class CrawlService {
    @Autowired
    private CrawlResultRepository repository;

    public Long startCrawl(String url) {
        CrawlResult result = new CrawlResult();
        result.setSeedUrl(url);
        result.setStatus(CrawlStatus.IN_PROGRESS);
        result.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        repository.save(result);

        new Thread(() -> {
            Set<String> links = WebCrawler.fetchLinks(url);
            result.setCrawledUrls(List.copyOf(links));
            result.setStatus(CrawlStatus.COMPLETED);
            repository.save(result);
        }).start();

        return result.getId();
    }

    public CrawlResultDTO getCrawlResult(Long id) {
        CrawlResult result = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crawl result not found"));
        return convertToDTO(result);
    }

    private CrawlResultDTO convertToDTO(CrawlResult result) {
        CrawlResultDTO dto = new CrawlResultDTO();
        dto.setId(result.getId());
        dto.setSeedUrl(result.getSeedUrl());
        dto.setCrawledUrls(result.getCrawledUrls());
        dto.setStatus(result.getStatus());
        dto.setCreatedAt(result.getCreatedAt());
        return dto;
    }
}