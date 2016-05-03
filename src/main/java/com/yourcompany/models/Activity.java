

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
        "ccy_exec_peak",
        "datestamp",
        "ccy_exec_mean",
        "minutes",
        "jobs"
})
public class Activity {

    @JsonProperty("ccy_exec_peak")
    private List<Integer> ccyExecPeak = new ArrayList<Integer>();
    @JsonProperty("datestamp")
    private List<String> datestamp = new ArrayList<String>();
    @JsonProperty("ccy_exec_mean")
    private List<Integer> ccyExecMean = new ArrayList<Integer>();
    @JsonProperty("minutes")
    private List<Integer> minutes = new ArrayList<Integer>();
    @JsonProperty("jobs")
    private List<Integer> jobs = new ArrayList<Integer>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The ccyExecPeak
     */
    @JsonProperty("ccy_exec_peak")
    public List<Integer> getCcyExecPeak() {
        return ccyExecPeak;
    }

    /**
     * @param ccyExecPeak The ccy_exec_peak
     */
    @JsonProperty("ccy_exec_peak")
    public void setCcyExecPeak(List<Integer> ccyExecPeak) {
        this.ccyExecPeak = ccyExecPeak;
    }

    /**
     * @return The datestamp
     */
    @JsonProperty("datestamp")
    public List<String> getDatestamp() {
        return datestamp;
    }

    /**
     * @param datestamp The datestamp
     */
    @JsonProperty("datestamp")
    public void setDatestamp(List<String> datestamp) {
        this.datestamp = datestamp;
    }

    /**
     * @return The ccyExecMean
     */
    @JsonProperty("ccy_exec_mean")
    public List<Integer> getCcyExecMean() {
        return ccyExecMean;
    }

    /**
     * @param ccyExecMean The ccy_exec_mean
     */
    @JsonProperty("ccy_exec_mean")
    public void setCcyExecMean(List<Integer> ccyExecMean) {
        this.ccyExecMean = ccyExecMean;
    }

    /**
     * @return The minutes
     */
    @JsonProperty("minutes")
    public List<Integer> getMinutes() {
        return minutes;
    }

    /**
     * @param minutes The minutes
     */
    @JsonProperty("minutes")
    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    /**
     * @return The jobs
     */
    @JsonProperty("jobs")
    public List<Integer> getJobs() {
        return jobs;
    }

    /**
     * @param jobs The jobs
     */
    @JsonProperty("jobs")
    public void setJobs(List<Integer> jobs) {
        this.jobs = jobs;
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