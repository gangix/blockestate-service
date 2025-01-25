package com.dcs.docusign.controller;

import com.dcs.docusign.dto.WebhookPayload;
import com.dcs.docusign.service.DocumentService;
import com.docusign.esign.client.ApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SuppressWarnings("unused")
@SpringBootTest
@AutoConfigureMockMvc
class DocuSignWebhookControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DocumentService documentService;

    @MockitoBean
    private ApiClient apiClient;

    @InjectMocks
    private DocuSignWebhookController docuSignWebhookController;

    @Test
    void givenValidWebhookDto_WhenCallback_thenShouldBeCapturedGracefully() throws Exception {
        WebhookPayload.Data data = new WebhookPayload.Data();
        data.setEnvelopeId("envelopeId");
        data.setEnvelopeSummary(new WebhookPayload.EnvelopeSummary());

        WebhookPayload payload = new WebhookPayload("completed", data);
        mockMvc.perform(post("/webhook/docusign")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(payload)))
                .andExpect(status().isOk());
    }
}
