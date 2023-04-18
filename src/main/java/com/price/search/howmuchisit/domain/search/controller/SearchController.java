package com.price.search.howmuchisit.domain.search.controller;

import com.price.search.howmuchisit.common.dto.CommonResponse;
import com.price.search.howmuchisit.common.enums.CommonResultCode;
import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import com.price.search.howmuchisit.domain.naver.service.NaverSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/search")
public class SearchController {

    private final NaverSearchService naverSearchService;
    @GetMapping(path = "/prices")
    public CommonResponse<List<NaverItem>> getPrices(
            @RequestParam("query") String query
    ) {
        log.info(">>> SearchController.getPrices()");
        List<NaverItem> naverItems = naverSearchService.searchItems(query);
        log.info("<<< SearchController.getPrices()");
        return CommonResponse.success(CommonResultCode.SUCCESS, naverItems);
    }
}
