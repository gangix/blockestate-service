package com.dcs.docusign.controller;



public class EthereumAddressGenerator {

//    @Test
//    public void wallets() throws Exception {
//        String walletDirectory = "./wallets";  // Relative path to current working directory
//
//        // Ensure the directory exists, if not, create it
//        File directory = new File(walletDirectory);
//        if (!directory.exists()) {
//            if (directory.mkdirs()) {
//                System.out.println("Wallet directory created at: " + walletDirectory);
//            } else {
//                System.err.println("Failed to create wallet directory.");
//                return; // Exit the program if directory creation fails
//            }
//        }
//
//        // Check if the directory is writable
//        if (!directory.canWrite()) {
//            System.err.println("Directory is not writable: " + walletDirectory);
//            return;
//        }
//
//        String password = "your-secure-password";
//        String walletFile = WalletUtils.generateNewWalletFile(password, new File(walletDirectory));
//        Credentials credentials = WalletUtils.loadCredentials(password, walletDirectory + "/" + walletFile);
//        System.out.println("Generated Wallet Address: " + credentials.getAddress());
//    }
}
