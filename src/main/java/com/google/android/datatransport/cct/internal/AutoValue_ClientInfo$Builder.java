/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ClientInfo$Builder;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;

public final class AutoValue_ClientInfo$Builder
extends ClientInfo$Builder {
    private AndroidClientInfo androidClientInfo;
    private ClientInfo$ClientType clientType;

    public ClientInfo build() {
        ClientInfo$ClientType clientInfo$ClientType = this.clientType;
        AndroidClientInfo androidClientInfo = this.androidClientInfo;
        AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(clientInfo$ClientType, androidClientInfo, null);
        return autoValue_ClientInfo;
    }

    public ClientInfo$Builder setAndroidClientInfo(AndroidClientInfo androidClientInfo) {
        this.androidClientInfo = androidClientInfo;
        return this;
    }

    public ClientInfo$Builder setClientType(ClientInfo$ClientType clientInfo$ClientType) {
        this.clientType = clientInfo$ClientType;
        return this;
    }
}

