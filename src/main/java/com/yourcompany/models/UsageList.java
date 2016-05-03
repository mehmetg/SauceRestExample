package com.yourcompany.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "usage",
        "username"
})
public class UsageList {

    @JsonProperty("usage")
    private List<List<Object>> usage = new ArrayList<List<Object>>();
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The usage
     */
    @JsonProperty("usage")
    public List<List<Object>> getUsage() {
        return usage;
    }

    /**
     * @param usage The usage
     */
    @JsonProperty("usage")
    public void setUsage(List<List<Object>> usage) {
        this.usage = usage;
    }

    /**
     * @return The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}