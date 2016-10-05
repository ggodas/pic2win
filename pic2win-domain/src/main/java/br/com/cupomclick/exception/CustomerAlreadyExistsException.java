package br.com.cupomclick.exception;

/**
 * Created by georgegodas on 21/09/16.
 */
public class CustomerAlreadyExistsException extends Exception {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
