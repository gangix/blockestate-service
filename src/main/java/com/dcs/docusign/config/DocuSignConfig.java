package com.dcs.docusign.config;

import com.docusign.esign.client.ApiClient;
import com.docusign.esign.client.auth.OAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocuSignConfig {

    @Value("${docusign.base-url}")
    private String baseUrl;

    @Value("${docusign.integrator-key}")
    private String integratorKey;

    @Value("${docusign.user-id}")
    private String userId;

    @Value("${docusign.private-key}")
    private String privateKey;

    @Value("${docusign.account-id}")
    private String accountId;

    @Value("${docusign.oauth-base-path}")
    private String oAuthBasePath;

    @Bean
    public ApiClient apiClient() throws Exception {
        ApiClient apiClient = new ApiClient(baseUrl);
        apiClient.setOAuthBasePath(oAuthBasePath);
        byte[] privateKeyBytes = privateKey.getBytes();
        OAuth.OAuthToken oAuthToken = apiClient.requestJWTUserToken(
                integratorKey,
                userId,
                List.of("signature", "impersonation"),
                privateKeyBytes,
                3600);
        apiClient.addDefaultHeader("Authorization", "Bearer " + oAuthToken.getAccessToken());
        return apiClient;
    }

    @Bean
    public String accountId() {
        return accountId;
    }
}
