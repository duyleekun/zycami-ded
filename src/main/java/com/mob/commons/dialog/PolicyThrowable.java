/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog;

public class PolicyThrowable
extends Throwable {
    private int code;

    public PolicyThrowable() {
        super("Privacy policy is not accepted");
    }

    public PolicyThrowable(int n10, String string2) {
        this(string2);
        this.code = n10;
    }

    public PolicyThrowable(int n10, String string2, Throwable throwable) {
        this(string2, throwable);
        this.code = n10;
    }

    public PolicyThrowable(String string2) {
        super(string2);
    }

    public PolicyThrowable(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public PolicyThrowable(Throwable throwable) {
        super(throwable);
    }

    public int getCode() {
        return this.code;
    }
}

