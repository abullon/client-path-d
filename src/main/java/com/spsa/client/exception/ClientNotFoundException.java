package com.spsa.client.exception;

public class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(Long id) {
        super("Could not find client " + id);
    }
}
