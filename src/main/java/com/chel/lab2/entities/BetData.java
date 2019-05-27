package com.chel.lab2.entities;

import java.sql.Timestamp;

public class BetData {
    private String riderFullName;
    private String racePlace;
    private Timestamp raceDateTime;         //STRING
    private double sum;
    private double coeff;
    private String state;

    public BetData(double sum, String state) {
        this.sum = sum;
        this.state = state;
    }

    public String getRiderFullName() {
        return riderFullName;
    }

    public void setRiderFullName(String riderFullName) {
        this.riderFullName = riderFullName;
    }

    public String getRacePlase() {
        return racePlace;
    }

    public void setRacePlace(String racePlace) {
        this.racePlace = racePlace;
    }

    public Timestamp getRaceDateTime() {
        return raceDateTime;
    }

    public void setRaceDateTime(Timestamp raceDateTime) {
        this.raceDateTime = raceDateTime;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BetData{" +
                "riderFullName='" + riderFullName + '\'' +
                ", racePlace='" + racePlace + '\'' +
                ", raceDateTime=" + raceDateTime +
                ", sum=" + sum +
                ", coeff=" + coeff +
                ", state='" + state + '\'' +
                '}';
    }
}
