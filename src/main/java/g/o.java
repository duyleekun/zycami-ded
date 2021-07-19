/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q1;
import f.x1.u;
import g.h0.d;
import g.h0.i.e;
import g.h0.i.e$a;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt___CollectionsKt;

public final class o {
    private int a;
    private int b;
    private Runnable c;
    private ExecutorService d;
    private final ArrayDeque e;
    private final ArrayDeque f;
    private final ArrayDeque g;

    public o() {
        ArrayDeque arrayDeque;
        this.a = 64;
        this.b = 5;
        this.e = arrayDeque = new ArrayDeque();
        this.f = arrayDeque = new ArrayDeque();
        this.g = arrayDeque = new ArrayDeque();
    }

    public o(ExecutorService executorService) {
        f0.p(executorService, "executorService");
        this();
        this.d = executorService;
    }

    private final e$a f(String string2) {
        boolean bl2;
        String string3;
        e$a e$a;
        boolean bl3;
        Iterator iterator2 = this.f.iterator();
        while (bl3 = iterator2.hasNext()) {
            e$a = (e$a)iterator2.next();
            string3 = e$a.d();
            bl2 = f0.g(string3, string2);
            if (!bl2) continue;
            return e$a;
        }
        iterator2 = this.e.iterator();
        while (bl3 = iterator2.hasNext()) {
            e$a = (e$a)iterator2.next();
            string3 = e$a.d();
            bl2 = f0.g(string3, string2);
            if (!bl2) continue;
            return e$a;
        }
        return null;
    }

    private final void g(Deque object, Object object2) {
        synchronized (this) {
            block9: {
                boolean bl2 = object.remove(object2);
                if (!bl2) break block9;
                object = this.c;
                object2 = q1.a;
                boolean bl3 = this.m();
                if (!bl3 && object != null) {
                    object.run();
                }
                return;
            }
            object2 = "Call wasn't in-flight!";
            object = new AssertionError(object2);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean m() {
        boolean bl2;
        int n10;
        int n11;
        boolean bl3 = g.h0.d.h;
        if (bl3 && (bl3 = Thread.holdsLock(this))) {
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
        ArrayList<Object> arrayList = new ArrayList<Object>();
        synchronized (this) {
            Object object;
            Object object2 = this.e;
            object2 = ((ArrayDeque)object2).iterator();
            Object object3 = "readyAsyncCalls.iterator()";
            f0.o(object2, (String)object3);
            while ((n11 = object2.hasNext()) != 0) {
                int n12;
                object3 = object2.next();
                object3 = (e$a)object3;
                object = this.f;
                n10 = ((ArrayDeque)object).size();
                if (n10 >= (n12 = this.a)) break;
                object = ((e$a)object3).c();
                n10 = ((AtomicInteger)object).get();
                if (n10 >= (n12 = this.b)) continue;
                object2.remove();
                object = ((e$a)object3).c();
                ((AtomicInteger)object).incrementAndGet();
                object = "asyncCall";
                f0.o(object3, (String)object);
                arrayList.add(object3);
                object = this.f;
                ((ArrayDeque)object).add(object3);
            }
            bl2 = this.q();
            n11 = 0;
            object3 = null;
            if (bl2 > false) {
                bl2 = true;
            } else {
                bl2 = false;
                object2 = null;
            }
            object = q1.a;
        }
        n10 = arrayList.size();
        while (n11 < n10) {
            e$a e$a = (e$a)arrayList.get(n11);
            ExecutorService executorService = this.e();
            e$a.a(executorService);
            ++n11;
        }
        return bl2;
    }

    public final ExecutorService a() {
        return this.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b() {
        synchronized (this) {
            Object object;
            boolean bl2;
            Iterator iterator2 = this.e;
            iterator2 = ((ArrayDeque)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (e$a)object;
                object = ((e$a)object).b();
                ((e)object).cancel();
            }
            iterator2 = this.f;
            iterator2 = ((ArrayDeque)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (e$a)object;
                object = ((e$a)object).b();
                ((e)object).cancel();
            }
            iterator2 = this.g;
            iterator2 = ((ArrayDeque)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (e)object;
                ((e)object).cancel();
            }
            return;
        }
    }

    public final void c(e$a object) {
        Object object2 = "call";
        f0.p(object, (String)object2);
        synchronized (this) {
            object2 = this.e;
            ((ArrayDeque)object2).add(object);
            object2 = ((e$a)object).b();
            boolean bl2 = ((e)object2).o();
            if (!bl2) {
                object2 = ((e$a)object).d();
                if ((object2 = this.f((String)object2)) != null) {
                    ((e$a)object).f((e$a)object2);
                }
            }
            object = q1.a;
            this.m();
            return;
            finally {
            }
        }
    }

    public final void d(e e10) {
        synchronized (this) {
            Object object = "call";
            f0.p(e10, (String)object);
            object = this.g;
            ((ArrayDeque)object).add(e10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final ExecutorService e() {
        synchronized (this) {
            ExecutorService executorService = this.d;
            if (executorService == null) {
                int n10 = -1 >>> 1;
                long l10 = 60;
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<Runnable>();
                Object object = new StringBuilder();
                Object object2 = g.h0.d.i;
                ((StringBuilder)object).append((String)object2);
                object2 = " Dispatcher";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                object2 = null;
                object2 = g.h0.d.U((String)object, false);
                object = executorService;
                this.d = executorService = new ThreadPoolExecutor(0, n10, l10, timeUnit, synchronousQueue, (ThreadFactory)object2);
            }
            executorService = this.d;
            f0.m(executorService);
            return executorService;
        }
    }

    public final void h(e$a e$a) {
        f0.p(e$a, "call");
        e$a.c().decrementAndGet();
        ArrayDeque arrayDeque = this.f;
        this.g(arrayDeque, e$a);
    }

    public final void i(e e10) {
        f0.p(e10, "call");
        ArrayDeque arrayDeque = this.g;
        this.g(arrayDeque, e10);
    }

    public final Runnable j() {
        synchronized (this) {
            Runnable runnable = this.c;
            return runnable;
        }
    }

    public final int k() {
        synchronized (this) {
            int n10 = this.a;
            return n10;
        }
    }

    public final int l() {
        synchronized (this) {
            int n10 = this.b;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final List n() {
        synchronized (this) {
            List list = this.e;
            int n10 = 10;
            n10 = u.Y(list, n10);
            Object object = new ArrayList(n10);
            list = list.iterator();
            while (true) {
                if ((n10 = (int)(list.hasNext() ? 1 : 0)) == 0) {
                    list = Collections.unmodifiableList(object);
                    object = "Collections.unmodifiable\u2026yncCalls.map { it.call })";
                    f0.o(list, (String)object);
                    return list;
                }
                Object object2 = list.next();
                object2 = (e$a)object2;
                object2 = ((e$a)object2).b();
                object.add(object2);
            }
        }
    }

    public final int o() {
        synchronized (this) {
            ArrayDeque arrayDeque = this.e;
            int n10 = arrayDeque.size();
            return n10;
        }
    }

    public final List p() {
        synchronized (this) {
            Collection<Object> collection = this.g;
            Object object = this.f;
            int n10 = 10;
            n10 = u.Y((Iterable)object, n10);
            ArrayList<Object> arrayList = new ArrayList<Object>(n10);
            object = object.iterator();
            while (true) {
                n10 = (int)(object.hasNext() ? 1 : 0);
                if (n10 == 0) break;
                Object object2 = object.next();
                object2 = (e$a)object2;
                object2 = ((e$a)object2).b();
                arrayList.add(object2);
                continue;
                break;
            }
            collection = CollectionsKt___CollectionsKt.o4(collection, arrayList);
            collection = Collections.unmodifiableList(collection);
            object = "Collections.unmodifiable\u2026yncCalls.map { it.call })";
            f0.o(collection, (String)object);
            return collection;
        }
    }

    public final int q() {
        synchronized (this) {
            ArrayDeque arrayDeque = this.f;
            int n10 = arrayDeque.size();
            ArrayDeque arrayDeque2 = this.g;
            int n11 = arrayDeque2.size();
            return n10 += n11;
        }
    }

    public final void r(Runnable runnable) {
        synchronized (this) {
            this.c = runnable;
            return;
        }
    }

    public final void s(int n10) {
        Serializable serializable;
        int n11 = 1;
        if (n10 < n11) {
            n11 = 0;
            serializable = null;
        }
        if (n11 != 0) {
            synchronized (this) {
                this.a = n10;
                q1 q12 = q1.a;
                this.m();
                return;
                finally {
                }
            }
        }
        serializable = new StringBuilder();
        serializable.append("max < 1: ");
        serializable.append(n10);
        String string2 = serializable.toString();
        string2 = string2.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }

    public final void t(int n10) {
        Serializable serializable;
        int n11 = 1;
        if (n10 < n11) {
            n11 = 0;
            serializable = null;
        }
        if (n11 != 0) {
            synchronized (this) {
                this.b = n10;
                q1 q12 = q1.a;
                this.m();
                return;
                finally {
                }
            }
        }
        serializable = new StringBuilder();
        serializable.append("max < 1: ");
        serializable.append(n10);
        String string2 = serializable.toString();
        string2 = string2.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }
}

