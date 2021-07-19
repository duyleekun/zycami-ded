/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.q1;
import h.m0;
import h.r;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$b;

public final class DiskLruCache$b$a
extends r {
    private boolean a;
    public final /* synthetic */ DiskLruCache$b b;
    public final /* synthetic */ m0 c;

    public DiskLruCache$b$a(DiskLruCache$b diskLruCache$b, m0 m02, m0 m03) {
        this.b = diskLruCache$b;
        this.c = m02;
        super(m03);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void close() {
        super.close();
        boolean bl2 = this.a;
        if (bl2) return;
        this.a = bl2 = true;
        DiskLruCache diskLruCache = this.b.j;
        synchronized (diskLruCache) {
            Object object = this.b;
            int n10 = ((DiskLruCache$b)object).f() + -1;
            ((DiskLruCache$b)object).n(n10);
            object = this.b;
            int n11 = ((DiskLruCache$b)object).f();
            if (n11 == 0 && (n11 = (int)(((DiskLruCache$b)(object = this.b)).i() ? 1 : 0)) != 0) {
                object = this.b;
                DiskLruCache diskLruCache2 = ((DiskLruCache$b)object).j;
                diskLruCache2.P0((DiskLruCache$b)object);
            }
            object = q1.a;
            return;
        }
    }
}

