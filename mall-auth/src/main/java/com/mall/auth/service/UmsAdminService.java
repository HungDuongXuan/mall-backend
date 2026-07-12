package com.mall.auth.service;

import com.mall.auth.domain.UmsAdminLoginParam;
import com.mall.auth.model.request.UserDto;
import com.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "mall-admin", contextId = "adminFeignClient")
public interface UmsAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam loginParam);

    @GetMapping("/admin/loadByUsername")
    CommonResult<UserDto> loadUserByUsername(@RequestParam("username") String username);

}