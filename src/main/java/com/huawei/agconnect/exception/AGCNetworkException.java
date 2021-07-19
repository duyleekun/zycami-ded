/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.agconnect.exception;

import com.huawei.agconnect.exception.AGCException;

public class AGCNetworkException
extends AGCException {
    public static final int NETWORK_UNAVAILABLE = 0;
    public static final int SERVER_NOT_REACH = 1;

    public AGCNetworkException(String string2, int n10) {
        super(string2, n10);
    }
}

