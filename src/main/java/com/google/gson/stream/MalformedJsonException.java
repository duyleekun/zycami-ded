/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.stream;

import java.io.IOException;

public final class MalformedJsonException
extends IOException {
    private static final long serialVersionUID = 1L;

    public MalformedJsonException(String string2) {
        super(string2);
    }

    public MalformedJsonException(String string2, Throwable throwable) {
        super(string2);
        this.initCause(throwable);
    }

    public MalformedJsonException(Throwable throwable) {
        this.initCause(throwable);
    }
}

