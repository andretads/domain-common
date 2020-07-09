package br.com.damsete.domain.exceptions;

public class ObjectDuplicatedException extends RuntimeException {

    public ObjectDuplicatedException(String message) {
        super(message);
    }
}
