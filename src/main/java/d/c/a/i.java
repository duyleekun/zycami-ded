/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentCallbacks2
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.View
 */
package d.c.a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.Priority;
import d.c.a.i$a;
import d.c.a.i$b;
import d.c.a.j;
import d.c.a.o.k.h;
import d.c.a.p.c;
import d.c.a.p.c$a;
import d.c.a.p.l;
import d.c.a.p.m;
import d.c.a.p.o;
import d.c.a.s.a;
import d.c.a.s.d;
import d.c.a.s.f;
import d.c.a.s.g;
import d.c.a.s.j.p;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class i
implements ComponentCallbacks2,
d.c.a.p.i,
d.c.a.g {
    private static final g m = (g)d.c.a.s.g.a1(Bitmap.class).o0();
    private static final g n = (g)d.c.a.s.g.a1(d.c.a.o.m.h.c.class).o0();
    private static final g o;
    public final d.c.a.c a;
    public final Context b;
    public final d.c.a.p.h c;
    private final m d;
    private final l e;
    private final o f;
    private final Runnable g;
    private final Handler h;
    private final c i;
    private final CopyOnWriteArrayList j;
    private g k;
    private boolean l;

    static {
        g g10 = d.c.a.s.g.b1(d.c.a.o.k.h.c);
        Priority priority = Priority.LOW;
        o = (g)((g)g10.C0(priority)).K0(true);
    }

    public i(d.c.a.c c10, d.c.a.p.h h10, l l10, Context context) {
        m m10 = new m();
        d.c.a.p.d d10 = c10.h();
        this(c10, h10, l10, m10, d10, context);
    }

    public i(d.c.a.c c10, d.c.a.p.h cloneable, l object, m m10, d.c.a.p.d d10, Context object2) {
        Handler handler;
        Object object3 = new o();
        this.f = object3;
        this.g = object3 = new i$a(this);
        Looper looper = Looper.getMainLooper();
        this.h = handler = new Handler(looper);
        this.a = c10;
        this.c = cloneable;
        this.e = object;
        this.d = m10;
        this.b = object2;
        object = object2.getApplicationContext();
        super(this, m10);
        this.i = object = d10.a((Context)object, (c$a)object2);
        boolean bl2 = d.c.a.u.m.s();
        if (bl2) {
            handler.post((Runnable)object3);
        } else {
            cloneable.b(this);
        }
        cloneable.b((d.c.a.p.i)object);
        object = c10.j().c();
        this.j = cloneable = new Cloneable(object);
        cloneable = c10.j().d();
        this.X((g)cloneable);
        c10.u(this);
    }

    private void a0(p p10) {
        d.c.a.c c10;
        boolean bl2 = this.Z(p10);
        d d10 = p10.h();
        if (!bl2 && !(bl2 = (c10 = this.a).v(p10)) && d10 != null) {
            bl2 = false;
            c10 = null;
            p10.l(null);
            d10.clear();
        }
    }

    private void b0(g a10) {
        synchronized (this) {
            g g10 = this.k;
            a a11 = g10.a(a10);
            g g11 = (g)a11;
            this.k = g11;
            return;
        }
    }

    public d.c.a.h A(Object object) {
        return this.B().u1(object);
    }

    public d.c.a.h B() {
        d.c.a.h h10 = this.t(File.class);
        g g10 = o;
        return h10.X0(g10);
    }

    public List C() {
        return this.j;
    }

    public g D() {
        synchronized (this) {
            g g10 = this.k;
            return g10;
        }
    }

    public j E(Class clazz) {
        return this.a.j().e(clazz);
    }

    public boolean F() {
        synchronized (this) {
            m m10 = this.d;
            boolean bl2 = m10.d();
            return bl2;
        }
    }

    public d.c.a.h G(Bitmap bitmap) {
        return this.v().p1(bitmap);
    }

    public d.c.a.h H(Drawable drawable2) {
        return this.v().q1(drawable2);
    }

    public d.c.a.h I(Uri uri) {
        return this.v().r1(uri);
    }

    public d.c.a.h J(File file) {
        return this.v().s1(file);
    }

    public d.c.a.h K(Integer n10) {
        return this.v().t1(n10);
    }

    public d.c.a.h L(Object object) {
        return this.v().u1(object);
    }

    public d.c.a.h M(String string2) {
        return this.v().v1(string2);
    }

    public d.c.a.h N(URL uRL) {
        return this.v().w1(uRL);
    }

    public d.c.a.h O(byte[] byArray) {
        return this.v().x1(byArray);
    }

    public void P() {
        synchronized (this) {
            m m10 = this.d;
            m10.e();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void Q() {
        synchronized (this) {
            this.P();
            Iterator iterator2 = this.e;
            iterator2 = iterator2.a();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (i)object;
                ((i)object).P();
            }
            return;
        }
    }

    public void R() {
        synchronized (this) {
            m m10 = this.d;
            m10.f();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void S() {
        synchronized (this) {
            this.R();
            Iterator iterator2 = this.e;
            iterator2 = iterator2.a();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (i)object;
                ((i)object).R();
            }
            return;
        }
    }

    public void T() {
        synchronized (this) {
            m m10 = this.d;
            m10.h();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void U() {
        synchronized (this) {
            d.c.a.u.m.b();
            this.T();
            Iterator iterator2 = this.e;
            iterator2 = iterator2.a();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (i)object;
                ((i)object).T();
            }
            return;
        }
    }

    public i V(g g10) {
        synchronized (this) {
            this.X(g10);
            return this;
        }
    }

    public void W(boolean bl2) {
        this.l = bl2;
    }

    public void X(g a10) {
        synchronized (this) {
            a10 = a10.m();
            a10 = (g)a10;
            a10 = a10.g();
            a10 = (g)a10;
            this.k = a10;
            return;
        }
    }

    public void Y(p object, d d10) {
        synchronized (this) {
            o o10 = this.f;
            o10.d((p)object);
            object = this.d;
            ((m)object).i(d10);
            return;
        }
    }

    public boolean Z(p p10) {
        synchronized (this) {
            block9: {
                boolean bl2;
                Object object;
                block8: {
                    object = p10.h();
                    bl2 = true;
                    if (object != null) break block8;
                    return bl2;
                }
                m m10 = this.d;
                boolean bl3 = m10.b((d)object);
                if (!bl3) break block9;
                object = this.f;
                ((o)object).e(p10);
                bl3 = false;
                object = null;
                p10.l(null);
                return bl2;
            }
            return false;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy() {
        synchronized (this) {
            Object object = this.f;
            ((o)object).onDestroy();
            object = this.f;
            object = ((o)object).c();
            object = object.iterator();
            while (true) {
                Object object2;
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.f;
                    ((o)object).b();
                    object = this.d;
                    ((m)object).c();
                    object = this.c;
                    object.a(this);
                    object = this.c;
                    object2 = this.i;
                    object.a((d.c.a.p.i)object2);
                    object = this.h;
                    object2 = this.g;
                    object.removeCallbacks(object2);
                    object = this.a;
                    ((d.c.a.c)object).A(this);
                    return;
                }
                object2 = object.next();
                object2 = (p)object2;
                this.z((p)object2);
            }
        }
    }

    public void onLowMemory() {
    }

    public void onStart() {
        synchronized (this) {
            this.T();
            o o10 = this.f;
            o10.onStart();
            return;
        }
    }

    public void onStop() {
        synchronized (this) {
            this.R();
            o o10 = this.f;
            o10.onStop();
            return;
        }
    }

    public void onTrimMemory(int n10) {
        int n11 = 60;
        if (n10 == n11 && (n10 = (int)(this.l ? 1 : 0)) != 0) {
            this.Q();
        }
    }

    public i r(f f10) {
        this.j.add(f10);
        return this;
    }

    public i s(g g10) {
        synchronized (this) {
            this.b0(g10);
            return this;
        }
    }

    public d.c.a.h t(Class clazz) {
        d.c.a.c c10 = this.a;
        Context context = this.b;
        d.c.a.h h10 = new d.c.a.h(c10, this, clazz, context);
        return h10;
    }

    public String toString() {
        synchronized (this) {
            CharSequence charSequence = new StringBuilder();
            Object object = super.toString();
            charSequence.append((String)object);
            object = "{tracker=";
            charSequence.append((String)object);
            object = this.d;
            charSequence.append(object);
            object = ", treeNode=";
            charSequence.append((String)object);
            object = this.e;
            charSequence.append(object);
            object = "}";
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            return charSequence;
        }
    }

    public d.c.a.h u() {
        d.c.a.h h10 = this.t(Bitmap.class);
        g g10 = m;
        return h10.X0(g10);
    }

    public d.c.a.h v() {
        return this.t(Drawable.class);
    }

    public d.c.a.h w() {
        d.c.a.h h10 = this.t(File.class);
        g g10 = d.c.a.s.g.u1(true);
        return h10.X0(g10);
    }

    public d.c.a.h x() {
        d.c.a.h h10 = this.t(d.c.a.o.m.h.c.class);
        g g10 = n;
        return h10.X0(g10);
    }

    public void y(View view) {
        i$b i$b = new i$b(view);
        this.z(i$b);
    }

    public void z(p p10) {
        if (p10 == null) {
            return;
        }
        this.a0(p10);
    }
}

