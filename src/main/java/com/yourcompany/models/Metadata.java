package com.yourcompany.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "hostname",
        "git_version",
        "platform",
        "command",
        "build",
        "release",
        "nofile_limit"
})
public class Metadata {

    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("git_version")
    private String gitVersion;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("command")
    private String command;
    @JsonProperty("build")
    private String build;
    @JsonProperty("release")
    private String release;
    @JsonProperty("nofile_limit")
    private Integer nofileLimit;

    /**
     * @return The hostname
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname The hostname
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return The gitVersion
     */
    @JsonProperty("git_version")
    public String getGitVersion() {
        return gitVersion;
    }

    /**
     * @param gitVersion The git_version
     */
    @JsonProperty("git_version")
    public void setGitVersion(String gitVersion) {
        this.gitVersion = gitVersion;
    }

    /**
     * @return The platform
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform The platform
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return The command
     */
    @JsonProperty("command")
    public String getCommand() {
        return command;
    }

    /**
     * @param command The command
     */
    @JsonProperty("command")
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return The build
     */
    @JsonProperty("build")
    public String getBuild() {
        return build;
    }

    /**
     * @param build The build
     */
    @JsonProperty("build")
    public void setBuild(String build) {
        this.build = build;
    }

    /**
     * @return The release
     */
    @JsonProperty("release")
    public String getRelease() {
        return release;
    }

    /**
     * @param release The release
     */
    @JsonProperty("release")
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * @return The nofileLimit
     */
    @JsonProperty("nofile_limit")
    public Integer getNofileLimit() {
        return nofileLimit;
    }

    /**
     * @param nofileLimit The nofile_limit
     */
    @JsonProperty("nofile_limit")
    public void setNofileLimit(Integer nofileLimit) {
        this.nofileLimit = nofileLimit;
    }

}