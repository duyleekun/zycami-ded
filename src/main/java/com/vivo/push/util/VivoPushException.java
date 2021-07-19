/*
 * Decompiled with CFR 0.151.
 */
package com.vivo.push.util;

public class VivoPushException
extends Exception {
    public static final int REASON_CODE_ACCESS = 10000;
    private int mReasonCode;

    public VivoPushException(int n10, String string2) {
        super(string2);
        this.mReasonCode = n10;
    }

    public VivoPushException(String string2) {
        this(10000, string2);
    }

    public int getCode() {
        return this.mReasonCode;
    }
}

