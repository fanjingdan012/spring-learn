package com.fjd.mbt.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Presentation extends BaseModel {
    @ApiModelProperty
    private String title;

    @ApiModelProperty
    private String content;

    @ApiModelProperty
    private String location;

    @ApiModelProperty(dataType = "java.util.Calendar")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar startDate;

    @ApiModelProperty(dataType = "java.util.Calendar")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar endDate;

    @JsonBackReference(value = "conference_presentation")
    @ApiModelProperty
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "conference_id", referencedColumnName = "id", nullable = false)
    private Conference conference;

    @JsonManagedReference(value = "presentation_tag")
    @ApiModelProperty
    @OneToMany(mappedBy = "presentation", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Tag> tag;

    @ApiModelProperty
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private BaseUser speaker;

    @ApiModelProperty
    @ManyToMany(mappedBy = "presentations")
    private List<BaseUser> audiences;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return the startDate
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * @return the endDate
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * @return the conference
     */
    public Conference getConference() {
        return conference;
    }

    /**
     * @return the tag
     */
    public List<Tag> getTag() {
        return tag;
    }

    /**
     * @return the speaker
     */
    public BaseUser getSpeaker() {
        return speaker;
    }

    /**
     * @return the audiences
     */
    public List<BaseUser> getAudiences() {
        return audiences;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * @param conference
     *            the conference to set
     */
    public void setConference(Conference conference) {
        this.conference = conference;
    }

    /**
     * @param tag
     *            the tag to set
     */
    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    /**
     * @param speaker
     *            the speaker to set
     */
    public void setSpeaker(BaseUser speaker) {
        this.speaker = speaker;
    }

    /**
     * @param audiences
     *            the audiences to set
     */
    public void setAudiences(List<BaseUser> audiences) {
        this.audiences = audiences;
    }
}