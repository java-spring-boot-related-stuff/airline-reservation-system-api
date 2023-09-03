package com.ars.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="flight_bookings")
@Data
@ToString
public class FlightBooking {

    @Id
    @Column(name="booking_id")
    private String bookingId;

    @Column(name="customer_name")
    private String customerName;

    @ManyToOne(optional = false)
    @JoinColumn(name="flight_schedule_id")
    private FlightSchedule flightSchedule;

    @Column(name="amount_paid")
    private Integer amountPaid;

    // 0 - Waiting 1- Confirmed 2- Cancelled
    @Column(name="current_status")
    private Integer currentStatus;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="last_updated_at")
    private LocalDateTime lastUpdatedAt;

    @Column(name="last_updated_by")
    private String lastUpdatedBy;
}
