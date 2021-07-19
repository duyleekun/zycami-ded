/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.a0;
import d.b.a.b.h;
import d.b.a.b.r0;

public final class u0
implements Runnable {
    private final /* synthetic */ Exception a;
    private final /* synthetic */ r0 b;

    public u0(r0 r02, Exception exception) {
        this.b = r02;
        this.a = exception;
    }

    public final void run() {
        Object object = String.valueOf(this.a);
        int n10 = String.valueOf(object).length() + 32;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Error acknowledge purchase; ex: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        zzb.zzb("BillingClient", (String)object);
        object = this.b.b;
        h h10 = a0.q;
        object.e(h10);
    }
}

