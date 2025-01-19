package com.dcs.docusign.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3jConfig {

    private static final String INFURA_URL = "https://sepolia.infura.io/v3/62819e28b654494791fdbcab19a44697";

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(INFURA_URL));
    }
}
