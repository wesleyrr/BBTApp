package com.bbts.bbtapp.model;


/**
 * Created by wesley on 12/06/17.
 */

public class Equipamento {
    private String latitude;
    private String longitude;
    private String nome;
    private String numero_chamado;
    private String equipamento;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero_chamado() {
        return numero_chamado;
    }

    public void setNumero_chamado(String numero_chamado) {
        this.numero_chamado = numero_chamado;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }


    @Override
    public String toString() {
        return "lat:" + this.getLatitude() + "long:" + this.getLongitude() + "nome:" + this.getNome() + "numero_chamado:" + getNumero_chamado() + "equipamento:" + getEquipamento() ;
    }
}
