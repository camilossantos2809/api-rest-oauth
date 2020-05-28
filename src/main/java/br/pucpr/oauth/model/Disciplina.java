package br.pucpr.oauth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    private int codigo;
    @Column(nullable = false)
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

        Disciplina that = (Disciplina) o;

        if (codigo != that.codigo) return false;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        int result = codigo;
        result = 31 * result + nome.hashCode();
        return result;
    }
}
