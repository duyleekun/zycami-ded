/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

public final class HuaweiServicesNotAvailableException
extends Exception {
    public final int errorCode;

    public HuaweiServicesNotAvailableException(int n10) {
        this.errorCode = n10;
    }
}

