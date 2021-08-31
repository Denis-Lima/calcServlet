package br.com.fatec.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Author: Denis Lima
 */

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "data_operacao", nullable = false)
    @CreationTimestamp
    private LocalDate dataOperacao;

    @OneToOne()
    @JoinColumn(name = "tipo_operacao")
    private Classificacao tipoOperacao;

    @Column(name = "operacao")
    private String operacao;

    @Column(name = "args")
    private String args;

    // CONSTRUCTOR
    public Log() {}

    // GETTERS AND SETTERS

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOperacao() {
        return this.dataOperacao;
    }

    public void setDataOperacao(LocalDate dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Classificacao getTipoOperacao() {
        return this.tipoOperacao;
    }

    public void setTipoOperacao(Classificacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getOperacao() {
        return this.operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getArgs() {
        return this.args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

}