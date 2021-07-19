/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType;

public abstract class NetworkConnectionInfo {
    public static NetworkConnectionInfo$Builder builder() {
        AutoValue_NetworkConnectionInfo$Builder autoValue_NetworkConnectionInfo$Builder = new AutoValue_NetworkConnectionInfo$Builder();
        return autoValue_NetworkConnectionInfo$Builder;
    }

    public abstract NetworkConnectionInfo$MobileSubtype getMobileSubtype();

    public abstract NetworkConnectionInfo$NetworkType getNetworkType();
}

