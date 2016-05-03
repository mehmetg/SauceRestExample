package com.yourcompany.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mehmetg on 4/7/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SauceSubUserList {

    @JsonProperty("users_total")
    private int usersTotal;

    @JsonProperty("users")
    private List<SauceUser> subUsers;

    public int getUsersTotal() {
        return usersTotal;
    }

    public void setUsersTotal(int usersTotal) {
        this.usersTotal = usersTotal;
    }

    public List<SauceUser> getSubUsers() {
        return subUsers;
    }

    public void setSubUsers(List<SauceUser> subUsers) {
        this.subUsers = subUsers;
    }

    public String toJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

}
