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
import d.b.a.b.n;
import java.util.List;

public final class k0
extends ResultReceiver {
    private final /* synthetic */ e a;

    public k0(e e10, Handler handler) {
        this.a = e10;
        super(handler);
    }

    public final void onReceiveResult(int n10, Bundle object) {
        n n11 = e.v(this.a).c();
        String string2 = "BillingClient";
        if (n11 == null) {
            zzb.zzb(string2, "PurchasesUpdatedListener is null - no way to return the response.");
            return;
        }
        List list = zzb.zza(object);
        Object object2 = h.c().c(n10);
        object = zzb.zzb(object, string2);
        object2 = ((h$a)object2).b((String)object).a();
        n11.d((h)object2, list);
    }
}

