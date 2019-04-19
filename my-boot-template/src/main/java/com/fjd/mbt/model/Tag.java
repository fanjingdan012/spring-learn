package com.fjd.mbt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Tag extends BaseModel {

    private String name;

    @JsonBackReference(value = "presentation-tag")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "presentation_id", referencedColumnName = "id")
    private Presentation presentation;

    @JsonBackReference(value = "user_tag")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "baseUser_id", referencedColumnName = "id")
    private BaseUser baseUser;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the presentation
     */
    public Presentation getPresentation() {
        return presentation;
    }

    /**
     * @return the baseUser
     */
    public BaseUser getBaseUser() {
        return baseUser;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param presentation the presentation to set
     */
    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    /**
     * @param baseUser the baseUser to set
     */
    public void setBaseUser(BaseUser baseUser) {
        this.baseUser = baseUser;
    }
}