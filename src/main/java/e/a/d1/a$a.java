/*
 * Decompiled with CFR 0.151.
 */
package e.a.d1;

import e.a.d1.a;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class a$a
implements b,
e.a.w0.i.a$a {
    public final g0 a;
    public final a b;
    public boolean c;
    public boolean d;
    public e.a.w0.i.a e;
    public boolean f;
    public volatile boolean g;
    public long h;

    public a$a(g0 g02, a a10) {
        this.a = g02;
        this.b = a10;
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
        Lock lock = ((a)object).d;
        lock.lock();
        this.h = l10 = ((a)object).g;
        object = ((a)object).a;
        object = ((AtomicReference)object).get();
        lock.unlock();
        boolean bl3 = true;
        boolean bl4 = object != null ? bl3 : false;
        this.d = bl4;
        this.c = bl3;
        // MONITOREXIT : this
        if (object == null) return;
        bl2 = this.test(object);
        if (bl2) {
            return;
        }
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
            e.a.w0.i.a a10;
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
            a10.d(this);
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
                    e.a.w0.i.a a10 = this.e;
                    if (a10 == null) {
                        int n10 = 4;
                        this.e = a10 = new e.a.w0.i.a(n10);
                    }
                    a10.c(object);
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
            a a10 = this.b;
            a10.t8(this);
        }
    }

    public boolean isDisposed() {
        return this.g;
    }

    public boolean test(Object object) {
        g0 g02;
        boolean bl2;
        boolean bl3 = this.g;
        if (!bl3 && !(bl2 = NotificationLite.accept(object, g02 = this.a))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

