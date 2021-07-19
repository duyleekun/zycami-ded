/*
 * Decompiled with CFR 0.151.
 */
package d.k.b;

import d.k.b.a;
import d.k.b.a$a;
import d.k.b.b;
import e.a.g0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class b$a
implements e.a.s0.b,
a$a {
    public final g0 a;
    public final b b;
    public boolean c;
    public boolean d;
    public a e;
    public boolean f;
    public volatile boolean g;
    public long h;

    public b$a(g0 g02, b b10) {
        this.a = g02;
        this.b = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a() {
        long l10;
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        // MONITORENTER : this
        bl2 = this.g;
        if (bl2) {
            // MONITOREXIT : this
            return;
        }
        bl2 = this.c;
        if (bl2) {
            // MONITOREXIT : this
            return;
        }
        Object object = this.b;
        Lock lock = ((b)object).c;
        lock.lock();
        this.h = l10 = ((b)object).e;
        object = ((b)object).a;
        object = ((AtomicReference)object).get();
        lock.unlock();
        boolean bl3 = true;
        boolean bl4 = object != null ? bl3 : false;
        this.d = bl4;
        this.c = bl3;
        // MONITOREXIT : this
        if (object == null) return;
        this.test(object);
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        boolean bl2;
        while (!(bl2 = this.g)) {
            a a10;
            synchronized (this) {
                a10 = this.e;
                if (a10 == null) {
                    bl2 = false;
                    a10 = null;
                    this.d = false;
                    return;
                }
                this.e = null;
            }
            a10.c(this);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(Object object, long l10) {
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        bl2 = this.f;
        if (!bl2) {
            Object object2;
            synchronized (this) {
                bl2 = this.g;
                if (bl2) {
                    return;
                }
                long l11 = this.h;
                long l12 = l11 - l10;
                object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false) {
                    return;
                }
                object2 = this.d;
                if (object2 != false) {
                    a a10 = this.e;
                    if (a10 == null) {
                        int n10 = 4;
                        this.e = a10 = new a(n10);
                    }
                    a10.b(object);
                    return;
                }
                object2 = 1;
                this.c = object2;
            }
            this.f = object2;
        }
        this.test(object);
    }

    public void dispose() {
        boolean bl2 = this.g;
        if (!bl2) {
            this.g = bl2 = true;
            b b10 = this.b;
            b10.q8(this);
        }
    }

    public boolean isDisposed() {
        return this.g;
    }

    public boolean test(Object object) {
        boolean bl2 = this.g;
        if (!bl2) {
            g0 g02 = this.a;
            g02.onNext(object);
        }
        return false;
    }
}

