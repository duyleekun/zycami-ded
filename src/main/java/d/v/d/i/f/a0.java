/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package d.v.d.i.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.f.a0$a;

public class a0
extends a {
    private static final float l = 1.0f;
    private Handler h;
    private int i = 40;
    private final Runnable j;
    private final Runnable k;

    public a0() {
        Object object = new a0$a(this);
        this.j = object;
        super(this);
        this.k = object;
        this.a = object = Float.valueOf(1.0f);
        this.b = object;
        this.c = object = Float.valueOf(4.0f);
        this.u();
    }

    public static /* synthetic */ Runnable n(a0 a02) {
        return a02.j;
    }

    public static /* synthetic */ int o(a0 a02) {
        return a02.i;
    }

    public static /* synthetic */ Handler p(a0 a02) {
        return a02.h;
    }

    public static /* synthetic */ Runnable q(a0 a02) {
        return a02.k;
    }

    private void u() {
        Handler handler;
        HandlerThread handlerThread = new HandlerThread("preview_zoom");
        handlerThread.start();
        handlerThread = handlerThread.getLooper();
        this.h = handler = new Handler((Looper)handlerThread);
    }

    public void b() {
        super.b();
        Handler handler = this.h;
        Runnable runnable = this.j;
        handler.removeCallbacks(runnable);
        handler = this.h;
        runnable = this.k;
        handler.removeCallbacks(runnable);
        this.h.getLooper().quitSafely();
    }

    public float r(float f10, float f11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BigDecimal add a=");
        stringBuilder.append(f10);
        stringBuilder.append(",b=");
        stringBuilder.append(f11);
        d.v.d.h.f.a(stringBuilder.toString());
        f10 += f11;
        f11 = 10.0f;
        return (float)Math.round(f10 * f11) / f11;
    }

    public void s(Boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("continue ZoomIn action=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.h;
        Runnable runnable = this.k;
        object.removeCallbacks(runnable);
        object = this.h;
        runnable = this.j;
        object.removeCallbacks(runnable);
        boolean bl3 = bl2;
        if (bl3) {
            bl2 = this.h;
            object = this.j;
            bl2.post((Runnable)object);
        }
    }

    public void t(Boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("continue ZoomOut action=");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.h;
        Runnable runnable = this.k;
        object.removeCallbacks(runnable);
        object = this.h;
        runnable = this.j;
        object.removeCallbacks(runnable);
        boolean bl3 = bl2;
        if (bl3) {
            bl2 = this.h;
            object = this.k;
            bl2.post((Runnable)object);
        }
    }

    public void v(Float f10) {
        Object object = new StringBuilder();
        String string2 = "set zoom  integer=";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        float f11 = f10.floatValue();
        float f12 = 0.1f;
        float f13 = f11 == f12 ? 0 : (f11 < f12 ? -1 : 1);
        if (f13 <= 0) {
            d.v.d.h.f.a("current is 0 invalid,return");
            return;
        }
        object = this.a;
        f13 = (float)f10.equals(object);
        if (f13 != false) {
            d.v.d.h.f.a("current is same value ,return");
            return;
        }
        super.set(f10);
    }

    public void w(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setContinueZoomSpeed speed=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.i = n10;
    }

    public void x(Float f10, Float f11) {
        super.c(f10, f11);
        f10 = Float.valueOf(1.0f);
        this.a = f10;
    }

    public void y(float f10) {
        block5: {
            block8: {
                float f11;
                Object object;
                Object object2;
                float f12;
                Object object3;
                block7: {
                    float f13;
                    block6: {
                        object3 = new StringBuilder();
                        String string2 = "set wt scaleFactor=";
                        ((StringBuilder)object3).append(string2);
                        ((StringBuilder)object3).append(f10);
                        d.v.d.h.f.a(((StringBuilder)object3).toString());
                        object3 = this.c;
                        if (object3 == null || (object3 = this.b) == null) break block5;
                        f12 = 1.0f;
                        float f14 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
                        f13 = 0.1f;
                        if (f14 <= 0) break block6;
                        f10 = ((Float)this.a).floatValue();
                        f10 = this.r(f10, f13);
                        this.a = object2 = Float.valueOf(f10);
                        break block7;
                    }
                    object = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1);
                    if (object >= 0) break block8;
                    f10 = ((Float)this.a).floatValue();
                    f10 = this.z(f10, f13);
                    this.a = object2 = Float.valueOf(f10);
                }
                object2 = (Float)this.a;
                f10 = ((Float)object2).floatValue();
                object3 = (Float)this.c;
                f12 = ((Float)object3).floatValue();
                object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
                if (object > 0) {
                    this.a = object2 = this.c;
                }
                if ((object = (f11 = (f10 = ((Float)(object2 = (Float)this.a)).floatValue()) - (f12 = ((Float)(object3 = (Float)this.b)).floatValue())) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
                    this.a = object2 = this.b;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("final wt set mT=");
                object3 = this.a;
                ((StringBuilder)object2).append(object3);
                object2 = ((StringBuilder)object2).toString();
                d.v.d.h.f.a((String)object2);
                this.d();
            }
            return;
        }
        d.v.d.h.f.a("current is max or min ==null ,return");
    }

    public float z(float f10, float f11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BigDecimal sub a=");
        stringBuilder.append(f10);
        stringBuilder.append(",b=");
        stringBuilder.append(f11);
        d.v.d.h.f.a(stringBuilder.toString());
        f10 -= f11;
        f11 = 10.0f;
        return (float)Math.round(f10 * f11) / f11;
    }
}

