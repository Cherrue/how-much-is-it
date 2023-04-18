package com.price.search.howmuchisit.domain.naver.service;

import com.price.search.howmuchisit.common.exception.CommonException;
import com.price.search.howmuchisit.domain.naver.dto.NaverApiProperties;
import com.price.search.howmuchisit.domain.naver.dto.NaverItem;
import com.price.search.howmuchisit.domain.naver.dto.NaverResponse;
import com.price.search.howmuchisit.domain.naver.enums.NaverApiHeader;
import com.price.search.howmuchisit.domain.naver.enums.NaverApiParameters;
import com.price.search.howmuchisit.domain.naver.enums.NaverExcludeType;
import com.price.search.howmuchisit.domain.naver.enums.NaverSortType;
import com.price.search.howmuchisit.domain.search.enums.SearchResultCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverSearchService {

    private final NaverApiProperties naverApiProperties;

    private static HttpEntity<String> headerEntity = null;
    private static final int DISPLAY = 10;

    @PostConstruct
    private void setUp() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(NaverApiHeader.X_NAVER_CLIENT_ID.getValue(), naverApiProperties.getId());
        headers.add(NaverApiHeader.X_NAVER_CLIENT_SECRET.getValue(), naverApiProperties.getSecret());

        headerEntity = new HttpEntity<>(headers);
    }

    public List<NaverItem> searchItems(String query) {
        RestTemplate restTemplate = new RestTemplate();
        UriComponents uri = getApiUri(query);

        try {
            ResponseEntity<NaverResponse> response = restTemplate.exchange(uri.toString(),
                    HttpMethod.GET,
                    headerEntity,
                    NaverResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                log.info("API result uri = {} : {}", uri, response.getBody());
                return response.getBody().getItems();
            } else {
                log.error("Fail to call Naver Shopping API : status = {}, query = {}, body = {}", response.getStatusCode(), uri, response.getBody());
                throw new CommonException(SearchResultCode.FAIL_TO_CALL_NAVER_API);
            }
        } catch (HttpClientErrorException e) {
            log.error("Naver Shopping API throw 4XX exception : status = {}, query = {}, body = {}", e.getStatusCode(), uri, e.getMessage());
            throw new CommonException(SearchResultCode.FAIL_TO_CALL_NAVER_API);
        } catch (RestClientException e) {
            log.error("Naver Shopping API throw 5XX exception : query = {}, body = {}", uri, e.getMessage());
            throw new CommonException(SearchResultCode.FAIL_TO_CALL_NAVER_API);
        }
    }

    private UriComponents getApiUri(String query) {
        return UriComponentsBuilder.fromHttpUrl(naverApiProperties.getUrl())
                .queryParam(NaverApiParameters.QUERY.getValue(), query)
                .queryParam(NaverApiParameters.DISPLAY.getValue(), DISPLAY)
                .queryParam(NaverApiParameters.SORT.getValue(), NaverSortType.SIMILARITY_DESC.getValue())
                .queryParam(NaverApiParameters.EXCLUDE.getValue(), NaverExcludeType.getQueryParam(NaverExcludeType.USED, NaverExcludeType.RENTAL, NaverExcludeType.DIRECT_PURCHASE))
                .build(false);
    }
}
