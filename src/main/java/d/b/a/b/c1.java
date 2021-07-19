/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.a0;
import d.b.a.b.e;
import d.b.a.b.h;
import d.b.a.b.j;

public final class c1
implements Runnable {
    private final /* synthetic */ Exception a;
    private final /* synthetic */ j b;
    private final /* synthetic */ String c;

    public c1(e e10, Exception exception, j j10, String string2) {
        this.a = exception;
        this.b = j10;
        this.c = string2;
    }

    public final void run() {
        Object object = String.valueOf(this.a);
        int n10 = String.valueOf(object).length() + 30;
        CharSequence charSequence = new StringBuilder(n10);
        charSequence.append("Error consuming purchase; ex: ");
        charSequence.append((String)object);
        object = charSequence.toString();
        zzb.zzb("BillingClient", (String)object);
        object = this.b;
        h h10 = a0.q;
        charSequence = this.c;
        object.h(h10, (String)charSequence);
    }
}

