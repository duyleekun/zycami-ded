/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.f;

import java.util.Locale;

public class a {
    public int a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public long g;
    public int h;
    public char i;
    public int j;
    public int k;
    public String l;
    public String m;
    private boolean n;

    public a() {
        long l10;
        int n10;
        int n11;
        this.a = n11 = -1;
        this.b = -1;
        this.c = n11;
        this.d = n11;
        this.e = n10 = -1 >>> 1;
        this.f = n10;
        this.g = 0L;
        this.h = n11;
        this.i = (char)48;
        this.j = n10;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = false;
        this.g = l10 = System.currentTimeMillis();
    }

    public a(int n10, long l10, int n11, int n12, int n13, char c10, int n14) {
        long l11;
        int n15;
        int n16;
        this.a = n16 = -1;
        this.b = -1;
        this.c = n16;
        this.d = n16;
        this.e = n15 = -1 >>> 1;
        this.f = n15;
        this.g = 0L;
        this.h = n16;
        this.i = (char)48;
        this.j = n15;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = false;
        this.a = n10;
        this.b = l10;
        this.c = n11;
        this.d = n12;
        this.h = n13;
        this.i = c10;
        this.g = l11 = System.currentTimeMillis();
        this.j = n14;
    }

    public a(a object) {
        int n10;
        long l10;
        int n11 = ((a)object).a;
        long l11 = ((a)object).b;
        int n12 = ((a)object).c;
        int n13 = ((a)object).d;
        int n14 = ((a)object).h;
        char c10 = ((a)object).i;
        int n15 = ((a)object).j;
        Object object2 = this;
        this(n11, l11, n12, n13, n14, c10, n15);
        this.g = l10 = ((a)object).g;
        this.l = object2 = ((a)object).l;
        this.k = n10 = ((a)object).k;
        this.m = object = ((a)object).m;
    }

    public boolean a() {
        long l10;
        int n10;
        long l11;
        long l12;
        long l13 = System.currentTimeMillis();
        long l14 = l13 - (l12 = this.g);
        long l15 = l14 - (l11 = 0L);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        n10 = object > 0 && (n10 = (l10 = (l13 -= l12) - (l12 = 3000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean a(a a10) {
        int n10;
        long l10;
        long l11;
        long l12;
        int n11 = this.a;
        int n12 = a10.a;
        return n11 == n12 && (n11 = (int)((l12 = (l11 = this.b) - (l10 = a10.b)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0 && (n11 = this.d) == (n12 = a10.d) && (n11 = this.c) == (n10 = a10.c);
    }

    public boolean b() {
        long l10;
        long l11;
        long l12;
        int n10 = this.a;
        int n11 = -1;
        n10 = n10 > n11 && (n10 = (l12 = (l11 = this.b) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean c() {
        long l10;
        long l11;
        long l12;
        int n10 = this.a;
        int n11 = -1;
        n10 = n10 == n11 && (n10 = (l12 = (l11 = this.b) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == 0 && (n10 = this.d) == n11 && (n10 = this.c) == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean d() {
        long l10;
        long l11;
        long l12;
        int n10 = this.a;
        int n11 = -1;
        n10 = n10 > n11 && (n10 = (l12 = (l11 = this.b) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (n10 = this.d) == n11 && (n10 = this.c) == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean e() {
        long l10;
        long l11;
        long l12;
        int n10 = this.a;
        int n11 = -1;
        n10 = n10 > n11 && (n10 = (l12 = (l11 = this.b) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (n10 = this.d) > n11 && (n10 = this.c) > n11 ? 1 : 0;
        return n10 != 0;
    }

    public void f() {
        this.n = true;
    }

    public String g() {
        StringBuffer stringBuffer = new StringBuffer(128);
        long l10 = this.b + (long)23;
        stringBuffer.append(l10);
        stringBuffer.append("H");
        int n10 = this.a + 45;
        stringBuffer.append(n10);
        stringBuffer.append("K");
        n10 = this.d + 54;
        stringBuffer.append(n10);
        stringBuffer.append("Q");
        n10 = this.c + 203;
        stringBuffer.append(n10);
        return stringBuffer.toString();
    }

    public String h() {
        Locale locale = Locale.CHINA;
        Object[] objectArray = new Object[4];
        Number number = this.c;
        objectArray[0] = number;
        number = this.d;
        objectArray[1] = number;
        number = this.a;
        objectArray[2] = number;
        number = this.b;
        objectArray[3] = number;
        return String.format(locale, "%d|%d|%d|%d", objectArray);
    }

    public String i() {
        Object object;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        int n10 = this.i;
        stringBuffer.append((char)n10);
        Object object2 = Locale.CHINA;
        Object[] objectArray = new Object[6];
        objectArray[0] = object = Integer.valueOf(this.c);
        objectArray[1] = object = Integer.valueOf(this.d);
        objectArray[2] = object = Integer.valueOf(this.a);
        long l10 = this.b;
        objectArray[3] = object = Long.valueOf(l10);
        objectArray[4] = object = Integer.valueOf(this.h);
        int n11 = this.k;
        object = n11;
        int n12 = 5;
        objectArray[n12] = object;
        object = "&cl=%d|%d|%d|%d&cl_s=%d&clp=%d";
        object2 = String.format((Locale)object2, (String)object, objectArray);
        stringBuffer.append((String)object2);
        n10 = this.j;
        int n13 = -1 >>> 1;
        if (n10 != n13) {
            object2 = "&cl_cs=";
            stringBuffer.append((String)object2);
            n10 = this.j;
            stringBuffer.append(n10);
        }
        if ((n10 = (int)(this.n ? 1 : 0)) != 0) {
            object2 = "&newcl=1";
            stringBuffer.append((String)object2);
        }
        if ((object2 = this.m) != null) {
            stringBuffer.append("&clnrs=");
            object2 = this.m;
            stringBuffer.append((String)object2);
        }
        return stringBuffer.toString();
    }

    public String j() {
        Object object;
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw2=");
        int n10 = this.i;
        stringBuffer.append((char)n10);
        Object object2 = Locale.CHINA;
        Object[] objectArray = new Object[6];
        objectArray[0] = object = Integer.valueOf(this.c);
        objectArray[1] = object = Integer.valueOf(this.d);
        objectArray[2] = object = Integer.valueOf(this.a);
        long l10 = this.b;
        objectArray[3] = object = Long.valueOf(l10);
        objectArray[4] = object = Integer.valueOf(this.h);
        int n11 = this.k;
        object = n11;
        int n12 = 5;
        objectArray[n12] = object;
        object = "&cl2=%d|%d|%d|%d&cl_s2=%d&clp2=%d";
        object2 = String.format((Locale)object2, (String)object, objectArray);
        stringBuffer.append((String)object2);
        n10 = this.j;
        int n13 = -1 >>> 1;
        if (n10 != n13) {
            object2 = "&cl_cs2=";
            stringBuffer.append((String)object2);
            n10 = this.j;
            stringBuffer.append(n10);
        }
        if ((object2 = this.m) != null) {
            stringBuffer.append("&clnrs2=");
            object2 = this.m;
            stringBuffer.append((String)object2);
        }
        return stringBuffer.toString();
    }
}

