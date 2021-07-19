/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.Objects;

public class ResolveClientBean {
    private final int clientKey;
    private final AnyClient mClient;
    private int minSdkVersion;

    public ResolveClientBean(AnyClient anyClient, int n10) {
        int n11;
        this.mClient = anyClient;
        Object[] objectArray = new Object[]{anyClient};
        this.clientKey = n11 = Objects.hashCode(objectArray);
        this.minSdkVersion = n10;
    }

    public void clientReconnect() {
        AnyClient anyClient = this.mClient;
        int n10 = this.minSdkVersion;
        anyClient.connect(n10, true);
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (this == object) {
            return true;
        }
        if (object != null && (bl2 = object instanceof ResolveClientBean)) {
            object = (ResolveClientBean)object;
            AnyClient anyClient = this.mClient;
            object = ((ResolveClientBean)object).mClient;
            return anyClient.equals(object);
        }
        return false;
    }

    public AnyClient getClient() {
        return this.mClient;
    }

    public int hashCode() {
        return this.clientKey;
    }
}

