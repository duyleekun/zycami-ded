/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;

public abstract class ClientInfo$Builder {
    public abstract ClientInfo build();

    public abstract ClientInfo$Builder setAndroidClientInfo(AndroidClientInfo var1);

    public abstract ClientInfo$Builder setClientType(ClientInfo.ClientType var1);
}

