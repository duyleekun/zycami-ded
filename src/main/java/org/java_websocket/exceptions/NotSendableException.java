/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

public class NotSendableException
extends RuntimeException {
    private static final long serialVersionUID = -6468967874576651628L;

    public NotSendableException(String string2) {
        super(string2);
    }

    public NotSendableException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public NotSendableException(Throwable throwable) {
        super(throwable);
    }
}

