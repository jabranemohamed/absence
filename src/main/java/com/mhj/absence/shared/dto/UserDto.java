package com.mhj.absence.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Setter
@Getter
public class UserDto implements Serializable {

    private static final long serialVersionUID = 6835192601898364280L;

    private long id;

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String encryptedPassword;

    private String emailVerificationToken;

    private Boolean emailVerificationStatus = false;

    private AddressDTO addresses;

    private Collection<String> roles;
}
