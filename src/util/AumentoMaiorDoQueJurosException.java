package util;

public class AumentoMaiorDoQueJurosException extends RuntimeException {

    public AumentoMaiorDoQueJurosException(String message){
        super(message);
    }

    public AumentoMaiorDoQueJurosException(String message, Throwable cause) {
        super(message,cause);
    }
}
