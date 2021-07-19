/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException
extends Exception {
    public final int errorCode;

    public GooglePlayServicesNotAvailableException(int n10) {
        this.errorCode = n10;
    }
}

