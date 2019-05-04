package com.user.realm;

import com.user.realm.exception.UserRealmException;
import com.user.realm.model.UserRealmEntity;
import com.user.realm.repository.UserRealmRepository;
import com.user.realm.request.CreateUserRealmRequest;
import com.user.realm.service.impl.UserRealmServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRealmServiceImplTest {

    @InjectMocks
    private UserRealmServiceImpl userRealmService;

    @Mock
    private UserRealmRepository userRealmRepository;

    @Test
    public void testCreateRealm() {
        CreateUserRealmRequest request = new CreateUserRealmRequest();
        request.setName("Test");
        request.setDescription("Test");

        assertNotNull(userRealmService.createUserRealm(request));
    }

    @Test
    public void testGetRealm() {
        UserRealmEntity userRealm = new UserRealmEntity();
        when(userRealmRepository.findById("1234")).thenReturn(java.util.Optional.of(userRealm));
        assertNotNull(userRealmService.getUserRealm("1234"));
    }

    @Test(expected = UserRealmException.class)
    public void testInvalidRealmName() {
        CreateUserRealmRequest request = new CreateUserRealmRequest();
        request.setName(null);
        request.setDescription("Test");

        userRealmService.createUserRealm(request);
    }

    @Test(expected = UserRealmException.class)
    public void testDuplicateRealmName() {
        CreateUserRealmRequest request = new CreateUserRealmRequest();
        request.setName("Test");
        request.setDescription("Test");
        UserRealmEntity userRealm = new UserRealmEntity();
        when(userRealmRepository.findByName("Test")).thenReturn(userRealm);
        userRealmService.createUserRealm(request);
    }

    @Test(expected = UserRealmException.class)
    public void testInvalidArgument() {
        UserRealmEntity userRealm = new UserRealmEntity();
        when(userRealmRepository.findById("Test")).thenReturn(java.util.Optional.of(userRealm));
        userRealmService.getUserRealm("Test");
    }

    @Test(expected = UserRealmException.class)
    public void testRealmNotFound() {
        when(userRealmRepository.findById("1234")).thenReturn(Optional.empty());
        userRealmService.getUserRealm("1234");
    }
}
