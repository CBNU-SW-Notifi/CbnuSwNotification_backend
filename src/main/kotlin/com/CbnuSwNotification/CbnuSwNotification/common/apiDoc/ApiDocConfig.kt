package com.CbnuSwNotification.CbnuSwNotification.common.apiDoc

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ApiDocConfig {
    //접속주소:http://localhost:8080/swagger-ui/index.html
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("CbnuSwNotification")
                    .description("충북대 채용 정보 알림 어플")
                    .version("1.0.0")
            )
    }
}