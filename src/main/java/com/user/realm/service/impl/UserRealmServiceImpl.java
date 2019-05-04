package com.user.realm.service.impl;

import com.user.realm.exception.UserRealmException;
import com.user.realm.model.UserRealmEntity;
import com.user.realm.repository.UserRealmRepository;
import com.user.realm.request.CreateUserRealmRequest;
import com.user.realm.service.UserRealmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
public class UserRealmServiceImpl implements UserRealmService {

    @Autowired
    private UserRealmRepository userRealmRepository;

    @Override
    public UserRealmEntity createUserRealm(CreateUserRealmRequest request) throws UserRealmException {
        log.info("Creating user realm with requested name {}", request.getName());
        validateRequest(request);

        UserRealmEntity userRealm = new UserRealmEntity();
        try {
            userRealm.setId(createId());
            userRealm.setName(request.getName());
            userRealm.setDescription(request.getDescription());
            userRealm.setRealmKey(createEncryptionKey());

            userRealmRepository.save(userRealm);
        } catch (Exception e) {
            log.error("An exception occur when attempting to create user realm", e);
            throw new UserRealmException("Unable to create user realm");
        }
        return userRealm;
    }

    @Override
    public UserRealmEntity getUserRealm(String realmId) throws UserRealmException {
        log.info("Retrieving user realm with id {}", realmId);
        UserRealmEntity userRealmEntity;
        if (!realmId.matches("\\d+")) {
            log.error("Invalid realm ID argument: {}", realmId);
            throw new UserRealmException("InvalidArgument");
        }

        try {
            userRealmEntity = userRealmRepository.findById(realmId).orElse(null);
        } catch (Exception e) {
            log.error("An exception occur when attempting to retrieve user realm", e);
            throw new UserRealmException("Unable to retrieve user realm");
        }

        if (Objects.isNull(userRealmEntity)) {
            log.error("Realm with ID {} could not be found", realmId);
            throw new UserRealmException("RealmNotFound");
        }

        return userRealmEntity;
    }

    private void validateRequest(CreateUserRealmRequest request) throws UserRealmException {
        if (Objects.isNull(request.getName())) {
            log.error("Invalid Realm Name: {}", request.getName());
            throw new UserRealmException("InvalidRealmName");
        }

        if (Objects.nonNull(userRealmRepository.findByName(request.getName()))) {
            log.error("Realm already exists with name: {}", request.getName());
            throw new UserRealmException("DuplicateRealmName");
        }
    }

    private String createId() {
        log.debug("Creating realm id");
        return "" + (int)(Math.random() * 2000000000);
    }

    private String createEncryptionKey() {
        log.debug("Creating encryption realmKey");
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,32);
    }
}
