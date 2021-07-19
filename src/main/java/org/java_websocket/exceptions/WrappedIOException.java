/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

import i.d.f;
import java.io.IOException;

public class WrappedIOException
extends Exception {
    private final f connection;
    private final IOException ioException;

    public WrappedIOException(f f10, IOException iOException) {
        this.connection = f10;
        this.ioException = iOException;
    }

    public f getConnection() {
        return this.connection;
    }

    public IOException getIOException() {
        return this.ioException;
    }
}

