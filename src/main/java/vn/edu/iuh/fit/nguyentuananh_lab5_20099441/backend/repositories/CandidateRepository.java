package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}