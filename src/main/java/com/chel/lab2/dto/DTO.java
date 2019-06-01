package com.chel.lab2.dto;

public class DTO {
    private String value;

    public DTO() {
    }

    public DTO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DTO{" +
                "value='" + value + '\'' +
                '}';
    }
}
