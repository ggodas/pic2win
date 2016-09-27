package br.com.promoscan.exception;

/**
 * Created by georgegodas on 21/09/16.
 */
public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
