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
import d.v.d.i.f.d;
import d.v.d.i.f.z$a;

public class z
extends a {
    private static final float l = 1.0f;
    private Handler h;
    private int i = 40;
    private final Runnable j;
    private final Runnable k;

    public z() {
        Object object = new z$a(this);
        this.j = object;
        super(this);
        this.k = object;
        this.a = object = Float.valueOf(1.0f);
        this.b = object;
        this.c = object;
        this.u();
    }

    public static /* synthetic */ Runnable n(z z10) {
        return z10.j;
    }

    public static /* synthetic */ int o(z z10) {
        return z10.i;
    }

    public static /* synthetic */ Handler p(z z10) {
        return z10.h;
    }

    public static /* synthetic */ Runnable q(z z10) {
        return z10.k;
    }

    private void u() {
        Handler handler;
        HandlerThread handlerThread = new HandlerThread("preview_wt");
        handlerThread.start();
        handlerThread = handlerThread.getLooper();
        this.h = handler = new Handler((Looper)handlerThread);
    }

    private /* synthetic */ void v(boolean bl2) {
        float f10;
        if (bl2) {
            int n10 = 1065772646;
            f10 = 1.05f;
        } else {
            int n11 = 0x3F733333;
            f10 = 0.95f;
        }
        this.A(f10);
    }

    public void A(float f10) {
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
                    f10 = this.C(f10, f13);
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

    public void B(float f10, int n10) {
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        ((StringBuilder)comparable).append("smooth wt start=");
        Object object = this.a;
        ((StringBuilder)comparable).append(object);
        ((StringBuilder)comparable).append(",dst=");
        ((StringBuilder)comparable).append(f10);
        ((StringBuilder)comparable).append(",time=");
        ((StringBuilder)comparable).append(n10);
        d.v.d.h.f.a(((StringBuilder)comparable).toString());
        comparable = (Float)this.a;
        float f11 = ((Float)comparable).floatValue();
        f11 = f10 - f11;
        float f12 = f11 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        int n11 = 0;
        object = null;
        if (f13 > 0) {
            f13 = 1.0f;
            f11 = Float.MIN_VALUE;
        } else {
            f13 = 0.0f;
            comparable = null;
            f11 = 0.0f;
        }
        float f14 = ((Float)this.a).floatValue();
        f10 = Math.abs(f10 - f14);
        f14 = n10 /= 5;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("smooth wt count=");
        ((StringBuilder)object2).append(n10);
        String string2 = "\uff0cv=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(f10 /= f14);
        String string3 = ((StringBuilder)object2).toString();
        d.v.d.h.f.a(string3);
        while (n11 < n10) {
            string3 = this.h;
            object2 = new d(this, (boolean)f13);
            int n12 = n11 * 5;
            long l10 = n12;
            string3.postDelayed((Runnable)object2, l10);
            ++n11;
        }
    }

    public float C(float f10, float f11) {
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

    public void b() {
        d.v.d.h.f.a("Preview Wt destroy");
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
        ((StringBuilder)object).append("continue action ZoomIn=");
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
        ((StringBuilder)object).append("continue action ZoomOut=");
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

    public /* synthetic */ void w(boolean bl2) {
        this.v(bl2);
    }

    public void x(Float f10) {
        float f11;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("wt  set  integer=");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        float f12 = f10.floatValue();
        Float f13 = (Float)this.b;
        float f14 = f13.floatValue();
        float f15 = f12 == f14 ? 0 : (f12 < f14 ? -1 : 1);
        if (f15 >= 0 && (f15 = (f11 = (f12 = f10.floatValue()) - (f14 = (f13 = (Float)this.c).floatValue())) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            object = this.a;
            f15 = (float)f10.equals(object);
            if (f15 != false) {
                d.v.d.h.f.a("current is same value ,return");
                return;
            }
            super.set(f10);
            return;
        }
        d.v.d.h.f.a("current is invalid value,return");
    }

    public void y(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setContinueZoomSpeed speed=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.i = n10;
    }

    public void z(Float f10, Float f11, float f12) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set min max current value mMinT=");
        stringBuilder.append(f10);
        stringBuilder.append(",mMaxT=");
        stringBuilder.append(f11);
        stringBuilder.append(",current=");
        stringBuilder.append(f12);
        d.v.d.h.f.a(stringBuilder.toString());
        Float f13 = Float.valueOf(f12);
        this.a = f13;
        this.c(f10, f11);
    }
}

