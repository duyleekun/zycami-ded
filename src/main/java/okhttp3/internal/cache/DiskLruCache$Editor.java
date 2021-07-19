/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.t.f0;
import f.q1;
import g.h0.f.d;
import h.k0;
import h.m0;
import h.z;
import java.io.File;
import java.io.FileNotFoundException;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1;
import okhttp3.internal.cache.DiskLruCache$b;

public final class DiskLruCache$Editor {
    private final boolean[] a;
    private boolean b;
    private final DiskLruCache$b c;
    public final /* synthetic */ DiskLruCache d;

    public DiskLruCache$Editor(DiskLruCache object, DiskLruCache$b diskLruCache$b) {
        String string2 = "entry";
        f0.p(diskLruCache$b, string2);
        this.d = object;
        this.c = diskLruCache$b;
        boolean bl2 = diskLruCache$b.g();
        if (bl2) {
            boolean bl3 = false;
            object = null;
        } else {
            int n10 = ((DiskLruCache)object).G0();
            object = new boolean[n10];
        }
        this.a = (boolean[])object;
    }

    public final void a() {
        DiskLruCache diskLruCache = this.d;
        synchronized (diskLruCache) {
            Object object;
            block14: {
                boolean bl2 = this.b;
                boolean bl3 = true;
                if (!(bl2 ^= bl3)) break block14;
                object = this.c;
                object = ((DiskLruCache$b)object).b();
                bl2 = f0.g(object, this);
                if (bl2) {
                    object = this.d;
                    ((DiskLruCache)object).u0(this, false);
                }
                this.b = bl3;
                object = q1.a;
                return;
            }
            object = "Check failed.";
            object = object.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
    }

    public final void b() {
        DiskLruCache diskLruCache = this.d;
        synchronized (diskLruCache) {
            Object object;
            block14: {
                boolean bl2 = this.b;
                boolean bl3 = true;
                if (!(bl2 ^= bl3)) break block14;
                object = this.c;
                object = ((DiskLruCache$b)object).b();
                bl2 = f0.g(object, this);
                if (bl2) {
                    object = this.d;
                    ((DiskLruCache)object).u0(this, bl3);
                }
                this.b = bl3;
                object = q1.a;
                return;
            }
            object = "Check failed.";
            object = object.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
    }

    public final void c() {
        Object object = this.c.b();
        boolean bl2 = f0.g(object, this);
        if (bl2) {
            object = this.d;
            bl2 = DiskLruCache.a((DiskLruCache)object);
            if (bl2) {
                object = this.d;
                boolean bl3 = false;
                ((DiskLruCache)object).u0(this, false);
            } else {
                object = this.c;
                boolean bl4 = true;
                ((DiskLruCache$b)object).q(bl4);
            }
        }
    }

    public final DiskLruCache$b d() {
        return this.c;
    }

    public final boolean[] e() {
        return this.a;
    }

    public final k0 f(int n10) {
        DiskLruCache diskLruCache = this.d;
        synchronized (diskLruCache) {
            block30: {
                boolean bl2 = this.b;
                boolean bl3 = true;
                if (!(bl2 ^= bl3)) break block30;
                Object object = this.c;
                object = ((DiskLruCache$b)object).b();
                bl2 = f0.g(object, this) ^ bl3;
                if (bl2) {
                    k0 k02 = z.b();
                    return k02;
                }
                object = this.c;
                bl2 = ((DiskLruCache$b)object).g();
                if (!bl2) {
                    object = this.a;
                    f0.m(object);
                    object[n10] = bl3;
                }
                object = this.c;
                object = ((DiskLruCache$b)object).c();
                object = object.get(n10);
                object = (File)object;
                Object object2 = this.d;
                object2 = ((DiskLruCache)object2).D0();
                object = object2.f((File)object);
                DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 diskLruCache$Editor$newSink$$inlined$synchronized$lambda$1 = new DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(this, n10);
                object2 = new d((k0)object, diskLruCache$Editor$newSink$$inlined$synchronized$lambda$1);
                return object2;
            }
            String string2 = "Check failed.";
            string2 = string2.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final m0 g(int n10) {
        DiskLruCache diskLruCache = this.d;
        synchronized (diskLruCache) {
            boolean bl2 = this.b ^ true;
            if (!bl2) {
                String string2 = "Check failed.";
                string2 = string2.toString();
                IllegalStateException illegalStateException = new IllegalStateException(string2);
                throw illegalStateException;
            }
            Object object = this.c;
            bl2 = ((DiskLruCache$b)object).g();
            m0 m02 = null;
            if (!bl2) return null;
            object = this.c;
            bl2 = f0.g(object = ((DiskLruCache$b)object).b(), this) ^ true;
            if (bl2) return null;
            object = this.c;
            bl2 = ((DiskLruCache$b)object).i();
            if (!bl2) {
                object = this.d;
                object = ((DiskLruCache)object).D0();
                Object object2 = this.c;
                object2 = ((DiskLruCache$b)object2).a();
                Object object3 = object2.get(n10);
                object3 = (File)object3;
                return object.e((File)object3);
            }
            return null;
            catch (FileNotFoundException fileNotFoundException) {}
            return m02;
        }
    }
}

