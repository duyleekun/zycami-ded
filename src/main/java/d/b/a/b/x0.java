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

public final class x0
implements Callable {
    private final /* synthetic */ String a;
    private final /* synthetic */ e b;

    public x0(e e10, String string2) {
        this.b = e10;
        this.a = string2;
    }

    public final /* synthetic */ Object call() {
        zza zza2 = e.M(this.b);
        String string2 = e.F(this.b).getPackageName();
        String string3 = this.a;
        Bundle bundle = e.Q(this.b);
        return zza2.zzb(7, string2, string3, bundle);
    }
}

