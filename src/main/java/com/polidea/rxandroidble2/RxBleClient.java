/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.polidea.rxandroidble2;

import android.content.Context;
import com.polidea.rxandroidble2.RxBleClient$State;
import d.n.a.a0;
import d.n.a.b$b;
import d.n.a.d0;
import d.n.a.j0;
import d.n.a.q0.p;
import d.n.a.r0.a;
import d.n.a.r0.b;
import d.n.a.r0.e;
import e.a.z;
import java.util.Set;
import java.util.UUID;

public abstract class RxBleClient {
    public static RxBleClient a(Context context) {
        b$b b$b = a0.l();
        context = context.getApplicationContext();
        return b$b.a(context).build().b();
    }

    public static void k(int n10) {
        p.o(n10);
    }

    public static void l(d0 d02) {
        p.r(d02);
    }

    public abstract a b();

    public abstract j0 c(String var1);

    public abstract Set d();

    public abstract String[] e();

    public abstract RxBleClient$State f();

    public abstract boolean g();

    public abstract z h();

    public abstract z i(e var1, b ... var2);

    public abstract z j(UUID ... var1);
}

