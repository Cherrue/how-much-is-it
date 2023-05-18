CREATE TABLE `search_log` (
    `seq` INT NOT NULL AUTO_INCREMENT COMMENT 'id',
    `query` VARCHAR(200) NOT NULL COMMENT '검색어',
    `user_id` VARCHAR(45) COMMENT '검색 유발 사용자',
    `mart_id` VARCHAR(45) COMMENT '검색 유발 사용자가 설정한 지점 id',
    `result_brand` VARCHAR(200) COMMENT '우리가 선정한 결과의 상표',
    `result_title` VARCHAR(200) COMMENT '우리가 선정한 결과의 상품명',
    `result_price` INT COMMENT '우리가 선정한 결과의 가격',
    `updated_at` DATETIME default CURRENT_TIMESTAMP,
    `created_at` DATETIME default CURRENT_TIMESTAMP
);