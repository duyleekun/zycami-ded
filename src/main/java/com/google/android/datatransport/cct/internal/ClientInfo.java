/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo$Builder;
import com.google.android.datatransport.cct.internal.ClientInfo$Builder;
import com.google.android.datatransport.cct.internal.ClientInfo$ClientType;

public abstract class ClientInfo {
    public static ClientInfo$Builder builder() {
        AutoValue_ClientInfo$Builder autoValue_ClientInfo$Builder = new AutoValue_ClientInfo$Builder();
        return autoValue_ClientInfo$Builder;
    }

    public abstract AndroidClientInfo getAndroidClientInfo();

    public abstract ClientInfo$ClientType getClientType();
}

