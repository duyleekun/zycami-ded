/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 */
package d.v.c.s0.e7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.zhiyun.cama.camera.liveassistant.FloatWindowPermissionHelper;
import d.v.c.s0.e7.p$a;
import d.v.c.s0.e7.q;
import d.v.c.s0.e7.q$b;

public class p {
    private final Context a;
    private final q b;
    private final BroadcastReceiver c;

    public p(Context context) {
        q q10;
        p$a p$a = new p$a(this);
        this.c = p$a;
        this.a = context;
        this.b = q10 = new q(context);
        super("android.intent.action.CONFIGURATION_CHANGED");
        context.registerReceiver((BroadcastReceiver)p$a, (IntentFilter)q10);
    }

    public void a() {
        this.b.m();
    }

    public void b() {
        this.b.f();
        Context context = this.a;
        BroadcastReceiver broadcastReceiver = this.c;
        context.unregisterReceiver(broadcastReceiver);
    }

    public void c() {
        this.b.b();
    }

    public void d(q.b b10) {
        this.b.J(b10);
    }

    public void e() {
        Context context = this.a;
        boolean bl2 = FloatWindowPermissionHelper.d(context);
        if (!bl2) {
            return;
        }
        this.b.g();
    }

    public void f(boolean bl2) {
        this.b.I(bl2);
    }
}

