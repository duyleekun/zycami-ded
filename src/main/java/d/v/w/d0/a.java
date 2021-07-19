/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0;

import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import d.b.a.b.h;
import d.b.a.b.p;
import java.util.List;

public final class a
implements p {
    public final /* synthetic */ GoogleBillingClientLifecycle a;
    public final /* synthetic */ p b;

    public /* synthetic */ a(GoogleBillingClientLifecycle googleBillingClientLifecycle, p p10) {
        this.a = googleBillingClientLifecycle;
        this.b = p10;
    }

    public final void c(h h10, List list) {
        GoogleBillingClientLifecycle googleBillingClientLifecycle = this.a;
        p p10 = this.b;
        googleBillingClientLifecycle.N(p10, h10, list);
    }
}

