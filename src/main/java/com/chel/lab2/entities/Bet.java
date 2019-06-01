package com.chel.lab2.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Bet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private Long clientId;
    private int participantId;
    private double sum;
    private String state;

    public Bet() {
    }

    public Bet(Long clientId, int participantId, double sum, String state) {
        this.clientId = clientId;
        this.participantId = participantId;
        this.sum = sum;
        this.state = state;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client_id", nullable = false)
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "participant_id", nullable = false)
    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    @Basic
    @Column(name = "sum", nullable = false, precision = 0)
    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return Objects.equals(id, bet.id) &&
                Objects.equals(clientId, bet.clientId) &&
                Objects.equals(participantId, bet.participantId) &&
                Double.compare(bet.sum, sum) == 0 &&
                Objects.equals(clientId, bet.clientId) &&
                Objects.equals(state, bet.state);
    }


    @Override
    public String toString() {
        return "Bet{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", participantId=" + participantId +
                ", sum=" + sum +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, participantId, sum, state);
    }
}
