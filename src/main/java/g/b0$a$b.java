/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.b0;
import g.v;
import h.n;
import okio.ByteString;

public final class b0$a$b
extends b0 {
    public final /* synthetic */ ByteString a;
    public final /* synthetic */ v b;

    public b0$a$b(ByteString byteString, v v10) {
        this.a = byteString;
        this.b = v10;
    }

    public long contentLength() {
        return this.a.size();
    }

    public v contentType() {
        return this.b;
    }

    public void writeTo(n n10) {
        f0.p(n10, "sink");
        ByteString byteString = this.a;
        n10.h0(byteString);
    }
}

