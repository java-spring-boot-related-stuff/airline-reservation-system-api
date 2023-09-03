package com.ars.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="airport_details")
@Data
@ToString
public class Airport {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="last_updated_at")
    private LocalDateTime lastUpdatedAt;

    @Column(name="last_updated_by")
    private String lastUpdatedBy;
}
