package br.pucpr.oauth.exception;

public class DisciplinaNotFoundException extends RuntimeException {
    DisciplinaNotFoundException(int id){
        super("Disciplina não encontrada" + id);
    }
}
