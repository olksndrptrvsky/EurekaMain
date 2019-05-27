package com.chel.lab2.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;


    @Column(name = "place", nullable = false, length = 32)
    private String place;


    @Column(name = "distance", nullable = false)
    private int distance;


    @Column(name = "winner", nullable = false, length = 64)
    private String winner;

    public Race() {
    }

    public Race(Timestamp dateTime, String place, int distance, String winner) {
        this.dateTime = dateTime;
        this.place = place;
        this.distance = distance;
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(id, race.id) &&
                distance == race.distance &&
                Objects.equals(dateTime, race.dateTime) &&
                Objects.equals(place, race.place) &&
                Objects.equals(winner, race.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, place, distance, winner);
    }

}
