package com.mhj.absence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "addresses")
public class Address implements Serializable {

    private static final long serialVersionUID = 7809200551672852690L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 30, nullable = false)
    private String addressId;

    @Column(length = 15, nullable = false)
    private String city;

    @Column(length = 15, nullable = false)
    private String country;

    @Column(length = 100, nullable = false)
    private String streetName;

    @Column(length = 7, nullable = false)
    private String postalCode;

    @Column(length = 10, nullable = false)
    private String type;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User userDetails;
}
