/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

public class InvalidDataException
extends Exception {
    private static final long serialVersionUID = 3731842424390998726L;
    private final int closecode;

    public InvalidDataException(int n10) {
        this.closecode = n10;
    }

    public InvalidDataException(int n10, String string2) {
        super(string2);
        this.closecode = n10;
    }

    public InvalidDataException(int n10, String string2, Throwable throwable) {
        super(string2, throwable);
        this.closecode = n10;
    }

    public InvalidDataException(int n10, Throwable throwable) {
        super(throwable);
        this.closecode = n10;
    }

    public int getCloseCode() {
        return this.closecode;
    }
}

