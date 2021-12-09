/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Edmilson Nhabinde
 */
@Entity
public class Pagamentos {

    @Id
    @GeneratedValue
    int id;
    private String nome, bairro, tipo, data, tempo, tako, tipo_de_casa;

    public String getTipo_de_casa() {
        return tipo_de_casa;
    }

    public void setTipo_de_casa(String tipo_de_casa) {
        this.tipo_de_casa = tipo_de_casa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTako() {
        return tako;
    }

    public void setTako(String tako) {
        this.tako = tako;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

}
