package com.yourcompany.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omg.CORBA.Object;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mehmetgerceker on 4/7/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SauceUser implements Serializable {
    @JsonProperty("domain")
    private String domain;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("creation_time")
    private Date creationTime;

    @JsonProperty("user_type")
    private String userType;

    @JsonProperty("children_count")
    private String childrenCount;

    @JsonProperty("concurrency_limit")
    private ConcurrencyLimit concurrencyLimit;

    @JsonProperty("manual_minutes")
    private String manualMinutes;

    @JsonProperty("can_run_manual")
    private boolean canRunManual;

    @JsonProperty("prevent_emails")
    private ArrayList<String> preventEmails;

    @JsonProperty("id")
    private String id;

    @JsonProperty("ancestor")
    private String ancestor;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("subscribed")
    private boolean subscribed;

    @JsonProperty("title")
    private String title;

    @JsonProperty("ancestor_allows_subaccounts")
    private boolean ancestorAllowsSubaccounts;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("vm_lockdown")
    private boolean vmLockdown;

    @JsonProperty("parent")
    private String parent;

    @JsonProperty("is_admin")
    private boolean isAdmin;

    @JsonProperty("is_public")
    private boolean isPublic;

    @JsonProperty("access_key")
    private String accessKey;

    @JsonProperty("name")
    private String name;

    @JsonProperty("is_sso")
    private boolean isSso;

    @JsonProperty("entity_type")
    private String entityType;

    @JsonProperty("ancestor_concurrency_limit")
    private ConcurrencyLimit ancestorConcurrencyLimit;

    @JsonProperty("minutes")
    private String minutes;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ConcurrencyLimit getConcurrencyLimit() {
        return concurrencyLimit;
    }

    public void setConcurrencyLimit(ConcurrencyLimit concurrencyLimit) {
        this.concurrencyLimit = concurrencyLimit;
    }

    public String getManualMinutes() {
        return manualMinutes;
    }

    public void setManualMinutes(String manualMinutes) {
        this.manualMinutes = manualMinutes;
    }

    public boolean isCanRunManual() {
        return canRunManual;
    }

    public void setCanRunManual(boolean canRunManual) {
        this.canRunManual = canRunManual;
    }

    public ArrayList<String> getPreventEmails() {
        return preventEmails;
    }

    public void setPreventEmails(ArrayList<String> preventEmails) {
        this.preventEmails = preventEmails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAncestor() {
        return ancestor;
    }

    public void setAncestor(String ancestor) {
        this.ancestor = ancestor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAncestorAllowsSubaccounts() {
        return ancestorAllowsSubaccounts;
    }

    public void setAncestorAllowsSubaccounts(boolean ancestorAllowsSubaccounts) {
        this.ancestorAllowsSubaccounts = ancestorAllowsSubaccounts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isVmLockdown() {
        return vmLockdown;
    }

    public void setVmLockdown(boolean vmLockdown) {
        this.vmLockdown = vmLockdown;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSso() {
        return isSso;
    }

    public void setSso(boolean sso) {
        isSso = sso;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public ConcurrencyLimit getAncestorConcurrencyLimit() {
        return ancestorConcurrencyLimit;
    }

    public void setAncestorConcurrencyLimit(ConcurrencyLimit ancestorConcurrencyLimit) {
        this.ancestorConcurrencyLimit = ancestorConcurrencyLimit;
    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String toJSON() throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
