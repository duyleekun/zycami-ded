/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import f.k;
import g.a0;
import g.c0;
import g.f;
import g.h0.d;
import g.h0.i.e;
import g.h0.n.h;
import g.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public final class e$a
implements Runnable {
    private volatile AtomicInteger a;
    private final f b;
    public final /* synthetic */ e c;

    public e$a(e object, f f10) {
        f0.p(f10, "responseCallback");
        this.c = object;
        this.b = f10;
        this.a = object = new AtomicInteger(0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(ExecutorService object) {
        f0.p(object, "executorService");
        Object object2 = this.c.k().R();
        boolean bl2 = d.h;
        if (bl2 && (bl2 = Thread.holdsLock(object2))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(object2);
            object2 = stringBuilder.toString();
            object = new AssertionError(object2);
            throw object;
        }
        try {
            try {
                object.execute(this);
                return;
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                Object object4 = "executor rejected";
                object2 = new InterruptedIOException((String)object4);
                ((Throwable)object2).initCause(rejectedExecutionException);
                Object object5 = this.c;
                ((e)object5).u((IOException)object2);
                object5 = this.b;
                object4 = this.c;
                object5.onFailure((g.e)object4, (IOException)object2);
                object5 = this.c.k().R();
                ((o)object5).h(this);
                return;
            }
        }
        catch (Throwable throwable) {}
        this.c.k().R().h(this);
        throw throwable;
    }

    public final e b() {
        return this.c;
    }

    public final AtomicInteger c() {
        return this.a;
    }

    public final String d() {
        return this.c.q().q().F();
    }

    public final a0 e() {
        return this.c.q();
    }

    public final void f(e$a object) {
        f0.p(object, "other");
        this.a = object = ((e$a)object).a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block18: {
            var1_1 = new StringBuilder();
            var1_1.append("OkHttp ");
            var2_6 = this.c.v();
            var1_1.append((String)var2_6);
            var1_1 = var1_1.toString();
            var2_6 = Thread.currentThread();
            f0.o(var2_6, "currentThread");
            var3_7 = var2_6.getName();
            var2_6.setName((String)var1_1);
            var1_1 = null;
            var4_8 = this.c;
            var4_8 = e.a((e)var4_8);
            var4_8.v();
            try {
                var4_8 = this.c;
                var1_1 = var4_8.r();
                var5_9 = true;
            }
            catch (Throwable var8_17) {
                var5_9 = false;
                var4_8 = null;
                var1_1 = var8_17;
                ** GOTO lbl51
            }
            {
                block19: {
                    catch (IOException var8_18) {
                        var5_9 = false;
                        var4_8 = null;
                        var1_1 = var8_18;
                        break block18;
                    }
                    try {
                        var6_10 = this.b;
                        var7_14 = this.c;
                        var6_10.onResponse(var7_14, (c0)var1_1);
                    }
                    catch (Throwable var1_2) {
                        break block19;
                    }
                    catch (IOException var1_3) {
                        break block18;
                    }
                    ** try [egrp 3[TRYBLOCK] [13 : 111->134)] { 
lbl45:
                    // 1 sources

                    var1_1 = this.c;
                    var1_1 = var1_1.k();
                    var1_1 = var1_1.R();
lbl48:
                    // 3 sources

                    while (true) {
                        var1_1.h(this);
                        return;
                    }
                }
                ** try [egrp 4[TRYBLOCK] [17 : 153->368)] { 
lbl53:
                // 1 sources

                var6_11 = this.c;
                var6_11.cancel();
                if (var5_9 != false) throw var1_1;
                var6_11 = new StringBuilder();
                var7_15 = "canceled due to ";
                var6_11.append((String)var7_15);
                var6_11.append(var1_1);
                var6_11 = var6_11.toString();
                var4_8 = new IOException((String)var6_11);
                k.a((Throwable)var4_8, (Throwable)var1_1);
                var6_11 = this.b;
                var7_15 = this.c;
                var6_11.onFailure((g.e)var7_15, (IOException)var4_8);
                throw var1_1;
            }
lbl69:
            // 1 sources

            catch (Throwable var1_4) {
                ** GOTO lbl-1000
            }
        }
        if (var5_9) {
            var4_8 = h.e;
            var4_8 = var4_8.g();
            var6_12 /* !! */  = new StringBuilder();
            var7_16 = "Callback failure for ";
            var6_12 /* !! */ .append((String)var7_16);
            var7_16 = this.c;
            var7_16 = e.b((e)var7_16);
            var6_12 /* !! */ .append((String)var7_16);
            var6_12 /* !! */  = var6_12 /* !! */ .toString();
            var9_19 = 4;
            var4_8.m((String)var6_12 /* !! */ , var9_19, (Throwable)var1_1);
        } else {
            var4_8 = this.b;
            var6_13 = this.c;
            var4_8.onFailure(var6_13, (IOException)var1_1);
        }
        ** try [egrp 5[TRYBLOCK] [44 : 368->382)] { 
lbl91:
        // 1 sources

        var1_1 = this.c;
        var1_1 = var1_1.k();
        var1_1 = var1_1.R();
        ** GOTO lbl48
lbl-1000:
        // 1 sources

        {
            var4_8 = this.c;
            var4_8 = var4_8.k();
            var4_8 = var4_8.R();
            var4_8.h(this);
            throw var1_4;
        }
lbl100:
        // 1 sources

        finally {
            ** continue;
        }
lbl102:
        // 1 sources

        finally {
            var2_6.setName(var3_7);
        }
    }
}

