/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.f0;
import f.q1;
import g.h0.h.a;
import g.h0.h.b;
import g.h0.h.c$a;
import g.h0.h.c$b;
import g.h0.h.c$c;
import g.h0.h.d;
import g.h0.h.d$a;
import g.h0.h.d$b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt___CollectionsKt;

public final class c {
    private boolean a;
    private a b;
    private final List c;
    private boolean d;
    private final d e;
    private final String f;

    public c(d arrayList, String string2) {
        f0.p(arrayList, "taskRunner");
        f0.p(string2, "name");
        this.e = arrayList;
        this.f = string2;
        this.c = arrayList = new ArrayList();
    }

    public static /* synthetic */ void d(c c10, String string2, long l10, boolean bl2, f.h2.s.a a10, int n10, Object object) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            l10 = 0L;
        }
        if ((n10 &= 4) != 0) {
            bl2 = true;
        }
        f0.p(string2, "name");
        f0.p(a10, "block");
        c$b c$b = new c$b(a10, string2, bl2, string2, bl2);
        c10.n(c$b, l10);
    }

    public static /* synthetic */ void o(c c10, String string2, long l10, f.h2.s.a a10, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = 0L;
        }
        f0.p(string2, "name");
        f0.p(a10, "block");
        c$c c$c = new c$c(a10, string2, string2);
        c10.n(c$c, l10);
    }

    public static /* synthetic */ void p(c c10, a a10, long l10, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = 0L;
        }
        c10.n(a10, l10);
    }

    public final void a() {
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        d d10 = this.e;
        synchronized (d10) {
            Object object;
            boolean bl3 = this.b();
            if (bl3) {
                object = this.e;
                ((d)object).i(this);
            }
            object = q1.a;
            return;
        }
    }

    public final boolean b() {
        int n10;
        Object object = this.b;
        int n11 = 1;
        if (object != null) {
            f0.m(object);
            boolean n102 = ((a)object).a();
            if (n102) {
                this.d = n11;
            }
        }
        boolean bl2 = false;
        object = null;
        List list = this.c;
        for (int i10 = list.size() - n11; i10 >= 0; i10 += -1) {
            Level level;
            Object object2 = (a)this.c.get(i10);
            boolean bl3 = ((a)object2).a();
            if (!bl3) continue;
            object = (a)this.c.get(i10);
            object2 = g.h0.h.d.j.a();
            bl3 = ((Logger)object2).isLoggable(level = Level.FINE);
            if (bl3) {
                object2 = "canceled";
                g.h0.h.b.a((a)object, this, (String)object2);
            }
            object = this.c;
            object.remove(i10);
            n10 = n11;
        }
        return n10 != 0;
    }

    public final void c(String string2, long l10, boolean bl2, f.h2.s.a a10) {
        f0.p(string2, "name");
        f0.p(a10, "block");
        c$b c$b = new c$b(a10, string2, bl2, string2, bl2);
        this.n(c$b, l10);
    }

    public final a e() {
        return this.b;
    }

    public final boolean f() {
        return this.d;
    }

    public final List g() {
        return this.c;
    }

    public final String h() {
        return this.f;
    }

    public final List i() {
        d d10 = this.e;
        synchronized (d10) {
            List list = this.c;
            list = CollectionsKt___CollectionsKt.I5(list);
            return list;
        }
    }

    public final boolean j() {
        return this.a;
    }

    public final d k() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final CountDownLatch l() {
        d d10 = this.e;
        synchronized (d10) {
            boolean bl2;
            Object object = this.b;
            boolean bl3 = false;
            d d11 = null;
            if (object == null && (bl2 = (object = this.c).isEmpty())) {
                return new CountDownLatch(0);
            }
            object = this.b;
            boolean bl4 = object instanceof c$a;
            if (bl4) {
                object = (c$a)object;
                return ((c$a)object).i();
            }
            object = this.c;
            object = object.iterator();
            while (bl4 = object.hasNext()) {
                Object object2 = object.next();
                boolean bl5 = (object2 = (a)object2) instanceof c$a;
                if (!bl5) continue;
                object2 = (c$a)object2;
                return ((c$a)object2).i();
            }
            object = new c$a();
            long l10 = 0L;
            bl3 = this.q((a)object, l10, false);
            if (!bl3) return ((c$a)object).i();
            d11 = this.e;
            d11.i(this);
            return ((c$a)object).i();
        }
    }

    public final void m(String string2, long l10, f.h2.s.a a10) {
        f0.p(string2, "name");
        f0.p(a10, "block");
        c$c c$c = new c$c(a10, string2, string2);
        this.n(c$c, l10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void n(a object, long l10) {
        f0.p(object, "task");
        d d10 = this.e;
        synchronized (d10) {
            void var2_2;
            boolean bl2 = this.a;
            if (bl2) {
                Level level;
                boolean bl3 = ((a)object).a();
                if (bl3) {
                    Level level2;
                    Object object2 = g.h0.h.d.j;
                    bl3 = ((Logger)(object2 = ((d$b)object2).a())).isLoggable(level2 = Level.FINE);
                    if (bl3) {
                        object2 = "schedule canceled (queue is shutdown)";
                        g.h0.h.b.a((a)object, this, (String)object2);
                    }
                    return;
                }
                Object object3 = g.h0.h.d.j;
                bl3 = ((Logger)(object3 = ((d$b)object3).a())).isLoggable(level = Level.FINE);
                if (bl3) {
                    object3 = "schedule failed (queue is shutdown)";
                    g.h0.h.b.a((a)object, this, (String)object3);
                }
                object = new RejectedExecutionException();
                throw object;
            }
            bl2 = false;
            boolean bl4 = this.q((a)object, (long)var2_2, false);
            if (bl4) {
                object = this.e;
                ((d)object).i(this);
            }
            object = q1.a;
            return;
        }
    }

    public final boolean q(a a10, long l10, boolean bl2) {
        List list;
        int n10;
        int n11;
        int n12;
        int n13;
        block12: {
            String string2;
            Object object;
            Object object2;
            long l11;
            f0.p(a10, "task");
            a10.e(this);
            d$a d$a = this.e.h();
            long l12 = d$a.nanoTime();
            long l13 = l12 + l10;
            Object object3 = this.c;
            n13 = object3.indexOf(a10);
            n12 = -1;
            n11 = 0;
            if (n13 != n12) {
                l11 = a10.c();
                long l14 = l11 - l13;
                Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object4 <= 0) {
                    Level level;
                    Object object5 = g.h0.h.d.j.a();
                    boolean bl3 = ((Logger)object5).isLoggable(level = Level.FINE);
                    if (bl3) {
                        object5 = "already scheduled";
                        g.h0.h.b.a(a10, this, (String)object5);
                    }
                    return false;
                }
                object2 = this.c;
                object2.remove(n13);
            }
            a10.g(l13);
            object3 = g.h0.h.d.j.a();
            object2 = Level.FINE;
            n13 = (int)(((Logger)object3).isLoggable((Level)object2) ? 1 : 0);
            if (n13 != 0) {
                if (bl2) {
                    object = new StringBuilder();
                    object3 = "run again after ";
                    ((StringBuilder)object).append((String)object3);
                    string2 = g.h0.h.b.b(l13 -= l12);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = new StringBuilder();
                    object3 = "scheduled after ";
                    ((StringBuilder)object).append((String)object3);
                    string2 = g.h0.h.b.b(l13 -= l12);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                }
                g.h0.h.b.a(a10, this, (String)object);
            }
            object = this.c.iterator();
            n10 = 0;
            string2 = null;
            while (true) {
                Object object6 = object.hasNext();
                n13 = 1;
                if (object6 == 0) break;
                a a11 = (a)object.next();
                l11 = a11.c() - l12;
                long l15 = l11 - l10;
                object6 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object6 > 0) {
                    object6 = n13;
                } else {
                    object6 = 0;
                    a11 = null;
                }
                if (object6 == 0) {
                    ++n10;
                    continue;
                }
                break block12;
                break;
            }
            n10 = n12;
        }
        if (n10 == n12) {
            list = this.c;
            n10 = list.size();
        }
        list = this.c;
        list.add(n10, a10);
        if (n10 == 0) {
            n11 = n13;
        }
        return n11 != 0;
    }

    public final void r(a a10) {
        this.b = a10;
    }

    public final void s(boolean bl2) {
        this.d = bl2;
    }

    public final void t(boolean bl2) {
        this.a = bl2;
    }

    public String toString() {
        return this.f;
    }

    public final void u() {
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        d d10 = this.e;
        synchronized (d10) {
            Object object;
            boolean bl3 = true;
            this.a = bl3;
            bl3 = this.b();
            if (bl3) {
                object = this.e;
                ((d)object).i(this);
            }
            object = q1.a;
            return;
        }
    }
}

