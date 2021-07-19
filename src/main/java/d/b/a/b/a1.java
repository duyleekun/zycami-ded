/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.e;
import d.b.a.b.h;
import d.b.a.b.j;

public final class a1
implements Runnable {
    private final /* synthetic */ j a;
    private final /* synthetic */ h b;
    private final /* synthetic */ String c;

    public a1(e e10, j j10, h h10, String string2) {
        this.a = j10;
        this.b = h10;
        this.c = string2;
    }

    public final void run() {
        zzb.zza("BillingClient", "Successfully consumed purchase.");
        j j10 = this.a;
        h h10 = this.b;
        String string2 = this.c;
        j10.h(h10, string2);
    }
}

