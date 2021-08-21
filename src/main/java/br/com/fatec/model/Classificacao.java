package br.com.fatec.model;

import javax.persistence.*;

/**
 * Author: Denis Lima
 */

@Entity
@Table(name = "classificacao")
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    // CONSTRUCTOR
    public Classificacao(){}

    // GETTERS AND SETTERS
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
