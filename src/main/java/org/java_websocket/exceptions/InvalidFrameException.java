/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

import org.java_websocket.exceptions.InvalidDataException;

public class InvalidFrameException
extends InvalidDataException {
    private static final long serialVersionUID = -9016496369828887591L;

    public InvalidFrameException() {
        super(1002);
    }

    public InvalidFrameException(String string2) {
        super(1002, string2);
    }

    public InvalidFrameException(String string2, Throwable throwable) {
        super(1002, string2, throwable);
    }

    public InvalidFrameException(Throwable throwable) {
        super(1002, throwable);
    }
}

