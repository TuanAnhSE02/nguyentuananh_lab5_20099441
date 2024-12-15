package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id", columnDefinition = "bigint(20)") // Đảm bảo tên cột là comp_id
    private Long id;

    @Column(name = "about", length = 2000)
    private String about;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "comp_name", nullable = false)
    private String compName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "web_url")
    private String webUrl;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>(); // Khởi tạo danh sách tại đây

    public Company(String about, String email, String compName, String phone, String webUrl, Address address, List<Job> jobs) {
        this.about = about;
        this.email = email;
        this.compName = compName;
        this.phone = phone;
        this.webUrl = webUrl;
        this.address = address;
        this.jobs = (jobs != null) ? jobs : new ArrayList<>(); // Khởi tạo danh sách nếu nó null
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", compName='" + compName + '\'' +
                ", phone='" + phone + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", address=" + address +
                ", jobs=" + jobs +
                '}';
    }
}
