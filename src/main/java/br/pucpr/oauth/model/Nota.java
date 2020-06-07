package br.pucpr.oauth.model;

import javax.persistence.*;

@Entity
@Table(name="nota")
public class Nota {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name="estudante_id")
    private Estudante estudante;

    private double nota;

    private double frequencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nota nota = (Nota) o;

        if (id != nota.id) return false;
        if (disciplina != null ? !disciplina.equals(nota.disciplina) : nota.disciplina != null) return false;
        return estudante != null ? estudante.equals(nota.estudante) : nota.estudante == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (disciplina != null ? disciplina.hashCode() : 0);
        result = 31 * result + (estudante != null ? estudante.hashCode() : 0);
        return result;
    }
}
