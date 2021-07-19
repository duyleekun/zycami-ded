/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.c0;

import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.model.PrimeInfo;

public final class h
implements Runnable {
    public final /* synthetic */ PrimeInfo a;

    public /* synthetic */ h(PrimeInfo primeInfo) {
        this.a = primeInfo;
    }

    public final void run() {
        PrimeManager.a(this.a);
    }
}

