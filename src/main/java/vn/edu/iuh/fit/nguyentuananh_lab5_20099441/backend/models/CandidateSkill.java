package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.ids.CandidateSkillId;


@Getter
@Setter
@Entity
@Table(name = "candidate_skill")
@NoArgsConstructor
public class CandidateSkill {
    @EmbeddedId
    private CandidateSkillId id;

    @MapsId("canId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "can_id", nullable = false)
    private Candidate candidate;

    @MapsId("skillId") // Ensure this matches the field in CandidateSkillId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill; // This should be the only mapping for skill_id

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;
}