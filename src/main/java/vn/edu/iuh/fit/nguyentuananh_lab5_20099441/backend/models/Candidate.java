    package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDate;

    @Getter
    @Setter
    @Entity
    @Table(name = "candidate")
    public class Candidate {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(name = "dob", nullable = false)
        private LocalDate dob;

        @Column(name = "email", nullable = false)
        private String email;

        @Column(name = "full_name", nullable = false)
        private String fullName;

        @Column(name = "phone", length = 15)
        private String phone;

        @OneToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "address", nullable = false)
        private  Address address;

        @Override
        public String toString() {
            return "Candidate{" +
                    "id=" + id +
                    ", dob=" + dob +
                    ", email='" + email + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address=" + address +
                    '}';
        }
    }