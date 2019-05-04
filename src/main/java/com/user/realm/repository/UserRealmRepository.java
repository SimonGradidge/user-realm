package com.user.realm.repository;

import com.user.realm.model.UserRealmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRealmRepository extends JpaRepository<UserRealmEntity, String> {
    UserRealmEntity findByName(String name);
}
