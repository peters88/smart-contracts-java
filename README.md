# smart-contracts-java

https://medium.com/coinmonks/ethereum-blockchain-hello-world-smart-contract-with-java-9b6ae2961ad1

###Installing Geth
```
brew tap ethereum/ethereum
brew install ethereum
```
###initiate blockchain protocol
```
geth --datadir=./chaindata/ init ./genesis.json
```
###Start node:
```
geth --identity "LocalTestNode" --http --http.port 8080 --http.corsdomain "*" --datadir ./data/ --port 30303 --nodiscover --http.api db,eth,net,web3,personal --networkid 1999 --maxpeers 0 console --rpc.allow-unprotected-txs --allow-insecure-unlock ./logs/00.log
```

###Account creation:
passphrase: test123
Public address of the key:   0x92531d8e964F426746dd3c7F687a3076E5f36e97
Path of the secret key file: data/keystore/UTC--2022-03-01T13-25-50.190459000Z--92531d8e964f426746dd3c7f687a3076e5f36e97

####Comando para q no pida password por un rato:
```
web3.personal.unlockAccount(web3.personal.listAccounts[0],"test123", 30000)
```
passphrase: test123
Public address of the key:   0x9Dc7f979e771fa1bC8EC2c5Db5fA5788840440B4
Path of the secret key file: data/keystore/UTC--2022-03-01T13-27-45.790519000Z--9dc7f979e771fa1bc8ec2c5db5fa5788840440b4

###install solc:
```
brew update
brew upgrade
brew tap ethereum/ethereum
brew install solidity
```
```
solc HelloWorld.sol --bin --abi --optimize -o ./
```
###Install web3j:
```
brew tap web3j/web3j
brew install web3j
```
```
sudo ./web3j solidity generate Counter.bin Counter.abi -o . -p org.example
```

###To start mining:
```
miner.start();
```