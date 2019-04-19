package com.fjd.mbt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Calendar;

@MappedSuperclass
public abstract class BaseModel {

    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Basic(optional = false)
    @Column(insertable = true, updatable = false)
    private Calendar createdAt;

    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(insertable = false, updatable = true)
    private Calendar updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public Long getVersion() {
        return version;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    void onCreate() {
        this.setCreatedAt(now());
    }

    @PreUpdate
    void onPersist() {
        this.setUpdatedAt(now());
    }

    protected Calendar now() {
        return Calendar.getInstance();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}