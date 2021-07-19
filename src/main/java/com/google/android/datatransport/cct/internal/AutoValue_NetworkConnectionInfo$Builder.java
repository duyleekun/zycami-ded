/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;

public final class AutoValue_NetworkConnectionInfo$Builder
extends NetworkConnectionInfo$Builder {
    private NetworkConnectionInfo$MobileSubtype mobileSubtype;
    private NetworkConnectionInfo$NetworkType networkType;

    public NetworkConnectionInfo build() {
        NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType = this.networkType;
        NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype = this.mobileSubtype;
        AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = new AutoValue_NetworkConnectionInfo(networkConnectionInfo$NetworkType, networkConnectionInfo$MobileSubtype, null);
        return autoValue_NetworkConnectionInfo;
    }

    public NetworkConnectionInfo$Builder setMobileSubtype(NetworkConnectionInfo$MobileSubtype networkConnectionInfo$MobileSubtype) {
        this.mobileSubtype = networkConnectionInfo$MobileSubtype;
        return this;
    }

    public NetworkConnectionInfo$Builder setNetworkType(NetworkConnectionInfo$NetworkType networkConnectionInfo$NetworkType) {
        this.networkType = networkConnectionInfo$NetworkType;
        return this;
    }
}

