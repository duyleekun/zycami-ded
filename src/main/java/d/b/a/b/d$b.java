/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.b.a.b;

import android.content.Context;
import d.b.a.b.d;
import d.b.a.b.e;
import d.b.a.b.i0;
import d.b.a.b.n;

public final class d$b {
    private boolean a;
    private final Context b;
    private n c;

    private d$b(Context context) {
        this.b = context;
    }

    public /* synthetic */ d$b(Context context, i0 i02) {
        this(context);
    }

    public final d a() {
        Object object = this.b;
        if (object != null) {
            n n10 = this.c;
            if (n10 != null) {
                boolean bl2 = this.a;
                if (bl2) {
                    e e10 = new e(null, bl2, (Context)object, n10);
                    return e10;
                }
                object = new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
                throw object;
            }
            object = new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            throw object;
        }
        object = new IllegalArgumentException("Please provide a valid Context.");
        throw object;
    }

    public final d$b b() {
        this.a = true;
        return this;
    }

    public final d$b c(n n10) {
        this.c = n10;
        return this;
    }
}

