/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.e.a.a.a.a;
import j$.time.LocalDate;
import j$.time.format.B;
import j$.time.format.b_0;
import j$.time.format.j;
import j$.time.format.v;
import j$.time.p.b;
import j$.time.q.s;
import j$.time.q.u;

final class m
extends j {
    static final LocalDate i;
    private final int g;
    private final b h;

    static {
        int n10 = 1;
        i = LocalDate.D(2000, n10, n10);
    }

    m(u object, int n10, int n11, int n12, b b10) {
        this((u)object, n10, n11, n12, b10, 0);
        int n13 = 1;
        if (n10 >= n13 && n10 <= (n12 = 10)) {
            if (n11 >= n13 && n11 <= n12) {
                if (n11 >= n10) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Maximum width must exceed or equal the minimum width but ");
                stringBuilder.append(n11);
                stringBuilder.append(" < ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The maxWidth must be from 1 to 10 inclusive but was ");
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            object = new IllegalArgumentException(string3);
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The minWidth must be from 1 to 10 inclusive but was ");
        stringBuilder.append(n10);
        String string4 = stringBuilder.toString();
        object = new IllegalArgumentException(string4);
        throw object;
    }

    private m(u u10, int n10, int n11, int n12, b b10, int n13) {
        B b11 = B.c;
        super(u10, n10, n11, b11, n13);
        this.g = n12;
        this.h = b10;
    }

    /* synthetic */ m(u u10, int n10, int n11, int n12, b b10, int n13, b_0 b_02) {
        this(u10, n10, n11, n12, b10, n13);
    }

    long b(v object, long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long[] lArray = j.f;
        long l18 = Math.abs(l10);
        int n10 = this.g;
        b b10 = this.h;
        if (b10 != null) {
            object = j$.time.p.j.A(((v)object).d());
            Object object2 = this.h;
            object = object.r((s)object2);
            object2 = this.a;
            n10 = object.k((u)object2);
        }
        if ((l17 = (l16 = l10 - (l15 = (long)n10)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0 && (l14 = (l13 = l10 - (l15 += (l12 = lArray[l17 = (long)this.b]))) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
            l11 = lArray[l17];
        } else {
            l17 = this.c;
            l11 = lArray[l17];
        }
        return l18 % l11;
    }

    j c() {
        m m10;
        int n10 = this.e;
        int n11 = -1;
        if (n10 == n11) {
            m10 = this;
        } else {
            u u10 = this.a;
            int n12 = this.b;
            int n13 = this.c;
            int n14 = this.g;
            b b10 = this.h;
            int n15 = -1;
            m10 = new m(u10, n12, n13, n14, b10, n15);
        }
        return m10;
    }

    j d(int n10) {
        u u10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        int n13 = this.g;
        b b10 = this.h;
        int n14 = this.e + n10;
        m m10 = new m(u10, n11, n12, n13, b10, n14);
        return m10;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("ReducedValue(");
        Object object = this.a;
        stringBuilder.append(object);
        object = ",";
        stringBuilder.append((String)object);
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append((String)object);
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append((String)object);
        object = this.h;
        if (object == null) {
            int n11 = this.g;
            object = n11;
        }
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

