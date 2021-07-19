/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.CallbackException;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DecodeJob$b;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.o.c;
import d.c.a.o.k.j$a;
import d.c.a.o.k.j$b;
import d.c.a.o.k.j$c;
import d.c.a.o.k.j$d;
import d.c.a.o.k.j$e;
import d.c.a.o.k.k;
import d.c.a.o.k.n;
import d.c.a.o.k.n$a;
import d.c.a.o.k.s;
import d.c.a.o.k.z.a;
import d.c.a.s.h;
import d.c.a.u.o.a$f;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class j
implements DecodeJob$b,
a$f {
    private static final j$c y;
    public final j$e a;
    private final d.c.a.u.o.c b;
    private final n$a c;
    private final Pools$Pool d;
    private final j$c e;
    private final k f;
    private final a g;
    private final a h;
    private final a i;
    private final a j;
    private final AtomicInteger k;
    private c l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private s q;
    public DataSource r;
    private boolean s;
    public GlideException t;
    private boolean u;
    public n v;
    private DecodeJob w;
    private volatile boolean x;

    static {
        j$c j$c;
        y = j$c = new j$c();
    }

    public j(a a10, a a11, a a12, a a13, k k10, n$a n$a, Pools$Pool pools$Pool) {
        j$c j$c = y;
        this(a10, a11, a12, a13, k10, n$a, pools$Pool, j$c);
    }

    public j(a a10, a a11, a a12, a a13, k k10, n$a n$a, Pools$Pool pools$Pool, j$c j$c) {
        Object object = new j$e();
        this.a = object;
        this.b = object = d.c.a.u.o.c.a();
        this.k = object = new AtomicInteger();
        this.g = a10;
        this.h = a11;
        this.i = a12;
        this.j = a13;
        this.f = k10;
        this.c = n$a;
        this.d = pools$Pool;
        this.e = j$c;
    }

    private a j() {
        boolean bl2 = this.n;
        a a10 = bl2 ? this.i : ((bl2 = this.o) ? this.j : this.h);
        return a10;
    }

    private boolean n() {
        boolean bl2 = this.u;
        bl2 = bl2 || (bl2 = this.s) || (bl2 = this.x);
        return bl2;
    }

    private void r() {
        synchronized (this) {
            Object object;
            block17: {
                object = this.l;
                if (object == null) break block17;
                object = this.a;
                ((j$e)object).clear();
                object = null;
                this.l = null;
                this.v = null;
                this.q = null;
                this.u = false;
                this.x = false;
                this.s = false;
                DecodeJob decodeJob = this.w;
                decodeJob.x(false);
                this.w = null;
                this.t = null;
                this.r = null;
                object = this.d;
                object.release(this);
                return;
            }
            object = new IllegalArgumentException();
            throw object;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(h object, Executor executor) {
        synchronized (this) {
            void var2_2;
            Object object2 = this.b;
            ((d.c.a.u.o.c)object2).c();
            object2 = this.a;
            ((j$e)object2).a((h)object, (Executor)var2_2);
            boolean bl2 = this.s;
            boolean bl3 = true;
            if (bl2) {
                this.k((int)(bl3 ? 1 : 0));
                object2 = new j$b(this, (h)object);
                var2_2.execute((Runnable)object2);
            } else {
                bl2 = this.u;
                if (bl2) {
                    this.k((int)(bl3 ? 1 : 0));
                    object2 = new j$a(this, (h)object);
                    var2_2.execute((Runnable)object2);
                } else {
                    boolean bl4 = this.x;
                    if (bl4) {
                        bl3 = false;
                    }
                    object = "Cannot add callbacks to a cancelled EngineJob";
                    d.c.a.u.k.a(bl3, (String)object);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(GlideException glideException) {
        synchronized (this) {
            this.t = glideException;
        }
        this.o();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(s s10, DataSource dataSource) {
        synchronized (this) {
            this.q = s10;
            this.r = dataSource;
        }
        this.p();
    }

    public d.c.a.u.o.c d() {
        return this.b;
    }

    public void e(DecodeJob decodeJob) {
        this.j().execute(decodeJob);
    }

    public void f(h h10) {
        Exception exception;
        try {
            exception = this.t;
        }
        catch (Throwable throwable) {
            exception = new CallbackException(throwable);
            throw exception;
        }
        h10.b((GlideException)exception);
    }

    public void g(h h10) {
        Object object;
        try {
            object = this.v;
        }
        catch (Throwable throwable) {
            object = new CallbackException(throwable);
            throw object;
        }
        DataSource dataSource = this.r;
        h10.c((s)object, dataSource);
    }

    public void h() {
        boolean bl2 = this.n();
        if (bl2) {
            return;
        }
        this.x = true;
        this.w.b();
        k k10 = this.f;
        c c10 = this.l;
        k10.c(this, c10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i() {
        Object object;
        synchronized (this) {
            boolean bl2;
            object = this.b;
            ((d.c.a.u.o.c)object).c();
            int n10 = this.n();
            String string2 = "Not yet complete!";
            d.c.a.u.k.a(n10 != 0, string2);
            object = this.k;
            n10 = ((AtomicInteger)object).decrementAndGet();
            if (n10 >= 0) {
                bl2 = true;
            } else {
                bl2 = false;
                string2 = null;
            }
            String string3 = "Can't decrement below 0";
            d.c.a.u.k.a(bl2, string3);
            if (n10 != 0) return;
            object = this.v;
            this.r();
        }
        if (object == null) return;
        ((n)object).e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k(int n10) {
        synchronized (this) {
            n n11;
            boolean bl2 = this.n();
            String string2 = "Not yet complete!";
            d.c.a.u.k.a(bl2, string2);
            AtomicInteger atomicInteger = this.k;
            n10 = atomicInteger.getAndAdd(n10);
            if (n10 == 0 && (n11 = this.v) != null) {
                n11.a();
            }
            return;
        }
    }

    public j l(c c10, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        synchronized (this) {
            this.l = c10;
            this.m = bl2;
            this.n = bl3;
            this.o = bl4;
            this.p = bl5;
            return this;
        }
    }

    public boolean m() {
        synchronized (this) {
            boolean bl2 = this.x;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o() {
        int n10;
        Object object;
        Object object2;
        Object object3;
        synchronized (this) {
            object3 = this.b;
            ((d.c.a.u.o.c)object3).c();
            int n11 = this.x;
            if (n11 != 0) {
                this.r();
                return;
            }
            object3 = this.a;
            n11 = ((j$e)object3).isEmpty();
            if (n11 != 0) {
                String string2 = "Received an exception without any callbacks to notify";
                object3 = new IllegalStateException(string2);
                throw object3;
            }
            n11 = this.u;
            if (n11 != 0) {
                String string3 = "Already failed once";
                object3 = new IllegalStateException(string3);
                throw object3;
            }
            n11 = 1;
            this.u = n11;
            object2 = this.l;
            object = this.a;
            object = ((j$e)object).c();
            n10 = ((j$e)object).size() + n11;
            this.k(n10);
        }
        object3 = this.f;
        n10 = 0;
        j$a j$a = null;
        object3.b(this, (c)object2, null);
        object3 = ((j$e)object).iterator();
        while (true) {
            boolean bl2;
            if (!(bl2 = object3.hasNext())) {
                this.i();
                return;
            }
            object2 = (j$d)object3.next();
            object = ((j$d)object2).b;
            object2 = ((j$d)object2).a;
            j$a = new j$a(this, (h)object2);
            object.execute(j$a);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void p() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        synchronized (this) {
            object4 = this.b;
            ((d.c.a.u.o.c)object4).c();
            int n10 = this.x;
            if (n10 != 0) {
                object4 = this.q;
                object4.recycle();
                this.r();
                return;
            }
            object4 = this.a;
            n10 = ((j$e)object4).isEmpty();
            if (n10 != 0) {
                String string2 = "Received a resource without any callbacks to notify";
                object4 = new IllegalStateException(string2);
                throw object4;
            }
            n10 = this.s;
            if (n10 != 0) {
                String string3 = "Already have resource";
                object4 = new IllegalStateException(string3);
                throw object4;
            }
            object4 = this.e;
            object3 = this.q;
            int n11 = this.m;
            object2 = this.l;
            n$a n$a = this.c;
            this.v = object4 = ((j$c)object4).a((s)object3, n11 != 0, (c)object2, n$a);
            n10 = 1;
            this.s = n10;
            object3 = this.a;
            object3 = ((j$e)object3).c();
            n11 = ((j$e)object3).size() + n10;
            this.k(n11);
            object4 = this.l;
            object = this.v;
        }
        object2 = this.f;
        object2.b(this, (c)object4, (n)object);
        object4 = ((j$e)object3).iterator();
        while (true) {
            boolean bl2;
            if (!(bl2 = object4.hasNext())) {
                this.i();
                return;
            }
            object3 = (j$d)object4.next();
            object = ((j$d)object3).b;
            object3 = ((j$d)object3).a;
            object2 = new j$b(this, (h)object3);
            object.execute((Runnable)object2);
        }
    }

    public boolean q() {
        return this.p;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void s(h object) {
        synchronized (this) {
            int n10;
            block11: {
                Object object2 = this.b;
                ((d.c.a.u.o.c)object2).c();
                object2 = this.a;
                ((j$e)object2).e((h)object);
                object = this.a;
                n10 = ((j$e)object).isEmpty();
                if (n10 == 0) return;
                this.h();
                n10 = this.s;
                if (n10 != 0) break block11;
                n10 = this.u;
                if (n10 == 0) return;
            }
            n10 = 1;
            if (n10 == 0) return;
            object = this.k;
            n10 = ((AtomicInteger)object).get();
            if (n10 != 0) return;
            this.r();
            return;
        }
    }

    public void t(DecodeJob decodeJob) {
        synchronized (this) {
            a a10;
            block7: {
                block6: {
                    this.w = decodeJob;
                    boolean bl2 = decodeJob.D();
                    if (!bl2) break block6;
                    a10 = this.g;
                    break block7;
                }
                a10 = this.j();
            }
            a10.execute(decodeJob);
            return;
        }
    }
}

