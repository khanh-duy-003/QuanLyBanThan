package com.vn.dev.config;

import org.springframework.context.annotation.Configuration;

import jp.xet.springframework.data.mirage.repository.config.EnableMirageRepositories;

@Configuration
@EnableMirageRepositories(
    basePackages = "com.vn.dev.repository", // Ghi đường dẫn của gói repository
    		sqlManagerRef = "sqlManagerServicePr" // Đường dẫn đến thư mục chứa tệp SQL
)
public class MirageRepositoryConfig {

}
