/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import g.h0.l.h;
import h.m;
import h.o;
import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

public final class d$f
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ m i;
    public final /* synthetic */ int j;
    public final /* synthetic */ boolean k;

    public d$f(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, m m10, int n11, boolean bl4) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = m10;
        this.j = n11;
        this.k = bl4;
        super(string3, bl3);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long f() {
        int n10;
        Object object;
        Object object2;
        try {
            Object object3 = this.g;
            object3 = d.O((d)object3);
            int n11 = this.h;
            object2 = this.i;
            int n12 = this.j;
            boolean bl2 = this.k;
            boolean bl3 = object3.d(n11, (o)object2, n12, bl2);
            if (bl3) {
                object = this.g;
                object = ((d)object).P0();
                n10 = this.h;
                ErrorCode errorCode = ErrorCode.CANCEL;
                ((h)object).p0(n10, errorCode);
            }
            if (!bl3) {
                bl3 = this.k;
                if (!bl3) return -1;
            }
            object3 = this.g;
            synchronized (object3) {
                object = this.g;
            }
        }
        catch (IOException iOException) {
            return -1;
        }
        {
            object = d.q((d)object);
            n10 = this.h;
            object2 = n10;
            object.remove(object2);
            return -1;
        }
    }
}

