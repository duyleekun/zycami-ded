/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.android.billingclient.api.SkuDetails;
import com.zhiyun.pay.PayClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.m;
import e.a.k0;
import java.util.List;

public final class u
implements m {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ k0 b;
    public final /* synthetic */ SkuDetails c;
    public final /* synthetic */ String d;

    public /* synthetic */ u(PayClientLifecycle payClientLifecycle, k0 k02, SkuDetails skuDetails, String string2) {
        this.a = payClientLifecycle;
        this.b = k02;
        this.c = skuDetails;
        this.d = string2;
    }

    public final void f(h h10, List list) {
        PayClientLifecycle payClientLifecycle = this.a;
        k0 k02 = this.b;
        SkuDetails skuDetails = this.c;
        String string2 = this.d;
        payClientLifecycle.H0(k02, skuDetails, string2, h10, list);
    }
}

