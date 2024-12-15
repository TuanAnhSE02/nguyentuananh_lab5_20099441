package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.enums.SkillLevel;
import vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models.Skill;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkillInformation {
    Skill skill;
    SkillLevel skillLevel;
    private String moreInfo;
}