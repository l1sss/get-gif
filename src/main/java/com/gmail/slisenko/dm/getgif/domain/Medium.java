
package com.gmail.slisenko.dm.getgif.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nanomp4",
    "nanowebm",
    "tinygif",
    "tinymp4",
    "tinywebm",
    "webm",
    "gif",
    "mp4",
    "loopedmp4",
    "mediumgif",
    "nanogif"
})
public class Medium {

    @JsonProperty("nanomp4")
    private Nanomp4 nanomp4;
    @JsonProperty("nanowebm")
    private Nanowebm nanowebm;
    @JsonProperty("tinygif")
    private Tinygif tinygif;
    @JsonProperty("tinymp4")
    private Tinymp4 tinymp4;
    @JsonProperty("tinywebm")
    private Tinywebm tinywebm;
    @JsonProperty("webm")
    private Webm webm;
    @JsonProperty("gif")
    private Gif gif;
    @JsonProperty("mp4")
    private Mp4 mp4;
    @JsonProperty("loopedmp4")
    private Loopedmp4 loopedmp4;
    @JsonProperty("mediumgif")
    private Mediumgif mediumgif;
    @JsonProperty("nanogif")
    private Nanogif nanogif;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nanomp4")
    public Nanomp4 getNanomp4() {
        return nanomp4;
    }

    @JsonProperty("nanomp4")
    public void setNanomp4(Nanomp4 nanomp4) {
        this.nanomp4 = nanomp4;
    }

    @JsonProperty("nanowebm")
    public Nanowebm getNanowebm() {
        return nanowebm;
    }

    @JsonProperty("nanowebm")
    public void setNanowebm(Nanowebm nanowebm) {
        this.nanowebm = nanowebm;
    }

    @JsonProperty("tinygif")
    public Tinygif getTinygif() {
        return tinygif;
    }

    @JsonProperty("tinygif")
    public void setTinygif(Tinygif tinygif) {
        this.tinygif = tinygif;
    }

    @JsonProperty("tinymp4")
    public Tinymp4 getTinymp4() {
        return tinymp4;
    }

    @JsonProperty("tinymp4")
    public void setTinymp4(Tinymp4 tinymp4) {
        this.tinymp4 = tinymp4;
    }

    @JsonProperty("tinywebm")
    public Tinywebm getTinywebm() {
        return tinywebm;
    }

    @JsonProperty("tinywebm")
    public void setTinywebm(Tinywebm tinywebm) {
        this.tinywebm = tinywebm;
    }

    @JsonProperty("webm")
    public Webm getWebm() {
        return webm;
    }

    @JsonProperty("webm")
    public void setWebm(Webm webm) {
        this.webm = webm;
    }

    @JsonProperty("gif")
    public Gif getGif() {
        return gif;
    }

    @JsonProperty("gif")
    public void setGif(Gif gif) {
        this.gif = gif;
    }

    @JsonProperty("mp4")
    public Mp4 getMp4() {
        return mp4;
    }

    @JsonProperty("mp4")
    public void setMp4(Mp4 mp4) {
        this.mp4 = mp4;
    }

    @JsonProperty("loopedmp4")
    public Loopedmp4 getLoopedmp4() {
        return loopedmp4;
    }

    @JsonProperty("loopedmp4")
    public void setLoopedmp4(Loopedmp4 loopedmp4) {
        this.loopedmp4 = loopedmp4;
    }

    @JsonProperty("mediumgif")
    public Mediumgif getMediumgif() {
        return mediumgif;
    }

    @JsonProperty("mediumgif")
    public void setMediumgif(Mediumgif mediumgif) {
        this.mediumgif = mediumgif;
    }

    @JsonProperty("nanogif")
    public Nanogif getNanogif() {
        return nanogif;
    }

    @JsonProperty("nanogif")
    public void setNanogif(Nanogif nanogif) {
        this.nanogif = nanogif;
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
