package com.deathnote.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Profile("!production")
@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun apiV3(): Docket {
        return Docket(DocumentationType.OAS_30).apply {
            apiInfo(apiInfo())
        }
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "API SERVER V3",
            "",
            "3.0",
            "",
            Contact("", "", "donghoon149@gmail.com"),
            "",
            "",
            Collections.emptyList()
        )
    }
}