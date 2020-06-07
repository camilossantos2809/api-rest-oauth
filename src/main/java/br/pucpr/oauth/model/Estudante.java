package br.pucpr.oauth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudante")
public class Estudante {
    @Id
    private int codigo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estudante estudante = (Estudante) o;

        return codigo == estudante.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }
}
