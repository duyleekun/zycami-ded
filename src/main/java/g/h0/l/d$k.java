/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import java.io.IOException;
import okhttp3.internal.http2.ErrorCode;

public final class d$k
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ d g;
    public final /* synthetic */ int h;
    public final /* synthetic */ ErrorCode i;

    public d$k(String string2, boolean bl2, String string3, boolean bl3, d d10, int n10, ErrorCode errorCode) {
        this.e = string2;
        this.f = bl2;
        this.g = d10;
        this.h = n10;
        this.i = errorCode;
        super(string3, bl3);
    }

    public long f() {
        d d10 = this.g;
        int n10 = this.h;
        ErrorCode errorCode = this.i;
        try {
            d10.r1(n10, errorCode);
        }
        catch (IOException iOException) {
            d d11 = this.g;
            d.a(d11, iOException);
        }
        return -1;
    }
}

