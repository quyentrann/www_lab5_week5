package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Page<Address> findAll(Pageable pageable);
}
