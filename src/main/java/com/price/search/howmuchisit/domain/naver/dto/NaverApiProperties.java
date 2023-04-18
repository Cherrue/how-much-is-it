package com.price.search.howmuchisit.domain.naver.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "naver.api")
public class NaverApiProperties {
    private String url;
    private String id;
    private String secret;
}
