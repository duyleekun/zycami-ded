/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 */
package d.c.a.s.j;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import d.c.a.i;
import d.c.a.s.j.e;
import d.c.a.s.j.m$a;
import d.c.a.s.k.f;

public final class m
extends e {
    private static final int e = 1;
    private static final Handler f;
    private final i d;

    static {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        m$a m$a = new m$a();
        f = handler = new Handler(looper, (Handler.Callback)m$a);
    }

    private m(i i10, int n10, int n11) {
        super(n10, n11);
        this.d = i10;
    }

    public static m o(i i10, int n10, int n11) {
        m m10 = new m(i10, n10, n11);
        return m10;
    }

    public void i(Drawable drawable2) {
    }

    public void j(Object object, f f10) {
        f.obtainMessage(1, (Object)this).sendToTarget();
    }

    public void n() {
        this.d.z(this);
    }
}

