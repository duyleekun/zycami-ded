/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.t.a.j;

import android.graphics.RectF;
import d.t.a.i.b;
import d.t.a.j.a;
import java.lang.ref.WeakReference;

public class a$a
implements Runnable {
    private final WeakReference a;
    private final long b;
    private final long c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final boolean j;

    public a$a(a a10, long l10, float f10, float f11, float f12, float f13, float f14, float f15, boolean bl2) {
        long l11;
        WeakReference<a> weakReference;
        this.a = weakReference = new WeakReference<a>(a10);
        this.b = l10;
        this.c = l11 = System.currentTimeMillis();
        this.d = f10;
        this.e = f11;
        this.f = f12;
        this.g = f13;
        this.h = f14;
        this.i = f15;
        this.j = bl2;
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
        float f11 = this.f;
        l11 = this.b;
        float f12 = l11;
        f11 = d.t.a.i.b.c(f10, 0.0f, f11, f12);
        f12 = this.g;
        float f13 = this.b;
        f12 = d.t.a.i.b.c(f10, 0.0f, f12, f13);
        f13 = this.i;
        long l13 = this.b;
        float f14 = l13;
        float f15 = d.t.a.i.b.b(f10, 0.0f, f13, f14);
        l12 = this.b;
        f13 = l12;
        float f16 = f10 - f13;
        Object object = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
        if (object < 0) {
            float[] fArray = a10.b;
            f13 = fArray[0];
            f14 = this.d;
            int n10 = 1;
            f10 = fArray[n10];
            f13 = this.e;
            a10.m(f11 -= (f13 -= f14), f12 -= (f10 -= f13));
            object = this.j;
            if (object == false) {
                f10 = this.h + f15;
                RectF rectF = d.t.a.j.a.q(a10);
                f11 = rectF.centerX();
                RectF rectF2 = d.t.a.j.a.q(a10);
                f12 = rectF2.centerY();
                a10.E(f10, f11, f12);
            }
            if ((object = (Object)a10.w()) == false) {
                a10.post(this);
            }
        }
    }
}

