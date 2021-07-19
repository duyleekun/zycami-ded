/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;

public abstract class NetworkConnectionInfo$Builder {
    public abstract NetworkConnectionInfo build();

    public abstract NetworkConnectionInfo$Builder setMobileSubtype(NetworkConnectionInfo.MobileSubtype var1);

    public abstract NetworkConnectionInfo$Builder setNetworkType(NetworkConnectionInfo.NetworkType var1);
}

