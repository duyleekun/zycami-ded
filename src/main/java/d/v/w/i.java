/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class i
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ Pair b;
    public final /* synthetic */ boolean c;

    public /* synthetic */ i(PayClientLifecycle payClientLifecycle, Pair pair, boolean bl2) {
        this.a = payClientLifecycle;
        this.b = pair;
        this.c = bl2;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        Pair pair = this.b;
        boolean bl2 = this.c;
        payClientLifecycle.P0(pair, bl2, k02);
    }
}

