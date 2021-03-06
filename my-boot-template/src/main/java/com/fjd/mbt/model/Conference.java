package com.fjd.mbt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.List;

@Entity
public class Conference extends BaseModel {
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Calendar endDate;

    @JsonManagedReference(value = "conference_presentation")
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Presentation> presentations;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the presentations
     */
    public List<Presentation> getPresentations() {
        return presentations;
    }

    /**
     * @param presentations the presentations to set
     */
    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }
}