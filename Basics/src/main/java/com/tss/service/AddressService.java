package com.tss.service;

import com.tss.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    Address getAddressById(int id);
    void addAddress(Address address);
}
