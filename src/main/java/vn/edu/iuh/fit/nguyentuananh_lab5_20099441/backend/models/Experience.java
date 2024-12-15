package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "experience")
@NoArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Column(name = "company", length = 120)
    private String company;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "role", length = 100)
    private String role;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "work_desc", length = 400)
    private String workDesc;

    @Column(name = "can_id")
    private Long canId;

    public Experience(String company, LocalDate fromDate, String role, LocalDate toDate, String workDesc, Long canId) {
        this.company = company;
        this.fromDate = fromDate;
        this.role = role;
        this.toDate = toDate;
        this.workDesc = workDesc;
        this.canId = canId;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", fromDate=" + fromDate +
                ", role='" + role + '\'' +
                ", toDate=" + toDate +
                ", workDesc='" + workDesc + '\'' +
                ", canId=" + canId +
                '}';
    }
}