/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import com.android.billingclient.api.SkuDetails;
import com.zhiyun.pay.PayClientLifecycle;
import e.a.v0.o;

public final class p
implements o {
    public final /* synthetic */ PayClientLifecycle a;

    public /* synthetic */ p(PayClientLifecycle payClientLifecycle) {
        this.a = payClientLifecycle;
    }

    public final Object apply(Object object) {
        PayClientLifecycle payClientLifecycle = this.a;
        object = (SkuDetails)object;
        return payClientLifecycle.q0((SkuDetails)object);
    }
}

