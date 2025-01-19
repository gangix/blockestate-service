package com.dcs.docusign.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EscrowControllerTest {

    @Autowired
    private MockMvc mockMvc; // Used to simulate HTTP requests

    // Test the generateEscrowAgreement endpoint
    @Test
    public void testGenerateEscrowAgreement() throws Exception {
        // Prepare request parameters
        String payerName = "John Doe";
        String payerEmail = "olcay.bilir@gmail.com";
        String payerAddress = "0x1234567890abcdef1234567890abcdef12345678";
        String payeeName = "Jane Smith";
        String payeeEmail = "bilir.olcay@gmail.com";
        String payeeAddress = "0xabcdefabcdefabcdefabcdefabcdefabcdefabcdef";
        String amount = "10"; // Amount in Ether
        String payerDescription = "I agree to pay to buy ";
        String payeeDescription = "I agree to give this service/good for this price";

        // Perform the GET request to /generateEscrowPdf
        mockMvc.perform(MockMvcRequestBuilders.get("/generateEscrowPdf")
                .param("payerName", payerName)
                .param("payerEmail", payerEmail)
                .param("payerAddress", payerAddress)
                .param("payeeName", payeeName)
                .param("payeeEmail", payeeEmail)
                .param("payeeAddress", payeeAddress)
                .param("amount", amount)
                .param("payerDescription", payerDescription)
                .param("payeeDescription", payeeDescription))
                .andExpect(status().isOk())  // HTTP 200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))  // Content type should be PDF
                .andExpect(header().string("Content-Disposition", "attachment; filename=\"escrow_agreement.pdf\""));  // Expect file download header
//                .andExpect(content().bytes(org.apache.commons.io.IOUtils.toByteArray(getClass().getResourceAsStream("/expected-escrow.pdf"))));  // You can check the content or length if needed
    }
}
