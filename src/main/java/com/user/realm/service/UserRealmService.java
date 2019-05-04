package com.user.realm.service;

import com.user.realm.model.UserRealmEntity;
import com.user.realm.request.CreateUserRealmRequest;

public interface UserRealmService {
    UserRealmEntity createUserRealm(CreateUserRealmRequest request);

    UserRealmEntity getUserRealm(String realmId);
}
