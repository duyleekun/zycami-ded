/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AndroidClientInfo$Builder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;

public final class AutoValue_AndroidClientInfo$Builder
extends AndroidClientInfo$Builder {
    private String applicationBuild;
    private String country;
    private String device;
    private String fingerprint;
    private String hardware;
    private String locale;
    private String manufacturer;
    private String mccMnc;
    private String model;
    private String osBuild;
    private String product;
    private Integer sdkVersion;

    public AndroidClientInfo build() {
        Integer n10 = this.sdkVersion;
        String string2 = this.model;
        String string3 = this.hardware;
        String string4 = this.device;
        String string5 = this.product;
        String string6 = this.osBuild;
        String string7 = this.manufacturer;
        String string8 = this.fingerprint;
        String string9 = this.locale;
        String string10 = this.country;
        String string11 = this.mccMnc;
        String string12 = this.applicationBuild;
        AutoValue_AndroidClientInfo autoValue_AndroidClientInfo = new AutoValue_AndroidClientInfo(n10, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, null);
        return autoValue_AndroidClientInfo;
    }

    public AndroidClientInfo$Builder setApplicationBuild(String string2) {
        this.applicationBuild = string2;
        return this;
    }

    public AndroidClientInfo$Builder setCountry(String string2) {
        this.country = string2;
        return this;
    }

    public AndroidClientInfo$Builder setDevice(String string2) {
        this.device = string2;
        return this;
    }

    public AndroidClientInfo$Builder setFingerprint(String string2) {
        this.fingerprint = string2;
        return this;
    }

    public AndroidClientInfo$Builder setHardware(String string2) {
        this.hardware = string2;
        return this;
    }

    public AndroidClientInfo$Builder setLocale(String string2) {
        this.locale = string2;
        return this;
    }

    public AndroidClientInfo$Builder setManufacturer(String string2) {
        this.manufacturer = string2;
        return this;
    }

    public AndroidClientInfo$Builder setMccMnc(String string2) {
        this.mccMnc = string2;
        return this;
    }

    public AndroidClientInfo$Builder setModel(String string2) {
        this.model = string2;
        return this;
    }

    public AndroidClientInfo$Builder setOsBuild(String string2) {
        this.osBuild = string2;
        return this;
    }

    public AndroidClientInfo$Builder setProduct(String string2) {
        this.product = string2;
        return this;
    }

    public AndroidClientInfo$Builder setSdkVersion(Integer n10) {
        this.sdkVersion = n10;
        return this;
    }
}

