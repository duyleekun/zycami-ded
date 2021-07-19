/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.t.f0;
import g.h0.d;
import h.m0;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$Editor;

public final class DiskLruCache$c
implements Closeable {
    private final String a;
    private final long b;
    private final List c;
    private final long[] d;
    public final /* synthetic */ DiskLruCache e;

    public DiskLruCache$c(DiskLruCache diskLruCache, String string2, long l10, List list, long[] lArray) {
        f0.p(string2, "key");
        f0.p(list, "sources");
        f0.p(lArray, "lengths");
        this.e = diskLruCache;
        this.a = string2;
        this.b = l10;
        this.c = list;
        this.d = lArray;
    }

    public final String B() {
        return this.a;
    }

    public final DiskLruCache$Editor a() {
        DiskLruCache diskLruCache = this.e;
        String string2 = this.a;
        long l10 = this.b;
        return diskLruCache.x0(string2, l10);
    }

    public void close() {
        boolean bl2;
        Iterator iterator2 = this.c.iterator();
        while (bl2 = iterator2.hasNext()) {
            m0 m02 = (m0)iterator2.next();
            g.h0.d.l(m02);
        }
    }

    public final long h(int n10) {
        return this.d[n10];
    }

    public final m0 q(int n10) {
        return (m0)this.c.get(n10);
    }
}

