package hu.aestallon.adrestore.repository;

import hu.aestallon.adrestore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {}