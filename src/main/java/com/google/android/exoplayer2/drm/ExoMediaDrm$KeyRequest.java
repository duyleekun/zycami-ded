/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public final class ExoMediaDrm$KeyRequest {
    public static final int REQUEST_TYPE_INITIAL = 0;
    public static final int REQUEST_TYPE_NONE = 3;
    public static final int REQUEST_TYPE_RELEASE = 2;
    public static final int REQUEST_TYPE_RENEWAL = 1;
    public static final int REQUEST_TYPE_UNKNOWN = Integer.MIN_VALUE;
    public static final int REQUEST_TYPE_UPDATE = 4;
    private final byte[] data;
    private final String licenseServerUrl;
    private final int requestType;

    public ExoMediaDrm$KeyRequest(byte[] byArray, String string2) {
        this(byArray, string2, -1 << -1);
    }

    public ExoMediaDrm$KeyRequest(byte[] byArray, String string2, int n10) {
        this.data = byArray;
        this.licenseServerUrl = string2;
        this.requestType = n10;
    }

    public byte[] getData() {
        return this.data;
    }

    public String getLicenseServerUrl() {
        return this.licenseServerUrl;
    }

    public int getRequestType() {
        return this.requestType;
    }
}

