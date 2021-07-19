/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.c$a$a;
import g.d0;
import g.h0.d;
import g.v;
import g.v$a;
import h.m0;
import h.o;
import h.z;
import okhttp3.internal.cache.DiskLruCache$c;

public final class c$a
extends d0 {
    private final o a;
    private final DiskLruCache$c b;
    private final String c;
    private final String d;

    public c$a(DiskLruCache$c closeable, String object, String string2) {
        f0.p(closeable, "snapshot");
        this.b = closeable;
        this.c = object;
        this.d = string2;
        closeable = closeable.q(1);
        object = new c$a$a(this, (m0)closeable, (m0)closeable);
        closeable = z.d((m0)object);
        this.a = closeable;
    }

    public final DiskLruCache$c a() {
        return this.b;
    }

    public long contentLength() {
        String string2 = this.d;
        long l10 = -1;
        if (string2 != null) {
            l10 = g.h0.d.e0(string2, l10);
        }
        return l10;
    }

    public v contentType() {
        Object object = this.c;
        if (object != null) {
            v$a v$a = v.i;
            object = v$a.d((String)object);
        } else {
            object = null;
        }
        return object;
    }

    public o source() {
        return this.a;
    }
}

