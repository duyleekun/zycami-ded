/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

public class ForbThrowable
extends Throwable {
    public ForbThrowable() {
        super("Service is forbidden currently");
    }

    public ForbThrowable(String string2) {
        super(string2);
    }
}

