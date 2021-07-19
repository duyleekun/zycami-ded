/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.k.a$a;
import d.c.a.o.k.a$b;
import d.c.a.o.k.a$c;
import d.c.a.o.k.a$d;
import d.c.a.o.k.n;
import d.c.a.o.k.n$a;
import d.c.a.o.k.s;
import d.c.a.u.e;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class a {
    private final boolean a;
    private final Executor b;
    public final Map c;
    private final ReferenceQueue d;
    private n$a e;
    private volatile boolean f;
    private volatile a$c g;

    public a(boolean bl2) {
        Object object = new a$a();
        object = Executors.newSingleThreadExecutor((ThreadFactory)object);
        this(bl2, (Executor)object);
    }

    public a(boolean bl2, Executor executor) {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.c = referenceQueue;
        this.d = referenceQueue = new ReferenceQueue();
        this.a = bl2;
        this.b = executor;
        a$b a$b = new a$b(this);
        executor.execute(a$b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(c object, n object2) {
        synchronized (this) {
            Map map;
            ReferenceQueue referenceQueue = this.d;
            boolean bl2 = this.a;
            a$d a$d = new a$d((c)object, (n)((Object)map), referenceQueue, bl2);
            map = this.c;
            object = map.put(object, a$d);
            object = (a$d)object;
            if (object != null) {
                ((a$d)object).a();
            }
            return;
        }
    }

    public void b() {
        boolean bl2;
        while (!(bl2 = this.f)) {
            Object object = this.d;
            object = ((ReferenceQueue)object).remove();
            object = (a$d)object;
            this.c((a$d)object);
            object = this.g;
            if (object == null) continue;
            try {
                object.a();
            }
            catch (InterruptedException interruptedException) {
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(a$d object) {
        synchronized (this) {
            s s10;
            Object object2 = this.c;
            Object object3 = ((a$d)object).a;
            object2.remove(object3);
            boolean bl2 = ((a$d)object).b;
            if (bl2 && (s10 = ((a$d)object).c) != null) {
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl8 : MonitorExitStatement: MONITOREXIT : this
                c c10 = ((a$d)object).a;
                n$a n$a = this.e;
                object3 = object2;
                object2 = new n(s10, true, false, c10, n$a);
                object3 = this.e;
                object = ((a$d)object).a;
                object3.d((c)object, (n)object2);
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(c object) {
        synchronized (this) {
            Map map = this.c;
            object = map.remove(object);
            object = (a$d)object;
            if (object != null) {
                ((a$d)object).a();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public n e(c object) {
        synchronized (this) {
            Object object2 = this.c;
            object = object2.get(object);
            object = (a$d)object;
            if (object == null) {
                return null;
            }
            object2 = ((Reference)object).get();
            if ((object2 = (n)object2) == null) {
                this.c((a$d)object);
            }
            return object2;
        }
    }

    public void f(a$c a$c) {
        this.g = a$c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g(n$a n$a) {
        synchronized (n$a) {
            synchronized (this) {
                this.e = n$a;
                return;
            }
        }
    }

    public void h() {
        boolean bl2;
        this.f = bl2 = true;
        Executor executor = this.b;
        boolean bl3 = executor instanceof ExecutorService;
        if (bl3) {
            executor = (ExecutorService)executor;
            d.c.a.u.e.c((ExecutorService)executor);
        }
    }
}

