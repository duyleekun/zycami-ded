/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.ups.entity;

import com.huawei.hms.push.ups.entity.CodeResult;

public class TokenResult
extends CodeResult {
    public String c;

    public TokenResult() {
    }

    public TokenResult(int n10) {
        super(n10);
    }

    public TokenResult(int n10, String string2) {
        super(n10, string2);
    }

    public TokenResult(String string2) {
        this.c = string2;
    }

    public String getToken() {
        return this.c;
    }

    public void setToken(String string2) {
        this.c = string2;
    }
}

