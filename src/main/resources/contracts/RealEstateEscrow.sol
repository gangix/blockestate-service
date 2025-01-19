// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract RealEstateEscrow {

    address public buyer;
    address public seller;
    uint public amount;
    bool public isCompleted;
    bool public isCancelled;

    constructor(address _buyer, address _seller, uint _amount) {
        buyer = _buyer;
        seller = _seller;
        amount = _amount;
        isCompleted = false;
        isCancelled = false;
    }

    // Complete the transaction
    function completeTransaction() public {
        require(msg.sender == buyer, "Only buyer can complete the transaction");
        require(!isCompleted, "Transaction already completed");
        require(!isCancelled, "Transaction is cancelled");

        isCompleted = true;
        payable(seller).transfer(amount);
    }

    // Cancel the transaction
    function cancelTransaction() public {
        require(msg.sender == buyer, "Only buyer can cancel the transaction");
        require(!isCompleted, "Transaction already completed");

        isCancelled = true;
        payable(buyer).transfer(amount);
    }

    // Deposit function to send Ether to the contract
    function deposit() public payable {
        require(msg.sender == buyer, "Only buyer can deposit funds");
        require(msg.value == amount, "Incorrect amount sent");
    }
}
