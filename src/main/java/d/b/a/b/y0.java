/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.b.a.b;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zza;
import d.b.a.b.e;
import java.util.concurrent.Callable;

public final class y0
implements Callable {
    private final /* synthetic */ String a;
    private final /* synthetic */ Bundle b;
    private final /* synthetic */ e c;

    public y0(e e10, String string2, Bundle bundle) {
        this.c = e10;
        this.a = string2;
        this.b = bundle;
    }

    public final /* synthetic */ Object call() {
        zza zza2 = e.M(this.c);
        String string2 = e.F(this.c).getPackageName();
        String string3 = this.a;
        Bundle bundle = this.b;
        return zza2.zzb(8, string2, string3, "subs", bundle);
    }
}

