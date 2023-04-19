package com.price.search.howmuchisit.domain.search.service;

import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import com.price.search.howmuchisit.domain.naver.service.NaverSearchService;
import com.price.search.howmuchisit.domain.search.dto.SearchRequest;
import com.price.search.howmuchisit.domain.search.dto.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final NaverSearchService naverSearchService;

    public List<SearchResponse> search(SearchRequest request) {
        String searchQuery = createSearchQuery(request);
        List<NaverItem> naverItems = naverSearchService.searchItems(searchQuery);
        return naverItems.stream().map(item -> SearchResponse.fromNaverItem(request, item)).toList();
    }

    private String createSearchQuery(SearchRequest request) {
        return request.getBrand() +
                request.getTitle() +
                request.getAmount();
    }
}
