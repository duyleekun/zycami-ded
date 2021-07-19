/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public class ExecutionError
extends Error {
    private static final long serialVersionUID;

    public ExecutionError() {
    }

    public ExecutionError(Error error) {
        super(error);
    }

    public ExecutionError(String string2) {
        super(string2);
    }

    public ExecutionError(String string2, Error error) {
        super(string2, error);
    }
}

