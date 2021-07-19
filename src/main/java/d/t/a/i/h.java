/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package d.t.a.i;

import android.view.MotionEvent;
import d.t.a.i.h$a;

public class h {
    private static final int j = 255;
    private float a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private h$a i;

    public h(h$a h$a) {
        int n10;
        this.i = h$a;
        this.e = n10 = -1;
        this.f = n10;
    }

    private float a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        double d10 = f11 - f13;
        double d11 = f10 - f12;
        f10 = (float)Math.toDegrees((float)Math.atan2(d10, d11));
        double d12 = f15 - f17;
        double d13 = f14 - f16;
        f11 = (float)Math.toDegrees((float)Math.atan2(d12, d13));
        return this.b(f10, f11);
    }

    private float b(float f10, float f11) {
        float f12 = 360.0f;
        f11 %= f12;
        this.g = f11 -= (f10 %= f12);
        f10 = -180.0f;
        float f13 = f11 - f10;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object < 0) {
            this.g = f11 += f12;
        } else {
            f10 = 180.0f;
            float f14 = f11 - f10;
            object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object > 0) {
                this.g = f11 -= f12;
            }
        }
        return this.g;
    }

    public float c() {
        return this.g;
    }

    public boolean d(MotionEvent motionEvent) {
        h h10 = this;
        Object object = motionEvent;
        int n10 = motionEvent.getActionMasked();
        int n11 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        int n12 = 1;
        if (n10 != 0) {
            int n13 = -1;
            float f12 = 0.0f / 0.0f;
            if (n10 != n12) {
                int n14 = 2;
                if (n10 != n14) {
                    n11 = 5;
                    f10 = 7.0E-45f;
                    if (n10 != n11) {
                        int n15 = 6;
                        if (n10 == n15) {
                            this.f = n13;
                        }
                    } else {
                        int n16;
                        float f13;
                        this.a = f13 = motionEvent.getX();
                        this.b = f13 = motionEvent.getY();
                        n10 = motionEvent.getActionIndex();
                        n10 = motionEvent.getPointerId(n10);
                        this.f = n16 = motionEvent.findPointerIndex(n10);
                        this.g = 0.0f;
                        this.h = n12;
                    }
                } else {
                    n10 = this.e;
                    if (n10 != n13 && (n10 = this.f) != n13 && (n10 = motionEvent.getPointerCount()) > (n13 = this.f)) {
                        n10 = this.e;
                        float f14 = motionEvent.getX(n10);
                        n10 = this.e;
                        float f15 = motionEvent.getY(n10);
                        n10 = this.f;
                        float f16 = motionEvent.getX(n10);
                        n10 = this.f;
                        float f17 = motionEvent.getY(n10);
                        boolean bl2 = this.h;
                        if (bl2) {
                            this.g = 0.0f;
                            this.h = false;
                        } else {
                            float f18 = this.a;
                            f10 = this.b;
                            f11 = this.c;
                            f12 = this.d;
                            object = this;
                            this.a(f18, f10, f11, f12, f16, f17, f14, f15);
                        }
                        object = h10.i;
                        if (object != null) {
                            object.a(this);
                        }
                        h10.a = f16;
                        h10.b = f17;
                        h10.c = f14;
                        h10.d = f15;
                    }
                }
            } else {
                this.e = n13;
            }
        } else {
            int n17;
            float f19;
            this.c = f19 = motionEvent.getX();
            this.d = f19 = motionEvent.getY();
            n10 = motionEvent.getPointerId(0);
            this.e = n17 = motionEvent.findPointerIndex(n10);
            this.g = 0.0f;
            this.h = n12;
        }
        return n12 != 0;
    }
}

