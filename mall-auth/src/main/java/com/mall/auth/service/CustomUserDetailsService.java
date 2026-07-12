package com.mall.auth.service;

import com.mall.auth.domain.SecurityUser;
import com.mall.auth.model.request.UserDto;
import com.mall.common.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UmsAdminService adminFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CommonResult<UserDto> result = adminFeignClient.loadUserByUsername(username);
        UserDto userDto = result.getData();

        if (userDto == null) {
            throw new UsernameNotFoundException("Tài khoản không tồn tại!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (userDto.getRoles() != null) {
            userDto.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
        }

        if (userDto.getPermissions() != null) {
            userDto.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission)));
        }

        return new SecurityUser(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getStatus() == 1,
                userDto.getClientId(),
                userDto.getRoles()
        );
    }
}