package com.chel.lab2.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {
    private Long id;
    private String login;
    private String pass;
    private String name;
    private double account;


    public Client() {
    }

    public Client(Long id, String login, String pass, String name, double account) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.account = account;
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
    @Column(name = "login", nullable = false, length = 32)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "pass", nullable = false, length = 32)
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 16)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "account", nullable = false, precision = 0)
    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Double.compare(client.account, account) == 0 &&
                Objects.equals(login, client.login) &&
                Objects.equals(pass, client.pass) &&
                Objects.equals(name, client.name);
    }

    @Override
    public String   toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, pass, name, account);
    }
}
