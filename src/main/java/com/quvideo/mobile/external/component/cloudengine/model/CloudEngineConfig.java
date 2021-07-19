/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.model;

public class CloudEngineConfig {
    private String OooO00o;
    private String OooO0O0;
    private String OooO0OO;
    private String OooO0Oo;
    private boolean OooO0o;
    private String OooO0o0;

    public CloudEngineConfig(String string2, String string3, String string4) {
        this(string2, string3, string4, null, null, false);
    }

    public CloudEngineConfig(String string2, String string3, String string4, String string5, String string6) {
        this(string2, string3, string4, string5, string6, false);
    }

    public CloudEngineConfig(String string2, String string3, String string4, String string5, String string6, boolean bl2) {
        this.OooO00o = string2;
        this.OooO0O0 = string3;
        this.OooO0OO = string4;
        this.OooO0Oo = string5;
        this.OooO0o0 = string6;
        this.OooO0o = bl2;
    }

    public CloudEngineConfig(String string2, String string3, String string4, boolean bl2) {
        this(string2, string3, string4, null, null, bl2);
    }

    public String getAppKey() {
        return this.OooO00o;
    }

    public String getAppSecret() {
        return this.OooO0O0;
    }

    public String getCountryCode() {
        return this.OooO0Oo;
    }

    public String getLanguageCode() {
        return this.OooO0o0;
    }

    public String getUserId() {
        return this.OooO0OO;
    }

    public boolean isDebug() {
        return this.OooO0o;
    }
}

