/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import g.h0.l.h;
import java.io.Closeable;
import java.io.IOException;

public final class d$l
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ long i;

    public d$l(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, long l10) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = l10;
        super(string3, bl3);
    }

    public long f() {
        Closeable closeable = this.g;
        closeable = ((d)closeable).P0();
        int n10 = this.h;
        long l10 = this.i;
        try {
            ((h)closeable).r0(n10, l10);
        }
        catch (IOException iOException) {
            d d10 = this.g;
            d.a(d10, iOException);
        }
        return -1;
    }
}

