package com.project.crypto.service.impl;

import com.project.crypto.model.person.Address;
import com.project.crypto.repository.AddressRepository;
import com.project.crypto.repository.UserRepository;
import com.project.crypto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Address> findOne(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address addAddress(Address address) {
        return null;
    }


    @Override
    public String deleteAddress(Long id) {
        addressRepository.deleteById(id);
        return "{'message':'address deleted successfully'}";
    }
}
