package com.biztelai.crawler.model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class CrawlResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seedUrl;

    @ElementCollection
    @CollectionTable(name = "crawled_urls", joinColumns = @JoinColumn(name = "crawl_result_id"))
    private List<String> crawledUrls;

    @Enumerated(EnumType.STRING)
    private CrawlStatus status;

    private Timestamp createdAt;
}