/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.j;
import h.o;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

public final class j$a$a
implements j {
    public void a(int n10, ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
    }

    public boolean b(int n10, List list) {
        f0.p(list, "requestHeaders");
        return true;
    }

    public boolean c(int n10, List list, boolean bl2) {
        f0.p(list, "responseHeaders");
        return true;
    }

    public boolean d(int n10, o o10, int n11, boolean bl2) {
        f0.p(o10, "source");
        long l10 = n11;
        o10.skip(l10);
        return true;
    }
}

