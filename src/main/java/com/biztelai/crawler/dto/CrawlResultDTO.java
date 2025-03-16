package com.biztelai.crawler.dto;

import com.biztelai.crawler.model.CrawlStatus;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CrawlResultDTO {
    private Long id;
    private String seedUrl;
    private List<String> crawledUrls;
    private CrawlStatus status;
    private Timestamp createdAt;
}