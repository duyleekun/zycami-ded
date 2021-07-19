/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.LayoutInflater
 *  android.view.View
 */
package d.v.c.s0.e7;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import d.v.c.s0.e7.o;

public class o$a {
    private final Context a;
    private View b;
    private boolean c;
    private int d = 17;
    private int e;
    private int f;

    public o$a(Context context) {
        this.a = context;
    }

    public o a() {
        int n10;
        Context context = this.a;
        o o10 = new o(context);
        context = this.b;
        o10.c = context;
        o10.e = n10 = this.c;
        o10.f = n10 = this.d;
        int n11 = this.e;
        int n12 = this.f;
        context = new Point(n11, n12);
        o10.g = context;
        return o10;
    }

    public o$a b(boolean bl2) {
        this.c = bl2;
        return this;
    }

    public o$a c(int n10) {
        this.d = n10;
        return this;
    }

    public o$a d(int n10) {
        View view;
        this.b = view = LayoutInflater.from((Context)this.a).inflate(n10, null);
        return this;
    }

    public o$a e(int n10, int n11) {
        this.e = n10;
        this.f = n11;
        return this;
    }

    public o$a f(View view) {
        this.b = view;
        return this;
    }
}

