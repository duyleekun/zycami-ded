/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.v.o.g;

import android.os.Handler;
import android.os.Message;
import d.v.o.g.a;

public class a$a
implements Handler.Callback {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public boolean handleMessage(Message object) {
        object = d.v.o.g.a.t(this.a);
        if (object != null) {
            int n10 = d.v.o.g.a.u(this.a);
            long l10 = n10;
            object = this.a;
            long l11 = d.v.o.g.a.G((a)object) + l10;
            d.v.o.g.a.I((a)object, l11);
            object = d.v.o.g.a.N(this.a);
            a a10 = this.a;
            int n11 = d.v.o.g.a.J(a10);
            float f10 = n11;
            a a11 = this.a;
            int n12 = d.v.o.g.a.L(a11);
            a a12 = this.a;
            l11 = d.v.o.g.a.G(a12);
            object.a(f10, n12, l11);
            object = d.v.o.g.a.O(this.a);
            if (object != null && (n10 = (int)(d.v.o.g.a.P((a)(object = this.a)) ? 1 : 0)) != 0) {
                object = d.v.o.g.a.O(this.a);
                n11 = 1;
                f10 = Float.MIN_VALUE;
                long l12 = 1000L;
                object.sendEmptyMessageDelayed(n11, l12);
            }
        }
        return false;
    }
}

