/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

public class SettingsRequest {
    public final String buildVersion;
    public final String deviceModel;
    public final String displayVersion;
    public final String googleAppId;
    public final InstallIdProvider installIdProvider;
    public final String instanceId;
    public final String osBuildVersion;
    public final String osDisplayVersion;
    public final int source;

    public SettingsRequest(String string2, String string3, String string4, String string5, InstallIdProvider installIdProvider, String string6, String string7, String string8, int n10) {
        this.googleAppId = string2;
        this.deviceModel = string3;
        this.osBuildVersion = string4;
        this.osDisplayVersion = string5;
        this.installIdProvider = installIdProvider;
        this.instanceId = string6;
        this.displayVersion = string7;
        this.buildVersion = string8;
        this.source = n10;
    }
}

