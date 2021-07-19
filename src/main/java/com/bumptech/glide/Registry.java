/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry$NoImageHeaderParserException;
import com.bumptech.glide.Registry$NoResultEncoderAvailableException;
import com.bumptech.glide.Registry$NoSourceEncoderAvailableException;
import com.bumptech.glide.load.ImageHeaderParser;
import d.c.a.o.h;
import d.c.a.o.j.e$a;
import d.c.a.o.k.g;
import d.c.a.o.k.q;
import d.c.a.o.k.s;
import d.c.a.o.l.o;
import d.c.a.o.l.p;
import d.c.a.r.a;
import d.c.a.r.b;
import d.c.a.r.c;
import d.c.a.r.d;
import d.c.a.r.e;
import d.c.a.r.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Registry {
    public static final String k = "Gif";
    public static final String l = "Bitmap";
    public static final String m = "BitmapDrawable";
    private static final String n = "legacy_prepend_all";
    private static final String o = "legacy_append";
    private final p a;
    private final a b;
    private final e c;
    private final f d;
    private final d.c.a.o.j.f e;
    private final d.c.a.o.m.i.f f;
    private final b g;
    private final d h;
    private final c i;
    private final Pools$Pool j;

    public Registry() {
        p p10;
        List<String> list = new List<String>();
        this.h = list;
        list = new List<String>();
        this.i = list;
        list = d.c.a.u.o.a.f();
        this.j = list;
        this.a = p10 = new p((Pools$Pool)((Object)list));
        list = new List<String>();
        this.b = list;
        list = new List<String>();
        this.c = list;
        list = new List<String>();
        this.d = list;
        list = new List<String>();
        this.e = list;
        list = new List<String>();
        this.f = list;
        list = new List<String>();
        this.g = list;
        list = Arrays.asList(k, l, m);
        this.z(list);
    }

    private List f(Class clazz, Class object, Class clazz2) {
        boolean bl2;
        ArrayList<g> arrayList = new ArrayList<g>();
        Object object2 = this.c;
        object = ((e)object2).d(clazz, (Class)object).iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            object2 = (Class)object.next();
            Object object3 = this.f.b((Class)object2, clazz2);
            Iterator iterator2 = object3.iterator();
            while (bl3 = iterator2.hasNext()) {
                g g10;
                Object object4 = object3 = iterator2.next();
                object4 = (Class)object3;
                List list = this.c.b(clazz, (Class)object2);
                d.c.a.o.m.i.e e10 = this.f.a((Class)object2, (Class)object4);
                Pools$Pool pools$Pool = this.j;
                object3 = g10;
                g10 = new g(clazz, (Class)object2, (Class)object4, list, e10, pools$Pool);
                arrayList.add(g10);
            }
        }
        return arrayList;
    }

    public Registry a(Class clazz, d.c.a.o.a a10) {
        this.b.a(clazz, a10);
        return this;
    }

    public Registry b(Class clazz, h h10) {
        this.d.a(clazz, h10);
        return this;
    }

    public Registry c(Class clazz, Class clazz2, d.c.a.o.g g10) {
        this.e(o, clazz, clazz2, g10);
        return this;
    }

    public Registry d(Class clazz, Class clazz2, o o10) {
        this.a.a(clazz, clazz2, o10);
        return this;
    }

    public Registry e(String string2, Class clazz, Class clazz2, d.c.a.o.g g10) {
        this.c.a(string2, g10, clazz, clazz2);
        return this;
    }

    public List g() {
        Object object = this.g.b();
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            return object;
        }
        object = new Registry$NoImageHeaderParserException();
        throw object;
    }

    public q h(Class clazz, Class clazz2, Class clazz3) {
        c c10 = this.i;
        q q10 = this.i.a(clazz, clazz2, clazz3);
        boolean bl2 = c10.c(q10);
        if (bl2) {
            return null;
        }
        if (q10 == null) {
            List list = this.f(clazz, clazz2, clazz3);
            boolean bl3 = list.isEmpty();
            if (bl3) {
                bl3 = false;
                q10 = null;
            } else {
                Pools$Pool pools$Pool = this.j;
                q10 = new q(clazz, clazz2, clazz3, list, pools$Pool);
            }
            c10 = this.i;
            c10.d(clazz, clazz2, clazz3, q10);
        }
        return q10;
    }

    public List i(Object object) {
        return this.a.e(object);
    }

    public List j(Class clazz, Class clazz2, Class clazz3) {
        ArrayList<Object> arrayList = this.h.b(clazz, clazz2, clazz3);
        if (arrayList == null) {
            Iterator iterator2;
            boolean bl2;
            arrayList = new ArrayList<Object>();
            Object object = this.a.d(clazz).iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                iterator2 = (Class)object.next();
                Object object2 = this.c;
                iterator2 = ((e)object2).d((Class)((Object)iterator2), clazz2).iterator();
                while (bl3 = iterator2.hasNext()) {
                    object2 = (Class)iterator2.next();
                    List list = this.f.b((Class)object2, clazz3);
                    boolean bl4 = list.isEmpty();
                    if (bl4 || (bl4 = arrayList.contains(object2))) continue;
                    arrayList.add(object2);
                }
            }
            object = this.h;
            iterator2 = Collections.unmodifiableList(arrayList);
            ((d)object).c(clazz, clazz2, clazz3, (List)((Object)iterator2));
        }
        return arrayList;
    }

    public h k(s object) {
        Object object2 = this.d;
        Class clazz = object.b();
        if ((object2 = ((f)object2).b(clazz)) != null) {
            return object2;
        }
        object = object.b();
        object2 = new Registry$NoResultEncoderAvailableException((Class)object);
        throw object2;
    }

    public d.c.a.o.j.e l(Object object) {
        return this.e.a(object);
    }

    public d.c.a.o.a m(Object clazz) {
        Object object = this.b;
        Class<?> clazz2 = clazz.getClass();
        if ((object = ((a)object).b(clazz2)) != null) {
            return object;
        }
        clazz = clazz.getClass();
        object = new Registry$NoSourceEncoderAvailableException(clazz);
        throw object;
    }

    public boolean n(s object) {
        boolean bl2;
        f f10 = this.d;
        object = object.b();
        if ((object = f10.b((Class)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Registry o(Class clazz, d.c.a.o.a a10) {
        this.b.c(clazz, a10);
        return this;
    }

    public Registry p(Class clazz, h h10) {
        this.d.c(clazz, h10);
        return this;
    }

    public Registry q(Class clazz, Class clazz2, d.c.a.o.g g10) {
        this.s(n, clazz, clazz2, g10);
        return this;
    }

    public Registry r(Class clazz, Class clazz2, o o10) {
        this.a.g(clazz, clazz2, o10);
        return this;
    }

    public Registry s(String string2, Class clazz, Class clazz2, d.c.a.o.g g10) {
        this.c.e(string2, g10, clazz, clazz2);
        return this;
    }

    public Registry t(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry u(e.a a10) {
        this.e.b(a10);
        return this;
    }

    public Registry v(Class clazz, d.c.a.o.a a10) {
        return this.a(clazz, a10);
    }

    public Registry w(Class clazz, h h10) {
        return this.b(clazz, h10);
    }

    public Registry x(Class clazz, Class clazz2, d.c.a.o.m.i.e e10) {
        this.f.c(clazz, clazz2, e10);
        return this;
    }

    public Registry y(Class clazz, Class clazz2, o o10) {
        this.a.i(clazz, clazz2, o10);
        return this;
    }

    public final Registry z(List list) {
        int n10 = list.size();
        ArrayList<String> arrayList = new ArrayList<String>(n10);
        arrayList.addAll(list);
        arrayList.add(0, n);
        arrayList.add(o);
        this.c.f(arrayList);
        return this;
    }
}

