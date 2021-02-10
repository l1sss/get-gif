
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
    "tags",
    "url",
    "media",
    "created",
    "shares",
    "itemurl",
    "composite",
    "hasaudio",
    "title",
    "id"
})
public class Result {

    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("url")
    private String url;
    @JsonProperty("media")
    private List<Medium> media = null;
    @JsonProperty("created")
    private Double created;
    @JsonProperty("shares")
    private Integer shares;
    @JsonProperty("itemurl")
    private String itemurl;
    @JsonProperty("composite")
    private Object composite;
    @JsonProperty("hasaudio")
    private Boolean hasaudio;
    @JsonProperty("title")
    private String title;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("created")
    public Double getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Double created) {
        this.created = created;
    }

    @JsonProperty("shares")
    public Integer getShares() {
        return shares;
    }

    @JsonProperty("shares")
    public void setShares(Integer shares) {
        this.shares = shares;
    }

    @JsonProperty("itemurl")
    public String getItemurl() {
        return itemurl;
    }

    @JsonProperty("itemurl")
    public void setItemurl(String itemurl) {
        this.itemurl = itemurl;
    }

    @JsonProperty("composite")
    public Object getComposite() {
        return composite;
    }

    @JsonProperty("composite")
    public void setComposite(Object composite) {
        this.composite = composite;
    }

    @JsonProperty("hasaudio")
    public Boolean getHasaudio() {
        return hasaudio;
    }

    @JsonProperty("hasaudio")
    public void setHasaudio(Boolean hasaudio) {
        this.hasaudio = hasaudio;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
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
