/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo$1;

public final class AutoValue_AndroidClientInfo
extends AndroidClientInfo {
    private final String applicationBuild;
    private final String country;
    private final String device;
    private final String fingerprint;
    private final String hardware;
    private final String locale;
    private final String manufacturer;
    private final String mccMnc;
    private final String model;
    private final String osBuild;
    private final String product;
    private final Integer sdkVersion;

    private AutoValue_AndroidClientInfo(Integer n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
        this.sdkVersion = n10;
        this.model = string2;
        this.hardware = string3;
        this.device = string4;
        this.product = string5;
        this.osBuild = string6;
        this.manufacturer = string7;
        this.fingerprint = string8;
        this.locale = string9;
        this.country = string10;
        this.mccMnc = string11;
        this.applicationBuild = string12;
    }

    public /* synthetic */ AutoValue_AndroidClientInfo(Integer n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, AutoValue_AndroidClientInfo$1 autoValue_AndroidClientInfo$1) {
        this(n10, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof AndroidClientInfo;
        if (bl3) {
            boolean bl4;
            Object object2;
            object = (AndroidClientInfo)object;
            Object object3 = this.sdkVersion;
            if (!((object3 == null ? (object3 = ((AndroidClientInfo)object).getSdkVersion()) == null : (bl3 = ((Integer)object3).equals(object2 = ((AndroidClientInfo)object).getSdkVersion()))) && ((object3 = this.model) == null ? (object3 = ((AndroidClientInfo)object).getModel()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getModel()))) && ((object3 = this.hardware) == null ? (object3 = ((AndroidClientInfo)object).getHardware()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getHardware()))) && ((object3 = this.device) == null ? (object3 = ((AndroidClientInfo)object).getDevice()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getDevice()))) && ((object3 = this.product) == null ? (object3 = ((AndroidClientInfo)object).getProduct()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getProduct()))) && ((object3 = this.osBuild) == null ? (object3 = ((AndroidClientInfo)object).getOsBuild()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getOsBuild()))) && ((object3 = this.manufacturer) == null ? (object3 = ((AndroidClientInfo)object).getManufacturer()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getManufacturer()))) && ((object3 = this.fingerprint) == null ? (object3 = ((AndroidClientInfo)object).getFingerprint()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getFingerprint()))) && ((object3 = this.locale) == null ? (object3 = ((AndroidClientInfo)object).getLocale()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getLocale()))) && ((object3 = this.country) == null ? (object3 = ((AndroidClientInfo)object).getCountry()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getCountry()))) && ((object3 = this.mccMnc) == null ? (object3 = ((AndroidClientInfo)object).getMccMnc()) == null : (bl3 = ((String)object3).equals(object2 = ((AndroidClientInfo)object).getMccMnc()))) && ((object3 = this.applicationBuild) == null ? (object = ((AndroidClientInfo)object).getApplicationBuild()) == null : (bl4 = ((String)object3).equals(object = ((AndroidClientInfo)object).getApplicationBuild()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getApplicationBuild() {
        return this.applicationBuild;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDevice() {
        return this.device;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMccMnc() {
        return this.mccMnc;
    }

    public String getModel() {
        return this.model;
    }

    public String getOsBuild() {
        return this.osBuild;
    }

    public String getProduct() {
        return this.product;
    }

    public Integer getSdkVersion() {
        return this.sdkVersion;
    }

    public int hashCode() {
        int n10;
        int n11;
        Integer n12 = this.sdkVersion;
        int n13 = 0;
        if (n12 == null) {
            n11 = 0;
            n12 = null;
        } else {
            n11 = n12.hashCode();
        }
        int n14 = 1000003;
        n11 = (n11 ^ n14) * n14;
        String string2 = this.model;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.hardware;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.device;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.product;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.osBuild;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.manufacturer;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.fingerprint;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.locale;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.country;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        string2 = this.mccMnc;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n14;
        String string3 = this.applicationBuild;
        if (string3 != null) {
            n13 = string3.hashCode();
        }
        return n11 ^ n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AndroidClientInfo{sdkVersion=");
        Object object = this.sdkVersion;
        stringBuilder.append(object);
        stringBuilder.append(", model=");
        object = this.model;
        stringBuilder.append((String)object);
        stringBuilder.append(", hardware=");
        object = this.hardware;
        stringBuilder.append((String)object);
        stringBuilder.append(", device=");
        object = this.device;
        stringBuilder.append((String)object);
        stringBuilder.append(", product=");
        object = this.product;
        stringBuilder.append((String)object);
        stringBuilder.append(", osBuild=");
        object = this.osBuild;
        stringBuilder.append((String)object);
        stringBuilder.append(", manufacturer=");
        object = this.manufacturer;
        stringBuilder.append((String)object);
        stringBuilder.append(", fingerprint=");
        object = this.fingerprint;
        stringBuilder.append((String)object);
        stringBuilder.append(", locale=");
        object = this.locale;
        stringBuilder.append((String)object);
        stringBuilder.append(", country=");
        object = this.country;
        stringBuilder.append((String)object);
        stringBuilder.append(", mccMnc=");
        object = this.mccMnc;
        stringBuilder.append((String)object);
        stringBuilder.append(", applicationBuild=");
        object = this.applicationBuild;
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

