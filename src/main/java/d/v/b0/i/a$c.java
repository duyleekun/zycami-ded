/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.i;

import com.faceunity.wrapper.faceunity;
import d.v.b0.i.a;

public class a$c
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a b;

    public a$c(a a10, boolean bl2) {
        this.b = a10;
        this.a = bl2;
    }

    public void run() {
        float f10;
        int n10 = this.a;
        if (n10 != 0) {
            n10 = 0;
            f10 = 0.0f;
        } else {
            n10 = 1065353216;
            f10 = 1.0f;
        }
        int n11 = d.v.b0.i.a.i(this.b);
        double d10 = f10;
        faceunity.fuItemSetParam(n11, "is_beauty_on", d10);
    }
}

