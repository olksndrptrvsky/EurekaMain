package com.chel.lab2.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Rider {
    private Long id;
    private String fullName;
    private String horseBreed;
    private int winsCount;

    public Rider() {
    }

    public Rider(Long id, String fullName, String horseBreed, int winsCount) {
        this.id = id;
        this.fullName = fullName;
        this.horseBreed = horseBreed;
        this.winsCount = winsCount;
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
    @Column(name = "full_name", nullable = false, length = 64)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "horse_breed", nullable = false, length = 64)
    public String getHorseBreed() {
        return horseBreed;
    }

    public void setHorseBreed(String horseBreed) {
        this.horseBreed = horseBreed;
    }

    @Basic
    @Column(name = "wins_count", nullable = false)
    public int getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(int winsCount) {
        this.winsCount = winsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rider rider = (Rider) o;
        return Objects.equals(id, rider.id) &&
                winsCount == rider.winsCount &&
                Objects.equals(fullName, rider.fullName) &&
                Objects.equals(horseBreed, rider.horseBreed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, horseBreed, winsCount);
    }
}
