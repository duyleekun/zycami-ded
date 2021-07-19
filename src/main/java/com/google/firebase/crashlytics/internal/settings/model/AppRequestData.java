/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

public class AppRequestData {
    public final String appId;
    public final String buildVersion;
    public final String builtSdkVersion;
    public final String displayVersion;
    public final String googleAppId;
    public final String instanceIdentifier;
    public final String minSdkVersion;
    public final String name;
    public final String organizationId;
    public final int source;

    public AppRequestData(String string2, String string3, String string4, String string5, String string6, String string7, String string8, int n10, String string9, String string10) {
        this.organizationId = string2;
        this.googleAppId = string3;
        this.appId = string4;
        this.displayVersion = string5;
        this.buildVersion = string6;
        this.instanceIdentifier = string7;
        this.name = string8;
        this.source = n10;
        this.minSdkVersion = string9;
        this.builtSdkVersion = string10;
    }
}

