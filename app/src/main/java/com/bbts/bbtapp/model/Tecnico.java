package com.bbts.bbtapp.model;

/**
 * Created by wesley on 12/06/17.
 */

public class Tecnico {
    private Long id;
    private String login;
    private String senha;
    private Double latitudeAtual;
    private Double longitudeAtual;

    public Double getLongitudeAtual() {
        return longitudeAtual;
    }

    public void setLongitudeAtual(Double longitudeAtual) {
        this.longitudeAtual = longitudeAtual;
    }

    public Double getLatitudeAtual() {
        return latitudeAtual;
    }

    public void setLatitudeAtual(Double latitudeAtual) {
        this.latitudeAtual = latitudeAtual;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
