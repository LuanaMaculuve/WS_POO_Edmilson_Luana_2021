/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.*;

/**
 *
 * @author Edmilson Nhabinde
 */
@Entity
public class TipoDePropriedade {

    @Id
    @GeneratedValue
    int id;
    String nome, tipo_da_prop, tipo_de_casa, bairro;
    int preco, quartos;
    boolean ja_tem_casas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_da_prop() {
        return tipo_da_prop;
    }

    public void setTipo_da_prop(String tipo_da_prop) {
        this.tipo_da_prop = tipo_da_prop;
    }

    public String getTipo_de_casa() {
        return tipo_de_casa;
    }

    public void setTipo_de_casa(String tipo_de_casa) {
        this.tipo_de_casa = tipo_de_casa;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isJa_tem_casas() {
        return ja_tem_casas;
    }

    public void setJa_tem_casas(boolean ja_tem_casas) {
        this.ja_tem_casas = ja_tem_casas;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public boolean isJa_te_casas() {
        return ja_tem_casas;
    }

    public void setJa_te_casas(boolean ja_tem_casas) {
        this.ja_tem_casas = ja_tem_casas;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
