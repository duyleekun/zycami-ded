/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package d.b.a.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzd;
import d.b.a.b.e;
import d.b.a.b.f;
import d.b.a.b.h;
import d.b.a.b.k0;
import d.b.a.b.v;
import d.b.a.b.w;
import d.b.a.b.x;
import java.util.concurrent.Callable;

public final class e$a
implements ServiceConnection {
    private final Object a;
    private boolean b;
    private f c;
    public final /* synthetic */ e d;

    private e$a(e object, f f10) {
        this.d = object;
        this.a = object = new Object();
        this.b = false;
        this.c = f10;
    }

    public /* synthetic */ e$a(e e10, f f10, k0 k02) {
        this(e10, f10);
    }

    public static /* synthetic */ Object a(e$a e$a) {
        return e$a.a;
    }

    public static /* synthetic */ void c(e$a e$a, h h10) {
        e$a.d(h10);
    }

    private final void d(h h10) {
        e e10 = this.d;
        v v10 = new v(this, h10);
        e.B(e10, v10);
    }

    public static /* synthetic */ f e(e$a e$a) {
        return e$a.c;
    }

    public static /* synthetic */ boolean f(e$a e$a) {
        return e$a.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b() {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = false;
            Object var3_3 = null;
            this.c = null;
            this.b = bl2 = true;
            return;
        }
    }

    public final void onServiceConnected(ComponentName object, IBinder object2) {
        zzb.zza("BillingClient", "Billing service connected.");
        object = this.d;
        object2 = zzd.zza(object2);
        e.w((e)object, (zza)object2);
        object = this.d;
        object2 = new x(this);
        w w10 = new w(this);
        long l10 = 30000L;
        object = e.y((e)object, (Callable)object2, l10, w10);
        if (object == null) {
            object = e.S(this.d);
            this.d((h)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceDisconnected(ComponentName object) {
        zzb.zzb("BillingClient", "Billing service disconnected.");
        e.w(this.d, null);
        object = this.d;
        f f10 = null;
        e.q((e)object, 0);
        object = this.a;
        synchronized (object) {
            f10 = this.c;
            if (f10 != null) {
                f10.b();
            }
            return;
        }
    }
}

