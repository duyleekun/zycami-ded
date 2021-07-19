/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$m
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ b e;

    public b$m(b b10, float f10, float f11, float f12, float f13) {
        this.e = b10;
        this.a = f10;
        this.b = f11;
        this.c = f12;
        this.d = f13;
    }

    public void run() {
        Object object = this.e;
        float f10 = this.a;
        d.v.b0.i.b.r0((b)object, f10);
        object = this.e;
        f10 = this.b;
        d.v.b0.i.b.s0((b)object, f10);
        object = this.e;
        f10 = this.c;
        d.v.b0.i.b.t0((b)object, f10);
        object = this.e;
        f10 = this.d;
        d.v.b0.i.b.u0((b)object, f10);
        object = d.v.b0.i.b.U0(this.e);
        int n10 = 1;
        f10 = Float.MIN_VALUE;
        Object object2 = object[n10];
        if (object2 > 0) {
            double d10 = this.a;
            faceunity.fuItemSetParam((int)object2, "start_x", d10);
            d10 = this.b;
            faceunity.fuItemSetParam((int)object2, "start_y", d10);
            d10 = this.c;
            faceunity.fuItemSetParam((int)object2, "end_x", d10);
            f10 = this.d;
            d10 = f10;
            String string2 = "end_y";
            faceunity.fuItemSetParam((int)object2, string2, d10);
        }
    }
}

