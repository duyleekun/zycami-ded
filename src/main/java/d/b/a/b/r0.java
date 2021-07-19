/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.b.a.b;

import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.b;
import d.b.a.b.c;
import d.b.a.b.e;
import d.b.a.b.t0;
import d.b.a.b.u0;
import java.util.concurrent.Callable;

public final class r0
implements Callable {
    private final /* synthetic */ b a;
    public final /* synthetic */ c b;
    private final /* synthetic */ e c;

    public r0(e e10, b b10, c c10) {
        this.c = e10;
        this.a = b10;
        this.b = c10;
    }

    private final Void a() {
        Object object;
        Object object2;
        try {
            object2 = this.c;
        }
        catch (Exception exception) {
            e e10 = this.c;
            object = new u0(this, exception);
            e.B(e10, (Runnable)object);
            return null;
        }
        object2 = e.M((e)object2);
        int n10 = 9;
        object = this.c;
        object = e.F((e)object);
        object = object.getPackageName();
        Object object3 = this.a;
        object3 = ((b)object3).a();
        b b10 = this.a;
        Object object4 = this.c;
        object4 = e.O((e)object4);
        b10 = zzb.zza(b10, (String)object4);
        object2 = object2.zzd(n10, (String)object, (String)object3, (Bundle)b10);
        Object object5 = "BillingClient";
        int n11 = zzb.zza((Bundle)object2, (String)object5);
        object2 = zzb.zzb((Bundle)object2, (String)object5);
        object5 = this.c;
        object3 = new t0(this, n11, (String)object2);
        e.B((e)object5, (Runnable)object3);
        return null;
    }

    public final /* synthetic */ Object call() {
        return this.a();
    }
}

