/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Api$AbstractClientBuilder;
import com.google.android.gms.common.api.Api$AnyClientKey;
import com.google.android.gms.common.api.Api$BaseClientBuilder;
import com.google.android.gms.common.api.Api$ClientKey;
import com.google.android.gms.common.api.Api$zaa;
import com.google.android.gms.common.api.Api$zab;
import com.google.android.gms.common.internal.Preconditions;

public final class Api {
    private final String mName;
    private final Api$AbstractClientBuilder zaau;
    private final zaa zaav;
    private final Api$ClientKey zaaw;
    private final zab zaax;

    public Api(String string2, Api$AbstractClientBuilder api$AbstractClientBuilder, Api$ClientKey api$ClientKey) {
        Preconditions.checkNotNull(api$AbstractClientBuilder, "Cannot construct an Api with a null ClientBuilder");
        Preconditions.checkNotNull(api$ClientKey, "Cannot construct an Api with a null ClientKey");
        this.mName = string2;
        this.zaau = api$AbstractClientBuilder;
        this.zaav = null;
        this.zaaw = api$ClientKey;
        this.zaax = null;
    }

    public final Api$AnyClientKey getClientKey() {
        Object object = this.zaaw;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        throw object;
    }

    public final String getName() {
        return this.mName;
    }

    public final Api$BaseClientBuilder zah() {
        return this.zaau;
    }

    public final Api$AbstractClientBuilder zai() {
        boolean bl2;
        Api$AbstractClientBuilder api$AbstractClientBuilder = this.zaau;
        if (api$AbstractClientBuilder != null) {
            bl2 = true;
        } else {
            bl2 = false;
            api$AbstractClientBuilder = null;
        }
        Preconditions.checkState(bl2, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.zaau;
    }
}

