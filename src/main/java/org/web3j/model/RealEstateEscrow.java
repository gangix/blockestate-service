package org.web3j.model;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.1.
 */
@SuppressWarnings("rawtypes")
public class RealEstateEscrow extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b50604051610578380380610578833981016040819052602b916086565b5f80546001600160a01b039485166001600160a01b03199182161790915560018054939094169216919091179091556002556003805461ffff1916905560ba565b80516001600160a01b03811681146081575f80fd5b919050565b5f805f606084860312156097575f80fd5b609e84606c565b925060aa60208501606c565b9150604084015190509250925092565b6104b1806100c75f395ff3fe608060405260043610610079575f3560e01c8063aa8c217c1161004c578063aa8c217c1461011b578063b3ae1d2c1461013e578063d0e30db014610152578063fa391c641461015a575f80fd5b806308551a531461007d5780635c8cf750146100b95780637150d8ae146100cf57806395ee1221146100ed575b5f80fd5b348015610088575f80fd5b5060015461009c906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b3480156100c4575f80fd5b506100cd610173565b005b3480156100da575f80fd5b505f5461009c906001600160a01b031681565b3480156100f8575f80fd5b5060035461010b90610100900460ff1681565b60405190151581526020016100b0565b348015610126575f80fd5b5061013060025481565b6040519081526020016100b0565b348015610149575f80fd5b506100cd61027c565b6100cd6103d7565b348015610165575f80fd5b5060035461010b9060ff1681565b5f546001600160a01b031633146101df5760405162461bcd60e51b815260206004820152602560248201527f4f6e6c792062757965722063616e2063616e63656c20746865207472616e736160448201526431ba34b7b760d91b60648201526084015b60405180910390fd5b60035460ff16156102325760405162461bcd60e51b815260206004820152601d60248201527f5472616e73616374696f6e20616c726561647920636f6d706c6574656400000060448201526064016101d6565b6003805461ff0019166101001790555f80546002546040516001600160a01b039092169281156108fc029290818181858888f19350505050158015610279573d5f803e3d5ffd5b50565b5f546001600160a01b031633146102e55760405162461bcd60e51b815260206004820152602760248201527f4f6e6c792062757965722063616e20636f6d706c65746520746865207472616e60448201526639b0b1ba34b7b760c91b60648201526084016101d6565b60035460ff16156103385760405162461bcd60e51b815260206004820152601d60248201527f5472616e73616374696f6e20616c726561647920636f6d706c6574656400000060448201526064016101d6565b600354610100900460ff16156103905760405162461bcd60e51b815260206004820152601860248201527f5472616e73616374696f6e2069732063616e63656c6c6564000000000000000060448201526064016101d6565b6003805460ff19166001908117909155546002546040516001600160a01b039092169181156108fc0291905f818181858888f19350505050158015610279573d5f803e3d5ffd5b5f546001600160a01b031633146104305760405162461bcd60e51b815260206004820152601c60248201527f4f6e6c792062757965722063616e206465706f7369742066756e64730000000060448201526064016101d6565b60025434146104795760405162461bcd60e51b8152602060048201526015602482015274125b98dbdc9c9958dd08185b5bdd5b9d081cd95b9d605a1b60448201526064016101d6565b56fea2646970667358221220d36e0ce1c9991fc6e96f446ce977f1820840b043349bbc8db9b259e2723adc6864736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_AMOUNT = "amount";

    public static final String FUNC_BUYER = "buyer";

    public static final String FUNC_CANCELTRANSACTION = "cancelTransaction";

    public static final String FUNC_COMPLETETRANSACTION = "completeTransaction";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_ISCANCELLED = "isCancelled";

    public static final String FUNC_ISCOMPLETED = "isCompleted";

    public static final String FUNC_SELLER = "seller";

    @Deprecated
    protected RealEstateEscrow(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RealEstateEscrow(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RealEstateEscrow(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RealEstateEscrow(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> amount() {
        final Function function = new Function(FUNC_AMOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> buyer() {
        final Function function = new Function(FUNC_BUYER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> cancelTransaction() {
        final Function function = new Function(
                FUNC_CANCELTRANSACTION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> completeTransaction() {
        final Function function = new Function(
                FUNC_COMPLETETRANSACTION, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> deposit(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteFunctionCall<Boolean> isCancelled() {
        final Function function = new Function(FUNC_ISCANCELLED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> isCompleted() {
        final Function function = new Function(FUNC_ISCOMPLETED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> seller() {
        final Function function = new Function(FUNC_SELLER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static RealEstateEscrow load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateEscrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RealEstateEscrow load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateEscrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RealEstateEscrow load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RealEstateEscrow(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RealEstateEscrow load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RealEstateEscrow(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RealEstateEscrow> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, String _buyer, String _seller,
            BigInteger _amount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer), 
                new org.web3j.abi.datatypes.Address(160, _seller), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)));
        return deployRemoteCall(RealEstateEscrow.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<RealEstateEscrow> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider,
            String _buyer, String _seller, BigInteger _amount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer), 
                new org.web3j.abi.datatypes.Address(160, _seller), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)));
        return deployRemoteCall(RealEstateEscrow.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RealEstateEscrow> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, String _buyer, String _seller,
            BigInteger _amount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer), 
                new org.web3j.abi.datatypes.Address(160, _seller), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)));
        return deployRemoteCall(RealEstateEscrow.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RealEstateEscrow> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit,
            String _buyer, String _seller, BigInteger _amount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer), 
                new org.web3j.abi.datatypes.Address(160, _seller), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)));
        return deployRemoteCall(RealEstateEscrow.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
