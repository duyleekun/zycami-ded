/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package d.v.e0;

import android.os.SystemClock;
import d.v.e0.ce;
import d.v.e0.ie.e;
import d.v.e0.s0;
import d.v.e0.v7;
import d.v.e0.yd;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$i2
implements o {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ e b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;
    public final /* synthetic */ ce e;

    public ce$i2(ce ce2, int[] nArray, e e10, int n10, long l10) {
        this.e = ce2;
        this.a = nArray;
        this.b = e10;
        this.c = n10;
        this.d = l10;
    }

    private /* synthetic */ void b(int[] nArray, e e10, int n10, long l10, Boolean bl2) {
        int n11 = nArray[0];
        int n12 = 1;
        nArray[0] = n11 += n12;
        ce ce2 = this.e;
        n11 = (int)(ce.a(ce2) ? 1 : 0);
        if (n11 == 0) {
            int n13;
            ce2 = this.e;
            e10.getClass();
            s0 s02 = new s0(e10);
            ce.e(ce2, s02);
            int n14 = nArray[0];
            if (n14 >= n12 && (n13 = nArray[0]) < n10) {
                SystemClock.sleep((long)l10);
            }
        }
    }

    public e0 a(yd object) {
        Object object2 = this.e;
        boolean bl2 = ce.a((ce)object2);
        if (bl2) {
            object = z.t3(Boolean.TRUE);
        } else {
            v7 v72;
            object = ce.d(this.e, (yd)object);
            int[] nArray = this.a;
            e e10 = this.b;
            int n10 = this.c;
            long l10 = this.d;
            object2 = v72;
            v72 = new v7(this, nArray, e10, n10, l10);
            object = ((z)object).f2(v72);
        }
        return object;
    }

    public /* synthetic */ void c(int[] nArray, e e10, int n10, long l10, Boolean bl2) {
        this.b(nArray, e10, n10, l10, bl2);
    }
}

