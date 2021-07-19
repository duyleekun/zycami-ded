/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package d.b.a.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.play_billing.zzb;
import d.b.a.b.f0;
import d.b.a.b.g0;
import d.b.a.b.h;
import d.b.a.b.n;
import java.util.List;

public final class h0
extends BroadcastReceiver {
    private final n a;
    private boolean b;
    private final /* synthetic */ g0 c;

    private h0(g0 g02, n n10) {
        this.c = g02;
        this.a = n10;
    }

    public /* synthetic */ h0(g0 g02, n n10, f0 f02) {
        this(g02, n10);
    }

    public static /* synthetic */ n a(h0 h02) {
        return h02.a;
    }

    public final void b(Context context) {
        boolean bl2 = this.b;
        if (bl2) {
            h0 h02 = g0.a(this.c);
            context.unregisterReceiver((BroadcastReceiver)h02);
            this.b = false;
            return;
        }
        zzb.zzb("BillingBroadcastManager", "Receiver is not registered.");
    }

    public final void c(Context context, IntentFilter intentFilter) {
        boolean bl2 = this.b;
        if (!bl2) {
            boolean bl3;
            h0 h02 = g0.a(this.c);
            context.registerReceiver((BroadcastReceiver)h02, intentFilter);
            this.b = bl3 = true;
        }
    }

    public final void onReceive(Context object, Intent object2) {
        object = zzb.zzb(object2, "BillingBroadcastManager");
        object2 = zzb.zza(object2.getExtras());
        this.a.d((h)object, (List)object2);
    }
}

