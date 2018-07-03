package com.project.crypto.service;


import com.project.crypto.model.person.Address;

import java.util.List;

public interface AddressService {
    List<Address> addressList();

    Address findOne(Long id);

    Address addAddress(Address address);

    String deleteAddress(Long id);
}
