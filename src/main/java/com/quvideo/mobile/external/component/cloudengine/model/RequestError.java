/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.model;

public class RequestError {
    private int OooO00o;
    private String OooO0O0;

    public RequestError(String string2, int n10) {
        this.OooO00o = n10;
        this.OooO0O0 = string2;
    }

    public int getCode() {
        return this.OooO00o;
    }

    public String getMessage() {
        return this.OooO0O0;
    }
}

