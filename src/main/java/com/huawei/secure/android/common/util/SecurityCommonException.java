/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.secure.android.common.util;

public class SecurityCommonException
extends Exception {
    private static final long serialVersionUID = 1L;
    private String v;
    private String w;

    public SecurityCommonException() {
    }

    public SecurityCommonException(String string2) {
        super(string2);
        this.w = string2;
    }

    public SecurityCommonException(String string2, String string3) {
        this.v = string2;
        this.w = string3;
    }

    public SecurityCommonException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public SecurityCommonException(Throwable throwable) {
        super(throwable);
    }

    public String getMsgDes() {
        return this.w;
    }

    public String getRetCd() {
        return this.v;
    }
}

