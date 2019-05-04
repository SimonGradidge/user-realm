package com.user.realm.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "realm")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
public class CreateUserRealmRequest {

    @XmlElement(name = "name")
    @JsonProperty("name")
    @FormParam("name")
    private String name;

    @XmlElement(name = "description")
    @JsonProperty("description")
    @FormParam("description")
    private String description;
}
