/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

import java.io.UnsupportedEncodingException;

public class InvalidEncodingException
extends RuntimeException {
    private final UnsupportedEncodingException encodingException;

    public InvalidEncodingException(UnsupportedEncodingException exception) {
        if (exception != null) {
            this.encodingException = exception;
            return;
        }
        throw exception;
    }

    public UnsupportedEncodingException getEncodingException() {
        return this.encodingException;
    }
}

