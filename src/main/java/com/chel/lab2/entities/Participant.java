package com.chel.lab2.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Participant {
    private Long id;
    private Long raceId;
    private Long riderId;
    private Double coeff;

    public Participant() {
    }

    public Participant(Long id, Long raceId, Long riderId, Double coeff) {
        this.id = id;
        this.raceId = raceId;
        this.riderId = riderId;
        this.coeff = coeff;
    }



    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "race_id", nullable = false)
    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    @Basic
    @Column(name = "rider_id", nullable = false)
    public Long getRiderId() {
        return riderId;
    }

    public void setRiderId(Long riderId) {
        this.riderId = riderId;
    }

    @Basic
    @Column(name = "coeff", nullable = false, precision = 0)
    public Double getCoeff() {
        return coeff;
    }

    public void setCoeff(Double coeff) {
        this.coeff = coeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(raceId, that.raceId) &&
                Objects.equals(riderId, that.riderId) &&
                Double.compare(that.coeff, coeff) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, raceId, riderId, coeff);
    }
}
