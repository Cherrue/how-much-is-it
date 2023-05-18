package com.price.search.howmuchisit.domain.search.entity;

import com.price.search.howmuchisit.common.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "search_log")
public class SearchLog extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;
    @Column(name = "query")
    private String query;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "mart_id")
    private String martId;
    @Column(name = "result_brand")
    private String resultBrand;
    @Column(name = "result_title")
    private String resultTitle;
    @Column(name = "result_price")
    private Integer resultPrice;

    // constructor
    @Builder
    public SearchLog(String query, String userId, String martId, String resultBrand, String resultTitle, Integer resultPrice) {
        this.query = query;
        this.userId = userId;
        this.martId = martId;
        this.resultBrand = resultBrand;
        this.resultTitle = resultTitle;
        this.resultPrice = resultPrice;
    }

    @Override
    public String toString() {
        return "SearchLog{" +
                "seq=" + seq +
                ", query='" + query + '\'' +
                ", userId='" + userId + '\'' +
                ", martId='" + martId + '\'' +
                ", resultBrand='" + resultBrand + '\'' +
                ", resultTitle='" + resultTitle + '\'' +
                ", resultPrice='" + resultPrice + '\'' +
                '}';
    }
}
