package com.mall.auth.config; // Đổi từ com.macro.mall thành com.mall theo cấu trúc của bạn

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringDocConfig implements WebMvcConfigurer {

    private static final String SECURITY_SCHEME_NAME = "Authorization";

    @Bean
    public OpenAPI mallAuthOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mall Authentication Center API") // Việt hóa hoặc chuẩn hóa tiếng Anh
                        .description("Tài liệu các API liên quan đến Xác thực và Phân quyền (mall-auth)")
                        .version("v1.0.0")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Tài liệu kiến trúc hệ thống Mall Backend")
                        .url("https://github.com/your-username/mall-backend1")) // Thay bằng link repo của bạn nếu có
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                .components(new Components()
                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                new SecurityScheme()
                                        .name(SECURITY_SCHEME_NAME)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/swagger-ui/").setViewName("redirect:/swagger-ui/index.html");
        registry.addViewController("/swagger-ui").setViewName("redirect:/swagger-ui/index.html");
    }
}