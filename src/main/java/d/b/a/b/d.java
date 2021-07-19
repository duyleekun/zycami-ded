/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package d.b.a.b;

import android.app.Activity;
import android.content.Context;
import com.android.billingclient.api.Purchase$b;
import d.b.a.b.b;
import d.b.a.b.c;
import d.b.a.b.d$b;
import d.b.a.b.f;
import d.b.a.b.g;
import d.b.a.b.h;
import d.b.a.b.i;
import d.b.a.b.j;
import d.b.a.b.k;
import d.b.a.b.l;
import d.b.a.b.m;
import d.b.a.b.o;
import d.b.a.b.p;

public abstract class d {
    public static d$b h(Context context) {
        d$b d$b = new d$b(context, null);
        return d$b;
    }

    public abstract void a(b var1, c var2);

    public abstract void b(i var1, j var2);

    public abstract void c();

    public abstract h d(String var1);

    public abstract boolean e();

    public abstract h f(Activity var1, g var2);

    public abstract void g(Activity var1, l var2, k var3);

    public abstract void i(String var1, m var2);

    public abstract Purchase$b j(String var1);

    public abstract void k(o var1, p var2);

    public abstract void l(f var1);
}

