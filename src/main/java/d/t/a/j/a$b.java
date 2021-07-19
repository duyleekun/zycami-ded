/*
 * Decompiled with CFR 0.151.
 */
package d.t.a.j;

import d.t.a.i.b;
import d.t.a.j.a;
import java.lang.ref.WeakReference;

public class a$b
implements Runnable {
    private final WeakReference a;
    private final long b;
    private final long c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;

    public a$b(a a10, long l10, float f10, float f11, float f12, float f13) {
        long l11;
        WeakReference<a> weakReference;
        this.a = weakReference = new WeakReference<a>(a10);
        this.c = l11 = System.currentTimeMillis();
        this.b = l10;
        this.d = f10;
        this.e = f11;
        this.f = f12;
        this.g = f13;
    }

    public void run() {
        a a10 = (a)this.a.get();
        if (a10 == null) {
            return;
        }
        long l10 = System.currentTimeMillis();
        long l11 = this.b;
        long l12 = this.c;
        l10 -= l12;
        l10 = Math.min(l11, l10);
        float f10 = l10;
        float f11 = this.e;
        long l13 = this.b;
        float f12 = l13;
        float f13 = d.t.a.i.b.b(f10, 0.0f, f11, f12);
        l11 = this.b;
        f11 = l11;
        float f14 = f10 - f11;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = this.d + f13;
            f13 = this.f;
            f11 = this.g;
            a10.E(f10, f13, f11);
            a10.post(this);
        } else {
            a10.A();
        }
    }
}

