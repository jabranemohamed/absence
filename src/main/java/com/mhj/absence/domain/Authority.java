package com.mhj.absence.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority implements Serializable {

    private static final long serialVersionUID = -5828101164006114538L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable=false, length=20)
    private String name;

    @ManyToMany(mappedBy="authorities")
    private Collection<Role> roles;
}
