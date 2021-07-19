/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.android.billingclient.api.SkuDetails;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.k0;
import e.a.m0;

public final class a
implements m0 {
    public final /* synthetic */ PayClientLifecycle a;
    public final /* synthetic */ SkuDetails b;

    public /* synthetic */ a(PayClientLifecycle payClientLifecycle, SkuDetails skuDetails) {
        this.a = payClientLifecycle;
        this.b = skuDetails;
    }

    public final void subscribe(k0 k02) {
        PayClientLifecycle payClientLifecycle = this.a;
        SkuDetails skuDetails = this.b;
        payClientLifecycle.L0(skuDetails, k02);
    }
}

