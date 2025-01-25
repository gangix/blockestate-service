package com.dcs.docusign.controller;

import com.dcs.docusign.service.DocumentService;
import com.docusign.esign.client.ApiClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EscrowControllerTest {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    @MockitoBean
    private DocumentService documentService;

    @MockitoBean
    private ApiClient apiClient;

    @InjectMocks
    private EscrowController escrowController;

    @Test
    void shouldGenerateEscrowAgreementSuccessfully() throws Exception {
        MultiValueMap<String, String> formParams = new LinkedMultiValueMap<>();
        formParams.add("payerName", "John Doe");
        formParams.add("payerEmail", "john.doe@example.com");
        formParams.add("payerEthAddress", "0x1234567890abcdef");
        formParams.add("payeeName", "Jane Doe");
        formParams.add("payeeEmail", "jane.doe@example.com");
        formParams.add("payeeEthAddress", "0xabcdef1234567890");
        formParams.add("transactionHash", "0xdeadbeefdeadbeefdeadbeefdeadbeef");
        formParams.add("amount", "1000");

        mockMvc.perform(post("/escrow")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .params(formParams))
                .andExpect(status().isOk());
    }
}
