package com.emazon.transaction_microservice.infrastructure.configuration;

import feign.RequestInterceptor;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignClientConfig {

    @Bean
    public ApacheHttpClient client() {
        return new ApacheHttpClient(HttpClients.createDefault());
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attributes != null) {
                String jwtToken = attributes.getRequest().getHeader("Authorization");

                if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
                    requestTemplate.header("Authorization", jwtToken);
                }
            }
        };
    }
}