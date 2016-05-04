
        package com.yourcompany.models;

        import java.util.ArrayList;
        import java.util.List;
        import javax.annotation.Generated;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "status",
        "direct_domains",
        "vm_version",
        "last_connected",
        "shutdown_time",
        "ssh_port",
        "launch_time",
        "user_shutdown",
        "use_caching_proxy",
        "creation_time",
        "domain_names",
        "shared_tunnel",
        "tunnel_identifier",
        "host",
        "no_proxy_caching",
        "owner",
        "use_kgp",
        "no_ssl_bump_domains",
        "id",
        "metadata"
})
public class Tunnel {

    @JsonProperty("status")
    private String status;
    @JsonProperty("direct_domains")
    private List<String> directDomains = new ArrayList<String>();
    @JsonProperty("vm_version")
    private Object vmVersion;
    @JsonProperty("last_connected")
    private Integer lastConnected;
    @JsonProperty("shutdown_time")
    private Object shutdownTime;
    @JsonProperty("ssh_port")
    private Integer sshPort;
    @JsonProperty("launch_time")
    private Integer launchTime;
    @JsonProperty("user_shutdown")
    private Object userShutdown;
    @JsonProperty("use_caching_proxy")
    private Object useCachingProxy;
    @JsonProperty("creation_time")
    private Integer creationTime;
    @JsonProperty("domain_names")
    private Object domainNames;
    @JsonProperty("shared_tunnel")
    private Boolean sharedTunnel;
    @JsonProperty("tunnel_identifier")
    private String tunnelIdentifier;
    @JsonProperty("host")
    private String host;
    @JsonProperty("no_proxy_caching")
    private Boolean noProxyCaching;
    @JsonProperty("owner")
    private String owner;
    @JsonProperty("use_kgp")
    private Boolean useKgp;
    @JsonProperty("no_ssl_bump_domains")
    private Object noSslBumpDomains;
    @JsonProperty("id")
    private String id;
    @JsonProperty("metadata")
    private Metadata metadata;

    /**
     * @return The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The directDomains
     */
    @JsonProperty("direct_domains")
    public List<String> getDirectDomains() {
        return directDomains;
    }

    /**
     * @param directDomains The direct_domains
     */
    @JsonProperty("direct_domains")
    public void setDirectDomains(List<String> directDomains) {
        this.directDomains = directDomains;
    }

    /**
     * @return The vmVersion
     */
    @JsonProperty("vm_version")
    public Object getVmVersion() {
        return vmVersion;
    }

    /**
     * @param vmVersion The vm_version
     */
    @JsonProperty("vm_version")
    public void setVmVersion(Object vmVersion) {
        this.vmVersion = vmVersion;
    }

    /**
     * @return The lastConnected
     */
    @JsonProperty("last_connected")
    public Integer getLastConnected() {
        return lastConnected;
    }

    /**
     * @param lastConnected The last_connected
     */
    @JsonProperty("last_connected")
    public void setLastConnected(Integer lastConnected) {
        this.lastConnected = lastConnected;
    }

    /**
     * @return The shutdownTime
     */
    @JsonProperty("shutdown_time")
    public Object getShutdownTime() {
        return shutdownTime;
    }

    /**
     * @param shutdownTime The shutdown_time
     */
    @JsonProperty("shutdown_time")
    public void setShutdownTime(Object shutdownTime) {
        this.shutdownTime = shutdownTime;
    }

    /**
     * @return The sshPort
     */
    @JsonProperty("ssh_port")
    public Integer getSshPort() {
        return sshPort;
    }

    /**
     * @param sshPort The ssh_port
     */
    @JsonProperty("ssh_port")
    public void setSshPort(Integer sshPort) {
        this.sshPort = sshPort;
    }

    /**
     * @return The launchTime
     */
    @JsonProperty("launch_time")
    public Integer getLaunchTime() {
        return launchTime;
    }

    /**
     * @param launchTime The launch_time
     */
    @JsonProperty("launch_time")
    public void setLaunchTime(Integer launchTime) {
        this.launchTime = launchTime;
    }

    /**
     * @return The userShutdown
     */
    @JsonProperty("user_shutdown")
    public Object getUserShutdown() {
        return userShutdown;
    }

    /**
     * @param userShutdown The user_shutdown
     */
    @JsonProperty("user_shutdown")
    public void setUserShutdown(Object userShutdown) {
        this.userShutdown = userShutdown;
    }

    /**
     * @return The useCachingProxy
     */
    @JsonProperty("use_caching_proxy")
    public Object getUseCachingProxy() {
        return useCachingProxy;
    }

    /**
     * @param useCachingProxy The use_caching_proxy
     */
    @JsonProperty("use_caching_proxy")
    public void setUseCachingProxy(Object useCachingProxy) {
        this.useCachingProxy = useCachingProxy;
    }

    /**
     * @return The creationTime
     */
    @JsonProperty("creation_time")
    public Integer getCreationTime() {
        return creationTime;
    }

    /**
     * @param creationTime The creation_time
     */
    @JsonProperty("creation_time")
    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @return The domainNames
     */
    @JsonProperty("domain_names")
    public Object getDomainNames() {
        return domainNames;
    }

    /**
     * @param domainNames The domain_names
     */
    @JsonProperty("domain_names")
    public void setDomainNames(Object domainNames) {
        this.domainNames = domainNames;
    }

    /**
     * @return The sharedTunnel
     */
    @JsonProperty("shared_tunnel")
    public Boolean getSharedTunnel() {
        return sharedTunnel;
    }

    /**
     * @param sharedTunnel The shared_tunnel
     */
    @JsonProperty("shared_tunnel")
    public void setSharedTunnel(Boolean sharedTunnel) {
        this.sharedTunnel = sharedTunnel;
    }

    /**
     * @return The tunnelIdentifier
     */
    @JsonProperty("tunnel_identifier")
    public String getTunnelIdentifier() {
        return tunnelIdentifier;
    }

    /**
     * @param tunnelIdentifier The tunnel_identifier
     */
    @JsonProperty("tunnel_identifier")
    public void setTunnelIdentifier(String tunnelIdentifier) {
        this.tunnelIdentifier = tunnelIdentifier;
    }

    /**
     * @return The host
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * @param host The host
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return The noProxyCaching
     */
    @JsonProperty("no_proxy_caching")
    public Boolean getNoProxyCaching() {
        return noProxyCaching;
    }

    /**
     * @param noProxyCaching The no_proxy_caching
     */
    @JsonProperty("no_proxy_caching")
    public void setNoProxyCaching(Boolean noProxyCaching) {
        this.noProxyCaching = noProxyCaching;
    }

    /**
     * @return The owner
     */
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner The owner
     */
    @JsonProperty("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return The useKgp
     */
    @JsonProperty("use_kgp")
    public Boolean getUseKgp() {
        return useKgp;
    }

    /**
     * @param useKgp The use_kgp
     */
    @JsonProperty("use_kgp")
    public void setUseKgp(Boolean useKgp) {
        this.useKgp = useKgp;
    }

    /**
     * @return The noSslBumpDomains
     */
    @JsonProperty("no_ssl_bump_domains")
    public Object getNoSslBumpDomains() {
        return noSslBumpDomains;
    }

    /**
     * @param noSslBumpDomains The no_ssl_bump_domains
     */
    @JsonProperty("no_ssl_bump_domains")
    public void setNoSslBumpDomains(Object noSslBumpDomains) {
        this.noSslBumpDomains = noSslBumpDomains;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The metadata
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}