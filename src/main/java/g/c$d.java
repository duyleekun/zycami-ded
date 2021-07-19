/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.c;
import g.c$d$a;
import g.h0.d;
import g.h0.f.b;
import h.k0;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache$Editor;

public final class c$d
implements b {
    private final k0 a;
    private final k0 b;
    private boolean c;
    private final DiskLruCache$Editor d;
    public final /* synthetic */ c e;

    public c$d(c closeable, DiskLruCache$Editor object) {
        f0.p(object, "editor");
        this.e = closeable;
        this.d = object;
        closeable = ((DiskLruCache$Editor)object).f(1);
        this.a = closeable;
        this.b = object = new c$d$a(this, (k0)closeable);
    }

    public static final /* synthetic */ DiskLruCache$Editor c(c$d c$d) {
        return c$d.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object = this.e;
        synchronized (object) {
            boolean bl2 = this.c;
            if (bl2) {
                return;
            }
            int n10 = 1;
            this.c = n10;
            c c10 = this.e;
            int n11 = c10.O() + n10;
            c10.v0(n11);
        }
        object = this.a;
        g.h0.d.l((Closeable)object);
        try {
            object = this.d;
            ((DiskLruCache$Editor)object).a();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public k0 b() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final void e(boolean bl2) {
        this.c = bl2;
    }
}

