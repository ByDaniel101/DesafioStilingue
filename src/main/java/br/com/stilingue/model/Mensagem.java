package br.com.stilingue.model;

import java.sql.Date;

public class Mensagem {
    private String texto;
    private Date data;
    private String status;
    private int id;

    public final String STATUS_PENDENTE = "Pendente";
    public final String STATUS_ABERTO = "Aberto";
    public final String STATUS_EM_ESPERA = "Em Espera";
    public final String STATUS_RESPONDIDO = "Respondido";
    public final String STATUS_FECHADO = "Fechado";
    public final String STATUS_IGNORADO = "Ignorado";

    public Mensagem(){

    }

    public Mensagem( int id, Date data, String status, String texto) {
        this.texto = texto;
        this.data = data;
        this.status = status;
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
