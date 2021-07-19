/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails$a;
import d.b.a.b.h;
import d.b.a.b.h$a;
import d.b.a.b.j0;
import d.b.a.b.p;
import java.util.List;

public final class m0
implements Runnable {
    private final /* synthetic */ SkuDetails$a a;
    private final /* synthetic */ j0 b;

    public m0(j0 j02, SkuDetails$a skuDetails$a) {
        this.b = j02;
        this.a = skuDetails$a;
    }

    public final void run() {
        p p10 = this.b.d;
        Object object = h.c();
        int n10 = this.a.b();
        object = ((h$a)object).c(n10);
        Object object2 = this.a.c();
        object = ((h$a)object).b((String)object2).a();
        object2 = this.a.a();
        p10.c((h)object, (List)object2);
    }
}

