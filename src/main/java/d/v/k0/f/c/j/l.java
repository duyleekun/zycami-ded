/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c.j;

import d.v.k0.f.c.j.a;
import d.v.k0.f.c.j.b;
import d.v.k0.f.c.j.c;
import d.v.k0.f.c.j.d;
import d.v.k0.f.c.j.e;
import d.v.k0.f.c.j.f;
import d.v.k0.f.c.j.g;
import d.v.k0.f.c.j.h;
import d.v.k0.f.c.j.i;
import d.v.k0.f.c.j.j;
import d.v.k0.f.c.j.k;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class l {
    private final CopyOnWriteArrayList a;
    private final List b;

    public l() {
        List list;
        this.a = list = new List();
        this.b = list;
    }

    public static /* synthetic */ void e(String string2, Throwable throwable, int n10, k k10) {
        d.v.k0.g.d.h(string2, throwable, n10, k10);
    }

    public static /* synthetic */ void f(String string2, Throwable throwable, int n10, k k10) {
        d.v.k0.g.d.h(string2, throwable, n10, k10);
    }

    public static /* synthetic */ boolean g(d.v.k0.f.d.a a10, k k10) {
        return k10.j(a10);
    }

    public static /* synthetic */ void h(d.v.k0.f.d.a a10, k k10) {
        k10.j(a10);
    }

    public static /* synthetic */ boolean i(d.v.k0.f.d.a a10, k k10) {
        return k10.k(a10);
    }

    public static /* synthetic */ void j(d.v.k0.f.d.a a10, k k10) {
        k10.k(a10);
    }

    public void a(k k10) {
        if (k10 == null) {
            return;
        }
        this.b.add(k10);
    }

    public void b(k k10) {
        if (k10 == null) {
            return;
        }
        this.a.add(k10);
    }

    public void c() {
        this.a.clear();
    }

    public void d() {
        this.b.clear();
    }

    public void k() {
        Stream stream = this.a.stream();
        a a10 = d.v.k0.f.c.j.a.a;
        stream.forEach(a10);
        this.b.stream().forEach(a10);
    }

    public void l(String string2, Throwable throwable, int n10) {
        Stream stream = this.a.stream();
        Consumer consumer = new h(string2, throwable, n10);
        stream.forEach(consumer);
        stream = this.b.stream();
        consumer = new f(string2, throwable, n10);
        stream.forEach(consumer);
    }

    public void m(d.v.k0.f.d.a a10) {
        Object object;
        Stream stream = this.a.stream();
        boolean bl2 = stream.anyMatch(object = new d(a10));
        if (bl2) {
            return;
        }
        stream = this.b.stream();
        object = new e(a10);
        stream.forEach(object);
    }

    public void n() {
        Stream stream = this.a.stream();
        c c10 = c.a;
        stream.forEach(c10);
        this.b.stream().forEach(c10);
    }

    public void o(d.v.k0.f.d.a a10) {
        Object object;
        Stream stream = this.a.stream();
        boolean bl2 = stream.anyMatch(object = new i(a10));
        if (bl2) {
            return;
        }
        stream = this.b.stream();
        object = new g(a10);
        stream.forEach(object);
    }

    public void p() {
        Stream stream = this.a.stream();
        j j10 = j.a;
        stream.forEach(j10);
        this.b.stream().forEach(j10);
    }

    public void q() {
        Stream stream = this.a.stream();
        b b10 = d.v.k0.f.c.j.b.a;
        stream.forEach(b10);
        this.b.stream().forEach(b10);
    }

    public void r(k k10) {
        if (k10 == null) {
            return;
        }
        this.b.remove(k10);
    }

    public void s(k k10) {
        if (k10 == null) {
            return;
        }
        this.a.remove(k10);
    }
}

