/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.cama.prime.model.PrimeInfo;
import d.v.a.f.b.a;

public final class PrimeManager$2
extends a {
    public final /* synthetic */ a val$callback;

    public PrimeManager$2(a a10) {
        this.val$callback = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        this.val$callback.onError(throwable, n10, string2);
    }

    public void onSuccess(PrimeInfo primeInfo) {
        this.val$callback.onSuccess(primeInfo);
    }
}

