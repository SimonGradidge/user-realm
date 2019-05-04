package com.user.realm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.user.realm.model.UserRealmEntity;
import lombok.Getter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XmlRootElement(name = "realm")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRealmResponse {

    @XmlElement(name = "id")
    @JsonProperty("id")
    private String id;

    @XmlElement(name = "name")
    @JsonProperty("name")
    private String realmName;

    @XmlElement(name = "description")
    @JsonProperty("description")
    private String realmDescription;

    @XmlElement(name = "key")
    @JsonProperty("key")
    private String realmKey;

    public UserRealmResponse(UserRealmEntity userRealm) {
        this.id = userRealm.getId();
        this.realmName = userRealm.getName();
        this.realmDescription = userRealm.getDescription();
        this.realmKey = userRealm.getRealmKey();
    }
}
