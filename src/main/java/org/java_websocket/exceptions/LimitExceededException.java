/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

import org.java_websocket.exceptions.InvalidDataException;

public class LimitExceededException
extends InvalidDataException {
    private static final long serialVersionUID = 6908339749836826785L;
    private final int limit;

    public LimitExceededException() {
        this(-1 >>> 1);
    }

    public LimitExceededException(int n10) {
        super(1009);
        this.limit = n10;
    }

    public LimitExceededException(String string2) {
        this(string2, -1 >>> 1);
    }

    public LimitExceededException(String string2, int n10) {
        super(1009, string2);
        this.limit = n10;
    }

    public int getLimit() {
        return this.limit;
    }
}

