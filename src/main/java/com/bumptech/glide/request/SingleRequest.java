/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 */
package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest$Status;
import d.c.a.e;
import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.k.h;
import d.c.a.o.k.i;
import d.c.a.o.k.i$d;
import d.c.a.o.k.s;
import d.c.a.s.a;
import d.c.a.s.d;
import d.c.a.s.j.o;
import d.c.a.s.j.p;
import d.c.a.u.g;
import d.c.a.u.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public final class SingleRequest
implements d,
o,
d.c.a.s.h {
    private static final String D = "Request";
    private static final String E = "Glide";
    private static final boolean F = Log.isLoggable((String)"Request", (int)2);
    private int A;
    private boolean B;
    private RuntimeException C;
    private final String a;
    private final d.c.a.u.o.c b;
    private final Object c;
    private final d.c.a.s.f d;
    private final RequestCoordinator e;
    private final Context f;
    private final e g;
    private final Object h;
    private final Class i;
    private final a j;
    private final int k;
    private final int l;
    private final Priority m;
    private final p n;
    private final List o;
    private final d.c.a.s.k.g p;
    private final Executor q;
    private s r;
    private i$d s;
    private long t;
    private volatile i u;
    private SingleRequest$Status v;
    private Drawable w;
    private Drawable x;
    private Drawable y;
    private int z;

    private SingleRequest(Context context, e e10, Object object, Object object2, Class clazz, a a10, int n10, int n11, Priority priority, p p10, d.c.a.s.f f10, List list, RequestCoordinator requestCoordinator, i i10, d.c.a.s.k.g g10, Executor executor) {
        Object object3;
        SingleRequest singleRequest = this;
        int n12 = F;
        if (n12 != 0) {
            n12 = super.hashCode();
            object3 = String.valueOf(n12);
        } else {
            n12 = 0;
            object3 = null;
        }
        singleRequest.a = object3;
        singleRequest.b = object3 = d.c.a.u.o.c.a();
        object3 = object;
        singleRequest.c = object;
        object3 = context;
        singleRequest.f = context;
        object3 = e10;
        singleRequest.g = e10;
        Object object4 = object2;
        singleRequest.h = object2;
        object4 = clazz;
        singleRequest.i = clazz;
        object4 = a10;
        singleRequest.j = a10;
        singleRequest.k = n10;
        singleRequest.l = n11;
        object4 = priority;
        singleRequest.m = priority;
        object4 = p10;
        singleRequest.n = p10;
        object4 = f10;
        singleRequest.d = f10;
        object4 = list;
        singleRequest.o = list;
        object4 = requestCoordinator;
        singleRequest.e = requestCoordinator;
        object4 = i10;
        singleRequest.u = i10;
        object4 = g10;
        singleRequest.p = g10;
        object4 = executor;
        singleRequest.q = executor;
        object4 = SingleRequest$Status.PENDING;
        singleRequest.v = object4;
        object4 = singleRequest.C;
        if (object4 == null && (n12 = (int)(e10.i() ? 1 : 0)) != 0) {
            object4 = "Glide request origin trace";
            object3 = new RuntimeException((String)object4);
            singleRequest.C = object3;
        }
    }

    private void i() {
        boolean bl2 = this.B;
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        throw illegalStateException;
    }

    private boolean j() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.i(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean k() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.b(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean l() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.c(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void m() {
        this.i();
        this.b.c();
        this.n.a(this);
        i$d i$d = this.s;
        if (i$d != null) {
            i$d.a();
            i$d = null;
            this.s = null;
        }
    }

    private Drawable n() {
        Object object = this.w;
        if (object == null) {
            int n10;
            object = this.j.J();
            this.w = object;
            if (object == null && (n10 = ((a)(object = this.j)).I()) > 0) {
                n10 = this.j.I();
                object = this.r(n10);
                this.w = object;
            }
        }
        return this.w;
    }

    private Drawable o() {
        Object object = this.y;
        if (object == null) {
            int n10;
            object = this.j.K();
            this.y = object;
            if (object == null && (n10 = ((a)(object = this.j)).L()) > 0) {
                n10 = this.j.L();
                object = this.r(n10);
                this.y = object;
            }
        }
        return this.y;
    }

    private Drawable p() {
        Object object = this.x;
        if (object == null) {
            int n10;
            object = this.j.Q();
            this.x = object;
            if (object == null && (n10 = ((a)(object = this.j)).R()) > 0) {
                n10 = this.j.R();
                object = this.r(n10);
                this.x = object;
            }
        }
        return this.x;
    }

    private boolean q() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null && (bl2 = (requestCoordinator = requestCoordinator.getRoot()).a())) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private Drawable r(int n10) {
        Resources.Theme theme = this.j.X();
        theme = theme != null ? this.j.X() : this.f.getTheme();
        return d.c.a.o.m.f.a.a((Context)this.g, n10, theme);
    }

    private void s(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" this: ");
        string2 = this.a;
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.v((String)D, (String)string2);
    }

    private static int t(int n10, float f10) {
        int n11 = -1 << -1;
        if (n10 != n11) {
            float f11 = n10;
            n10 = Math.round(f10 *= f11);
        }
        return n10;
    }

    private void u() {
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    private void v() {
        RequestCoordinator requestCoordinator = this.e;
        if (requestCoordinator != null) {
            requestCoordinator.f(this);
        }
    }

    public static SingleRequest w(Context context, e e10, Object object, Object object2, Class clazz, a a10, int n10, int n11, Priority priority, p p10, d.c.a.s.f f10, List list, RequestCoordinator requestCoordinator, i i10, d.c.a.s.k.g g10, Executor executor) {
        SingleRequest singleRequest = new SingleRequest(context, e10, object, object2, clazz, a10, n10, n11, priority, p10, f10, list, requestCoordinator, i10, g10, executor);
        return singleRequest;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void x(GlideException glideException, int n10) {
        this.b.c();
        Object object = this.c;
        synchronized (object) {
            boolean bl2;
            int n11;
            Object object2;
            Object object3;
            int n12;
            Object object4;
            Object object5;
            Object object6;
            Object object7 = this.C;
            glideException.setOrigin((Exception)object7);
            object7 = this.g;
            int n13 = ((e)((Object)object7)).g();
            if (n13 <= n10) {
                object6 = E;
                object5 = new StringBuilder();
                object4 = "Load failed for ";
                ((StringBuilder)object5).append((String)object4);
                object4 = this.h;
                ((StringBuilder)object5).append(object4);
                object4 = " with size [";
                ((StringBuilder)object5).append((String)object4);
                n12 = this.z;
                ((StringBuilder)object5).append(n12);
                object4 = "x";
                ((StringBuilder)object5).append((String)object4);
                n12 = this.A;
                ((StringBuilder)object5).append(n12);
                object4 = "]";
                ((StringBuilder)object5).append((String)object4);
                object5 = ((StringBuilder)object5).toString();
                Log.w((String)object6, (String)object5, (Throwable)glideException);
                n10 = 4;
                if (n13 <= n10) {
                    object6 = E;
                    glideException.logRootCauses((String)object6);
                }
            }
            n10 = 0;
            object6 = null;
            this.s = null;
            object6 = SingleRequest$Status.FAILED;
            this.v = object6;
            n10 = 1;
            this.B = n10;
            n13 = 0;
            object7 = null;
            object5 = this.o;
            if (object5 != null) {
                int n14;
                object5 = object5.iterator();
                n12 = 0;
                object4 = null;
                while ((n14 = object5.hasNext()) != 0) {
                    object3 = object5.next();
                    object3 = (d.c.a.s.f)object3;
                    object2 = this.h;
                    p p10 = this.n;
                    boolean bl3 = this.q();
                    n14 = object3.b(glideException, object2, p10, bl3);
                    n12 |= n14;
                }
            } else {
                n12 = 0;
                object4 = null;
            }
            if ((object5 = this.d) == null || (n11 = (int)(object5.b(glideException, object3 = this.h, (p)(object2 = this.n), bl2 = this.q()) ? 1 : 0)) == 0) {
                n10 = 0;
                object6 = null;
            }
            n11 = n12 | n10;
            if (n11 == 0) {
                this.z();
            }
            this.u();
            return;
            finally {
                this.B = false;
            }
        }
    }

    private void y(s object, Object object2, DataSource object3) {
        int n10;
        boolean bl2;
        block24: {
            int n11;
            block23: {
                p p10;
                Object object4;
                int n12;
                Object object5;
                block22: {
                    block21: {
                        bl2 = this.q();
                        object5 = SingleRequest$Status.COMPLETE;
                        this.v = object5;
                        this.r = object;
                        object = this.g;
                        n11 = ((e)((Object)object)).g();
                        if (n11 <= (n12 = 3)) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Finished loading ");
                            object5 = object2.getClass().getSimpleName();
                            ((StringBuilder)object).append((String)object5);
                            ((StringBuilder)object).append(" from ");
                            ((StringBuilder)object).append(object3);
                            ((StringBuilder)object).append(" for ");
                            object5 = this.h;
                            ((StringBuilder)object).append(object5);
                            ((StringBuilder)object).append(" with size [");
                            n12 = this.z;
                            ((StringBuilder)object).append(n12);
                            ((StringBuilder)object).append("x");
                            n12 = this.A;
                            ((StringBuilder)object).append(n12);
                            ((StringBuilder)object).append("] in ");
                            long l10 = this.t;
                            double d10 = d.c.a.u.g.a(l10);
                            ((StringBuilder)object).append(d10);
                            ((StringBuilder)object).append(" ms");
                            object = ((StringBuilder)object).toString();
                            object5 = E;
                            Log.d((String)object5, (String)object);
                        }
                        n11 = 1;
                        this.B = n11;
                        object5 = this.o;
                        if (object5 == null) break block21;
                        Iterator iterator2 = object5.iterator();
                        n10 = 0;
                        while (true) {
                            n12 = (int)(iterator2.hasNext() ? 1 : 0);
                            if (n12 == 0) break block22;
                            object5 = iterator2.next();
                            object5 = (d.c.a.s.f)object5;
                            object4 = this.h;
                            p10 = this.n;
                            n12 = (int)(object5.c(object2, object4, p10, (DataSource)((Object)object3), bl2) ? 1 : 0);
                            n10 |= n12;
                            continue;
                            break;
                        }
                    }
                    n10 = 0;
                }
                object5 = this.d;
                if (object5 == null) break block23;
                object4 = this.h;
                p10 = this.n;
                n12 = (int)(object5.c(object2, object4, p10, (DataSource)((Object)object3), bl2) ? 1 : 0);
                if (n12 != 0) break block24;
            }
            n11 = 0;
            object = null;
        }
        if ((n11 |= n10) == 0) {
            object = this.p;
            object = object.a((DataSource)((Object)object3), bl2);
            object3 = this.n;
            object3.j(object2, (d.c.a.s.k.f)object);
        }
        this.v();
        return;
        finally {
            this.B = false;
        }
    }

    private void z() {
        boolean bl2 = this.k();
        if (!bl2) {
            return;
        }
        bl2 = false;
        Drawable drawable2 = null;
        Object object = this.h;
        if (object == null) {
            drawable2 = this.o();
        }
        if (drawable2 == null) {
            drawable2 = this.n();
        }
        if (drawable2 == null) {
            drawable2 = this.p();
        }
        this.n.m(drawable2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        Object object = this.c;
        synchronized (object) {
            SingleRequest$Status singleRequest$Status = this.v;
            SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.COMPLETE;
            if (singleRequest$Status != singleRequest$Status2) return false;
            return true;
        }
    }

    public void b(GlideException glideException) {
        this.x(glideException, 5);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void begin() {
        Object object = this.c;
        synchronized (object) {
            boolean bl2;
            long l10;
            this.i();
            Object object2 = this.b;
            ((d.c.a.u.o.c)object2).c();
            this.t = l10 = d.c.a.u.g.b();
            object2 = this.h;
            if (object2 == null) {
                int n10 = this.k;
                int n11 = this.l;
                if ((n10 = (int)(d.c.a.u.m.v(n10, n11) ? 1 : 0)) != 0) {
                    this.z = n10 = this.k;
                    this.A = n10 = this.l;
                }
                n10 = (object2 = this.o()) == null ? 5 : 3;
                String string2 = "Received null model";
                GlideException glideException = new GlideException(string2);
                this.x(glideException, n10);
                return;
            }
            object2 = this.v;
            Object object3 = SingleRequest$Status.RUNNING;
            if (object2 == object3) {
                object3 = "Cannot restart a running request";
                object2 = new IllegalArgumentException((String)object3);
                throw object2;
            }
            Object object4 = SingleRequest$Status.COMPLETE;
            if (object2 == object4) {
                object2 = this.r;
                object3 = DataSource.MEMORY_CACHE;
                this.c((s)object2, (DataSource)((Object)object3));
                return;
            }
            object2 = SingleRequest$Status.WAITING_FOR_SIZE;
            this.v = object2;
            int n12 = this.k;
            int n13 = this.l;
            if ((n12 = (int)(d.c.a.u.m.v(n12, n13) ? 1 : 0)) != 0) {
                n12 = this.k;
                n13 = this.l;
                this.d(n12, n13);
            } else {
                object4 = this.n;
                object4.p(this);
            }
            object4 = this.v;
            if ((object4 == object3 || object4 == object2) && (bl2 = this.k())) {
                object2 = this.n;
                object3 = this.p();
                object2.g((Drawable)object3);
            }
            if (bl2 = F) {
                object2 = new StringBuilder();
                object3 = "finished run method in ";
                ((StringBuilder)object2).append((String)object3);
                long l11 = this.t;
                double d10 = d.c.a.u.g.a(l11);
                ((StringBuilder)object2).append(d10);
                object2 = ((StringBuilder)object2).toString();
                this.s((String)object2);
            }
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(s var1_1, DataSource var2_3) {
        this.b.c();
        var3_5 = null;
        var4_6 = this.c;
        synchronized (var4_6) {
            this.s = null;
            if (var1_1 == null) {
                var2_3 = new StringBuilder();
                var5_7 = "Expected to receive a Resource<R> with an object of ";
                var2_3.append((String)var5_7);
            }
            ** GOTO lbl28
        }
        {
            catch (Throwable var1_2) {
                if (var3_5 != null) {
                    var2_3 = this.u;
                    var2_3.l((s)var3_5);
                }
                throw var1_2;
            }
            {
                var5_7 = this.i;
                var2_3.append(var5_7);
                var5_7 = " inside, but instead got null.";
                var2_3.append((String)var5_7);
                var2_3 = var2_3.toString();
                var1_1 = new GlideException((String)var2_3);
                this.b((GlideException)var1_1);
                return;
lbl28:
                // 1 sources

                var5_8 = var1_1.get();
                if (var5_8 == null || !(var8_11 = (var6_9 = this.i).isAssignableFrom(var7_10 = var5_8.getClass()))) ** GOTO lbl43
                var8_11 = this.l();
                if (var8_11) {
                    this.y((s)var1_1, var5_8, (DataSource)var2_3);
                    return;
                }
                try {
                    this.r = null;
                    var2_3 = SingleRequest$Status.COMPLETE;
                    this.v = var2_3;
                    // MONITOREXIT @DISABLED, blocks:[2, 7, 8] lbl40 : MonitorExitStatement: MONITOREXIT : var4_6
                    if (var1_1 != null) {
                        var2_3 = this.u;
                        var2_3.l((s)var1_1);
                    }
                    return;
lbl43:
                    // 1 sources

                    this.r = null;
                    var3_5 = new StringBuilder();
                    var6_9 = "Expected to receive an object of ";
                    var3_5.append((String)var6_9);
                    var6_9 = this.i;
                    var3_5.append(var6_9);
                    var6_9 = " but instead got ";
                    var3_5.append((String)var6_9);
                    var6_9 = var5_8 != null ? var5_8.getClass() : "";
                    var3_5.append(var6_9);
                    var6_9 = "{";
                    var3_5.append((String)var6_9);
                    var3_5.append(var5_8);
                    var6_9 = "} inside Resource{";
                    var3_5.append((String)var6_9);
                    var3_5.append(var1_1);
                    var6_9 = "}.";
                    var3_5.append((String)var6_9);
                    var5_8 = var5_8 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                    var3_5.append((String)var5_8);
                    var3_5 = var3_5.toString();
                    var2_3 = new GlideException((String)var3_5);
                    this.b((GlideException)var2_3);
                    // MONITOREXIT @DISABLED, blocks:[2, 7, 8] lbl78 : MonitorExitStatement: MONITOREXIT : var4_6
                    if (var1_1 != null) {
                        var2_3 = this.u;
                        var2_3.l((s)var1_1);
                    }
                    return;
                }
                catch (Throwable var2_4) {}
                var3_5 = var1_1;
                var1_1 = var2_4;
                {
                    throw var1_1;
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
    public void clear() {
        Object object = this.c;
        // MONITORENTER : object
        this.i();
        Object object2 = this.b;
        object2.c();
        object2 = this.v;
        SingleRequest$Status singleRequest$Status = SingleRequest$Status.CLEARED;
        if (object2 == singleRequest$Status) {
            // MONITOREXIT : object
            return;
        }
        this.m();
        object2 = this.r;
        boolean bl2 = false;
        p p10 = null;
        if (object2 != null) {
            this.r = null;
        } else {
            object2 = null;
        }
        bl2 = this.j();
        if (bl2) {
            p10 = this.n;
            Drawable drawable2 = this.p();
            p10.i(drawable2);
        }
        this.v = singleRequest$Status;
        // MONITOREXIT : object
        if (object2 == null) return;
        object = this.u;
        ((i)object).l((s)object2);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(int n10, int n11) {
        SingleRequest singleRequest = this;
        Object object = this.b;
        ((d.c.a.u.o.c)object).c();
        Object object2 = this.c;
        synchronized (object2) {
            void var4_7;
            block14: {
                int n12;
                SingleRequest$Status singleRequest$Status;
                double d10;
                long l10;
                Object object3;
                boolean bl2 = F;
                if (bl2) {
                    object3 = new StringBuilder();
                    String string2 = "Got onSizeReady in ";
                    ((StringBuilder)object3).append(string2);
                    l10 = this.t;
                    d10 = d.c.a.u.g.a(l10);
                    ((StringBuilder)object3).append(d10);
                    object3 = ((StringBuilder)object3).toString();
                    this.s((String)object3);
                }
                if ((object3 = singleRequest.v) != (singleRequest$Status = SingleRequest$Status.WAITING_FOR_SIZE)) {
                    return;
                }
                Object object4 = SingleRequest$Status.RUNNING;
                singleRequest.v = object4;
                object3 = singleRequest.j;
                float f10 = ((a)object3).W();
                int n13 = n10;
                singleRequest.z = n13 = SingleRequest.t(n10, f10);
                n13 = n11;
                singleRequest.A = n12 = SingleRequest.t(n11, f10);
                if (bl2) {
                    object3 = new StringBuilder();
                    String string3 = "finished setup for calling load in ";
                    ((StringBuilder)object3).append(string3);
                    l10 = singleRequest.t;
                    d10 = d.c.a.u.g.a(l10);
                    ((StringBuilder)object3).append(d10);
                    object3 = ((StringBuilder)object3).toString();
                    singleRequest.s((String)object3);
                }
                object3 = singleRequest.u;
                e e10 = singleRequest.g;
                Object object5 = singleRequest.h;
                Object object6 = singleRequest.j;
                object6 = ((a)object6).V();
                int n14 = singleRequest.z;
                int n15 = singleRequest.A;
                Object object7 = singleRequest.j;
                object7 = ((a)object7).U();
                Class clazz = singleRequest.i;
                Priority priority = singleRequest.m;
                Object object8 = singleRequest.j;
                object8 = ((a)object8).H();
                Object object9 = singleRequest.j;
                object9 = ((a)object9).Y();
                a a10 = singleRequest.j;
                boolean bl3 = a10.l0();
                SingleRequest$Status singleRequest$Status2 = object4;
                object4 = singleRequest.j;
                boolean bl4 = ((a)object4).g0();
                boolean bl5 = bl2;
                object = singleRequest.j;
                Object object10 = object = ((a)object).N();
                object = singleRequest.j;
                bl2 = ((a)object).e0();
                n11 = (int)(bl2 ? 1 : 0);
                object = singleRequest.j;
                boolean bl6 = bl2 = ((a)object).a0();
                object = singleRequest.j;
                boolean bl7 = bl2 = ((a)object).Z();
                object = singleRequest.j;
                bl2 = ((a)object).M();
                object = singleRequest.q;
                Object object11 = object2;
                object2 = object10;
                boolean bl8 = bl6;
                bl6 = bl7;
                bl7 = bl2;
                object = ((i)object3).g(e10, object5, (c)object6, n14, n15, (Class)object7, clazz, priority, (h)object8, (Map)object9, bl3, bl4, (f)object10, n11 != 0, bl8, bl6, bl2, this, (Executor)object);
                object3 = this;
                try {
                    this.s = object;
                    object = this.v;
                    SingleRequest$Status singleRequest$Status3 = singleRequest$Status2;
                    if (object != singleRequest$Status2) {
                        bl2 = false;
                        object = null;
                        this.s = null;
                    }
                    if (bl5) {
                        object = new StringBuilder();
                        String string4 = "finished onSizeReady in ";
                        ((StringBuilder)object).append(string4);
                        l10 = ((SingleRequest)object3).t;
                        d10 = d.c.a.u.g.a(l10);
                        ((StringBuilder)object).append(d10);
                        object = ((StringBuilder)object).toString();
                        super.s((String)object);
                    }
                    // ** MonitorExit[var34_42] (shouldn't be in output)
                    return;
                    catch (Throwable throwable) {
                        object3 = this;
                    }
                    break block14;
                    catch (Throwable throwable) {
                        object11 = object2;
                        object3 = singleRequest;
                    }
                }
                catch (Throwable throwable) {}
            }
            // ** MonitorExit[var34_42] (shouldn't be in output)
            throw var4_7;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean e() {
        Object object = this.c;
        synchronized (object) {
            SingleRequest$Status singleRequest$Status = this.v;
            SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.CLEARED;
            if (singleRequest$Status != singleRequest$Status2) return false;
            return true;
        }
    }

    public Object f() {
        this.b.c();
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean g() {
        Object object = this.c;
        synchronized (object) {
            SingleRequest$Status singleRequest$Status = this.v;
            SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.COMPLETE;
            if (singleRequest$Status != singleRequest$Status2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean h(d d10) {
        int n10;
        a a10;
        Class clazz;
        Object object;
        int n11;
        int n12;
        Priority priority;
        a a11;
        Class clazz2;
        Object object2;
        int n13;
        int n14;
        Object object3 = d10;
        int n15 = d10 instanceof SingleRequest;
        boolean bl2 = false;
        Priority priority2 = null;
        if (n15 == 0) {
            return false;
        }
        Object object4 = this.c;
        synchronized (object4) {
            n14 = this.k;
            n13 = this.l;
            object2 = this.h;
            clazz2 = this.i;
            a11 = this.j;
            priority = this.m;
            List list = this.o;
            if (list != null) {
                n12 = list.size();
            } else {
                n12 = 0;
                list = null;
            }
        }
        object3 = (SingleRequest)object3;
        Object object5 = ((SingleRequest)object3).c;
        synchronized (object5) {
            n15 = ((SingleRequest)object3).k;
            n11 = ((SingleRequest)object3).l;
            object = ((SingleRequest)object3).h;
            clazz = ((SingleRequest)object3).i;
            a10 = ((SingleRequest)object3).j;
            priority2 = ((SingleRequest)object3).m;
            object3 = ((SingleRequest)object3).o;
            if (object3 != null) {
                n10 = object3.size();
            } else {
                n10 = 0;
                object3 = null;
            }
        }
        if (n14 != n15) return false;
        if (n13 != n11) return false;
        n15 = (int)(d.c.a.u.m.c(object2, object) ? 1 : 0);
        if (n15 == 0) return false;
        n15 = (int)(clazz2.equals(clazz) ? 1 : 0);
        if (n15 == 0) return false;
        n15 = (int)(a11.equals(a10) ? 1 : 0);
        if (n15 == 0) return false;
        if (priority != priority2) return false;
        if (n12 != n10) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.c;
        synchronized (object) {
            SingleRequest$Status singleRequest$Status = this.v;
            SingleRequest$Status singleRequest$Status2 = SingleRequest$Status.RUNNING;
            if (singleRequest$Status == singleRequest$Status2) return true;
            singleRequest$Status2 = SingleRequest$Status.WAITING_FOR_SIZE;
            if (singleRequest$Status != singleRequest$Status2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        Object object = this.c;
        synchronized (object) {
            boolean bl2 = this.isRunning();
            if (bl2) {
                this.clear();
            }
            return;
        }
    }
}

