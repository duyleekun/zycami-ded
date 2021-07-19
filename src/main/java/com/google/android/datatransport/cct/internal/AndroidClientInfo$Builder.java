/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

public abstract class AndroidClientInfo$Builder {
    public abstract AndroidClientInfo build();

    public abstract AndroidClientInfo$Builder setApplicationBuild(String var1);

    public abstract AndroidClientInfo$Builder setCountry(String var1);

    public abstract AndroidClientInfo$Builder setDevice(String var1);

    public abstract AndroidClientInfo$Builder setFingerprint(String var1);

    public abstract AndroidClientInfo$Builder setHardware(String var1);

    public abstract AndroidClientInfo$Builder setLocale(String var1);

    public abstract AndroidClientInfo$Builder setManufacturer(String var1);

    public abstract AndroidClientInfo$Builder setMccMnc(String var1);

    public abstract AndroidClientInfo$Builder setModel(String var1);

    public abstract AndroidClientInfo$Builder setOsBuild(String var1);

    public abstract AndroidClientInfo$Builder setProduct(String var1);

    public abstract AndroidClientInfo$Builder setSdkVersion(Integer var1);
}

