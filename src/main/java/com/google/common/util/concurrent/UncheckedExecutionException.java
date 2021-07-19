/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public class UncheckedExecutionException
extends RuntimeException {
    private static final long serialVersionUID;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(String string2) {
        super(string2);
    }

    public UncheckedExecutionException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public UncheckedExecutionException(Throwable throwable) {
        super(throwable);
    }
}

