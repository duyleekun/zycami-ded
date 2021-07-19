/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.model.PrimeInfo;
import d.v.a.f.b.a;

public final class PrimeManager$1
extends a {
    public void onError(Throwable throwable, int n10, String string2) {
    }

    public void onSuccess(PrimeInfo primeInfo) {
        PrimeManager.savePrimeInfo(primeInfo);
    }
}

