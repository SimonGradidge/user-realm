package com.user.realm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.user.realm.model.UserRealmEntity;
import lombok.Getter;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Getter
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JacksonXmlRootElement(localName = "realm")
@XmlAccessorType(XmlAccessType.NONE)
public class UserRealmResponse {

    @JacksonXmlProperty(isAttribute = true, localName = "id")
    @JsonProperty("id")
    private String id;

    @JacksonXmlProperty(isAttribute = true, localName = "name")
    @JsonProperty("name")
    private String realmName;

    @JacksonXmlProperty(localName = "description")
    @JsonProperty("description")
    private String realmDescription;

    @JacksonXmlProperty(localName = "key")
    @JsonProperty("key")
    private String realmKey;

    public UserRealmResponse(UserRealmEntity userRealm) {
        this.id = userRealm.getId();
        this.realmName = userRealm.getName();
        this.realmDescription = userRealm.getDescription();
        this.realmKey = userRealm.getRealmKey();
    }
}
