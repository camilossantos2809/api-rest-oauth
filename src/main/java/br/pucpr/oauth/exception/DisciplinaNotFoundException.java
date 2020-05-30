package br.pucpr.oauth.exception;

public class DisciplinaNotFoundException extends RuntimeException {
    public DisciplinaNotFoundException(Integer id){
        super("Disciplina não encontrada: " + id);
    }
}
