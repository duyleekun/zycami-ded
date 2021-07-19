/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.IntentFilter
 */
package com.baidu.location.c;

import android.content.IntentFilter;
import com.baidu.location.c.d$a;
import com.baidu.location.f;

public class d {
    private static d d;
    private boolean a = false;
    private String b = null;
    private d$a c = null;
    private int e = -1;

    private d() {
    }

    public static /* synthetic */ int a(d d10, int n10) {
        d10.e = n10;
        return n10;
    }

    public static d a() {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            d d10 = d;
            if (d10 == null) {
                d = d10 = new d();
            }
            d10 = d;
            return d10;
        }
    }

    public static /* synthetic */ String a(d d10, String string2) {
        d10.b = string2;
        return string2;
    }

    public static /* synthetic */ boolean a(d d10, boolean bl2) {
        d10.a = bl2;
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        d$a d$a;
        this.c = d$a = new d$a(this);
        try {
            d$a = f.getServiceContext();
        }
        catch (Exception exception) {
            return;
        }
        d$a d$a2 = this.c;
        String string2 = "android.intent.action.BATTERY_CHANGED";
        IntentFilter intentFilter = new IntentFilter(string2);
        d$a.registerReceiver(d$a2, intentFilter);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        d$a d$a = this.c;
        if (d$a != null) {
            try {
                d$a = f.getServiceContext();
                d$a d$a2 = this.c;
                d$a.unregisterReceiver(d$a2);
            }
            catch (Exception exception) {}
        }
        this.c = null;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public int f() {
        return this.e;
    }
}

