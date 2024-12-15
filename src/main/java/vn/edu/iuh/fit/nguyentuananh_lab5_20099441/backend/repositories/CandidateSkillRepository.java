package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.CandidateSkillId;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.CandidateSkill;


public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}