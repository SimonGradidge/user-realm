package com.user.realm.resources;

import com.user.realm.exception.UserRealmException;
import com.user.realm.request.CreateUserRealmRequest;
import com.user.realm.response.UserRealmExceptionResponse;
import com.user.realm.response.UserRealmResponse;
import com.user.realm.service.UserRealmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping("/service/user/realm")
public class RealmResource {

    @Autowired
    private UserRealmService userRealmService;

    @PostMapping(consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity createUserRealm(@Valid @RequestBody CreateUserRealmRequest request) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new UserRealmResponse(userRealmService.createUserRealm(request)));
        } catch (UserRealmException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new UserRealmExceptionResponse(e.getMessage()));
        }
    }

    @GetMapping(path = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity getUserRealm(@PathVariable("id") String id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new UserRealmResponse(userRealmService.getUserRealm(id)));
        } catch (UserRealmException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new UserRealmExceptionResponse(e.getMessage()));
        }
    }
}


