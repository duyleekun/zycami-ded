/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 */
package d.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import d.c.a.h$a;
import d.c.a.j;
import d.c.a.o.k.i;
import d.c.a.s.b;
import d.c.a.s.c;
import d.c.a.s.d;
import d.c.a.s.e;
import d.c.a.s.f;
import d.c.a.s.g;
import d.c.a.s.j.p;
import d.c.a.s.j.r;
import d.c.a.t.a;
import d.c.a.u.k;
import d.c.a.u.m;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class h
extends d.c.a.s.a
implements Cloneable,
d.c.a.g {
    public static final g w0;
    private final Context V;
    private final d.c.a.i W;
    private final Class X;
    private final d.c.a.c Y;
    private final d.c.a.e Z;
    private j k0;
    private Object o0;
    private List p0;
    private h q0;
    private h r0;
    private Float s0;
    private boolean t0;
    private boolean u0;
    private boolean v0;

    static {
        g g10 = new g();
        Object object = d.c.a.o.k.h.c;
        g10 = (g)g10.s((d.c.a.o.k.h)object);
        object = Priority.LOW;
        w0 = (g)((g)g10.C0((Priority)((Object)object))).K0(true);
    }

    public h(d.c.a.c object, d.c.a.i i10, Class object2, Context context) {
        this.t0 = true;
        this.Y = object;
        this.W = i10;
        this.X = object2;
        this.V = context;
        this.k0 = object2 = i10.E((Class)object2);
        object = object.j();
        this.Z = object;
        object = i10.C();
        this.h1((List)object);
        object = i10.D();
        this.X0((d.c.a.s.a)object);
    }

    public h(Class object, h h10) {
        boolean bl2;
        d.c.a.c c10 = h10.Y;
        d.c.a.i i10 = h10.W;
        Context context = h10.V;
        this(c10, i10, (Class)object, context);
        this.o0 = object = h10.o0;
        this.u0 = bl2 = h10.u0;
        this.X0(h10);
    }

    private d Y0(p p10, f f10, d.c.a.s.a a10, Executor executor) {
        Object object = new Object();
        j j10 = this.k0;
        Priority priority = a10.T();
        int n10 = a10.P();
        int n11 = a10.O();
        return this.Z0(object, p10, f10, null, j10, priority, n10, n11, a10, executor);
    }

    private d Z0(Object object, p p10, f f10, RequestCoordinator requestCoordinator, j j10, Priority priority, int n10, int n11, d.c.a.s.a a10, Executor executor) {
        Object object2;
        Object object3;
        Object object4;
        h h10 = this;
        Object object5 = this.r0;
        if (object5 != null) {
            object4 = requestCoordinator;
            object3 = object5 = new b(object, requestCoordinator);
            object2 = object5;
        } else {
            object4 = requestCoordinator;
            object5 = null;
            object2 = null;
            object3 = requestCoordinator;
        }
        object5 = this;
        object4 = object;
        Object object6 = p10;
        Object object7 = f10;
        object5 = this.a1(object, p10, f10, (RequestCoordinator)object3, j10, priority, n10, n11, a10, executor);
        if (object2 == null) {
            return object5;
        }
        object4 = h10.r0;
        int n12 = ((d.c.a.s.a)object4).P();
        object6 = h10.r0;
        int n13 = ((d.c.a.s.a)object6).O();
        boolean bl2 = m.v(n10, n11);
        if (bl2 && !(bl2 = ((d.c.a.s.a)(object7 = h10.r0)).n0())) {
            n12 = a10.P();
            n13 = a10.O();
        }
        h h11 = h10.r0;
        object4 = h11.k0;
        Priority priority2 = h11.T();
        object6 = h10.r0;
        object7 = object2;
        object2 = f10;
        object4 = h11.Z0(object, p10, f10, (RequestCoordinator)object7, (j)object4, priority2, n12, n13, (d.c.a.s.a)object6, executor);
        ((b)object7).n((d)object5, (d)object4);
        return object7;
    }

    private d a1(Object object, p p10, f f10, RequestCoordinator requestCoordinator, j j10, Priority priority, int n10, int n11, d.c.a.s.a a10, Executor executor) {
        h h10 = this;
        Object object2 = object;
        Object object3 = requestCoordinator;
        Object object4 = priority;
        Object object5 = this.q0;
        if (object5 != null) {
            int n12 = this.v0;
            if (n12 == 0) {
                int n13;
                Object p12;
                Object object7 = ((h)object5).k0;
                boolean bl2 = ((h)object5).t0;
                Object object8 = bl2 ? j10 : object7;
                boolean n132 = ((d.c.a.s.a)object5).f0();
                object5 = n132 ? h10.q0.T() : h10.g1((Priority)((Object)object4));
                Object object6 = object5;
                object5 = h10.q0;
                int n14 = ((d.c.a.s.a)object5).P();
                object7 = h10.q0;
                n12 = ((d.c.a.s.a)object7).O();
                bl2 = m.v(n10, n11);
                if (bl2 && !(bl2 = ((d.c.a.s.a)(p12 = h10.q0)).n0())) {
                    n13 = a10.P();
                    n12 = a10.O();
                }
                Object executor3 = new d.c.a.s.i(object2, (RequestCoordinator)object3);
                object5 = this;
                object7 = object;
                p12 = p10;
                Object a12 = a10;
                object3 = executor3;
                Priority priority4 = priority;
                object4 = executor3;
                executor3 = executor;
                executor3 = this.z1(object, p10, f10, a10, (RequestCoordinator)object3, j10, priority, n10, n11, executor);
                h10.v0 = true;
                h h11 = h10.q0;
                object5 = h11;
                a12 = object3;
                object3 = object8;
                object2 = executor3;
                executor3 = executor;
                object5 = h11.Z0(object, p10, f10, (RequestCoordinator)object4, (j)object8, (Priority)((Object)object6), n13, n12, h11, executor);
                h10.v0 = false;
                ((d.c.a.s.i)object4).m((d)object2, (d)object5);
                return object4;
            }
            object5 = new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            throw object5;
        }
        object5 = this.s0;
        if (object5 != null) {
            d.c.a.s.i i10 = new d.c.a.s.i(object, requestCoordinator);
            object5 = this;
            Object object12 = object;
            p p11 = p10;
            d.c.a.s.a a11 = a10;
            object3 = i10;
            Priority priority2 = priority;
            Executor executor2 = executor;
            d d10 = this.z1(object, p10, f10, a10, i10, j10, priority, n10, n11, executor);
            object5 = a10.m();
            float f11 = this.s0.floatValue();
            a11 = ((d.c.a.s.a)object5).J0(f11);
            priority2 = this.g1(priority);
            object5 = this;
            object12 = object;
            object5 = this.z1(object, p10, f10, a11, i10, j10, priority2, n10, n11, executor);
            i10.m(d10, (d)object5);
            return i10;
        }
        object5 = this;
        Object object13 = object;
        p p12 = p10;
        d.c.a.s.a a12 = a10;
        Priority priority3 = priority;
        Executor executor3 = executor;
        return this.z1(object, p10, f10, a10, requestCoordinator, j10, priority, n10, n11, executor);
    }

    private Priority g1(Priority object) {
        Object object2 = h$a.b;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11 && n10 != (n11 = 4)) {
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("unknown priority: ");
                    Priority priority = this.T();
                    ((StringBuilder)object2).append((Object)priority);
                    object2 = ((StringBuilder)object2).toString();
                    object = new IllegalArgumentException((String)object2);
                    throw object;
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    private void h1(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            f f10 = (f)object.next();
            this.W0(f10);
        }
    }

    private p k1(p object, f object2, d.c.a.s.a a10, Executor object3) {
        k.d(object);
        boolean bl2 = this.u0;
        if (bl2) {
            boolean bl3;
            bl2 = (object2 = this.Y0((p)object, (f)object2, a10, (Executor)object3)).h((d)(object3 = object.h()));
            if (bl2 && !(bl3 = this.n1(a10, (d)object3))) {
                object2 = (d)k.d(object3);
                boolean bl4 = object2.isRunning();
                if (!bl4) {
                    object3.begin();
                }
                return object;
            }
            this.W.z((p)object);
            object.l((d)object2);
            this.W.Y((p)object, (d)object2);
            return object;
        }
        object = new IllegalArgumentException("You must call #load() before calling #into()");
        throw object;
    }

    private boolean n1(d.c.a.s.a a10, d d10) {
        boolean bl2 = a10.e0();
        if (!bl2 && (bl2 = d10.g())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    private h y1(Object object) {
        this.o0 = object;
        this.u0 = true;
        return this;
    }

    private d z1(Object object, p p10, f f10, d.c.a.s.a a10, RequestCoordinator requestCoordinator, j j10, Priority priority, int n10, int n11, Executor executor) {
        Context context = this.V;
        d.c.a.e e10 = this.Z;
        Object object2 = this.o0;
        Class clazz = this.X;
        List list = this.p0;
        i i10 = e10.f();
        d.c.a.s.k.g g10 = j10.c();
        return SingleRequest.w(context, e10, object, object2, clazz, a10, n10, n11, priority, p10, f10, list, requestCoordinator, i10, g10, executor);
    }

    public p A1() {
        int n10 = -1 << -1;
        return this.B1(n10, n10);
    }

    public p B1(int n10, int n11) {
        d.c.a.s.j.m m10 = d.c.a.s.j.m.o(this.W, n10, n11);
        return this.j1(m10);
    }

    public c C1() {
        int n10 = -1 << -1;
        return this.D1(n10, n10);
    }

    public c D1(int n10, int n11) {
        e e10 = new e(n10, n11);
        Executor executor = d.c.a.u.e.a();
        return (c)this.l1(e10, e10, executor);
    }

    public h E1(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            Float f14;
            this.s0 = f14 = Float.valueOf(f10);
            return this;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        throw illegalArgumentException;
    }

    public h F1(h h10) {
        this.q0 = h10;
        return this;
    }

    public h G1(h ... hArray) {
        int n10;
        h h10 = null;
        if (hArray != null && (n10 = hArray.length) != 0) {
            for (n10 = hArray.length + -1; n10 >= 0; n10 += -1) {
                h h11 = hArray[n10];
                if (h11 == null) continue;
                h10 = h10 == null ? h11 : h11.F1(h10);
            }
            return this.F1(h10);
        }
        return this.F1(null);
    }

    public h H1(j j10) {
        this.k0 = j10 = (j)k.d(j10);
        this.t0 = false;
        return this;
    }

    public h W0(f f10) {
        if (f10 != null) {
            ArrayList<f> arrayList = this.p0;
            if (arrayList == null) {
                this.p0 = arrayList = new ArrayList<f>();
            }
            arrayList = this.p0;
            arrayList.add(f10);
        }
        return this;
    }

    public h X0(d.c.a.s.a a10) {
        k.d(a10);
        return (h)super.a(a10);
    }

    public h b1() {
        j j10;
        h h10 = (h)super.m();
        h10.k0 = j10 = h10.k0.a();
        return h10;
    }

    public c c1(int n10, int n11) {
        return this.f1().D1(n10, n11);
    }

    public p d1(p p10) {
        return this.f1().j1(p10);
    }

    public h e1(h h10) {
        this.r0 = h10;
        return this;
    }

    public h f1() {
        h h10 = new h(File.class, this);
        g g10 = w0;
        return h10.X0(g10);
    }

    public c i1(int n10, int n11) {
        return this.D1(n10, n11);
    }

    public p j1(p p10) {
        Executor executor = d.c.a.u.e.b();
        return this.l1(p10, null, executor);
    }

    public p l1(p p10, f f10, Executor executor) {
        return this.k1(p10, f10, this, executor);
    }

    public r m1(ImageView object) {
        d.c.a.e e10;
        Object object2;
        block7: {
            block6: {
                m.b();
                k.d(object);
                Object object3 = this.m0();
                if (object3 || !(object3 = this.k0()) || (object2 = object.getScaleType()) == null) break block6;
                object2 = h$a.a;
                e10 = object.getScaleType();
                int n10 = e10.ordinal();
                object3 = object2[n10];
                switch (object3 ? 1 : 0) {
                    default: {
                        break;
                    }
                    case 6: {
                        object2 = ((d.c.a.s.a)this).m().r0();
                        break block7;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        object2 = ((d.c.a.s.a)this).m().t0();
                        break block7;
                    }
                    case 2: {
                        object2 = ((d.c.a.s.a)this).m().r0();
                        break block7;
                    }
                    case 1: {
                        object2 = ((d.c.a.s.a)this).m().q0();
                        break block7;
                    }
                }
            }
            object2 = this;
        }
        e10 = this.Z;
        Object object4 = this.X;
        object = e10.a((ImageView)object, (Class)object4);
        object4 = d.c.a.u.e.b();
        return (r)this.k1((p)object, null, (d.c.a.s.a)object2, (Executor)object4);
    }

    public h o1(f f10) {
        this.p0 = null;
        return this.W0(f10);
    }

    public h p1(Bitmap object) {
        object = this.y1(object);
        g g10 = g.b1(d.c.a.o.k.h.b);
        return ((h)object).X0(g10);
    }

    public h q1(Drawable object) {
        object = this.y1(object);
        g g10 = g.b1(d.c.a.o.k.h.b);
        return ((h)object).X0(g10);
    }

    public h r1(Uri uri) {
        return this.y1(uri);
    }

    public h s1(File file) {
        return this.y1(file);
    }

    public h t1(Integer object) {
        object = this.y1(object);
        g g10 = g.s1(a.c(this.V));
        return ((h)object).X0(g10);
    }

    public h u1(Object object) {
        return this.y1(object);
    }

    public h v1(String string2) {
        return this.y1(string2);
    }

    public h w1(URL uRL) {
        return this.y1(uRL);
    }

    public h x1(byte[] object) {
        g g10;
        boolean bl2 = ((d.c.a.s.a)(object = (Object)this.y1(object))).c0();
        if (!bl2) {
            g10 = g.b1(d.c.a.o.k.h.b);
            object = ((h)object).X0(g10);
        }
        if (!(bl2 = ((d.c.a.s.a)object).j0())) {
            bl2 = true;
            g10 = g.u1(bl2);
            object = ((h)object).X0(g10);
        }
        return object;
    }
}

