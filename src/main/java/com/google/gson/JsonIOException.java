/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonParseException;

public final class JsonIOException
extends JsonParseException {
    private static final long serialVersionUID = 1L;

    public JsonIOException(String string2) {
        super(string2);
    }

    public JsonIOException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public JsonIOException(Throwable throwable) {
        super(throwable);
    }
}

