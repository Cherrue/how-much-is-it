package com.price.search.howmuchisit.domain.search.service;

import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import com.price.search.howmuchisit.domain.naver.service.NaverSearchService;
import com.price.search.howmuchisit.domain.search.dto.SearchRequest;
import com.price.search.howmuchisit.domain.search.dto.SearchResponse;
import com.price.search.howmuchisit.domain.search.repository.SearchLogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    private NaverSearchService naverSearchService;

    @Mock
    private SearchLogRepository searchLogRepository;

    @InjectMocks
    private SearchService searchService;

    private SearchRequest createSearchRequest(String brand, String title, String amount, String price) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setBrand(brand);
        searchRequest.setTitle(title);
        searchRequest.setAmount(amount);
        searchRequest.setPrice(price);

        return searchRequest;
    }
    private NaverItem createItem(String title, String link, String image, int price) {
        NaverItem item = new NaverItem();
        item.setTitle(title);
        item.setLink(link);
        item.setImage(image);
        item.setLprice(price);

        return item;
    }
    @Test
    void testSearchPrices() {
        // Arrange
        SearchRequest request = createSearchRequest("brand", "title", "amount", "1000");
        List<NaverItem> naverItems = Arrays.asList(
                createItem("title1", "link1", "image1", 1000),
                createItem("title2", "link2", "image2", 1100),
                createItem("title3", "link3", "image3", 1200)
        );
        when(naverSearchService.searchItems(anyString()))
                .thenReturn(naverItems);
        when(searchLogRepository.save(any()))
                .thenReturn(null);

        // Act
        List<SearchResponse> searchResponses = searchService.search(request);

        // Assert
        assertEquals(3, searchResponses.size());
        assertEquals("title1", searchResponses.get(0).getTitle());
        assertEquals("link1", searchResponses.get(0).getLink());
        assertEquals("image1", searchResponses.get(0).getImage());
        assertEquals(1000, searchResponses.get(0).getPrice());
        assertEquals("title2", searchResponses.get(1).getTitle());
        assertEquals("link2", searchResponses.get(1).getLink());
        assertEquals("image2", searchResponses.get(1).getImage());
        assertEquals(1100, searchResponses.get(1).getPrice());
        assertEquals("title3", searchResponses.get(2).getTitle());
        assertEquals("link3", searchResponses.get(2).getLink());
        assertEquals("image3", searchResponses.get(2).getImage());
        assertEquals(1200, searchResponses.get(2).getPrice());

        verify(naverSearchService, times(1)).searchItems(anyString());
    }
}
