/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.d0;
import g.v;
import g.v$a;
import h.o;

public final class h
extends d0 {
    private final String a;
    private final long b;
    private final o c;

    public h(String string2, long l10, o o10) {
        f0.p(o10, "source");
        this.a = string2;
        this.b = l10;
        this.c = o10;
    }

    public long contentLength() {
        return this.b;
    }

    public v contentType() {
        Object object = this.a;
        if (object != null) {
            v$a v$a = v.i;
            object = v$a.d((String)object);
        } else {
            object = null;
        }
        return object;
    }

    public o source() {
        return this.c;
    }
}

