/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.e;
import d.b.a.b.h;
import d.b.a.b.j;

public final class z0
implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ j b;
    private final /* synthetic */ h c;
    private final /* synthetic */ String d;

    public z0(e e10, int n10, j j10, h h10, String string2) {
        this.a = n10;
        this.b = j10;
        this.c = h10;
        this.d = string2;
    }

    public final void run() {
        int n10 = this.a;
        Object object = new StringBuilder(63);
        ((StringBuilder)object).append("Error consuming purchase with token. Response code: ");
        ((StringBuilder)object).append(n10);
        Object object2 = ((StringBuilder)object).toString();
        zzb.zzb("BillingClient", (String)object2);
        object2 = this.b;
        object = this.c;
        String string2 = this.d;
        object2.h((h)object, string2);
    }
}

