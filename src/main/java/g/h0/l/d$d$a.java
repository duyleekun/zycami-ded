/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.d$d;
import g.h0.l.g;
import okhttp3.internal.http2.ErrorCode;

public final class d$d$a
extends d$d {
    public void f(g g10) {
        f0.p(g10, "stream");
        ErrorCode errorCode = ErrorCode.REFUSED_STREAM;
        g10.d(errorCode, null);
    }
}

