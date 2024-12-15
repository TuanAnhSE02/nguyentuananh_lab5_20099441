package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
}