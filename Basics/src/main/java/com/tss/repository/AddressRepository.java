package com.tss.repository;

import com.tss.entity.Address;

import java.util.List;

public interface AddressRepository{
    List<Address> findAll();
    Address findById(int id);
    int save(Address address);
}
