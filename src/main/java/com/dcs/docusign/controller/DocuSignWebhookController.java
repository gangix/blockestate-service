package com.dcs.docusign.controller;

import com.dcs.docusign.dto.WebhookPayload;
import com.dcs.docusign.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class DocuSignWebhookController {

    private static final Logger log = LoggerFactory.getLogger(DocuSignWebhookController.class);
    private final DocumentService documentService;

    public DocuSignWebhookController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/docusign")
    @ResponseStatus(HttpStatus.OK)
    public void handleWebhook(@RequestBody WebhookPayload payload) {
        log.info("Webhook payload captured: {}", payload);
        documentService.updateSigningStatus(payload);
    }

    @GetMapping("/docusign")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("DocuSign Webhook Endpoint is running!");
    }
}
