/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

public class AppSettingsData {
    public static final String STATUS_ACTIVATED = "activated";
    public static final String STATUS_CONFIGURED = "configured";
    public static final String STATUS_NEW = "new";
    public final String bundleId;
    public final int nativeReportUploadVariant;
    public final String ndkReportsUrl;
    public final String organizationId;
    public final int reportUploadVariant;
    public final String reportsUrl;
    public final String status;
    public final boolean updateRequired;
    public final String url;

    public AppSettingsData(String string2, String string3, String string4, String string5, String string6, String string7, boolean bl2, int n10, int n11) {
        this.status = string2;
        this.url = string3;
        this.reportsUrl = string4;
        this.ndkReportsUrl = string5;
        this.bundleId = string6;
        this.organizationId = string7;
        this.updateRequired = bl2;
        this.reportUploadVariant = n10;
        this.nativeReportUploadVariant = n11;
    }

    public AppSettingsData(String string2, String string3, String string4, String string5, boolean bl2) {
        this(string2, string3, string4, string5, null, null, bl2, 0, 0);
    }
}

