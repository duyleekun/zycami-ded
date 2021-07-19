/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.b;

public class b$h
implements Runnable {
    public final /* synthetic */ float a;
    public final /* synthetic */ b b;

    public b$h(b b10, float f10) {
        this.b = b10;
        this.a = f10;
    }

    public void run() {
        Object object = this.b;
        float f10 = this.a;
        d.v.b0.i.b.o0((b)object, f10);
        object = d.v.b0.i.b.U0(this.b);
        int n10 = 1;
        f10 = Float.MIN_VALUE;
        Object object2 = object[n10];
        if (object2 > 0) {
            f10 = this.a;
            double d10 = f10;
            String string2 = "chroma_thres";
            faceunity.fuItemSetParam((int)object2, string2, d10);
        }
    }
}

