/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.p;
import d.n.a.q0.v.a;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.v.m;
import d.n.a.q0.v.u;
import d.n.a.q0.v.w;
import d.n.a.q0.v.x;
import d.n.a.q0.x.y;
import d.n.a.r0.b;
import e.a.f0;

public class c0
implements x {
    private final y a;
    private final g b;
    private final u c;
    private final a d;

    public c0(y y10, g g10, u u10, a a10) {
        this.a = y10;
        this.b = g10;
        this.c = u10;
        this.d = a10;
    }

    private static boolean b(b[] bArray) {
        int n10 = bArray.length;
        boolean bl2 = true;
        boolean bl3 = bl2;
        for (int i10 = 0; i10 < n10; ++i10) {
            b b10 = bArray[i10];
            boolean bl4 = b10.b();
            bl3 &= bl4;
        }
        return bl3 ^ true;
    }

    public w a(d.n.a.r0.e object, b ... bArray) {
        Object object2;
        m[] mArray;
        int n10;
        int n11 = c0.b(bArray);
        int n12 = ((d.n.a.r0.e)object).d();
        if (n12 != (n10 = 1)) {
            n12 = n10;
        } else {
            n12 = 0;
            mArray = null;
        }
        f0 f02 = d.n.a.q0.x.w.a();
        if (n12 != 0 && n11 == 0) {
            n11 = n10;
        } else {
            n11 = 0;
            object2 = null;
        }
        if (n11 != 0) {
            object2 = new Object[]{};
            mArray = "ScanSettings.callbackType != CALLBACK_TYPE_ALL_MATCHES but no (or only empty) filters are specified. Falling back to callbackType emulation.";
            p.b((String)mArray, (Object[])object2);
            object2 = this.c;
            n12 = ((d.n.a.r0.e)object).d();
            f02 = ((u)object2).a(n12);
            object = ((d.n.a.r0.e)object).c(n10);
        }
        d.n.a.r0.e e10 = object;
        y y10 = this.a;
        g g10 = this.b;
        a a10 = this.d;
        mArray = new m[]{};
        e e11 = new e(mArray);
        object2 = new d.n.a.q0.u.x(y10, g10, a10, e10, e11, bArray);
        object = new w((d.n.a.q0.u.p)object2, f02);
        return object;
    }
}

