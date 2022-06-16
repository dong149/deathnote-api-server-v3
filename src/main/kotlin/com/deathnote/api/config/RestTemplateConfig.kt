package com.deathnote.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        val requestFactory = SimpleClientHttpRequestFactory()
        return RestTemplate(requestFactory)
    }
}