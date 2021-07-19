/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.bumptech.glide.load.engine;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry$NoResultEncoderAvailableException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.CallbackException;
import com.bumptech.glide.load.engine.DecodeJob$RunReason;
import com.bumptech.glide.load.engine.DecodeJob$Stage;
import com.bumptech.glide.load.engine.DecodeJob$a;
import com.bumptech.glide.load.engine.DecodeJob$b;
import com.bumptech.glide.load.engine.DecodeJob$c;
import com.bumptech.glide.load.engine.DecodeJob$d;
import com.bumptech.glide.load.engine.DecodeJob$e;
import com.bumptech.glide.load.engine.DecodeJob$f;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.o.i;
import d.c.a.o.j.d;
import d.c.a.o.k.c;
import d.c.a.o.k.e;
import d.c.a.o.k.e$a;
import d.c.a.o.k.f;
import d.c.a.o.k.h;
import d.c.a.o.k.l;
import d.c.a.o.k.o;
import d.c.a.o.k.q;
import d.c.a.o.k.r;
import d.c.a.o.k.s;
import d.c.a.o.k.t;
import d.c.a.o.k.u;
import d.c.a.o.k.w;
import d.c.a.o.k.x.b;
import d.c.a.u.g;
import d.c.a.u.o.a$f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DecodeJob
implements e$a,
Runnable,
Comparable,
a$f {
    private static final String F = "DecodeJob";
    private DataSource A;
    private d B;
    private volatile e C;
    private volatile boolean D;
    private volatile boolean E;
    private final f a;
    private final List b;
    private final d.c.a.u.o.c c;
    private final DecodeJob$e d;
    private final Pools$Pool e;
    private final DecodeJob$d f;
    private final DecodeJob$f g;
    private d.c.a.e h;
    private d.c.a.o.c i;
    private Priority j;
    private l k;
    private int l;
    private int m;
    private h n;
    private d.c.a.o.f o;
    private DecodeJob$b p;
    private int q;
    private DecodeJob$Stage r;
    private DecodeJob$RunReason s;
    private long t;
    private boolean u;
    private Object v;
    private Thread w;
    private d.c.a.o.c x;
    private d.c.a.o.c y;
    private Object z;

    public DecodeJob(DecodeJob$e decodeJob$e, Pools$Pool pools$Pool) {
        Object object = new f();
        this.a = object;
        object = new ArrayList();
        this.b = object;
        this.c = object = d.c.a.u.o.c.a();
        this.f = object = new DecodeJob$d();
        this.g = object = new DecodeJob$f();
        this.d = decodeJob$e;
        this.e = pools$Pool;
    }

    private s A(Object object, DataSource object2, q q10) {
        d.c.a.o.f f10 = this.l((DataSource)((Object)object2));
        Object object3 = this.h.h();
        object = ((Registry)object3).l(object);
        try {
            int n10 = this.l;
            int n11 = this.m;
            DecodeJob$c decodeJob$c = new DecodeJob$c(this, (DataSource)((Object)object2));
            object3 = q10;
            object2 = q10.b((d.c.a.o.j.e)object, f10, n10, n11, decodeJob$c);
            return object2;
        }
        finally {
            object.b();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void B() {
        int[] nArray = DecodeJob$a.a;
        Object object = this.s;
        int n10 = ((Enum)object).ordinal();
        int n11 = nArray[n10];
        if (n11 == (n10 = 1)) {
            e e10;
            DecodeJob$Stage decodeJob$Stage;
            DecodeJob$Stage decodeJob$Stage2 = DecodeJob$Stage.INITIALIZE;
            this.r = decodeJob$Stage = this.k(decodeJob$Stage2);
            this.C = e10 = this.j();
            this.z();
            return;
        }
        n10 = 2;
        if (n11 == n10) {
            this.z();
            return;
        }
        n10 = 3;
        if (n11 == n10) {
            this.i();
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unrecognized run reason: ");
        DecodeJob$RunReason decodeJob$RunReason = this.s;
        ((StringBuilder)object).append((Object)decodeJob$RunReason);
        object = ((StringBuilder)object).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private void C() {
        Object object = this.c;
        ((d.c.a.u.o.c)object).c();
        boolean bl2 = this.D;
        int n10 = 1;
        if (bl2) {
            object = this.b;
            bl2 = object.isEmpty();
            if (bl2) {
                bl2 = false;
                object = null;
            } else {
                object = this.b;
                int n11 = object.size() - n10;
                object = (Throwable)object.get(n11);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Already notified", (Throwable)object);
            throw illegalStateException;
        }
        this.D = n10;
    }

    private s g(d d10, Object object, DataSource object2) {
        block11: {
            if (object == null) {
                d10.b();
                return null;
            }
            long l10 = d.c.a.u.g.b();
            object = this.h(object, (DataSource)((Object)object2));
            object2 = F;
            int n10 = 2;
            boolean bl2 = Log.isLoggable((String)object2, (int)n10);
            if (!bl2) break block11;
            object2 = new StringBuilder();
            String string2 = "Decoded result ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            this.p((String)object2, l10);
        }
        return object;
        finally {
            d10.b();
        }
    }

    private s h(Object object, DataSource dataSource) {
        Object object2 = this.a;
        Class<?> clazz = object.getClass();
        object2 = ((f)object2).h(clazz);
        return this.A(object, dataSource, (q)object2);
    }

    private void i() {
        Object object;
        Object object2;
        Object object3 = F;
        int n10 = 2;
        boolean bl2 = Log.isLoggable((String)object3, (int)n10);
        if (bl2) {
            long l10 = this.t;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("data: ");
            object = this.z;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(", cache key: ");
            object = this.x;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(", fetcher: ");
            object = this.B;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            object = "Retrieved data";
            this.q((String)object, l10, (String)object2);
        }
        bl2 = false;
        object3 = null;
        Object object4 = this.B;
        object2 = this.z;
        object = this.A;
        try {
            object3 = this.g((d)object4, object2, (DataSource)((Object)object));
        }
        catch (GlideException glideException) {
            object2 = this.y;
            object = this.A;
            glideException.setLoggingDetails((d.c.a.o.c)object2, (DataSource)((Object)object));
            object2 = this.b;
            object2.add(glideException);
        }
        if (object3 != null) {
            object4 = this.A;
            this.s((s)object3, (DataSource)((Object)object4));
        } else {
            this.z();
        }
    }

    private e j() {
        Object object = DecodeJob$a.b;
        Object object2 = this.r;
        int n10 = ((Enum)object2).ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 == n10) {
                        return null;
                    }
                    object = new IllegalStateException;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Unrecognized stage: ");
                    DecodeJob$Stage decodeJob$Stage = this.r;
                    ((StringBuilder)object2).append((Object)decodeJob$Stage);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new w;
                object2 = this.a;
                object((f)object2, this);
                return object;
            }
            object = new d.c.a.o.k.b;
            object2 = this.a;
            object((f)object2, this);
            return object;
        }
        object = new t;
        object2 = this.a;
        object((f)object2, this);
        return object;
    }

    private DecodeJob$Stage k(DecodeJob$Stage object) {
        Object object2 = DecodeJob$a.b;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10 && n11 != (n10 = 4)) {
                    n10 = 5;
                    if (n11 == n10) {
                        object = this.n;
                        boolean bl2 = ((h)object).b();
                        if (bl2) {
                            object = DecodeJob$Stage.RESOURCE_CACHE;
                        } else {
                            object = DecodeJob$Stage.RESOURCE_CACHE;
                            object = this.k((DecodeJob$Stage)((Object)object));
                        }
                        return object;
                    }
                    object2 = new IllegalArgumentException;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized stage: ");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    object2((String)object);
                    throw object2;
                }
                return DecodeJob$Stage.FINISHED;
            }
            boolean bl3 = this.u;
            object = bl3 ? DecodeJob$Stage.FINISHED : DecodeJob$Stage.SOURCE;
            return object;
        }
        object = this.n;
        boolean bl4 = ((h)object).a();
        if (bl4) {
            object = DecodeJob$Stage.DATA_CACHE;
        } else {
            object = DecodeJob$Stage.DATA_CACHE;
            object = this.k((DecodeJob$Stage)((Object)object));
        }
        return object;
    }

    private d.c.a.o.f l(DataSource object) {
        boolean bl2;
        d.c.a.o.f f10 = this.o;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return f10;
        }
        Object object2 = DataSource.RESOURCE_DISK_CACHE;
        if (object != object2 && !(bl2 = ((f)(object = this.a)).w())) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        object2 = d.c.a.o.m.d.o.k;
        Object object3 = (Boolean)f10.c((d.c.a.o.e)object2);
        if (object3 != null && ((n11 = (int)(((Boolean)object3).booleanValue() ? 1 : 0)) == 0 || bl2)) {
            return f10;
        }
        f10 = new d.c.a.o.f();
        object3 = this.o;
        f10.d((d.c.a.o.f)object3);
        object = bl2;
        f10.e((d.c.a.o.e)object2, object);
        return f10;
    }

    private int m() {
        return this.j.ordinal();
    }

    private void p(String string2, long l10) {
        this.q(string2, l10, null);
    }

    private void q(String object, long l10, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" in ");
        double d10 = d.c.a.u.g.a(l10);
        stringBuilder.append(d10);
        stringBuilder.append(", load key: ");
        object = this.k;
        stringBuilder.append(object);
        if (string2 != null) {
            object = new StringBuilder();
            String string3 = ", ";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            object = "";
        }
        stringBuilder.append((String)object);
        stringBuilder.append(", thread: ");
        object = Thread.currentThread().getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Log.v((String)F, (String)object);
    }

    private void r(s s10, DataSource dataSource) {
        this.C();
        this.p.c(s10, dataSource);
    }

    private void s(s object, DataSource object2) {
        Object object3;
        block11: {
            boolean bl2 = object instanceof o;
            if (bl2) {
                object3 = object;
                object3 = (o)object;
                object3.a();
            }
            bl2 = false;
            object3 = null;
            Object object4 = this.f;
            boolean bl3 = ((DecodeJob$d)object4).c();
            if (bl3) {
                object3 = object = d.c.a.o.k.r.c((s)object);
            }
            this.r((s)object, (DataSource)((Object)object2));
            object = DecodeJob$Stage.ENCODE;
            this.r = object;
            object = this.f;
            boolean bl4 = ((DecodeJob$d)object).c();
            if (!bl4) break block11;
            object = this.f;
            object2 = this.d;
            object4 = this.o;
            ((DecodeJob$d)object).b((DecodeJob$e)object2, (d.c.a.o.f)object4);
        }
        this.u();
        return;
        finally {
            if (object3 != null) {
                ((r)object3).f();
            }
        }
    }

    private void t() {
        this.C();
        List list = this.b;
        ArrayList arrayList = new ArrayList(list);
        GlideException glideException = new GlideException("Failed to load resource", arrayList);
        this.p.b(glideException);
        this.v();
    }

    private void u() {
        DecodeJob$f decodeJob$f = this.g;
        boolean bl2 = decodeJob$f.b();
        if (bl2) {
            this.y();
        }
    }

    private void v() {
        DecodeJob$f decodeJob$f = this.g;
        boolean bl2 = decodeJob$f.c();
        if (bl2) {
            this.y();
        }
    }

    private void y() {
        this.g.e();
        this.f.a();
        this.a.a();
        this.D = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.r = null;
        this.C = null;
        this.w = null;
        this.x = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.t = 0L;
        this.E = false;
        this.v = null;
        this.b.clear();
        this.e.release(this);
    }

    private void z() {
        DecodeJob$Stage decodeJob$Stage;
        Object object;
        boolean bl2;
        long l10;
        Object object2 = Thread.currentThread();
        this.w = object2;
        this.t = l10 = d.c.a.u.g.b();
        boolean bl3 = false;
        object2 = null;
        while (!(bl2 = this.E) && (object = this.C) != null && !(bl3 = (object2 = this.C).b())) {
            object = this.r;
            object = this.k((DecodeJob$Stage)((Object)object));
            this.r = object;
            this.C = object = this.j();
            object = this.r;
            decodeJob$Stage = DecodeJob$Stage.SOURCE;
            if (object != decodeJob$Stage) continue;
            this.c();
            return;
        }
        object = this.r;
        decodeJob$Stage = DecodeJob$Stage.FINISHED;
        if ((object == decodeJob$Stage || (bl2 = this.E)) && !bl3) {
            this.t();
        }
    }

    public boolean D() {
        boolean bl2;
        DecodeJob$Stage decodeJob$Stage;
        DecodeJob$Stage decodeJob$Stage2 = DecodeJob$Stage.INITIALIZE;
        if ((decodeJob$Stage2 = this.k(decodeJob$Stage2)) != (decodeJob$Stage = DecodeJob$Stage.RESOURCE_CACHE) && decodeJob$Stage2 != (decodeJob$Stage = DecodeJob$Stage.DATA_CACHE)) {
            bl2 = false;
            decodeJob$Stage2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void a(d.c.a.o.c object, Exception object2, d d10, DataSource dataSource) {
        d10.b();
        String string2 = "Fetching data failed";
        GlideException glideException = new GlideException(string2, (Throwable)object2);
        object2 = d10.a();
        glideException.setLoggingDetails((d.c.a.o.c)object, dataSource, (Class)object2);
        this.b.add(glideException);
        object = Thread.currentThread();
        object2 = this.w;
        if (object != object2) {
            object = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.s = object;
            object = this.p;
            object.e(this);
        } else {
            this.z();
        }
    }

    public void b() {
        boolean bl2;
        this.E = bl2 = true;
        e e10 = this.C;
        if (e10 != null) {
            e10.cancel();
        }
    }

    public void c() {
        DecodeJob$RunReason decodeJob$RunReason;
        this.s = decodeJob$RunReason = DecodeJob$RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.p.e(this);
    }

    public d.c.a.u.o.c d() {
        return this.c;
    }

    public void e(d.c.a.o.c object, Object object2, d d10, DataSource dataSource, d.c.a.o.c c10) {
        this.x = object;
        this.z = object2;
        this.B = d10;
        this.A = dataSource;
        this.y = c10;
        object = Thread.currentThread();
        if (object != (object2 = this.w)) {
            object = DecodeJob$RunReason.DECODE_DATA;
            this.s = object;
            object = this.p;
            object.e(this);
        } else {
            object = "DecodeJob.decodeFromRetrievedData";
            d.c.a.u.o.b.a((String)object);
            this.i();
        }
        return;
        finally {
            d.c.a.u.o.b.e();
        }
    }

    public int f(DecodeJob decodeJob) {
        int n10 = this.m();
        int n11 = decodeJob.m();
        if ((n10 -= n11) == 0) {
            n10 = this.q;
            int n12 = decodeJob.q;
            n10 -= n12;
        }
        return n10;
    }

    public DecodeJob o(d.c.a.e e10, Object object, l l10, d.c.a.o.c c10, int n10, int n11, Class clazz, Class clazz2, Priority priority, h h10, Map map, boolean bl2, boolean bl3, boolean bl4, d.c.a.o.f f10, DecodeJob$b decodeJob$b, int n12) {
        Object object2 = this.a;
        DecodeJob$e decodeJob$e = this.d;
        object2.u(e10, object, c10, n10, n11, h10, clazz, clazz2, priority, f10, map, bl2, bl3, decodeJob$e);
        object2 = e10;
        this.h = e10;
        object2 = c10;
        this.i = c10;
        object2 = priority;
        this.j = priority;
        object2 = l10;
        this.k = l10;
        this.l = n10;
        this.m = n11;
        object2 = h10;
        this.n = h10;
        this.u = bl4;
        object2 = f10;
        this.o = f10;
        object2 = decodeJob$b;
        this.p = decodeJob$b;
        this.q = n12;
        object2 = DecodeJob$RunReason.INITIALIZE;
        this.s = object2;
        object2 = object;
        this.v = object;
        return this;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block13: {
            Object object;
            Object object2;
            block11: {
                block12: {
                    object2 = F;
                    object = this.v;
                    String string2 = "DecodeJob#run(model=%s)";
                    d.c.a.u.o.b.b(string2, object);
                    object = this.B;
                    boolean bl2 = this.E;
                    if (!bl2) break block11;
                    this.t();
                    if (object == null) break block12;
                    object.b();
                }
                d.c.a.u.o.b.e();
                return;
            }
            try {
                this.B();
                if (object == null) break block13;
            }
            catch (Throwable throwable) {
                int n10 = 3;
                try {
                    boolean bl3;
                    Object object3;
                    n10 = (int)(Log.isLoggable((String)object2, (int)n10) ? 1 : 0);
                    if (n10 != 0) {
                        object3 = new StringBuilder();
                        String string3 = "DecodeJob threw unexpectedly, isCancelled: ";
                        ((StringBuilder)object3).append(string3);
                        boolean bl4 = this.E;
                        ((StringBuilder)object3).append(bl4);
                        String string4 = ", stage: ";
                        ((StringBuilder)object3).append(string4);
                        DecodeJob$Stage decodeJob$Stage = this.r;
                        ((StringBuilder)object3).append((Object)decodeJob$Stage);
                        object3 = ((StringBuilder)object3).toString();
                        Log.d((String)object2, (String)object3, (Throwable)throwable);
                    }
                    if ((object2 = this.r) != (object3 = DecodeJob$Stage.ENCODE)) {
                        object2 = this.b;
                        object2.add(throwable);
                        this.t();
                    }
                    if (!(bl3 = this.E)) {
                        throw throwable;
                    }
                    throw throwable;
                    catch (CallbackException callbackException) {
                        throw callbackException;
                    }
                }
                catch (Throwable throwable2) {
                    if (object != null) {
                        object.b();
                    }
                    d.c.a.u.o.b.e();
                    throw throwable2;
                }
            }
            object.b();
        }
        d.c.a.u.o.b.e();
        return;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public s w(DataSource object, s object2) {
        void var1_6;
        void var6_14;
        boolean bl2;
        Object object3;
        Object object4;
        Class<?> clazz = object4.get().getClass();
        Object object5 = DataSource.RESOURCE_DISK_CACHE;
        int n10 = 0;
        Object var6_12 = null;
        if (object != object5) {
            object5 = this.a.r(clazz);
            d.c.a.e e10 = this.h;
            int n11 = this.l;
            int n12 = this.m;
            s s10 = object5.a((Context)e10, (s)object4, n11, n12);
            object3 = object5;
            object5 = s10;
        } else {
            object5 = object4;
            object3 = null;
        }
        boolean bl3 = object4.equals(object5);
        if (!bl3) {
            object4.recycle();
        }
        if (bl2 = ((f)(object4 = this.a)).v((s)object5)) {
            d.c.a.o.h h10 = this.a.n((s)object5);
            object4 = this.o;
            object4 = h10.b((d.c.a.o.f)object4);
        } else {
            object4 = EncodeStrategy.NONE;
        }
        void var13_28 = var6_14;
        f f10 = this.a;
        d.c.a.o.c c10 = this.x;
        n10 = f10.x(c10);
        int n13 = 1;
        Object object6 = this.n;
        boolean bl4 = ((h)object6).d((n10 ^= n13) != 0, (DataSource)((Object)object), (EncodeStrategy)((Object)object4));
        if (!bl4) return object5;
        if (var13_28 == null) {
            object4 = object5.get().getClass();
            Registry$NoResultEncoderAvailableException registry$NoResultEncoderAvailableException = new Registry$NoResultEncoderAvailableException((Class)object4);
            throw registry$NoResultEncoderAvailableException;
        }
        int[] nArray = DecodeJob$a.c;
        n10 = ((Enum)object4).ordinal();
        int n14 = nArray[n10];
        if (n14 != n13) {
            u u10;
            n10 = 2;
            if (n14 != n10) {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("Unknown strategy: ");
                ((StringBuilder)object5).append(object4);
                object4 = ((StringBuilder)object5).toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4);
                throw illegalArgumentException;
            }
            object4 = this.a;
            b b10 = ((f)object4).b();
            object6 = this.x;
            d.c.a.o.c c11 = this.i;
            int n15 = this.l;
            int n16 = this.m;
            d.c.a.o.f f11 = this.o;
            u u11 = u10;
            u10 = new u(b10, (d.c.a.o.c)object6, c11, n15, n16, (i)object3, clazz, f11);
        } else {
            object4 = this.x;
            d.c.a.o.c c12 = this.i;
            c c13 = new c((d.c.a.o.c)object4, c12);
        }
        object5 = d.c.a.o.k.r.c((s)object5);
        object4 = this.f;
        ((DecodeJob$d)object4).d((d.c.a.o.c)var1_6, (d.c.a.o.h)var13_28, (r)object5);
        return object5;
    }

    public void x(boolean bl2) {
        DecodeJob$f decodeJob$f = this.g;
        if (bl2 = decodeJob$f.d(bl2)) {
            this.y();
        }
    }
}

