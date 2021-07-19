/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.q1;
import g.h0.h.a;
import g.h0.l.d;
import okhttp3.internal.http2.ErrorCode;

public final class d$i
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ ErrorCode i;

    public d$i(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, ErrorCode errorCode) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = errorCode;
        super(string3, bl3);
    }

    public long f() {
        Object object = d.O(this.g);
        int n10 = this.h;
        Object object2 = this.i;
        object.a(n10, (ErrorCode)((Object)object2));
        object = this.g;
        synchronized (object) {
            Object object3 = this.g;
            object3 = d.q((d)object3);
            int n11 = this.h;
            object2 = n11;
            object3.remove(object2);
            object3 = q1.a;
            return -1;
        }
    }
}

