/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.f0;
import f.q1;
import g.h0.h.a;
import g.h0.h.c;
import g.h0.h.d$a;
import g.h0.h.d$b;
import g.h0.h.d$c;
import g.h0.h.d$d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt___CollectionsKt;

public final class d {
    public static final d h;
    private static final Logger i;
    public static final d$b j;
    private int a;
    private boolean b;
    private long c;
    private final List d;
    private final List e;
    private final Runnable f;
    private final d$a g;

    static {
        Object object = new d$b(null);
        j = object;
        Object object2 = new StringBuilder();
        String string2 = g.h0.d.i;
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" TaskRunner");
        object2 = g.h0.d.U(((StringBuilder)object2).toString(), true);
        d$c d$c = new d$c((ThreadFactory)object2);
        h = object = new d(d$c);
        object = Logger.getLogger(d.class.getName());
        f0.o(object, "Logger.getLogger(TaskRunner::class.java.name)");
        i = object;
    }

    public d(d$a object) {
        f0.p(object, "backend");
        this.g = object;
        this.a = 10000;
        object = new ArrayList();
        this.d = object;
        object = new ArrayList();
        this.e = object;
        this.f = object = new d$d(this);
    }

    public static final /* synthetic */ Logger a() {
        return i;
    }

    public static final /* synthetic */ void b(d d10, a a10) {
        d10.k(a10);
    }

    private final void d(a object, long l10) {
        boolean bl2;
        boolean bl3 = g.h0.d.h;
        if (bl3 && !(bl3 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            charSequence.append((String)object2);
            charSequence.append(" MUST hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        c c10 = ((a)object).d();
        f0.m(c10);
        a a10 = c10.e();
        boolean bl4 = false;
        List list = null;
        boolean bl5 = true;
        if (a10 == object) {
            bl2 = bl5;
        } else {
            bl2 = false;
            a10 = null;
        }
        if (bl2) {
            boolean bl6;
            bl2 = c10.f();
            c10.s(false);
            c10.r(null);
            list = this.d;
            list.remove(c10);
            long l11 = -1;
            bl4 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (bl4 && !bl2 && !(bl2 = c10.j())) {
                c10.q((a)object, l10, bl5);
            }
            if (bl6 = (object = c10.g()).isEmpty() ^ bl5) {
                object = this.e;
                object.add(c10);
            }
            return;
        }
        String string2 = "Check failed.".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    private final void f(a object) {
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            charSequence.append((String)object2);
            charSequence.append(" MUST hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        ((a)object).g(-1);
        c c10 = ((a)object).d();
        f0.m(c10);
        c10.g().remove(object);
        this.e.remove(c10);
        c10.r((a)object);
        this.d.add(c10);
    }

    private final void k(a object) {
        boolean bl2 = g.h0.d.h;
        if (bl2 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            charSequence.append((String)object2);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        Thread thread = Thread.currentThread();
        f0.o(thread, "currentThread");
        String string2 = thread.getName();
        String string3 = ((a)object).b();
        thread.setName(string3);
        long l10 = -1;
        try {
            l10 = ((a)object).f();
        }
        catch (Throwable throwable) {
            synchronized (this) {
                this.d((a)object, l10);
                object = q1.a;
                thread.setName(string2);
                throw throwable;
                finally {
                }
            }
        }
        synchronized (this) {
            this.d((a)object, l10);
            object = q1.a;
            thread.setName(string2);
            return;
        }
    }

    public final List c() {
        synchronized (this) {
            List list = this.d;
            List list2 = this.e;
            list = CollectionsKt___CollectionsKt.o4(list, list2);
            return list;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final a e() {
        var1_1 /* !! */  = g.h0.d.h;
        if (var1_1 /* !! */  != 0 && (var1_1 /* !! */  = Thread.holdsLock(this)) == 0) {
            var3_5 /* !! */  = new StringBuilder();
            var3_5 /* !! */ .append("Thread ");
            var4_7 = Thread.currentThread();
            f0.o(var4_7, "Thread.currentThread()");
            var4_7 = var4_7.getName();
            var3_5 /* !! */ .append((String)var4_7);
            var3_5 /* !! */ .append(" MUST hold lock on ");
            var3_5 /* !! */ .append(this);
            var3_5 /* !! */  = var3_5 /* !! */ .toString();
            var2_2 = new AssertionError(var3_5 /* !! */ );
            throw var2_2;
        }
        block4: while (true) {
            block15: {
                var2_3 = this.e;
                var1_1 /* !! */  = var2_3.isEmpty();
                var3_6 = null;
                if (var1_1 /* !! */  != 0) {
                    return null;
                }
                var5_8 = this.g.nanoTime();
                var7_9 = 0x7FFFFFFFFFFFFFFFL;
                var2_3 = this.e.iterator();
                var9_10 = null;
                while (true) {
                    var10_11 = var2_3.hasNext();
                    var11_12 = 1;
                    if (!var10_11) break;
                    var12_13 = (a)((c)var2_3.next()).g().get(0);
                    var13_14 = var12_13.c() - var5_8;
                    var15_15 = 0L;
                    cfr_temp_0 = (var13_14 = Math.max(var15_15, var13_14)) - var15_15;
                    var17_16 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var17_16 /* !! */  > 0) {
                        var7_9 = Math.min(var13_14, var7_9);
                        continue;
                    }
                    if (var9_10 != null) {
                        var1_1 /* !! */  = var11_12;
                        break block15;
                    }
                    var9_10 = var12_13;
                }
                var1_1 /* !! */  = 0;
                var2_3 = null;
            }
            if (var9_10 != null) {
                this.f(var9_10);
                if (var1_1 /* !! */  != 0 || (var1_1 /* !! */  = this.b) == 0 && (var1_1 /* !! */  = (var2_3 = this.e).isEmpty() ^ var11_12) != 0) {
                    var2_3 = this.g;
                    var3_6 = this.f;
                    var2_3.execute(var3_6);
                }
                return var9_10;
            }
            var1_1 /* !! */  = this.b;
            if (var1_1 /* !! */  != 0) {
                var18_17 = this.c - var5_8;
                cfr_temp_1 = var7_9 - var18_17;
                var1_1 /* !! */  = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var1_1 /* !! */  < 0) {
                    var2_3 = this.g;
                    var2_3.a(this);
                }
                return null;
            }
            this.b = var11_12;
            this.c = var5_8 += var7_9;
            var2_3 = this.g;
            var2_3.b(this, var7_9);
lbl69:
            // 2 sources

            while (true) {
                this.b = false;
                continue block4;
                break;
            }
            {
                catch (Throwable var2_4) {
                    break;
                }
                catch (InterruptedException v0) {}
                {
                    this.g();
                    ** continue;
                }
            }
        }
        this.b = false;
        throw var2_4;
    }

    public final void g() {
        Object object;
        int n10;
        List list = this.d;
        for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
            object = (c)this.d.get(n10);
            ((c)object).b();
        }
        list = this.e;
        for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
            object = (c)this.e.get(n10);
            ((c)object).b();
            object = ((c)object).g();
            boolean bl2 = object.isEmpty();
            if (!bl2) continue;
            object = this.e;
            object.remove(n10);
        }
    }

    public final d$a h() {
        return this.g;
    }

    public final void i(c object) {
        boolean bl2;
        Object object2 = "taskQueue";
        f0.p(object, (String)object2);
        boolean bl3 = g.h0.d.h;
        if (bl3 && !(bl3 = Thread.holdsLock(this))) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" MUST hold lock on ");
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            object = new AssertionError(object2);
            throw object;
        }
        object2 = ((c)object).e();
        if (object2 == null) {
            object2 = ((c)object).g();
            bl3 = object2.isEmpty() ^ true;
            if (bl3) {
                object2 = this.e;
                g.h0.d.a((List)object2, object);
            } else {
                object2 = this.e;
                object2.remove(object);
            }
        }
        if (bl2 = this.b) {
            object = this.g;
            object.a(this);
        } else {
            object = this.g;
            object2 = this.f;
            object.execute((Runnable)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final c j() {
        int n10;
        synchronized (this) {
            int n11;
            n10 = this.a;
            this.a = n11 = n10 + 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('Q');
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        return new c(this, string2);
    }
}

