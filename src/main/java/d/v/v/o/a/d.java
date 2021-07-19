/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

import d.v.v.o.a.c$a;
import java.util.List;

public class d {
    private int a;
    private long b;
    private long c;
    private long d;
    private long e;
    private List f;
    private List g;

    public d(int n10, long l10, long l11, long l12, long l13, List list) {
        this.a = n10;
        this.b = l10;
        this.c = l11;
        this.d = l12;
        this.e = l13;
        this.g = list;
    }

    public void a(c$a c$a) {
        List list = this.g;
        boolean bl2 = list.contains(c$a);
        if (!bl2) {
            list = this.g;
            list.add(c$a);
        }
    }

    public long b() {
        return this.d;
    }

    public long c() {
        return this.c;
    }

    public List d() {
        return this.g;
    }

    public long e() {
        return this.e;
    }

    public long f() {
        return this.b;
    }

    public List g() {
        return this.f;
    }

    public int h() {
        return this.a;
    }

    public d i(long l10) {
        this.d = l10;
        return this;
    }

    public d j(long l10) {
        this.c = l10;
        return this;
    }

    public d k(long l10) {
        this.e = l10;
        return this;
    }

    public d l(long l10) {
        this.b = l10;
        return this;
    }

    public d m(List list) {
        this.f = list;
        return this;
    }

    public d n(int n10) {
        this.a = n10;
        return this;
    }
}

