/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.h2.t.u;
import f.x1.n;
import g.h0.l.a;
import g.h0.l.b;
import g.h0.l.i;
import h.m;
import java.util.Arrays;
import java.util.List;
import okio.ByteString;

public final class b$b {
    private int a;
    private boolean b;
    public int c;
    public a[] d;
    private int e;
    public int f;
    public int g;
    public int h;
    private final boolean i;
    private final m j;

    public b$b(int n10, m m10) {
        this(n10, false, m10, 2, null);
    }

    public b$b(int n10, boolean bl2, m m10) {
        f0.p(m10, "out");
        this.h = n10;
        this.i = bl2;
        this.j = m10;
        this.a = -1 >>> 1;
        this.c = n10;
        a[] aArray = new a[8];
        this.d = aArray;
        this.e = n10 = aArray.length + -1;
    }

    public /* synthetic */ b$b(int n10, boolean bl2, m m10, int n11, u u10) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            n10 = 4096;
        }
        if ((n11 &= 2) != 0) {
            bl2 = true;
        }
        this(n10, bl2, m10);
    }

    public b$b(m m10) {
        this(0, false, m10, 3, null);
    }

    private final void a() {
        int n10 = this.c;
        int n11 = this.g;
        if (n10 < n11) {
            if (n10 == 0) {
                this.b();
            } else {
                this.c(n11 -= n10);
            }
        }
    }

    private final void b() {
        int n10;
        n.w2(this.d, null, 0, 0, 6, null);
        this.e = n10 = this.d.length + -1;
        this.f = 0;
        this.g = 0;
    }

    private final int c(int n10) {
        int n11 = 0;
        if (n10 > 0) {
            int n12;
            a a10;
            int n13;
            int n14;
            a[] aArray = this.d;
            for (n14 = aArray.length + -1; n14 >= (n13 = this.e) && n10 > 0; n14 += -1) {
                a a11 = this.d[n14];
                f0.m(a11);
                n13 = a11.a;
                n10 -= n13;
                n13 = this.g;
                a10 = this.d[n14];
                f0.m(a10);
                n12 = a10.a;
                this.g = n13 -= n12;
                this.f = n13 = this.f + -1;
                ++n11;
            }
            Object[] objectArray = this.d;
            n14 = n13 + 1;
            n13 = n13 + 1 + n11;
            n12 = this.f;
            System.arraycopy(objectArray, n14, objectArray, n13, n12);
            objectArray = this.d;
            n14 = this.e;
            n13 = n14 + 1;
            n14 = n14 + 1 + n11;
            n12 = 0;
            a10 = null;
            Arrays.fill(objectArray, n13, n14, null);
            this.e = n10 = this.e + n11;
        }
        return n11;
    }

    private final void d(a a10) {
        int n10;
        int n11 = a10.a;
        int n12 = this.c;
        if (n11 > n12) {
            this.b();
            return;
        }
        int n13 = this.g + n11 - n12;
        this.c(n13);
        n12 = this.f + 1;
        a[] aArray = this.d;
        int n14 = aArray.length;
        if (n12 > n14) {
            n12 = aArray.length * 2;
            a[] aArray2 = new a[n12];
            n14 = 0;
            int n15 = aArray.length;
            int n16 = aArray.length;
            System.arraycopy(aArray, 0, aArray2, n15, n16);
            aArray = this.d;
            this.e = n13 = aArray.length + -1;
            this.d = aArray2;
        }
        n12 = this.e;
        this.e = n13 = n12 + -1;
        this.d[n12] = a10;
        this.f = n10 = this.f + 1;
        this.g = n10 = this.g + n11;
    }

    public final void e(int n10) {
        this.h = n10;
        int n11 = this.c;
        if (n11 == (n10 = Math.min(n10, 16384))) {
            return;
        }
        if (n10 < n11) {
            this.a = n11 = Math.min(this.a, n10);
        }
        this.b = true;
        this.c = n10;
        this.a();
    }

    public final void f(ByteString byteString) {
        int n10;
        int n11;
        Object object = "data";
        f0.p(byteString, (String)object);
        int n12 = this.i;
        int n13 = 127;
        if (n12 != 0 && (n11 = ((i)(object = g.h0.l.i.d)).d(byteString)) < (n10 = byteString.size())) {
            m m10 = new m();
            ((i)object).c(byteString, m10);
            byteString = m10.b0();
            n12 = byteString.size();
            n11 = 128;
            this.h(n12, n13, n11);
            object = this.j;
            ((m)object).W0(byteString);
        } else {
            n12 = byteString.size();
            n11 = 0;
            Object var7_8 = null;
            this.h(n12, n13, 0);
            object = this.j;
            ((m)object).W0(byteString);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void g(List var1_1) {
        var2_2 = "headerBlock";
        f0.p(var1_1, var2_2);
        var3_3 = this.b;
        if (var3_3 != 0) {
            var3_3 = this.a;
            var4_4 = this.c;
            var5_5 = 32;
            var6_6 = 31;
            if (var3_3 < var4_4) {
                this.h(var3_3, var6_6, var5_5);
            }
            this.b = false;
            this.a = -1 >>> 1;
            var3_3 = this.c;
            this.h(var3_3, var6_6, var5_5);
        }
        var3_3 = var1_1.size();
        for (var4_4 = 0; var4_4 < var3_3; ++var4_4) {
            block14: {
                block13: {
                    var7_7 = (a)var1_1.get(var4_4);
                    var8_8 = var7_7.b.toAsciiLowercase();
                    var9_9 = var7_7.c;
                    var10_10 = g.h0.l.b.i;
                    var11_11 = (a[])var10_10.b().get(var8_8);
                    var12_12 = -1;
                    if (var11_11 == null) break block13;
                    var13_13 = var11_11.intValue() + 1;
                    var14_14 = 7;
                    var15_15 = 2;
                    if (var15_15 > var13_13 || var14_14 < var13_13) ** GOTO lbl-1000
                    var16_16 /* !! */  = var10_10.c();
                    var15_15 = var13_13 + -1;
                    var16_16 /* !! */  = var16_16 /* !! */ [var15_15].c;
                    var14_14 = (int)f0.g(var16_16 /* !! */ , var9_9);
                    if (var14_14 != 0) {
                        var17_17 = var13_13;
                    } else {
                        var10_10 = var10_10.c()[var13_13].c;
                        var17_17 = (int)f0.g(var10_10, var9_9);
                        if (var17_17 != 0) {
                            var17_17 = var13_13 + 1;
                            var18_18 = var13_13;
                            var13_13 = var17_17;
                            var17_17 = var18_18;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var17_17 = var13_13;
                            var13_13 = var12_12;
                        }
                    }
                    break block14;
                }
                var17_17 = var12_12;
                var13_13 = var12_12;
            }
            if (var13_13 == var12_12) {
                var19_19 = this.d;
                var15_15 = var19_19.length;
                for (var14_14 = this.e + 1; var14_14 < var15_15; ++var14_14) {
                    var20_20 = this.d[var14_14];
                    f0.m(var20_20);
                    var20_20 = var20_20.b;
                    var21_21 = f0.g(var20_20, var8_8);
                    if (var21_21 == 0) continue;
                    var20_20 = this.d[var14_14];
                    f0.m(var20_20);
                    var20_20 = var20_20.c;
                    var21_21 = f0.g(var20_20, var9_9);
                    if (var21_21 != 0) {
                        var13_13 = this.e;
                        var14_14 -= var13_13;
                        var11_11 = g.h0.l.b.i.c();
                        var13_13 = var11_11.length + var14_14;
                        break;
                    }
                    if (var17_17 != var12_12) continue;
                    var17_17 = this.e;
                    var17_17 = var14_14 - var17_17;
                    var20_20 = g.h0.l.b.i.c();
                    var21_21 = var20_20.length;
                    var17_17 += var21_21;
                }
            }
            if (var13_13 != var12_12) {
                var5_5 = 127;
                var6_6 = 128;
                this.h(var13_13, var5_5, var6_6);
                continue;
            }
            var13_13 = 64;
            if (var17_17 == var12_12) {
                var10_10 = this.j;
                var10_10.b1(var13_13);
                this.f(var8_8);
                this.f(var9_9);
                this.d(var7_7);
                continue;
            }
            var22_22 = g.h0.l.a.d;
            var12_12 = (int)var8_8.startsWith(var22_22);
            if (var12_12 != 0 && (var6_6 = f0.g(var22_22 = g.h0.l.a.n, var8_8) ^ 1) != 0) {
                var5_5 = 15;
                this.h(var17_17, var5_5, 0);
                this.f(var9_9);
                continue;
            }
            var6_6 = 63;
            this.h(var17_17, var6_6, var13_13);
            this.f(var9_9);
            this.d(var7_7);
        }
    }

    public final void h(int n10, int n11, int n12) {
        if (n10 < n11) {
            m m10 = this.j;
            m10.b1(n10 |= n12);
            return;
        }
        m m11 = this.j;
        m11.b1(n12 |= n11);
        n10 -= n11;
        while (n10 >= (n11 = 128)) {
            n12 = n10 & 0x7F;
            m11 = this.j;
            m11.b1(n11 |= n12);
            n10 >>>= 7;
        }
        this.j.b1(n10);
    }
}

