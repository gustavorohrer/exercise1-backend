package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties("new")
public class BaseDomainClass extends AbstractPersistable<Long> {

    @Version
    protected Long version;
    @CreatedDate
    protected LocalDateTime createdOn;
    @LastModifiedDate
    protected LocalDateTime modifiedOn;
    @CreatedBy
    @Column(length = 100)
    protected String createdBy;
    @LastModifiedBy
    @Column(length = 100)
    protected String modifiedBy;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", getId()).toString();
    }

    @JsonIgnore
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
