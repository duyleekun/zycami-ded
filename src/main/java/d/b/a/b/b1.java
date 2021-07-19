/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 */
package d.b.a.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.e;
import d.b.a.b.h;
import d.b.a.b.h$a;
import d.b.a.b.k;

public final class b1
extends ResultReceiver {
    private final /* synthetic */ k a;

    public b1(e e10, Handler handler, k k10) {
        this.a = k10;
        super(handler);
    }

    public final void onReceiveResult(int n10, Bundle object) {
        Object object2 = h.c().c(n10);
        object = zzb.zzb(object, "BillingClient");
        object2 = ((h$a)object2).b((String)object).a();
        this.a.g((h)object2);
    }
}

