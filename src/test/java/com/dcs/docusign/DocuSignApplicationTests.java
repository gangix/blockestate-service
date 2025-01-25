package com.dcs.docusign;

import com.docusign.esign.client.ApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
class DocuSignApplicationTests {

    @MockitoBean
    private ApiClient apiClient;

    @Test
    void contextLoads() {
    }

}
