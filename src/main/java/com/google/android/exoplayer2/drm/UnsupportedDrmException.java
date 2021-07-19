/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public final class UnsupportedDrmException
extends Exception {
    public static final int REASON_INSTANTIATION_ERROR = 2;
    public static final int REASON_UNSUPPORTED_SCHEME = 1;
    public final int reason;

    public UnsupportedDrmException(int n10) {
        this.reason = n10;
    }

    public UnsupportedDrmException(int n10, Exception exception) {
        super(exception);
        this.reason = n10;
    }
}

