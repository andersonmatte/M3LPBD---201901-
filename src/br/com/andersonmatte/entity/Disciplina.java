package br.com.andersonmatte.entity;

import java.io.Serializable;

/**
 * Instituto Federal de São Paulo - Campus Sertãozinho
 * Disciplina......: M3LPBD
 * Programação de Computadores e Dispositivos Móveis
 * Aluno...........: Anderson Matte Tamborim
 *
 * Classe que representa a entidade Disciplina do Banco de Dados.
 */
public class Disciplina implements Serializable {

    private String nome;

    private Integer cargaHoraria;

    private String nomeCursoPertence;

    private Integer numeroVagas;

    private String periodo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeCursoPertence() {
        return nomeCursoPertence;
    }

    public void setNomeCursoPertence(String nomeCursoPertence) {
        this.nomeCursoPertence = nomeCursoPertence;
    }

    public Integer getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(Integer numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
