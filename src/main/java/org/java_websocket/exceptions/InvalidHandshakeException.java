/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

import org.java_websocket.exceptions.InvalidDataException;

public class InvalidHandshakeException
extends InvalidDataException {
    private static final long serialVersionUID = -1426533877490484964L;

    public InvalidHandshakeException() {
        super(1002);
    }

    public InvalidHandshakeException(String string2) {
        super(1002, string2);
    }

    public InvalidHandshakeException(String string2, Throwable throwable) {
        super(1002, string2, throwable);
    }

    public InvalidHandshakeException(Throwable throwable) {
        super(1002, throwable);
    }
}

