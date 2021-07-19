/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package d.s.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import d.s.a.c$a;

public final class c$b {
    private Intent a;

    private c$b(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        context = context.registerReceiver(null, intentFilter);
        this.a = context;
    }

    public /* synthetic */ c$b(Context context, c$a c$a) {
        this(context);
    }

    public static /* synthetic */ int a(c$b c$b) {
        return c$b.m();
    }

    public static /* synthetic */ int b(c$b c$b) {
        return c$b.l();
    }

    public static /* synthetic */ int c(c$b c$b) {
        return c$b.f();
    }

    public static /* synthetic */ int d(c$b c$b) {
        return c$b.i();
    }

    private int e() {
        return this.a.getIntExtra("health", 1);
    }

    private int f() {
        return this.a.getIntExtra("level", 0);
    }

    private int g() {
        return this.a.getIntExtra("plugged", 0);
    }

    private boolean h() {
        return this.a.getBooleanExtra("present", false);
    }

    private int i() {
        return this.a.getIntExtra("scale", 0);
    }

    private int j() {
        return this.a.getIntExtra("status", 0);
    }

    private String k() {
        return this.a.getStringExtra("technology");
    }

    private int l() {
        return this.a.getIntExtra("temperature", 0);
    }

    private int m() {
        return this.a.getIntExtra("voltage", 0);
    }
}

