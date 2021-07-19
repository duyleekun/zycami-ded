/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import okio.ByteString;

public final class e$c {
    private final int a;
    private final ByteString b;

    public e$c(int n10, ByteString byteString) {
        f0.p(byteString, "data");
        this.a = n10;
        this.b = byteString;
    }

    public final ByteString a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }
}

