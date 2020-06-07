package br.pucpr.oauth.exception;

public class NotaNotFoundException extends RuntimeException {
    public NotaNotFoundException(Integer id){
        super("Nota não encontrada: " + id);
    }
}
