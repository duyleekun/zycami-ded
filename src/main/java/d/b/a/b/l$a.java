/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails;
import d.b.a.b.l;

public class l$a {
    private SkuDetails a;

    public l a() {
        Object object = this.a;
        if (object != null) {
            object = new l();
            SkuDetails skuDetails = this.a;
            l.c((l)object, skuDetails);
            return object;
        }
        object = new IllegalArgumentException("SkuDetails must be set");
        throw object;
    }

    public l$a b(SkuDetails skuDetails) {
        this.a = skuDetails;
        return this;
    }
}

