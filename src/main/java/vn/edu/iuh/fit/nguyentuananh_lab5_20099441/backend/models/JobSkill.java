package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.JobSkillId;


@Getter
@Setter
@Entity
@Table(name = "job_skill")
@NoArgsConstructor
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @MapsId("skillId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level")
    private SkillLevel skillLevel;


}