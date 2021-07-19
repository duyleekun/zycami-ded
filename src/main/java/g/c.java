/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a0;
import g.c$a;
import g.c$b;
import g.c$c;
import g.c$d;
import g.c$e;
import g.c0;
import g.h0.f.b;
import g.h0.h.d;
import g.h0.j.f;
import g.h0.m.a;
import g.t;
import h.m0;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.cache.DiskLruCache$c;

public final class c
implements Closeable,
Flushable {
    private static final int g = 201105;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    public static final c$b k;
    private final DiskLruCache a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    static {
        c$b c$b;
        k = c$b = new c$b(null);
    }

    public c(File file, long l10) {
        f0.p(file, "directory");
        a a10 = g.h0.m.a.a;
        this(file, l10, a10);
    }

    public c(File file, long l10, a a10) {
        DiskLruCache diskLruCache;
        f0.p(file, "directory");
        f0.p(a10, "fileSystem");
        d d10 = g.h0.h.d.h;
        this.a = diskLruCache = new DiskLruCache(a10, file, 201105, 2, l10, d10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void h(DiskLruCache$Editor diskLruCache$Editor) {
        if (diskLruCache$Editor == null) return;
        try {
            diskLruCache$Editor.a();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static final String p0(t t10) {
        return k.b(t10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void A0(c0 closeable, c0 object) {
        f0.p(closeable, "cached");
        f0.p(object, "network");
        c$c c$c = new c$c((c0)object);
        closeable = ((c0)closeable).r0();
        Objects.requireNonNull(closeable, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        closeable = ((c$a)closeable).a();
        object = null;
        object = ((DiskLruCache$c)closeable).a();
        if (object == null) return;
        try {
            c$c.f((DiskLruCache$Editor)object);
            ((DiskLruCache$Editor)object).b();
            return;
        }
        catch (IOException iOException) {
            this.h((DiskLruCache$Editor)object);
        }
    }

    public final File B() {
        return this.a.C0();
    }

    public final Iterator B0() {
        c$e c$e = new c$e(this);
        return c$e;
    }

    public final void C() {
        this.a.z0();
    }

    public final int C0() {
        synchronized (this) {
            int n10 = this.c;
            return n10;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final c0 D(a0 object) {
        block8: {
            Object object2;
            f0.p(object, "request");
            Object object3 = k;
            t t10 = ((a0)object).q();
            object3 = ((c$b)object3).b(t10);
            t10 = null;
            try {
                object2 = this.a;
            }
            catch (IOException iOException) {
                return null;
            }
            object3 = ((DiskLruCache)object2).A0((String)object3);
            if (object3 == null) break block8;
            m0 m02 = null;
            m02 = ((DiskLruCache$c)object3).q(0);
            try {
                object2 = new c$c(m02);
                object3 = ((c$c)object2).d((DiskLruCache$c)object3);
                boolean bl2 = ((c$c)object2).b((a0)object, (c0)object3);
                if (bl2) return object3;
                object = ((c0)object3).r0();
                if (object == null) return null;
            }
            catch (IOException iOException) {
                g.h0.d.l((Closeable)object3);
            }
            g.h0.d.l((Closeable)object);
            return null;
        }
        return null;
    }

    public final int D0() {
        synchronized (this) {
            int n10 = this.b;
            return n10;
        }
    }

    public final DiskLruCache E() {
        return this.a;
    }

    public final int O() {
        return this.c;
    }

    public final int S() {
        return this.b;
    }

    public final File a() {
        return this.a.C0();
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        this.a.flush();
    }

    public final boolean isClosed() {
        return this.a.isClosed();
    }

    public final int n0() {
        synchronized (this) {
            int n10 = this.e;
            return n10;
        }
    }

    public final void o0() {
        this.a.H0();
    }

    public final void q() {
        this.a.v0();
    }

    public final long q0() {
        return this.a.F0();
    }

    public final int r0() {
        synchronized (this) {
            int n10 = this.d;
            return n10;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final b s0(c0 object) {
        f0.p(object, "response");
        Object object2 = ((c0)object).L0().m();
        Object object3 = g.h0.j.f.a;
        String string2 = ((c0)object).L0().m();
        boolean bl2 = ((f)object3).a(string2);
        string2 = null;
        if (bl2) {
            object = ((c0)object).L0();
            this.t0((a0)object);
            return null;
        }
        object3 = "GET";
        boolean bl3 = f0.g(object2, object3) ^ true;
        if (bl3) {
            return null;
        }
        object2 = k;
        bl2 = ((c$b)object2).a((c0)object);
        if (bl2) {
            return null;
        }
        object3 = new c$c((c0)object);
        DiskLruCache diskLruCache = this.a;
        object = ((c0)object).L0();
        object = ((a0)object).q();
        String string3 = ((c$b)object2).b((t)object);
        long l10 = 0L;
        int n10 = 2;
        object = DiskLruCache.y0(diskLruCache, string3, l10, n10, null);
        if (object == null) return null;
        ((c$c)object3).f((DiskLruCache$Editor)object);
        return new c$d(this, (DiskLruCache$Editor)object);
        {
            catch (IOException iOException) {}
        }
        catch (IOException iOException) {
            block9: {
                object = null;
                break block9;
                catch (IOException iOException2) {
                    return null;
                }
            }
            this.h((DiskLruCache$Editor)object);
            return null;
        }
    }

    public final void t0(a0 object) {
        f0.p(object, "request");
        DiskLruCache diskLruCache = this.a;
        c$b c$b = k;
        object = ((a0)object).q();
        object = c$b.b((t)object);
        diskLruCache.O0((String)object);
    }

    public final int u0() {
        synchronized (this) {
            int n10 = this.f;
            return n10;
        }
    }

    public final void v0(int n10) {
        this.c = n10;
    }

    public final void w0(int n10) {
        this.b = n10;
    }

    public final long x0() {
        return this.a.T0();
    }

    public final void y0() {
        synchronized (this) {
            int n10 = this.e + 1;
            this.e = n10;
            return;
        }
    }

    public final void z0(g.h0.f.c object) {
        synchronized (this) {
            int n10;
            Object object2 = "cacheStrategy";
            f0.p(object, (String)object2);
            this.f = n10 = this.f + 1;
            object2 = ((g.h0.f.c)object).b();
            if (object2 != null) {
                int n11;
                this.d = n11 = this.d + 1;
            } else if ((object = ((g.h0.f.c)object).a()) != null) {
                int n12;
                this.e = n12 = this.e + 1;
            }
            return;
        }
    }
}

