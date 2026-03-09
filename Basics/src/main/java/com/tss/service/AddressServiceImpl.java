package com.tss.service;

import com.tss.entity.Address;
import com.tss.repository.AddressRepository;

import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
