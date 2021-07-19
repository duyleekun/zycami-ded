/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.b0;
import g.v;
import h.n;

public class p$a
extends b0 {
    private final b0 a;
    private final v b;

    public p$a(b0 b02, v v10) {
        this.a = b02;
        this.b = v10;
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public v contentType() {
        return this.b;
    }

    public void writeTo(n n10) {
        this.a.writeTo(n10);
    }
}

