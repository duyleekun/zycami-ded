/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.b.a.b;

import android.os.Bundle;
import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.internal.play_billing.zza;
import d.b.a.b.e;
import d.b.a.b.g;
import java.util.concurrent.Callable;

public final class s
implements Callable {
    private final /* synthetic */ int a;
    private final /* synthetic */ SkuDetails b;
    private final /* synthetic */ String c;
    private final /* synthetic */ g d;
    private final /* synthetic */ Bundle e;
    private final /* synthetic */ e f;

    public s(e e10, int n10, SkuDetails skuDetails, String string2, g g10, Bundle bundle) {
        this.f = e10;
        this.a = n10;
        this.b = skuDetails;
        this.c = string2;
        this.d = g10;
        this.e = bundle;
    }

    public final /* synthetic */ Object call() {
        zza zza2 = d.b.a.b.e.M(this.f);
        int n10 = this.a;
        String string2 = d.b.a.b.e.F(this.f).getPackageName();
        String string3 = this.b.n();
        String string4 = this.c;
        String string5 = this.d.t();
        Bundle bundle = this.e;
        return zza2.zza(n10, string2, string3, string4, string5, bundle);
    }
}

