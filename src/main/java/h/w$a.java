/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.h2.t.u;
import h.m0;
import h.w;
import okio.ByteString;

public final class w$a {
    private w$a() {
    }

    public /* synthetic */ w$a(u u10) {
        this();
    }

    public final w a(m0 m02, ByteString byteString) {
        f0.p(m02, "source");
        f0.p(byteString, "key");
        w w10 = new w(m02, byteString, "HmacSHA1");
        return w10;
    }

    public final w b(m0 m02, ByteString byteString) {
        f0.p(m02, "source");
        f0.p(byteString, "key");
        w w10 = new w(m02, byteString, "HmacSHA256");
        return w10;
    }

    public final w c(m0 m02, ByteString byteString) {
        f0.p(m02, "source");
        f0.p(byteString, "key");
        w w10 = new w(m02, byteString, "HmacSHA512");
        return w10;
    }

    public final w d(m0 m02) {
        f0.p(m02, "source");
        w w10 = new w(m02, "MD5");
        return w10;
    }

    public final w e(m0 m02) {
        f0.p(m02, "source");
        w w10 = new w(m02, "SHA-1");
        return w10;
    }

    public final w f(m0 m02) {
        f0.p(m02, "source");
        w w10 = new w(m02, "SHA-256");
        return w10;
    }

    public final w g(m0 m02) {
        f0.p(m02, "source");
        w w10 = new w(m02, "SHA-512");
        return w10;
    }
}

