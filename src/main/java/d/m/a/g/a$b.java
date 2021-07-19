/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.m.a.g;

import android.graphics.Bitmap;
import com.meishe.cafconvertor.webpcoder.FrameSequence$a;
import d.m.a.g.a;

public class a$b
implements Runnable {
    public final /* synthetic */ a a;

    public a$b(a a10) {
        this.a = a10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        a a10;
        Object object = d.m.a.g.a.e(this.a);
        // MONITORENTER : object
        a a11 = this.a;
        int n10 = d.m.a.g.a.h(a11);
        if (n10 != 0) {
            // MONITOREXIT : object
            return;
        }
        a11 = this.a;
        n10 = d.m.a.g.a.i(a11);
        if (n10 < 0) {
            // MONITOREXIT : object
            return;
        }
        a a12 = this.a;
        a12 = d.m.a.g.a.k(a12);
        Object object2 = this.a;
        int n11 = 2;
        d.m.a.g.a.a((a)object2, n11);
        // MONITOREXIT : object
        int n12 = n10 + -2;
        object2 = d.m.a.g.a.m(this.a);
        long l10 = ((FrameSequence$a)object2).b(n10, (Bitmap)a12, n12);
        long l11 = 20;
        n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n12 < 0) {
            l10 = 100;
        }
        n12 = 0;
        object = null;
        Object object3 = d.m.a.g.a.e(this.a);
        // MONITORENTER : object3
        a a13 = this.a;
        int n13 = d.m.a.g.a.h(a13);
        a a14 = null;
        if (n13 != 0) {
            a10 = this.a;
            a10 = d.m.a.g.a.k(a10);
            a13 = this.a;
            d.m.a.g.a.d(a13, null);
            a14 = a10;
        } else {
            a13 = this.a;
            n13 = d.m.a.g.a.i(a13);
            if (n13 >= 0 && (n13 = d.m.a.g.a.o(a13 = this.a)) == n11) {
                n12 = 1;
                a10 = this.a;
                long l12 = d.m.a.g.a.p(a10) + l10;
                d.m.a.g.a.b(a10, l12);
                a10 = this.a;
                n13 = 3;
                d.m.a.g.a.a(a10, n13);
            }
        }
        // MONITOREXIT : object3
        if (n12 != 0) {
            object = d.m.a.g.a.r(this.a);
            if (object != null) {
                object = d.m.a.g.a.r(this.a);
                a10 = d.m.a.g.a.k(this.a);
                object.a(n10, (Bitmap)a10, l10);
            }
            object = this.a;
            long l13 = d.m.a.g.a.s((a)object);
            object.scheduleSelf((Runnable)object, l13);
        }
        if (a14 == null) return;
        object = d.m.a.g.a.u(this.a);
        object.b((Bitmap)a14);
    }
}

