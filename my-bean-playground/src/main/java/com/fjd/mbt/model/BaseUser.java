package com.fjd.mbt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class BaseUser extends BaseModel {

    @ApiModelProperty
    private String firstName;

    @ApiModelProperty
    private String lastName;

    @ApiModelProperty
    private String phone;

    @ApiModelProperty
    private String type;

    @JsonManagedReference(value = "user_tag")
    @ApiModelProperty
    @OneToMany(mappedBy = "baseUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tag;

    // used when type is speaker
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;

    // used when type is audience
    @ManyToMany
    @JoinTable(name = "presentation_audience", joinColumns = @JoinColumn(name = "audience_id"), inverseJoinColumns = @JoinColumn(name = "presentation_id"))
    private List<Presentation> presentations = new ArrayList<>();

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the tag
     */
    public List<Tag> getTag() {
        return tag;
    }

    /**
     * @return the presentation
     */
    public Presentation getPresentation() {
        return presentation;
    }

    /**
     * @return the presentations
     */
    public List<Presentation> getPresentations() {
        return presentations;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @param tag
     *            the tag to set
     */
    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    /**
     * @param presentation
     *            the presentation to set
     */
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    /**
     * @param presentations
     *            the presentations to set
     */
    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }
}