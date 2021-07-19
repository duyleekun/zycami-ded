/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.ups.entity;

public class CodeResult {
    public int a;
    public String b;

    public CodeResult() {
    }

    public CodeResult(int n10) {
        this.a = n10;
    }

    public CodeResult(int n10, String string2) {
        this.a = n10;
        this.b = string2;
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(String string2) {
        this.b = string2;
    }

    public void setReturnCode(int n10) {
        this.a = n10;
    }
}

