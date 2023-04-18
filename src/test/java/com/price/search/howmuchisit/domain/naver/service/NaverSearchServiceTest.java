package com.price.search.howmuchisit.domain.naver.service;

import com.price.search.howmuchisit.common.exception.CommonException;
import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NaverSearchServiceTest {

    @Autowired
    private NaverSearchService naverSearchService;
    @Test
    public void testSearchItems() {
        // given
        String query = "iphone";

        // when
        List<NaverItem> items = naverSearchService.searchItems(query);
//        when(restTemplate.exchange(any(URI.class), eq(HttpMethod.GET), eq(responseEntity), eq(NaverResponse.class))).thenReturn(responseEntity);

        // then
        assertNotNull(items);
        assertTrue(items.size() > 0);
    }

    @Test
    public void throwException_whenKeywordAbnormal() {
        // given
        String query = null;

        // when
        Assertions.assertThrows(CommonException.class, () -> naverSearchService.searchItems(query));
    }
}
