/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.internal.play_billing.zza;
import d.b.a.b.e;
import java.util.concurrent.Callable;

public final class u
implements Callable {
    private final /* synthetic */ SkuDetails a;
    private final /* synthetic */ String b;
    private final /* synthetic */ e c;

    public u(e e10, SkuDetails skuDetails, String string2) {
        this.c = e10;
        this.a = skuDetails;
        this.b = string2;
    }

    public final /* synthetic */ Object call() {
        zza zza2 = e.M(this.c);
        String string2 = e.F(this.c).getPackageName();
        String string3 = this.a.n();
        String string4 = this.b;
        return zza2.zza(3, string2, string3, string4, (String)null);
    }
}

