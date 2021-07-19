/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import g.h0.h.a;
import h.k0;
import h.n;
import h.z;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache;

public final class DiskLruCache$d
extends a {
    public final /* synthetic */ DiskLruCache e;

    public DiskLruCache$d(DiskLruCache diskLruCache, String string2) {
        this.e = diskLruCache;
        super(string2, false, 2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long f() {
        DiskLruCache diskLruCache = this.e;
        synchronized (diskLruCache) {
            DiskLruCache diskLruCache2 = this.e;
            boolean bl2 = DiskLruCache.q(diskLruCache2);
            long l10 = -1;
            if (bl2 && !(bl2 = (diskLruCache2 = this.e).B0())) {
                Closeable closeable;
                bl2 = true;
                try {
                    closeable = this.e;
                    closeable.V0();
                }
                catch (IOException iOException) {
                    closeable = this.e;
                    DiskLruCache.r0(closeable, bl2);
                }
                try {
                    closeable = this.e;
                    boolean bl3 = DiskLruCache.O(closeable);
                    if (bl3) {
                        closeable = this.e;
                        closeable.N0();
                        closeable = this.e;
                        DiskLruCache.s0(closeable, 0);
                    }
                }
                catch (IOException iOException) {
                    closeable = this.e;
                    DiskLruCache.q0(closeable, bl2);
                    diskLruCache2 = this.e;
                    closeable = z.b();
                    closeable = z.c((k0)closeable);
                    DiskLruCache.p0(diskLruCache2, (n)closeable);
                }
                return l10;
            }
            return l10;
        }
    }
}

