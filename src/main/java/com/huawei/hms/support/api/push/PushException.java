/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.push;

public class PushException
extends RuntimeException {
    public static final String EXCEPTION_SEND_FAILED = "send message failed";

    public PushException() {
    }

    public PushException(String string2) {
        super(string2);
    }

    public PushException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public PushException(Throwable throwable) {
        super(throwable);
    }
}

