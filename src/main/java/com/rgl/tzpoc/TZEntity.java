package com.rgl.tzpoc;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Entity
class TZEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    private LocalDate dateCreatedLocalDate;
    @CreationTimestamp
    private LocalDateTime dateCreatedLocalDateTime;
    @CreationTimestamp
    private OffsetDateTime dateCreatedOffsetDateTime;
    private OffsetDateTime dateOffset;
    //Avoid interconversion
    private ZonedDateTime zonedDateTimeAmerica;
    private ZonedDateTime zonedDateTimeLocal;
    private Duration duration;
    private Instant instant;

    public void setDateOffset(OffsetDateTime dateOffset) {
        this.dateOffset = dateOffset;
    }

    public void setZonedDateTimeAmerica(ZonedDateTime zonedDateTime) {
        this.zonedDateTimeAmerica = zonedDateTime;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public void setZonedDateTimeLocal(ZonedDateTime zonedDateTimeLocal) {
        this.zonedDateTimeLocal = zonedDateTimeLocal;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDateCreatedLocalDate() {
        return dateCreatedLocalDate;
    }

    public LocalDateTime getDateCreatedLocalDateTime() {
        return dateCreatedLocalDateTime;
    }

    public OffsetDateTime getDateCreatedOffsetDateTime() {
        return dateCreatedOffsetDateTime;
    }

    public OffsetDateTime getDateOffset() {
        return dateOffset;
    }

    public ZonedDateTime getZonedDateTimeAmerica() {
        return zonedDateTimeAmerica;
    }

    public ZonedDateTime getZonedDateTimeLocal() {
        return zonedDateTimeLocal;
    }

    public Duration getDuration() {
        return duration;
    }

    public Instant getInstant() {
        return instant;
    }
}
