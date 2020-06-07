package br.pucpr.oauth.exception;

public class EstudanteNotFoundException extends RuntimeException {
    public EstudanteNotFoundException(Integer id){
        super("Estudante não encontrado: " + id);
    }
}
