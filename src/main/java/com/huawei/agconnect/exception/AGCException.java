/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.agconnect.exception;

public abstract class AGCException
extends Exception {
    private int code;
    private String errMsg;

    public AGCException(String string2, int n10) {
        this.code = n10;
        this.errMsg = string2;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" code: ");
        int n10 = this.code;
        stringBuilder.append(n10);
        stringBuilder.append(" message: ");
        String string2 = this.errMsg;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

