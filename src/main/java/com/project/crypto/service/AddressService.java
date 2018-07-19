package com.project.crypto.service;


import com.project.crypto.model.person.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> addressList();

    Optional<Address> findOne(Long id);

    Address addAddress(Address address);

    String deleteAddress(Long id);
}
