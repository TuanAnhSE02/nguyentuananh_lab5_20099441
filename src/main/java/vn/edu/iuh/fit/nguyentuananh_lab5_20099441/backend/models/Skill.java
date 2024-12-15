package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillType;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Enumerated
    private SkillType skillType;

    @Column(name = "skill_desc")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills= new ArrayList<>();
}