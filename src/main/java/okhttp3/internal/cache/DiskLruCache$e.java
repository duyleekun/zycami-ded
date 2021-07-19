/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.t.f0;
import f.h2.t.x0.d;
import f.q1;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$b;
import okhttp3.internal.cache.DiskLruCache$c;

public final class DiskLruCache$e
implements Iterator,
d {
    private final Iterator a;
    private DiskLruCache$c b;
    private DiskLruCache$c c;
    public final /* synthetic */ DiskLruCache d;

    public DiskLruCache$e(DiskLruCache iterator2) {
        this.d = iterator2;
        iterator2 = ((DiskLruCache)((Object)iterator2)).E0().values();
        ArrayList arrayList = new ArrayList(iterator2);
        iterator2 = arrayList.iterator();
        f0.o(iterator2, "ArrayList(lruEntries.values).iterator()");
        this.a = iterator2;
    }

    public DiskLruCache$c b() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            DiskLruCache$c diskLruCache$c;
            this.c = diskLruCache$c = this.b;
            this.b = null;
            f0.m(diskLruCache$c);
            return diskLruCache$c;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasNext() {
        Closeable closeable = this.b;
        boolean bl2 = true;
        if (closeable != null) {
            return bl2;
        }
        closeable = this.d;
        synchronized (closeable) {
            Object object = this.d;
            boolean bl3 = ((DiskLruCache)object).B0();
            if (bl3) {
                return false;
            }
            do {
                if (!(bl3 = (object = this.a).hasNext())) {
                    q1 q12 = q1.a;
                    return false;
                }
                object = this.a;
                object = object.next();
            } while ((object = (DiskLruCache$b)object) == null || (object = ((DiskLruCache$b)object).r()) == null);
            this.b = object;
            return bl2;
        }
    }

    public void remove() {
        Object object = this.c;
        if (object != null) {
            Object var2_3 = null;
            DiskLruCache diskLruCache = this.d;
            object = ((DiskLruCache$c)object).B();
            try {
                diskLruCache.O0((String)object);
            }
            catch (Throwable throwable) {
                this.c = null;
                throw throwable;
            }
            catch (IOException iOException) {}
            this.c = null;
            return;
        }
        String string2 = "remove() before next()".toString();
        object = new IllegalStateException(string2);
        throw object;
    }
}

