package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.JobSkillId;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.JobSkill;


public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
}