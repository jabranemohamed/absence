package com.mhj.absence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable=false, length=120)
    private String email;

    @Column(nullable=false)
    private String encryptedPassword;

    private String emailVerificationToken;

    @Column(nullable=false)
    private Boolean emailVerificationStatus = false;

    @OneToOne(mappedBy="userDetails", cascade= CascadeType.ALL)
    private Address address;

    @ManyToMany(cascade= { CascadeType.ALL } )
    @JoinTable(name="users_roles",
            joinColumns=@JoinColumn(name="users_id",referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="roles_id",referencedColumnName="id"))
    private Collection<Role> roles;
}
