/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.android.billingclient.api.Purchase;
import com.zhiyun.pay.PayClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.j;
import e.a.k0;

public final class d
implements j {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ Purchase b;
    public final /* synthetic */ k0 c;
    public final /* synthetic */ Pair d;

    public /* synthetic */ d(PayClientLifecycle payClientLifecycle, Purchase purchase, k0 k02, Pair pair) {
        this.a = payClientLifecycle;
        this.b = purchase;
        this.c = k02;
        this.d = pair;
    }

    public final void h(h h10, String string2) {
        PayClientLifecycle payClientLifecycle = this.a;
        Purchase purchase = this.b;
        k0 k02 = this.c;
        Pair pair = this.d;
        payClientLifecycle.N0(purchase, k02, pair, h10, string2);
    }
}

