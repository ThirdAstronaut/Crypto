package com.project.crypto.controller;

import com.project.crypto.model.person.Address;
import com.project.crypto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteAddress(@PathVariable Long id) {
		return addressService.deleteAddress(id);
	}
	
	@RequestMapping("/add")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	@RequestMapping("/list/{id}")
	public Optional<Address> findOne(@PathVariable Long id) {
		return addressService.findOne(id);
	}
	
	@RequestMapping("/list")
	public List<Address> addressList() {
		return addressService.addressList();
	}
	
}
