package com.tss.repository;

import com.tss.entity.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryImpl implements AddressRepository {
    private Connection connection;

    public AddressRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                addresses.add(
                        new Address(resultSet.getInt("address_id"),
                                resultSet.getString("city"),
                                resultSet.getString("state"),
                                resultSet.getString("pincode"))
                );
            }
            return addresses;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return addresses;
    }

    @Override
    public Address findById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address WHERE addressId = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.wasNull()) {
                return null;
            }
            return new Address(resultSet.getInt("addressId"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("pincode"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void save(Address address) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO address VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setInt(1, address.getAddressId());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getState());
            preparedStatement.setString(4, address.getPincode());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
