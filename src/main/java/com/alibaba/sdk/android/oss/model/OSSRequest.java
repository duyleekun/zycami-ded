/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config;

public class OSSRequest {
    private Enum CRC64;
    private boolean isAuthorizationRequired = true;

    public OSSRequest() {
        OSSRequest$CRC64Config oSSRequest$CRC64Config = OSSRequest$CRC64Config.NULL;
        this.CRC64 = oSSRequest$CRC64Config;
    }

    public Enum getCRC64() {
        return this.CRC64;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public void setCRC64(Enum enum_) {
        this.CRC64 = enum_;
    }

    public void setIsAuthorizationRequired(boolean bl2) {
        this.isAuthorizationRequired = bl2;
    }
}

