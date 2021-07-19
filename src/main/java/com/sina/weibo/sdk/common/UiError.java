/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.common;

public class UiError {
    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int n10, String string2, String string3) {
        this.errorCode = n10;
        this.errorMessage = string2;
        this.errorDetail = string3;
    }
}

