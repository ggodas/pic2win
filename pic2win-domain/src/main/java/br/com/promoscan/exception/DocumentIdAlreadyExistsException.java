package br.com.promoscan.exception;

/**
 * Created by georgegodas on 21/09/16.
 */
public class DocumentIdAlreadyExistsException extends Exception {
    public DocumentIdAlreadyExistsException(String message) {
        super(message);
    }
}
