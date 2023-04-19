package com.price.search.howmuchisit.domain.search.controller;

import com.price.search.howmuchisit.common.dto.CommonResponse;
import com.price.search.howmuchisit.common.enums.CommonResultCode;
import com.price.search.howmuchisit.domain.search.dto.SearchRequest;
import com.price.search.howmuchisit.domain.search.dto.SearchResponse;
import com.price.search.howmuchisit.domain.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {
    private final SearchService searchService;

    @GetMapping(path = "/search")
    public CommonResponse<List<SearchResponse>> getSearchResults(
            @ModelAttribute SearchRequest request
    ) {
        log.info(">>> SearchController.getSearchResults()");
        List<SearchResponse> prices = searchService.search(request);
        log.info("<<< SearchController.getSearchResults()");
        return CommonResponse.success(CommonResultCode.SUCCESS, prices);
    }
}
