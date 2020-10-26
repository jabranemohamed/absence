package com.mhj.absence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {

    private static final long serialVersionUID = 5605260522147928803L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "roles_authorities",
            joinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authorities_id", referencedColumnName = "id"))
    private Collection<Authority> authorities;
}
