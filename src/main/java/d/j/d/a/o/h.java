/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.j.d.a.o;

import android.app.Activity;
import d.j.d.a.d;
import d.j.d.a.e;
import d.j.d.a.i;
import d.j.d.a.j;
import d.j.d.a.k;
import d.j.d.a.m;
import d.j.d.a.o.b;
import d.j.d.a.o.f;
import d.j.d.a.o.g;
import d.j.d.a.o.h$a;
import d.j.d.a.o.h$b;
import d.j.d.a.o.h$c;
import d.j.d.a.o.h$d;
import d.j.d.a.o.h$e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public final class h
extends k {
    private final Object a;
    private boolean b;
    private volatile boolean c;
    private Object d;
    private Exception e;
    private List f;

    public h() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.f = arrayList = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C() {
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.f;
            object2 = object2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object2.hasNext())) {
                    object2 = null;
                    this.f = null;
                    return;
                }
                Object object3 = object2.next();
                object3 = (e)object3;
                try {
                    object3.onComplete(this);
                }
                catch (Exception exception) {
                    object3 = new RuntimeException(exception);
                    throw object3;
                }
                catch (RuntimeException runtimeException) {
                    throw runtimeException;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private k y(e e10) {
        Object object = this.a;
        // MONITORENTER : object
        boolean bl2 = this.u();
        if (!bl2) {
            List list = this.f;
            list.add(e10);
        }
        // MONITOREXIT : object
        if (!bl2) return this;
        e10.onComplete(this);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void A(Object object) {
        Object object2 = this.a;
        synchronized (object2) {
            boolean bl2 = this.b;
            if (bl2) {
                return;
            }
            this.b = bl2 = true;
            this.d = object;
            object = this.a;
            object.notifyAll();
            this.C();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean B() {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = this.b;
            if (bl2) {
                return false;
            }
            this.b = bl2 = true;
            this.c = bl2;
            Object object2 = this.a;
            object2.notifyAll();
            this.C();
            return bl2;
        }
    }

    public final k a(Activity activity, d.j.d.a.f f10) {
        Executor executor = m.c();
        b b10 = new b(executor, f10);
        com.huawei.hmf.tasks.a.g.c(activity, b10);
        return this.y(b10);
    }

    public final k b(d.j.d.a.f f10) {
        Executor executor = m.c();
        return this.c(executor, f10);
    }

    public final k c(Executor executor, d.j.d.a.f f10) {
        b b10 = new b(executor, f10);
        return this.y(b10);
    }

    public final k d(Activity activity, d.j.d.a.g g10) {
        Executor executor = m.c();
        d.j.d.a.o.d d10 = new d.j.d.a.o.d(executor, g10);
        com.huawei.hmf.tasks.a.g.c(activity, d10);
        return this.y(d10);
    }

    public final k e(d.j.d.a.g g10) {
        Executor executor = m.c();
        return this.f(executor, g10);
    }

    public final k f(Executor executor, d.j.d.a.g g10) {
        d.j.d.a.o.d d10 = new d.j.d.a.o.d(executor, g10);
        return this.y(d10);
    }

    public final k g(Activity activity, d.j.d.a.h h10) {
        Executor executor = m.c();
        f f10 = new f(executor, h10);
        com.huawei.hmf.tasks.a.g.c(activity, f10);
        return this.y(f10);
    }

    public final k h(d.j.d.a.h h10) {
        Executor executor = m.c();
        return this.i(executor, h10);
    }

    public final k i(Executor executor, d.j.d.a.h h10) {
        f f10 = new f(executor, h10);
        return this.y(f10);
    }

    public final k j(Activity activity, i i10) {
        Executor executor = m.c();
        g g10 = new g(executor, i10);
        com.huawei.hmf.tasks.a.g.c(activity, g10);
        return this.y(g10);
    }

    public final k k(i i10) {
        Executor executor = m.c();
        return this.l(executor, i10);
    }

    public final k l(Executor executor, i i10) {
        g g10 = new g(executor, i10);
        return this.y(g10);
    }

    public final k m(d d10) {
        Executor executor = m.c();
        return this.n(executor, d10);
    }

    public final k n(Executor executor, d d10) {
        h h10 = new h();
        h$e h$e = new h$e(this, h10, d10);
        this.f(executor, h$e);
        return h10;
    }

    public final k o(d d10) {
        Executor executor = m.c();
        return this.p(executor, d10);
    }

    public final k p(Executor executor, d d10) {
        h h10 = new h();
        h$d h$d = new h$d(this, d10, h10);
        this.f(executor, h$d);
        return h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Exception q() {
        Object object = this.a;
        synchronized (object) {
            return this.e;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object r() {
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.e;
            if (object2 == null) {
                return this.d;
            }
            Exception exception = this.e;
            object2 = new RuntimeException(exception);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object s(Class object) {
        Object object2 = this.a;
        synchronized (object2) {
            Exception exception;
            boolean bl2;
            if (object != null && (bl2 = ((Class)object).isInstance(exception = this.e))) {
                exception = this.e;
                object = ((Class)object).cast(exception);
                object = (Throwable)object;
                throw object;
            }
            object = this.e;
            if (object == null) {
                return this.d;
            }
            exception = this.e;
            object = new RuntimeException(exception);
            throw object;
        }
    }

    public final boolean t() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean u() {
        Object object = this.a;
        synchronized (object) {
            return this.b;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean v() {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = this.b;
            if (!bl2) return false;
            bl2 = this.t();
            if (bl2) return false;
            Exception exception = this.e;
            if (exception != null) return false;
            return true;
        }
    }

    public final k w(j j10) {
        Executor executor = m.c();
        return this.x(executor, j10);
    }

    public final k x(Executor object, j j10) {
        h h10 = new h();
        h$a h$a = new h$a(this, j10, h10);
        this.l((Executor)object, h$a);
        object = new h$b(this, h10);
        this.h((d.j.d.a.h)object);
        object = new h$c(this, h10);
        this.b((d.j.d.a.f)object);
        return h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void z(Exception object) {
        Object object2 = this.a;
        synchronized (object2) {
            boolean bl2 = this.b;
            if (bl2) {
                return;
            }
            this.b = bl2 = true;
            this.e = object;
            object = this.a;
            object.notifyAll();
            this.C();
            return;
        }
    }
}

