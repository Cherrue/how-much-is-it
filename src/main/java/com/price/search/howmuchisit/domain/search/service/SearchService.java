package com.price.search.howmuchisit.domain.search.service;

import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import com.price.search.howmuchisit.domain.naver.service.NaverSearchService;
import com.price.search.howmuchisit.domain.search.dto.SearchRequest;
import com.price.search.howmuchisit.domain.search.dto.SearchResponse;
import com.price.search.howmuchisit.domain.search.entity.SearchLog;
import com.price.search.howmuchisit.domain.search.repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {
    private final NaverSearchService naverSearchService;
    private final SearchLogRepository searchLogRepository;

    public List<SearchResponse> search(SearchRequest request) {
        // 1. 검색어 전처리
        String searchQuery = createSearchQuery(request);
        // 2. 검색 수행
        List<NaverItem> naverItems = naverSearchService.searchItems(searchQuery);
        // 3. 검색 결과 후처리
        List<SearchResponse> searchResponses = naverItems.stream().map(item -> SearchResponse.fromNaverItem(request, item)).toList();
        // 4. 결과 저장
        SearchLog firstResult = SearchLog.builder()
                .query(searchQuery)
                .resultTitle(searchResponses.get(0).getTitle())
                .resultBrand(searchResponses.get(0).getBrand())
                .resultPrice(searchResponses.get(0).getPrice())
                .build();
        log.info(firstResult.toString());
        searchLogRepository.save(firstResult);

        return searchResponses;
    }

    private String createSearchQuery(SearchRequest request) {
        return request.getBrand() +
                request.getTitle() +
                request.getAmount();
    }
}
