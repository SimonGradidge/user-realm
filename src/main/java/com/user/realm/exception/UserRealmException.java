package com.user.realm.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class UserRealmException extends AbstractBadRequestException {

    private static final long serialVersionUID = 7394931306494602003L;

    public UserRealmException() {
        super();
    }

    public UserRealmException(String message) {
        super(message);
    }
}
