package com.mall.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public interface AuthConstant {

    @Value("${spring.datasource.AUTHORITY_PREFIX}")
    String AUTHORITY_PREFIX;

    @Value("${spring.datasource.AUTHORITY_CLAIM_NAME}")
    String AUTHORITY_CLAIM_NAME;

    @Value("${spring.datasource.ADMIN_CLIENT_ID}")
    String ADMIN_CLIENT_ID;

    @Value("${spring.datasource.PORTAL_CLIENT_ID}")
    String PORTAL_CLIENT_ID;

    @Value("${spring.datasource.ADMIN_URL_PATTERN}")
    String ADMIN_URL_PATTERN;

    @Value("${spring.datasource.PATH_RESOURCE_MAP}")
    String PATH_RESOURCE_MAP;

    @Value("${spring.datasource.JWT_TOKEN_HEADER}")
    String JWT_TOKEN_HEADER;

    @Value("${spring.datasource.JWT_TOKEN_PREFIX}")
    String JWT_TOKEN_PREFIX;

    @Value("${spring.datasource.USER_TOKEN_HEADER}")
    String USER_TOKEN_HEADER;

    @Value("${spring.datasource.STP_MEMBER_INFO}")
    String STP_MEMBER_INFO;

    @Value("${spring.datasource.STP_ADMIN_INFO}")
    String STP_ADMIN_INFO;

}