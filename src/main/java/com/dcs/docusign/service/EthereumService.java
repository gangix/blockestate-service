package com.dcs.docusign.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;


@Service
public class EthereumService {

    private static final Logger log = LoggerFactory.getLogger(EthereumService.class);
    private final Web3j web3j;

    public EthereumService(Web3j web3j) {
        this.web3j = web3j;
    }


    public void completeTransaction(String escrowTrxHash) {
        // Call the completeTransaction method in the smart contract
        log.info("Completing transaction with hash {}", escrowTrxHash);
    }

    public void cancelTransaction(String escrowTrxHash) {
        // Call the cancelTransaction method in the smart contract
        log.info("Cancel transaction with hash to refund buyer{}", escrowTrxHash);
    }
}
