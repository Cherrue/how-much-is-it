package com.price.search.howmuchisit.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
        Info info = new Info()
                .title("가격표 검색 API")
                .version(springdocVersion)
                .description("가격표에서 추출된 정보를 이용해 Naver Shopping 가격 검색");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }

}
