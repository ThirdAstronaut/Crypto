package com.project.crypto.service.impl;

import com.project.crypto.model.person.Address;
import com.project.crypto.repository.AddressRepository;
import com.project.crypto.repository.UserRepository;
import com.project.crypto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Address> addressList() {
        return addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address addAddress(Address address) {
        return null;
    }


    @Override
    public String deleteAddress(Long id) {
        addressRepository.delete(id);
        return "{'message':'address deleted successfully'}";
    }
}
