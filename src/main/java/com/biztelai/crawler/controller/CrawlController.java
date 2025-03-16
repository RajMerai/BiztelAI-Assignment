/*
package com.biztelai.crawler.controller;

import com.biztelai.crawler.model.CrawlResult;
import com.biztelai.crawler.service.CrawlService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crawl")
public class CrawlController {
    @Autowired
    private CrawlService crawlService;

    @Operation(summary = "Start a web crawl job")
    @PostMapping
    public ResponseEntity<Long> startCrawl(@RequestParam String url) {
        Long jobId = crawlService.startCrawl(url);
        return ResponseEntity.ok(jobId);
    }

    @Operation(summary = "Get the status and results of a crawl job")
    @GetMapping("/{id}")
    public ResponseEntity<CrawlResult> getCrawlStatus(@PathVariable Long id) {
        return ResponseEntity.ok(crawlService.getCrawlResult(id));
    }
}*/

package com.biztelai.crawler.controller;

import com.biztelai.crawler.dto.CrawlResultDTO;
import com.biztelai.crawler.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crawl")

public class CrawlController {
    @Autowired
    private CrawlService crawlService;


    @PostMapping
    public ResponseEntity<Long> startCrawl(@RequestParam String url) {
        Long jobId = crawlService.startCrawl(url);
        return ResponseEntity.ok(jobId);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CrawlResultDTO> getCrawlStatus(@PathVariable Long id) {
        return ResponseEntity.ok(crawlService.getCrawlResult(id));
    }
}