/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo$Builder;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo$Builder;

public abstract class AndroidClientInfo {
    public static AndroidClientInfo$Builder builder() {
        AutoValue_AndroidClientInfo$Builder autoValue_AndroidClientInfo$Builder = new AutoValue_AndroidClientInfo$Builder();
        return autoValue_AndroidClientInfo$Builder;
    }

    public abstract String getApplicationBuild();

    public abstract String getCountry();

    public abstract String getDevice();

    public abstract String getFingerprint();

    public abstract String getHardware();

    public abstract String getLocale();

    public abstract String getManufacturer();

    public abstract String getMccMnc();

    public abstract String getModel();

    public abstract String getOsBuild();

    public abstract String getProduct();

    public abstract Integer getSdkVersion();
}

