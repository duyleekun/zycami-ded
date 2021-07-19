/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.agconnect.exception;

import com.huawei.agconnect.exception.AGCException;

public class AGCServerException
extends AGCException {
    public static final int ACCESS_TOKEN_EXPIRED = 205524994;
    public static final int AUTHENTICATION_FAILED = 403;
    public static final int AUTHENTICATION_INVALID = 400;
    public static final int CLIENT_TOKEN_EXPIRED = 205524993;
    public static final int FETCH_THROTTLED = 1;
    public static final int NO_USER_LOGIN = 3;
    public static final int OK = 200;
    public static final int SERVER_NOT_AVAILABLE = 503;
    public static final int SERVER_RSP_INVALID = 2;
    public static final int TOKEN_INVALID = 401;
    public static final int UNKNOW_EXCEPTION = 500;
    private int retCode;

    public AGCServerException(String string2, int n10) {
        super(string2, n10);
    }

    public AGCServerException(String string2, int n10, int n11) {
        this(string2, n10);
        this.retCode = n11;
    }

    public int getRetCode() {
        return this.retCode;
    }
}

