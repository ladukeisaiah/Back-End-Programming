package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@Entity
@Table(name="divisions")
@Setter
@Getter

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;


    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_id")
    private long country_id;

//    public Division(Long id, String division_name) {
//        this.id = id;
//        this.division_name = division_name;
//    };


    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    public void add(Customer customer) {
        if (customer != null) {
            if (customers == null) {
                customers = new HashSet<>();
            }
            customers.add(customer);
            customer.setDivision(this);
        }
    }
}
