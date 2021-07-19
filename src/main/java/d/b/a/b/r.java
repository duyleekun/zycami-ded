/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.internal.play_billing.zza;
import d.b.a.b.e;
import d.b.a.b.g;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public final class r
implements Callable {
    private final /* synthetic */ g a;
    private final /* synthetic */ SkuDetails b;
    private final /* synthetic */ e c;

    public r(e e10, g g10, SkuDetails skuDetails) {
        this.c = e10;
        this.a = g10;
        this.b = skuDetails;
    }

    public final /* synthetic */ Object call() {
        zza zza2 = e.M(this.c);
        String string2 = e.F(this.c).getPackageName();
        String string3 = this.a.a();
        String[] stringArray = new String[]{string3};
        List<String> list = Arrays.asList(stringArray);
        String string4 = this.b.n();
        return zza2.zza(5, string2, list, string4, "subs", null);
    }
}

