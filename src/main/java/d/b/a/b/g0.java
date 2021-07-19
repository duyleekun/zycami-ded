/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 */
package d.b.a.b;

import android.content.Context;
import android.content.IntentFilter;
import d.b.a.b.h0;
import d.b.a.b.n;

public final class g0 {
    private final Context a;
    private final h0 b;

    public g0(Context object, n n10) {
        this.a = object;
        super(this, n10, null);
        this.b = object;
    }

    public static /* synthetic */ h0 a(g0 g02) {
        return g02.b;
    }

    public final void b() {
        h0 h02 = this.b;
        Context context = this.a;
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        h02.c(context, intentFilter);
    }

    public final n c() {
        return h0.a(this.b);
    }

    public final void d() {
        h0 h02 = this.b;
        Context context = this.a;
        h02.b(context);
    }
}

