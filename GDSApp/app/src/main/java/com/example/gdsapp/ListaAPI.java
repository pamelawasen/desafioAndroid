package com.example.gdsapp;

import java.util.ArrayList;

class ListaAPI {

    private  String codCartao;
    private  String nomeEmpresa;
    private  String nome;
    private  String saldo;
    //private ArrayList movimentos;

    public String getCodCartao() {
        return codCartao;
    }

    public void setCodCartao(String codCartao) {
        this.codCartao = codCartao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    /*public ArrayList getMovimentos() {
        return movimentos;
    }

    public void setMovimentos(ArrayList movimentos) {
        this.movimentos = movimentos;
    }*/

    @Override
    public String toString(){
        return "codCartao" + getCodCartao()
                +"\nnomeEmpresa:" + getNomeEmpresa()
                +"\nnome:" + getNome()
                +"\nsaldo:" + getSaldo();
                //+"\nmovimentos" + getNomeEmpresa();
    }
}
