package com.mhj.absence.repository;

import com.mhj.absence.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByEmail(String email);

    User findByUserId(String userId);

    User findUserByEmailVerificationToken(String token);


}

