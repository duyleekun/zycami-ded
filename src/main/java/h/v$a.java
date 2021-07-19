/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.h2.t.u;
import h.k0;
import h.v;
import okio.ByteString;

public final class v$a {
    private v$a() {
    }

    public /* synthetic */ v$a(u u10) {
        this();
    }

    public final v a(k0 k02, ByteString byteString) {
        f0.p(k02, "sink");
        f0.p(byteString, "key");
        v v10 = new v(k02, byteString, "HmacSHA1");
        return v10;
    }

    public final v b(k0 k02, ByteString byteString) {
        f0.p(k02, "sink");
        f0.p(byteString, "key");
        v v10 = new v(k02, byteString, "HmacSHA256");
        return v10;
    }

    public final v c(k0 k02, ByteString byteString) {
        f0.p(k02, "sink");
        f0.p(byteString, "key");
        v v10 = new v(k02, byteString, "HmacSHA512");
        return v10;
    }

    public final v d(k0 k02) {
        f0.p(k02, "sink");
        v v10 = new v(k02, "MD5");
        return v10;
    }

    public final v e(k0 k02) {
        f0.p(k02, "sink");
        v v10 = new v(k02, "SHA-1");
        return v10;
    }

    public final v f(k0 k02) {
        f0.p(k02, "sink");
        v v10 = new v(k02, "SHA-256");
        return v10;
    }

    public final v g(k0 k02) {
        f0.p(k02, "sink");
        v v10 = new v(k02, "SHA-512");
        return v10;
    }
}

