package com.mall.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {
    private String username;
    private String password;
}