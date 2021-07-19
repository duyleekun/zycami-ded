/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;

public final class PrimeManager$4
extends a {
    public final /* synthetic */ a val$callback;

    public PrimeManager$4(a a10) {
        this.val$callback = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        this.val$callback.onError(throwable, n10, string2);
    }

    public void onSuccess(BaseEntity baseEntity) {
        this.val$callback.onSuccess(baseEntity);
    }
}

