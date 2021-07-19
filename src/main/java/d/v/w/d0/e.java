/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0;

import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.m;
import java.util.List;

public final class e
implements m {
    public final /* synthetic */ GoogleBillingClientLifecycle a;
    public final /* synthetic */ m b;

    public /* synthetic */ e(GoogleBillingClientLifecycle googleBillingClientLifecycle, m m10) {
        this.a = googleBillingClientLifecycle;
        this.b = m10;
    }

    public final void f(h h10, List list) {
        GoogleBillingClientLifecycle googleBillingClientLifecycle = this.a;
        m m10 = this.b;
        googleBillingClientLifecycle.H(m10, h10, list);
    }
}

