/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.d0;
import g.v;
import h.o;

public final class l$c
extends d0 {
    private final v a;
    private final long b;

    public l$c(v v10, long l10) {
        this.a = v10;
        this.b = l10;
    }

    public long contentLength() {
        return this.b;
    }

    public v contentType() {
        return this.a;
    }

    public o source() {
        IllegalStateException illegalStateException = new IllegalStateException("Cannot read raw response body of a converted body.");
        throw illegalStateException;
    }
}

