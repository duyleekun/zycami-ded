/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.t.f0;
import g.h0.d;
import h.m0;
import h.n;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.cache.DiskLruCache$b$a;
import okhttp3.internal.cache.DiskLruCache$c;

public final class DiskLruCache$b {
    private final long[] a;
    private final List b;
    private final List c;
    private boolean d;
    private boolean e;
    private DiskLruCache$Editor f;
    private int g;
    private long h;
    private final String i;
    public final /* synthetic */ DiskLruCache j;

    public DiskLruCache$b(DiskLruCache diskLruCache, String string2) {
        f0.p(string2, "key");
        this.j = diskLruCache;
        this.i = string2;
        int n10 = diskLruCache.G0();
        Object object = new long[n10];
        this.a = object;
        object = new ArrayList;
        this.b = object;
        object = new ArrayList;
        super();
        this.c = object;
        object = new StringBuilder;
        super(string2);
        ((StringBuilder)object).append('.');
        int n11 = ((StringBuilder)object).length();
        int n12 = diskLruCache.G0();
        for (int i10 = 0; i10 < n12; ++i10) {
            ((StringBuilder)object).append(i10);
            List list = this.b;
            File file = diskLruCache.C0();
            String string3 = ((StringBuilder)object).toString();
            File file2 = new File(file, string3);
            list.add(file2);
            ((StringBuilder)object).append(".tmp");
            list = this.c;
            file = diskLruCache.C0();
            string3 = ((StringBuilder)object).toString();
            file2 = new File(file, string3);
            list.add(file2);
            ((StringBuilder)object).setLength(n11);
        }
    }

    private final Void j(List object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal line: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    private final m0 k(int n10) {
        Object object = this.j.D0();
        List list = this.b;
        Object object2 = (File)list.get(n10);
        object2 = object.e((File)object2);
        object = this.j;
        int n11 = DiskLruCache.a((DiskLruCache)object);
        if (n11 != 0) {
            return object2;
        }
        this.g = n11 = this.g + 1;
        object = new DiskLruCache$b$a(this, (m0)object2, (m0)object2);
        return object;
    }

    public final List a() {
        return this.b;
    }

    public final DiskLruCache$Editor b() {
        return this.f;
    }

    public final List c() {
        return this.c;
    }

    public final String d() {
        return this.i;
    }

    public final long[] e() {
        return this.a;
    }

    public final int f() {
        return this.g;
    }

    public final boolean g() {
        return this.d;
    }

    public final long h() {
        return this.h;
    }

    public final boolean i() {
        return this.e;
    }

    public final void l(DiskLruCache$Editor diskLruCache$Editor) {
        this.f = diskLruCache$Editor;
    }

    public final void m(List object) {
        String string2 = "strings";
        f0.p(object, string2);
        int n10 = object.size();
        DiskLruCache diskLruCache = this.j;
        int n11 = diskLruCache.G0();
        if (n10 == n11) {
            string2 = null;
            try {
                n11 = object.size();
            }
            catch (NumberFormatException numberFormatException) {
                this.j((List)object);
                object = new KotlinNothingValueException();
                throw object;
            }
            for (n10 = 0; n10 < n11; ++n10) {
                long[] lArray = this.a;
                Object object2 = object.get(n10);
                object2 = (String)object2;
                long l10 = Long.parseLong(object2);
                lArray[n10] = l10;
                continue;
            }
            return;
        }
        this.j((List)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public final void n(int n10) {
        this.g = n10;
    }

    public final void o(boolean bl2) {
        this.d = bl2;
    }

    public final void p(long l10) {
        this.h = l10;
    }

    public final void q(boolean bl2) {
        this.e = bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final DiskLruCache$c r() {
        DiskLruCache$c diskLruCache$c;
        Object object;
        int n10;
        Object object2;
        Object object3 = this.j;
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(object3))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object4 = Thread.currentThread();
            f0.o(object4, "Thread.currentThread()");
            object4 = ((Thread)object4).getName();
            stringBuilder.append((String)object4);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object3);
            object3 = stringBuilder.toString();
            AssertionError assertionError = new AssertionError(object3);
            throw assertionError;
        }
        boolean bl3 = this.d;
        bl2 = false;
        Object var3_4 = null;
        if (!bl3) {
            return null;
        }
        object3 = this.j;
        bl3 = DiskLruCache.a((DiskLruCache)object3);
        if (!bl3) {
            object3 = this.f;
            if (object3 != null) return null;
            bl3 = this.e;
            if (bl3) {
                return null;
            }
        }
        object3 = new ArrayList();
        Object object5 = object2 = this.a.clone();
        object5 = (long[])object2;
        object2 = null;
        DiskLruCache diskLruCache = this.j;
        int n11 = diskLruCache.G0();
        for (n10 = 0; n10 < n11; ++n10) {
            object = this.k(n10);
            object3.add(object);
            continue;
        }
        try {
            diskLruCache = this.j;
        }
        catch (FileNotFoundException fileNotFoundException) {
            object3 = object3.iterator();
            while ((n10 = object3.hasNext()) != 0) {
                object2 = (m0)object3.next();
                g.h0.d.l((Closeable)object2);
            }
            try {
                object3 = this.j;
            }
            catch (IOException iOException) {
                return null;
            }
            ((DiskLruCache)object3).P0(this);
            return null;
        }
        object = this.i;
        long l10 = this.h;
        object2 = diskLruCache$c;
        return new DiskLruCache$c(diskLruCache, (String)object, l10, (List)object3, (long[])object5);
    }

    public final void s(n n10) {
        f0.p(n10, "writer");
        for (long l10 : this.a) {
            int n11 = 32;
            n n12 = n10.writeByte(n11);
            n12.M(l10);
        }
    }
}

