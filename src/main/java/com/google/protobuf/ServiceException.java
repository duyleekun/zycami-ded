/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public class ServiceException
extends Exception {
    private static final long serialVersionUID = -1219262335729891920L;

    public ServiceException(String string2) {
        super(string2);
    }

    public ServiceException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}

