package org.web3j.model;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
public class RealEstateEscrowFactory extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b506108b98061001c5f395ff3fe608060405234801561000f575f80fd5b506004361061003f575f3560e01c8063c361765014610043578063d02d54eb14610073578063ebfbc5e614610086575b5f80fd5b61005661005136600461023e565b6100a6565b6040516001600160a01b0390911681526020015b60405180910390f35b610056610081366004610278565b610172565b6100996100943660046102a0565b6101a5565b60405161006a91906102c0565b5f808484846040516100b790610216565b6001600160a01b0393841681529290911660208301526040820152606001604051809103905ff0801580156100ee573d5f803e3d5ffd5b506001600160a01b038681165f8181526020818152604080832080546001810182559084529282902090920180546001600160a01b031916868616908117909155915188815294955092881693919290917fd99c67ae0185d6b0a36717d67d259f252914f7955744e4d81a91685ff480896d910160405180910390a4949350505050565b5f602052815f5260405f20818154811061018a575f80fd5b5f918252602090912001546001600160a01b03169150829050565b6001600160a01b0381165f908152602081815260409182902080548351818402810184019094528084526060939283018282801561020a57602002820191905f5260205f20905b81546001600160a01b031681526001909101906020018083116101ec575b50505050509050919050565b6105788061030c83390190565b80356001600160a01b0381168114610239575f80fd5b919050565b5f805f60608486031215610250575f80fd5b61025984610223565b925061026760208501610223565b929592945050506040919091013590565b5f8060408385031215610289575f80fd5b61029283610223565b946020939093013593505050565b5f602082840312156102b0575f80fd5b6102b982610223565b9392505050565b602080825282518282018190525f918401906040840190835b818110156103005783516001600160a01b03168352602093840193909201916001016102d9565b50909594505050505056fe6080604052348015600e575f80fd5b50604051610578380380610578833981016040819052602b916086565b5f80546001600160a01b039485166001600160a01b03199182161790915560018054939094169216919091179091556002556003805461ffff1916905560ba565b80516001600160a01b03811681146081575f80fd5b919050565b5f805f606084860312156097575f80fd5b609e84606c565b925060aa60208501606c565b9150604084015190509250925092565b6104b1806100c75f395ff3fe608060405260043610610079575f3560e01c8063aa8c217c1161004c578063aa8c217c1461011b578063b3ae1d2c1461013e578063d0e30db014610152578063fa391c641461015a575f80fd5b806308551a531461007d5780635c8cf750146100b95780637150d8ae146100cf57806395ee1221146100ed575b5f80fd5b348015610088575f80fd5b5060015461009c906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b3480156100c4575f80fd5b506100cd610173565b005b3480156100da575f80fd5b505f5461009c906001600160a01b031681565b3480156100f8575f80fd5b5060035461010b90610100900460ff1681565b60405190151581526020016100b0565b348015610126575f80fd5b5061013060025481565b6040519081526020016100b0565b348015610149575f80fd5b506100cd61027c565b6100cd6103d7565b348015610165575f80fd5b5060035461010b9060ff1681565b5f546001600160a01b031633146101df5760405162461bcd60e51b815260206004820152602560248201527f4f6e6c792062757965722063616e2063616e63656c20746865207472616e736160448201526431ba34b7b760d91b60648201526084015b60405180910390fd5b60035460ff16156102325760405162461bcd60e51b815260206004820152601d60248201527f5472616e73616374696f6e20616c726561647920636f6d706c6574656400000060448201526064016101d6565b6003805461ff0019166101001790555f80546002546040516001600160a01b039092169281156108fc029290818181858888f19350505050158015610279573d5f803e3d5ffd5b50565b5f546001600160a01b031633146102e55760405162461bcd60e51b815260206004820152602760248201527f4f6e6c792062757965722063616e20636f6d706c65746520746865207472616e60448201526639b0b1ba34b7b760c91b60648201526084016101d6565b60035460ff16156103385760405162461bcd60e51b815260206004820152601d60248201527f5472616e73616374696f6e20616c726561647920636f6d706c6574656400000060448201526064016101d6565b600354610100900460ff16156103905760405162461bcd60e51b815260206004820152601860248201527f5472616e73616374696f6e2069732063616e63656c6c6564000000000000000060448201526064016101d6565b6003805460ff19166001908117909155546002546040516001600160a01b039092169181156108fc0291905f818181858888f19350505050158015610279573d5f803e3d5ffd5b5f546001600160a01b031633146104305760405162461bcd60e51b815260206004820152601c60248201527f4f6e6c792062757965722063616e206465706f7369742066756e64730000000060448201526064016101d6565b60025434146104795760405162461bcd60e51b8152602060048201526015602482015274125b98dbdc9c9958dd08185b5bdd5b9d081cd95b9d605a1b60448201526064016101d6565b56fea2646970667358221220d36e0ce1c9991fc6e96f446ce977f1820840b043349bbc8db9b259e2723adc6864736f6c634300081a0033a26469706673582212201187bd5ba671ec0d42881a9b87d75347a3e0b584ac97625ac75f80efb69accb464736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_CREATEESCROW = "createEscrow";

    public static final String FUNC_ESCROWCONTRACTS = "escrowContracts";

    public static final String FUNC_GETESCROWCONTRACTS = "getEscrowContracts";

    public static final Event ESCROWCREATED_EVENT = new Event("EscrowCreated", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected RealEstateEscrowFactory(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RealEstateEscrowFactory(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RealEstateEscrowFactory(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RealEstateEscrowFactory(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<EscrowCreatedEventResponse> getEscrowCreatedEvents(
            TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ESCROWCREATED_EVENT, transactionReceipt);
        ArrayList<EscrowCreatedEventResponse> responses = new ArrayList<EscrowCreatedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EscrowCreatedEventResponse typedResponse = new EscrowCreatedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.escrowAddress = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.seller = (String) eventValues.getIndexedValues().get(2).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static EscrowCreatedEventResponse getEscrowCreatedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ESCROWCREATED_EVENT, log);
        EscrowCreatedEventResponse typedResponse = new EscrowCreatedEventResponse();
        typedResponse.log = log;
        typedResponse.escrowAddress = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.buyer = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.seller = (String) eventValues.getIndexedValues().get(2).getValue();
        typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<EscrowCreatedEventResponse> escrowCreatedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getEscrowCreatedEventFromLog(log));
    }

    public Flowable<EscrowCreatedEventResponse> escrowCreatedEventFlowable(
            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ESCROWCREATED_EVENT));
        return escrowCreatedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> createEscrow(String _buyer, String _seller,
            BigInteger _amount) {
        final Function function = new Function(
                FUNC_CREATEESCROW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer), 
                new org.web3j.abi.datatypes.Address(160, _seller), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> escrowContracts(String param0, BigInteger param1) {
        final Function function = new Function(FUNC_ESCROWCONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<List> getEscrowContracts(String _buyer) {
        final Function function = new Function(FUNC_GETESCROWCONTRACTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _buyer)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    @Deprecated
    public static RealEstateEscrowFactory load(String contractAddress, Web3j web3j,
            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateEscrowFactory(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RealEstateEscrowFactory load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RealEstateEscrowFactory(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RealEstateEscrowFactory load(String contractAddress, Web3j web3j,
            Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RealEstateEscrowFactory(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RealEstateEscrowFactory load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RealEstateEscrowFactory(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RealEstateEscrowFactory> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RealEstateEscrowFactory.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<RealEstateEscrowFactory> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RealEstateEscrowFactory.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<RealEstateEscrowFactory> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RealEstateEscrowFactory.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<RealEstateEscrowFactory> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RealEstateEscrowFactory.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
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

    public static class EscrowCreatedEventResponse extends BaseEventResponse {
        public String escrowAddress;

        public String buyer;

        public String seller;

        public BigInteger amount;
    }
}
