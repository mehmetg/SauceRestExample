
package com.yourcompany.models;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "usernames"
})
public class UsersToDelete {

    @JsonProperty("usernames")
    private List<String> usernames = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UsersToDelete() {
    }

    /**
     * @param usernames
     */
    public UsersToDelete(List<String> usernames) {
        this.usernames = usernames;
    }

    /**
     * @return The usernames
     */
    @JsonProperty("usernames")
    public List<String> getUsernames() {
        return usernames;
    }

    /**
     * @param usernames The usernames
     */
    @JsonProperty("usernames")
    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
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