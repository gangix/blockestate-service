// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

import "./RealEstateEscrow.sol"; // Import the RealEstateEscrow contract

contract RealEstateEscrowFactory {

    // Mapping to store escrow contract addresses by sale ID
    mapping(address => address[]) public escrowContracts;

    // Event to log the creation of new escrow contract
    event EscrowCreated(address indexed escrowAddress, address indexed buyer, address indexed seller, uint amount);

    // Function to create a new escrow contract
    function createEscrow(address _buyer, address _seller, uint _amount) external returns (address) {
        // Deploy a new instance of RealEstateEscrow for each transaction
        RealEstateEscrow newEscrow = new RealEstateEscrow(_buyer, _seller, _amount);
        
        // Store the created escrow contract in the mapping
        escrowContracts[_buyer].push(address(newEscrow));

        // Emit an event when the escrow contract is created
        emit EscrowCreated(address(newEscrow), _buyer, _seller, _amount);

        // Return the address of the newly created escrow contract
        return address(newEscrow);
    }

    // Function to retrieve all escrow contracts for a specific buyer
    function getEscrowContracts(address _buyer) external view returns (address[] memory) {
        return escrowContracts[_buyer];
    }
}