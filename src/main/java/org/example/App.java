package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import java.math.BigDecimal;

/**
 *
 *
 */
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService("http://127.0.0.1:8080"));
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "test123",
                        "/Users/psayol/Documents/Crypto/geth-files/data/keystore/UTC--2022-03-01T13-25-50.190459000Z--92531d8e964f426746dd3c7f687a3076e5f36e97");
        log.info("Credentials loaded");
        log.info("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                        web3j, credentials,
                        "0x9Dc7f979e771fa1bC8EC2c5Db5fA5788840440B4",  // you can put any address here
                        BigDecimal.valueOf(0,1), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .send();
        log.info("Transaction complete : "
                + transferReceipt.getTransactionHash());


        /////////


        // Now lets deploy a smart contract
        log.info("Deploying smart contract");
        Counter contract = Counter.deploy(
                web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();
        log.info("Smart contract deployed to address " + contractAddress);

        log.info("Initial value of counter in Smart contract: " + contract.get().send());
        log.info("Incrementing counter in Smart contract");
        contract.inc().send();
        log.info("Value of counter in Smart contract after increment : " + contract.get().send());
        log.info("Decrementing counter in Smart contract");
        contract.dec().send();
        log.info("Final value of counter in Smart contract : " + contract.get().send());
    }
}


