/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.e2.b;
import f.h2.t.f0;
import g.b0;
import g.v;
import h.m0;
import h.n;
import h.z;
import java.io.File;

public final class b0$a$a
extends b0 {
    public final /* synthetic */ File a;
    public final /* synthetic */ v b;

    public b0$a$a(File file, v v10) {
        this.a = file;
        this.b = v10;
    }

    public long contentLength() {
        return this.a.length();
    }

    public v contentType() {
        return this.b;
    }

    public void writeTo(n n10) {
        f0.p(n10, "sink");
        m0 m02 = z.l(this.a);
        try {
            n10.v(m02);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                f.e2.b.a(m02, throwable);
                throw throwable2;
            }
        }
        f.e2.b.a(m02, null);
    }
}

