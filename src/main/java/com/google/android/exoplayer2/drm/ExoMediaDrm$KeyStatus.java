/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$KeyStatus {
    private final byte[] keyId;
    private final int statusCode;

    public ExoMediaDrm$KeyStatus(int n10, byte[] byArray) {
        this.statusCode = n10;
        this.keyId = byArray;
    }

    public byte[] getKeyId() {
        return this.keyId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

