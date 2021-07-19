/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.internal.Objects;

public final class zai {
    private final Api mApi;
    private final Api$ApiOptions zabh;
    private final boolean zacu;
    private final int zacv;

    private zai(Api api) {
        int n10;
        this.zacu = true;
        this.mApi = api;
        this.zabh = null;
        this.zacv = n10 = System.identityHashCode(this);
    }

    private zai(Api api, Api$ApiOptions api$ApiOptions) {
        int n10;
        this.zacu = false;
        this.mApi = api;
        this.zabh = api$ApiOptions;
        Object[] objectArray = new Object[]{api, api$ApiOptions};
        this.zacv = n10 = Objects.hashCode(objectArray);
    }

    public static zai zaa(Api api) {
        zai zai2 = new zai(api);
        return zai2;
    }

    public static zai zaa(Api api, Api$ApiOptions api$ApiOptions) {
        zai zai2 = new zai(api, api$ApiOptions);
        return zai2;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        Api api;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof zai;
        if (!bl4) {
            return false;
        }
        object = (zai)object;
        bl4 = this.zacu;
        if (!bl4 && !(bl4 = ((zai)object).zacu) && (bl4 = Objects.equal(object2 = this.mApi, api = ((zai)object).mApi)) && (bl2 = Objects.equal(object2 = this.zabh, object = ((zai)object).zabh))) {
            return bl3;
        }
        return false;
    }

    public final int hashCode() {
        return this.zacv;
    }

    public final String zan() {
        return this.mApi.getName();
    }
}

