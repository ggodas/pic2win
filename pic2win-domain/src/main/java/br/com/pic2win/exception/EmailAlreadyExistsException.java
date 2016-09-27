package br.com.pic2win.exception;

/**
 * Created by georgegodas on 21/09/16.
 */
public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
