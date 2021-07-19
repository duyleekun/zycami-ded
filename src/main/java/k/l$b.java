/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.d0;
import g.v;
import h.m0;
import h.o;
import h.z;
import java.io.IOException;
import k.l$b$a;

public final class l$b
extends d0 {
    private final d0 a;
    private final o b;
    public IOException c;

    public l$b(d0 closeable) {
        this.a = closeable;
        closeable = closeable.source();
        l$b$a l$b$a = new l$b$a(this, (m0)closeable);
        closeable = z.d(l$b$a);
        this.b = closeable;
    }

    public void a() {
        IOException iOException = this.c;
        if (iOException == null) {
            return;
        }
        throw iOException;
    }

    public void close() {
        this.a.close();
    }

    public long contentLength() {
        return this.a.contentLength();
    }

    public v contentType() {
        return this.a.contentType();
    }

    public o source() {
        return this.b;
    }
}

