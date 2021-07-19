/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push;

import com.huawei.hms.aaid.constant.ErrorEnum;

public class BaseException
extends Exception {
    public final int a;
    public final ErrorEnum b;

    public BaseException(int n10) {
        ErrorEnum errorEnum;
        this.b = errorEnum = ErrorEnum.fromCode(n10);
        this.a = n10 = errorEnum.getExternalCode();
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getMessage() {
        return this.b.getMessage();
    }
}

