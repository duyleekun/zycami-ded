/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

public class VerifyException
extends RuntimeException {
    public VerifyException() {
    }

    public VerifyException(String string2) {
        super(string2);
    }

    public VerifyException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public VerifyException(Throwable throwable) {
        super(throwable);
    }
}

