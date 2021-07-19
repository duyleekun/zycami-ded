/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public class UncheckedTimeoutException
extends RuntimeException {
    private static final long serialVersionUID;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(String string2) {
        super(string2);
    }

    public UncheckedTimeoutException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public UncheckedTimeoutException(Throwable throwable) {
        super(throwable);
    }
}

