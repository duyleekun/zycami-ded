/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.d;
import g.h0.l.a;
import g.h0.l.b;
import g.h0.l.i;
import h.m;
import h.m0;
import h.n;
import h.o;
import h.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okio.ByteString;

public final class b$a {
    private final List a;
    private final o b;
    public a[] c;
    private int d;
    public int e;
    public int f;
    private final int g;
    private int h;

    public b$a(m0 m02, int n10) {
        this(m02, n10, 0, 4, null);
    }

    public b$a(m0 aArray, int n10, int n11) {
        int n12;
        ArrayList arrayList;
        f0.p(aArray, "source");
        this.g = n10;
        this.h = n11;
        this.a = arrayList = new ArrayList();
        aArray = z.d((m0)aArray);
        this.b = aArray;
        aArray = new a[8];
        this.c = aArray;
        this.d = n12 = aArray.length + -1;
    }

    public /* synthetic */ b$a(m0 m02, int n10, int n11, int n12, u u10) {
        if ((n12 &= 4) != 0) {
            n11 = n10;
        }
        this(m02, n10, n11);
    }

    private final void a() {
        int n10 = this.h;
        int n11 = this.f;
        if (n10 < n11) {
            if (n10 == 0) {
                this.b();
            } else {
                this.d(n11 -= n10);
            }
        }
    }

    private final void b() {
        int n10;
        f.x1.n.w2(this.c, null, 0, 0, 6, null);
        this.d = n10 = this.c.length + -1;
        this.e = 0;
        this.f = 0;
    }

    private final int c(int n10) {
        return this.d + 1 + n10;
    }

    private final int d(int n10) {
        int n11 = 0;
        if (n10 > 0) {
            int n12;
            int n13;
            int n14;
            a[] aArray = this.c;
            for (n14 = aArray.length + -1; n14 >= (n13 = this.d) && n10 > 0; n14 += -1) {
                a a10 = this.c[n14];
                f0.m(a10);
                n13 = a10.a;
                n10 -= n13;
                this.f = n12 = this.f - n13;
                this.e = n13 = this.e + -1;
                ++n11;
            }
            a[] aArray2 = this.c;
            n14 = n13 + 1;
            n13 = n13 + 1 + n11;
            n12 = this.e;
            System.arraycopy(aArray2, n14, aArray2, n13, n12);
            this.d = n10 = this.d + n11;
        }
        return n11;
    }

    private final ByteString f(int n10) {
        Object object;
        Object object2;
        block4: {
            Object object3;
            block3: {
                int n11;
                int n12;
                block2: {
                    n12 = this.h(n10);
                    if (n12 == 0) break block2;
                    a[] aArray = g.h0.l.b.i.c();
                    object3 = aArray[n10].b;
                    break block3;
                }
                object2 = g.h0.l.b.i.c();
                n12 = ((a[])object2).length;
                n12 = n10 - n12;
                if ((n12 = this.c(n12)) < 0 || n12 >= (n11 = ((a[])(object = this.c)).length)) break block4;
                object3 = object[n12];
                f0.m(object3);
                object3 = ((a)object3).b;
            }
            return object3;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Header index too large ");
        ((StringBuilder)object).append(++n10);
        String string2 = ((StringBuilder)object).toString();
        object2 = new IOException(string2);
        throw object2;
    }

    private final void g(int n10, a a10) {
        int n11;
        int n12;
        Object object;
        List list = this.a;
        list.add(a10);
        int n13 = a10.a;
        int n14 = -1;
        if (n10 != n14) {
            object = this.c;
            n12 = this.c(n10);
            object = object[n12];
            f0.m(object);
            n11 = object.a;
            n13 -= n11;
        }
        if (n13 > (n11 = this.h)) {
            this.b();
            return;
        }
        n12 = this.f + n13 - n11;
        n11 = this.d(n12);
        if (n10 == n14) {
            n10 = this.e + 1;
            a[] aArray = this.c;
            n11 = aArray.length;
            if (n10 > n11) {
                n10 = aArray.length * 2;
                a[] aArray2 = new a[n10];
                n11 = 0;
                object = null;
                n12 = aArray.length;
                int n15 = aArray.length;
                System.arraycopy(aArray, 0, aArray2, n12, n15);
                aArray = this.c;
                this.d = n14 = aArray.length + -1;
                this.c = aArray2;
            }
            n10 = this.d;
            this.d = n14 = n10 + -1;
            aArray = this.c;
            aArray[n10] = a10;
            this.e = n10 = this.e + 1;
        } else {
            n14 = this.c(n10) + n11;
            a[] aArray = this.c;
            aArray[n10 += n14] = a10;
        }
        this.f = n10 = this.f + n13;
    }

    private final boolean h(int n10) {
        a[] aArray;
        int n11;
        int n12 = 1;
        if (n10 < 0 || n10 > (n11 = (aArray = g.h0.l.b.i.c()).length - n12)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private final int j() {
        return g.h0.d.b(this.b.readByte(), 255);
    }

    private final void m(int n10) {
        Object object;
        Object object2;
        block4: {
            block3: {
                int n11;
                int n12;
                block2: {
                    n12 = this.h(n10);
                    if (n12 == 0) break block2;
                    a a10 = g.h0.l.b.i.c()[n10];
                    List list = this.a;
                    list.add(a10);
                    break block3;
                }
                object2 = g.h0.l.b.i.c();
                n12 = ((a[])object2).length;
                n12 = n10 - n12;
                if ((n12 = this.c(n12)) < 0 || n12 >= (n11 = ((a[])(object = this.c)).length)) break block4;
                List list = this.a;
                object2 = object[n12];
                f0.m(object2);
                list.add(object2);
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Header index too large ");
        ((StringBuilder)object).append(++n10);
        String string2 = ((StringBuilder)object).toString();
        object2 = new IOException(string2);
        throw object2;
    }

    private final void o(int n10) {
        ByteString byteString = this.f(n10);
        ByteString byteString2 = this.k();
        a a10 = new a(byteString, byteString2);
        this.g(-1, a10);
    }

    private final void p() {
        Object object = g.h0.l.b.i;
        ByteString byteString = this.k();
        object = ((b)object).a(byteString);
        byteString = this.k();
        a a10 = new a((ByteString)object, byteString);
        this.g(-1, a10);
    }

    private final void q(int n10) {
        ByteString byteString = this.f(n10);
        ByteString byteString2 = this.k();
        List list = this.a;
        a a10 = new a(byteString, byteString2);
        list.add(a10);
    }

    private final void r() {
        Object object = g.h0.l.b.i;
        ByteString byteString = this.k();
        object = ((b)object).a(byteString);
        byteString = this.k();
        List list = this.a;
        a a10 = new a((ByteString)object, byteString);
        list.add(a10);
    }

    public final List e() {
        List list = CollectionsKt___CollectionsKt.I5(this.a);
        this.a.clear();
        return list;
    }

    public final int i() {
        return this.h;
    }

    public final ByteString k() {
        Object object;
        i i10;
        int n10;
        int n11 = this.j();
        int n12 = n11 & 0x80;
        if (n12 == (n10 = 128)) {
            n12 = 1;
        } else {
            n12 = 0;
            i10 = null;
        }
        n10 = 127;
        n11 = this.n(n11, n10);
        long l10 = n11;
        if (n12 != 0) {
            object = new m();
            i10 = i.d;
            o o10 = this.b;
            i10.b(o10, l10, (n)object);
            object = ((m)object).b0();
        } else {
            object = this.b.Q(l10);
        }
        return object;
    }

    public final void l() {
        Object object;
        int n10;
        while ((n10 = (object = this.b).V()) == 0) {
            int n11;
            object = this.b;
            n10 = g.h0.d.b(object.readByte(), 255);
            if (n10 != (n11 = 128)) {
                int n12 = n10 & 0x80;
                if (n12 == n11) {
                    n11 = 127;
                    n10 = this.n(n10, n11) + -1;
                    this.m(n10);
                    continue;
                }
                n11 = 64;
                if (n10 == n11) {
                    this.p();
                    continue;
                }
                n12 = n10 & 0x40;
                if (n12 == n11) {
                    n11 = 63;
                    n10 = this.n(n10, n11) + -1;
                    this.o(n10);
                    continue;
                }
                n11 = n10 & 0x20;
                n12 = 32;
                if (n11 == n12) {
                    n11 = 31;
                    this.h = n10 = this.n(n10, n11);
                    if (n10 >= 0 && n10 <= (n11 = this.g)) {
                        this.a();
                        continue;
                    }
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Invalid dynamic table size update ");
                    n12 = this.h;
                    charSequence.append(n12);
                    charSequence = charSequence.toString();
                    object = new IOException((String)charSequence);
                    throw object;
                }
                n11 = 16;
                if (n10 != n11 && n10 != 0) {
                    n11 = 15;
                    n10 = this.n(n10, n11) + -1;
                    this.q(n10);
                    continue;
                }
                this.r();
                continue;
            }
            object = new IOException("index == 0");
            throw object;
        }
    }

    public final int n(int n10, int n11) {
        int n12;
        int n13;
        if ((n10 &= n11) < n11) {
            return n10;
        }
        n10 = 0;
        while ((n13 = (n12 = this.j()) & 0x80) != 0) {
            n12 = (n12 & 0x7F) << n10;
            n11 += n12;
            n10 += 7;
        }
        n10 = n12 << n10;
        return n11 + n10;
    }
}

