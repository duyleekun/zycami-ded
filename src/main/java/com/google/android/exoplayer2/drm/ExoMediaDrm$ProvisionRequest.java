/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$ProvisionRequest {
    private final byte[] data;
    private final String defaultUrl;

    public ExoMediaDrm$ProvisionRequest(byte[] byArray, String string2) {
        this.data = byArray;
        this.defaultUrl = string2;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDefaultUrl() {
        return this.defaultUrl;
    }
}

