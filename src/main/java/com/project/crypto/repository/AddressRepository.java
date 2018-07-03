package com.project.crypto.repository;

import com.project.crypto.model.person.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
