package vn.edu.iuh.fit.nguyentuananh_lab5_20099441.backend.models;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", length = 150)
    private String street;

    @Column(name = "city", length = 50)
    private String city;
    @Column(name = "country", columnDefinition = "smallint(6)")
    private CountryCode country = CountryCode.VN;

    @Column(name = "number", length = 20)
    private String number;


    @Column(name = "zipcode", length = 7)
    private String zipcode;

    public Address(String street, String city, String number, String zipcode,CountryCode country) {
        this.street = street;
        this.city = city;
        this.number = number;
        this.country = country;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", number='" + number + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}