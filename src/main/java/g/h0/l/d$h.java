/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import g.h0.l.h;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

public final class d$h
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ List i;

    public d$h(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, List list) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = list;
        super(string3, bl3);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long f() {
        Object object;
        Object object2;
        int n10;
        Object object3 = d.O(this.g);
        boolean bl2 = object3.b(n10 = this.h, (List)(object2 = this.i));
        if (!bl2) return -1;
        try {
            object3 = this.g;
            object3 = ((d)object3).P0();
            n10 = this.h;
            object2 = ErrorCode.CANCEL;
            ((h)object3).p0(n10, (ErrorCode)((Object)object2));
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
            int n11 = this.h;
            object2 = n11;
            object.remove(object2);
            return -1;
        }
    }
}

