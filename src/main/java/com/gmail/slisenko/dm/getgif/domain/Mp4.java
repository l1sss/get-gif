
package com.gmail.slisenko.dm.getgif.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "dims",
    "duration",
    "preview",
    "size"
})
public class Mp4 {

    @JsonProperty("url")
    private String url;
    @JsonProperty("dims")
    private List<Integer> dims = null;
    @JsonProperty("duration")
    private Double duration;
    @JsonProperty("preview")
    private String preview;
    @JsonProperty("size")
    private Integer size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("dims")
    public List<Integer> getDims() {
        return dims;
    }

    @JsonProperty("dims")
    public void setDims(List<Integer> dims) {
        this.dims = dims;
    }

    @JsonProperty("duration")
    public Double getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @JsonProperty("preview")
    public String getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(String preview) {
        this.preview = preview;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
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
