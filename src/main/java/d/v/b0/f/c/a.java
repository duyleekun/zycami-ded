/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.opengl.EGLContext
 *  android.view.Surface
 */
package d.v.b0.f.c;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.view.Surface;
import d.v.b0.f.b;
import d.v.b0.f.c.b.c;
import d.v.b0.f.c.b.f;
import d.v.b0.f.c.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
extends d.v.b0.f.a
implements b {
    private Map a;
    private Map b;
    private List c;
    private d.v.b0.f.c.b.b d;

    public a() {
        Object object = new HashMap();
        this.a = object;
        object = new HashMap();
        this.b = object;
        this.c = object;
        this.d = object = new d.v.b0.f.c.b.b();
    }

    public a(EGLContext eGLContext) {
        Object object = new HashMap();
        this.a = object;
        object = new HashMap();
        this.b = object;
        this.c = object;
        this.d = object = new d.v.b0.f.c.b.b(eGLContext, 0);
    }

    public void a(d.v.b0.b.c c10) {
        boolean bl2 = c10.i();
        if (bl2) {
            Object object = this.a;
            String string2 = c10.b();
            if ((object = (h)object.remove(string2)) != null) {
                ((h)object).l();
            }
        } else {
            Object object = this.b;
            String string3 = c10.b();
            if ((object = (f)object.remove(string3)) != null) {
                ((f)object).k();
            }
        }
        this.c.remove(c10);
    }

    public List b() {
        return this.c;
    }

    public void c(d.v.b0.b.c object) {
        boolean bl2 = ((d.v.b0.b.c)object).i();
        if (bl2) {
            Map map = this.a;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (h)map.get(object)) != null) {
                ((c)object).e();
            }
        } else {
            Map map = this.b;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (f)map.get(object)) != null) {
                ((c)object).e();
            }
        }
    }

    public void d(d.v.b0.b.c object, long l10) {
        boolean bl2 = ((d.v.b0.b.c)object).i();
        if (bl2) {
            Map map = this.a;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (h)map.get(object)) != null) {
                ((c)object).i(l10);
            }
        } else {
            Map map = this.b;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (f)map.get(object)) != null) {
                ((c)object).i(l10);
            }
        }
    }

    public void e(d.v.b0.b.c c10) {
        Object object = this.d;
        if (object == null) {
            d.v.b0.j.b.b("GlEngineRuntimeEnvironment addOutputSurfaces, eglCore can not be null.");
            return;
        }
        boolean bl2 = c10.i();
        if (bl2) {
            Object object2;
            Object object3;
            object = c10.f();
            bl2 = object instanceof SurfaceTexture;
            if (bl2) {
                object3 = this.d;
                object2 = (SurfaceTexture)c10.f();
                object = new h((d.v.b0.f.c.b.b)object3, (SurfaceTexture)object2);
            } else {
                object3 = this.d;
                object2 = (Surface)c10.f();
                boolean bl3 = c10.c();
                object = new h((d.v.b0.f.c.b.b)object3, (Surface)object2, bl3);
            }
            object3 = this.a;
            object2 = c10.b();
            object3.put(object2, object);
        } else {
            Object object4 = this.d;
            int n10 = c10.g();
            int n11 = c10.a();
            object = new f((d.v.b0.f.c.b.b)object4, n10, n11);
            object4 = this.b;
            String string2 = c10.b();
            object4.put(string2, object);
        }
        this.c.add(c10);
    }

    public void f(d.v.b0.b.c object) {
        boolean bl2 = ((d.v.b0.b.c)object).i();
        if (bl2) {
            Map map = this.a;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (h)map.get(object)) != null) {
                ((c)object).j();
            }
        } else {
            Map map = this.b;
            object = ((d.v.b0.b.c)object).b();
            if ((object = (f)map.get(object)) != null) {
                ((c)object).j();
            }
        }
    }

    public void release() {
        boolean bl2;
        Object object = this.c;
        Object object2 = new ArrayList(object);
        object2 = ((ArrayList)object2).iterator();
        while (bl2 = object2.hasNext()) {
            object = (d.v.b0.b.c)object2.next();
            this.a((d.v.b0.b.c)object);
        }
        object2 = this.d;
        if (object2 != null) {
            ((d.v.b0.f.c.b.b)object2).m();
            object2 = null;
            this.d = null;
        }
    }
}

