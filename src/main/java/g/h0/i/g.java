/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import f.q1;
import g.a;
import g.h0.d;
import g.h0.h.c;
import g.h0.i.e;
import g.h0.i.e$b;
import g.h0.i.g$a;
import g.h0.i.g$b;
import g.h0.n.h;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.internal.connection.RealConnection;

public final class g {
    public static final g$a f;
    private final long a;
    private final c b;
    private final g$b c;
    private final ConcurrentLinkedQueue d;
    private final int e;

    static {
        g$a g$a;
        f = g$a = new g$a(null);
    }

    public g(g.h0.h.d object, int n10, long l10, TimeUnit object2) {
        long l11;
        f0.p(object, "taskRunner");
        String string2 = "timeUnit";
        f0.p(object2, string2);
        this.e = n10;
        this.a = l11 = object2.toNanos(l10);
        this.b = object = ((g.h0.h.d)object).j();
        Object object3 = new StringBuilder();
        object2 = g.h0.d.i;
        ((StringBuilder)object3).append((String)object2);
        object2 = " ConnectionPool";
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        this.c = object = new g$b(this, (String)object3);
        object = new ConcurrentLinkedQueue();
        this.d = object;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 > 0) {
            l13 = 1;
        } else {
            l13 = 0;
            object = null;
        }
        if (l13 != false) {
            return;
        }
        ((StringBuilder)object).append("keepAliveDuration <= 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    private final int g(RealConnection object, long l10) {
        int n10;
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            stringBuilder.append((String)object2);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            AssertionError assertionError = new AssertionError(object);
            throw assertionError;
        }
        List list = ((RealConnection)object).u();
        int n11 = 0;
        while (n11 < (n10 = list.size())) {
            Object object3 = (Reference)list.get(n11);
            Object object4 = ((Reference)object3).get();
            if (object4 != null) {
                ++n11;
                continue;
            }
            Objects.requireNonNull(object3, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
            object3 = (e$b)object3;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("A connection to ");
            Object object5 = ((RealConnection)object).b().d().w();
            ((StringBuilder)object4).append(object5);
            ((StringBuilder)object4).append(" was leaked. ");
            ((StringBuilder)object4).append("Did you forget to close a response body?");
            object4 = ((StringBuilder)object4).toString();
            object5 = h.e.g();
            object3 = ((e$b)object3).a();
            ((h)object5).o((String)object4, object3);
            list.remove(n11);
            ((RealConnection)object).J(true);
            n10 = (int)(list.isEmpty() ? 1 : 0);
            if (n10 == 0) continue;
            long l11 = this.a;
            ((RealConnection)object).I(l10 -= l11);
            return 0;
        }
        return list.size();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(a a10, e e10, List list, boolean bl2) {
        void var2_2;
        f0.p(a10, "address");
        f0.p(var2_2, "call");
        Iterator iterator2 = this.d.iterator();
        boolean bl3;
        while (bl3 = iterator2.hasNext()) {
            RealConnection realConnection = (RealConnection)iterator2.next();
            Object object = "connection";
            f0.o(realConnection, (String)object);
            synchronized (realConnection) {
                void var3_3;
                boolean bl4;
                void var4_4;
                if ((var4_4 == false || (bl4 = realConnection.C())) && (bl4 = realConnection.A(a10, (List)var3_3))) {
                    var2_2.c(realConnection);
                    return true;
                }
                object = q1.a;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long b(long l10) {
        Object object;
        Object object2;
        boolean bl2;
        long l11;
        Object object3 = this.d.iterator();
        int n10 = 0;
        long l12 = l11 = Long.MIN_VALUE;
        Object object4 = null;
        int n11 = 0;
        while (bl2 = object3.hasNext()) {
            RealConnection realConnection = (RealConnection)object3.next();
            Object object5 = "connection";
            f0.o(realConnection, (String)object5);
            synchronized (realConnection) {
                int n12 = this.g(realConnection, l10);
                if (n12 > 0) {
                    ++n11;
                } else {
                    ++n10;
                    long l13 = realConnection.w();
                    long l14 = (l13 = l10 - l13) - l12;
                    Object object6 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object6 > 0) {
                        object4 = q1.a;
                        object4 = realConnection;
                        l12 = l13;
                    } else {
                        object5 = q1.a;
                    }
                }
            }
        }
        long l15 = this.a;
        long l16 = l12 - l15;
        Object object7 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object7 < 0 && n10 <= (object7 = (Object)this.e)) {
            if (n10 > 0) {
                return l15 - l12;
            }
            if (n11 > 0) {
                return l15;
            }
            return -1;
        }
        f0.m(object4);
        synchronized (object4) {
            object3 = ((RealConnection)object4).u();
            object7 = object3.isEmpty();
            n10 = 1;
            object7 = object7 ^ n10;
            l15 = 0L;
            if (object7 != false) {
                return l15;
            }
            long l17 = ((RealConnection)object4).w() + l12;
            long l18 = l17 - l10;
            object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 != false) {
                return l15;
            }
            ((RealConnection)object4).J(n10 != 0);
            object = this.d;
            ((ConcurrentLinkedQueue)object).remove(object4);
        }
        g.h0.d.n(((RealConnection)object4).d());
        object = this.d;
        object2 = ((ConcurrentLinkedQueue)object).isEmpty();
        if (object2 != false) {
            object = this.b;
            ((c)object).a();
        }
        return l15;
    }

    public final boolean c(RealConnection object) {
        int n10;
        boolean bl2;
        Object object2 = "connection";
        f0.p(object, (String)object2);
        boolean n102 = g.h0.d.h;
        if (n102 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
        boolean bl3 = ((RealConnection)object).x();
        boolean bl4 = true;
        if (!bl3 && (n10 = this.e) != 0) {
            c c10 = this.b;
            g$b g$b = this.c;
            long l10 = 0L;
            int n11 = 2;
            g.h0.h.c.p(c10, g$b, l10, n11, null);
            bl4 = false;
            Object var4_8 = null;
        } else {
            ((RealConnection)object).J(bl4);
            object2 = this.d;
            ((ConcurrentLinkedQueue)object2).remove(object);
            object = this.d;
            boolean bl5 = ((ConcurrentLinkedQueue)object).isEmpty();
            if (bl5) {
                object = this.b;
                ((c)object).a();
            }
        }
        return bl4;
    }

    public final int d() {
        return this.d.size();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e() {
        boolean bl2;
        Object object = this.d.iterator();
        Object object2 = "connections.iterator()";
        f0.o(object, (String)object2);
        while (bl2 = object.hasNext()) {
            object2 = (RealConnection)object.next();
            Object object3 = "connection";
            f0.o(object2, (String)object3);
            synchronized (object2) {
                object3 = ((RealConnection)object2).u();
                boolean bl3 = object3.isEmpty();
                if (bl3) {
                    object.remove();
                    bl3 = true;
                    ((RealConnection)object2).J(bl3);
                    object3 = ((RealConnection)object2).d();
                } else {
                    bl3 = false;
                    object3 = null;
                }
                if (object3 == null) continue;
            }
            g.h0.d.n((Socket)object3);
        }
        object = this.d;
        boolean bl4 = ((ConcurrentLinkedQueue)object).isEmpty();
        if (bl4) {
            object = this.b;
            ((c)object).a();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final int f() {
        Object object = this.d;
        boolean bl2 = object instanceof Collection;
        int n10 = 0;
        if (bl2 && (bl2 = object.isEmpty())) {
            return n10;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            RealConnection realConnection = (RealConnection)object.next();
            Object object2 = "it";
            f0.o(realConnection, (String)object2);
            synchronized (realConnection) {
                object2 = realConnection.u();
                boolean bl3 = object2.isEmpty();
                if (!bl3 || ++n10 >= 0) continue;
            }
            CollectionsKt__CollectionsKt.V();
        }
        return n10;
    }

    public final void h(RealConnection object) {
        Object object2 = "connection";
        f0.p(object, (String)object2);
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
        this.d.add(object);
        c c10 = this.b;
        g$b g$b = this.c;
        g.h0.h.c.p(c10, g$b, 0L, 2, null);
    }
}

