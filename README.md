# **Trustless Real Estate Platform**

This is a Spring Boot-based application designed to revolutionize the real estate market by combining the power of Ethereum blockchain and DocuSign API. The platform offers a seamless, secure, and trustless flow for property buying and selling.

---

## **Features**
- **Property Listing**: Sellers can list properties with verified documents.
- **Trustless Transactions**: Secure payments and title transfers using Ethereum smart contracts.
- **Digital Signatures**: Legally binding agreements with DocuSign API.
- **Immutable History**: View property transaction history stored on the blockchain.
- **Escrow Automation**: Funds and ownership transfer handled transparently without intermediaries.

---

## **Requirements**
### **Prerequisites**
- **Java 17** or later
- **Maven** 3.8 or later
- **Node.js** (for any front-end component, if applicable)
- **Ethereum Wallet** (e.g., Metamask) for testing blockchain interactions
- **DocuSign Developer Account**

### **Secrets Configuration**
To run the app, you’ll need to provide your **DocuSign API service credentials**. Follow these steps:

1. Create a `.env` file in the root directory.
2. Add the following keys to the file:
   ```properties
   DOCUSIGN_CLIENT_ID=<your_client_id>
   DOCUSIGN_CLIENT_SECRET=<your_client_secret>
   DOCUSIGN_BASE_URL=<your_base_url>
   DOCUSIGN_REDIRECT_URI=<your_redirect_uri>
   ```
   Replace `<your_client_id>`, `<your_client_secret>`, etc., with your actual DocuSign API keys.
3. Ensure that the `.env` file is excluded from version control (already added to `.gitignore`).

---

## **Setup and Installation**
1. **Clone the repository**:
   ```bash
   git clone <repository_url>
   cd trustless-real-estate
   ```

2. **Install dependencies**:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

---

## **Blockchain Configuration**
1. Update Ethereum network settings in `application.properties`:
   ```properties
   blockchain.network=<network_name>
   blockchain.wallet.private_key=<your_private_key>
   blockchain.contract.address=<contract_address>
   ```

2. Deploy or connect to an existing smart contract for escrow and transaction management.

---

## **Usage**
### **For Sellers**
1. Register and verify your identity.
2. List your property with relevant documents.
3. Review and accept offers.

### **For Buyers**
1. Browse property listings.
2. Make an offer with an escrow deposit.
3. Sign agreements and complete payment.

---

## **Testing**
- Use mock data or test Ethereum networks like **Rinkeby** or **Goerli**.
- For DocuSign, use sandbox credentials from your developer account.

---

## **Contributing**
We welcome contributions! Please fork the repository, create a feature branch, and submit a pull request.

---

## **License**
This project is licensed under the MIT License.

---
