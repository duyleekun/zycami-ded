/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.d2.l;
import f.h2.t.f0;
import f.k2.d;
import f.k2.e$a;
import f.k2.f;

public abstract class e {
    private static final e a;
    public static final e$a b;

    static {
        e$a e$a;
        b = e$a = new e$a(null);
        a = l.a.b();
    }

    public static final /* synthetic */ e a() {
        return a;
    }

    public static /* synthetic */ byte[] g(e object, byte[] byArray, int n10, int n11, int n12, Object object2) {
        if (object2 == null) {
            int n13 = n12 & 2;
            if (n13 != 0) {
                n10 = 0;
            }
            if ((n12 &= 4) != 0) {
                n11 = byArray.length;
            }
            return ((e)object).f(byArray, n10, n11);
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        throw object;
    }

    public abstract int b(int var1);

    public boolean c() {
        boolean bl2 = true;
        int n10 = this.b((int)(bl2 ? 1 : 0));
        if (n10 == 0) {
            bl2 = false;
        }
        return bl2;
    }

    public byte[] d(int n10) {
        byte[] byArray = new byte[n10];
        return this.e(byArray);
    }

    public byte[] e(byte[] byArray) {
        f0.p(byArray, "array");
        int n10 = byArray.length;
        return this.f(byArray, 0, n10);
    }

    /*
     * Unable to fully structure code
     */
    public byte[] f(byte[] var1_1, int var2_2, int var3_3) {
        var4_4 = "array";
        f0.p(var1_1, (String)var4_4);
        var5_5 = ((byte[])var1_1).length;
        var6_6 = 0;
        var7_7 = 1;
        if (var2_2 < 0 || var5_5 < var2_2) ** GOTO lbl-1000
        var5_5 = ((byte[])var1_1).length;
        if (var3_3 >= 0 && var5_5 >= var3_3) {
            var5_5 = var7_7;
        } else lbl-1000:
        // 2 sources

        {
            var5_5 = 0;
            var4_4 = null;
        }
        var8_8 = "fromIndex (";
        if (var5_5 != 0) {
            if (var2_2 > var3_3) {
                var7_7 = 0;
            }
            if (var7_7 != 0) {
                var5_5 = (var3_3 - var2_2) / 4;
                for (var7_7 = 0; var7_7 < var5_5; ++var7_7) {
                    var9_9 = this.l();
                    var10_10 = var9_9;
                    var1_1[var2_2] = var10_10;
                    var10_10 = var2_2 + 1;
                    var11_11 = (byte)(var9_9 >>> 8);
                    var1_1[var10_10] = var11_11;
                    var10_10 = var2_2 + 2;
                    var11_11 = (byte)(var9_9 >>> 16);
                    var1_1[var10_10] = var11_11;
                    var10_10 = var2_2 + 3;
                    var9_9 = (byte)(var9_9 >>> 24);
                    var1_1[var10_10] = var9_9;
                    var2_2 += 4;
                }
                var5_5 = (var3_3 -= var2_2) * 8;
                var5_5 = this.b(var5_5);
                while (var6_6 < var3_3) {
                    var7_7 = var2_2 + var6_6;
                    var9_9 = var6_6 * 8;
                    var9_9 = (byte)(var5_5 >>> var9_9);
                    var1_1[var7_7] = var9_9;
                    ++var6_6;
                }
                return var1_1;
            }
            var1_1 = new StringBuilder;
            var1_1();
            var1_1.append(var8_8);
            var1_1.append(var2_2);
            var1_1.append(") must be not greater than toIndex (");
            var1_1.append(var3_3);
            var1_1.append(").");
            var1_1 = var1_1.toString();
            var1_1 = var1_1.toString();
            var12_12 = new IllegalArgumentException((String)var1_1);
            throw var12_12;
        }
        var4_4 = new StringBuilder();
        var4_4.append(var8_8);
        var4_4.append(var2_2);
        var4_4.append(") or toIndex (");
        var4_4.append(var3_3);
        var4_4.append(") are out of range: 0..");
        var13_14 = ((Object)var1_1).length;
        var4_4.append(var13_14);
        var4_4.append('.');
        var1_1 = var4_4.toString();
        var1_1 = var1_1.toString();
        var12_13 = new IllegalArgumentException((String)var1_1);
        throw var12_13;
    }

    public double h() {
        int n10 = this.b(26);
        int n11 = this.b(27);
        return d.d(n10, n11);
    }

    public double i(double d10) {
        return this.j(0.0, d10);
    }

    /*
     * Unable to fully structure code
     */
    public double j(double var1_1, double var3_2) {
        f.d(var1_1, var3_2);
        var5_3 = var3_2 - var1_1;
        var7_4 = Double.isInfinite(var5_3);
        if (var7_4 == 0) ** GOTO lbl-1000
        var7_4 = Double.isInfinite(var1_1);
        var8_5 = 1;
        if ((var7_4 = var7_4 == 0 && (var7_4 = Double.isNaN(var1_1)) == 0 ? var8_5 : 0) == 0) ** GOTO lbl-1000
        var7_4 = Double.isInfinite(var3_2);
        if (var7_4 != 0 || (var7_4 = Double.isNaN(var3_2)) != 0) {
            var8_5 = 0;
        }
        if (var8_5 != 0) {
            var5_3 = this.h();
            var7_4 = 2;
            var9_6 = var7_4;
            var11_8 = var3_2 / var9_6;
            var9_6 = var1_1 / var9_6;
            var1_1 = var1_1 + (var5_3 *= (var11_8 -= var9_6)) + var5_3;
        } else lbl-1000:
        // 3 sources

        {
            var9_7 = this.h() * var5_3;
            var1_1 += var9_7;
        }
        var13_9 = var1_1 == var3_2 ? 0 : (var1_1 > var3_2 ? 1 : -1);
        if (var13_9 >= 0) {
            var1_1 = Math.nextAfter(var3_2, -1.0 / 0.0);
        }
        return var1_1;
    }

    public float k() {
        float f10 = this.b(24);
        float f11 = 0x1000000;
        return f10 / f11;
    }

    public int l() {
        return this.b(32);
    }

    public int m(int n10) {
        return this.n(0, n10);
    }

    public int n(int n10, int n11) {
        int n12;
        f.e(n10, n11);
        int n13 = n11 - n10;
        if (n13 <= 0 && n13 != (n12 = -1 << -1)) {
            while (n10 > (n13 = this.l()) || n11 <= n13) {
            }
            return n13;
        }
        n11 = -n13 & n13;
        if (n11 == n13) {
            n11 = f.g(n13);
            n11 = this.b(n11);
        } else {
            int n14;
            do {
                n11 = this.l() >>> 1;
                n12 = n11 % n13;
                n11 -= n12;
            } while ((n11 += (n14 = n13 + -1)) < 0);
            n11 = n12;
        }
        return n10 + n11;
    }

    public long o() {
        long l10 = (long)this.l() << 32;
        long l11 = this.l();
        return l10 + l11;
    }

    public long p(long l10) {
        return this.q(0L, l10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public long q(long l10, long l11) {
        long l12;
        long l13;
        f.f(l10, l11);
        long l14 = l11 - l10;
        long l15 = 0L;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        if (l16 > 0) {
            long l17;
            long l18;
            long l19;
            l11 = -l14 & l14;
            long l20 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
            l16 = 1;
            if (l20 == false) {
                l20 = (int)l14;
                int n10 = 32;
                int n11 = (int)(l14 >>>= n10);
                long l21 = 0xFFFFFFFFL;
                if (l20 != false) {
                    l20 = f.g((int)l20);
                    l20 = this.b((int)l20);
                } else {
                    if (n11 != l16) {
                        l20 = f.g(n11);
                        l20 = this.b((int)l20);
                        l11 = (long)l20 << n10;
                        n11 = this.l();
                        l14 = n11;
                        return l10 + (l11 += l14);
                    }
                    l20 = this.l();
                }
                l11 = (long)l20 & l21;
                return l10 + l11;
            }
            do {
                l11 = this.o() >>> l16;
                l17 = l11 % l14;
                l11 -= l17;
            } while ((l20 = (l19 = (l11 += (l18 = l14 - 1L)) - l15) == 0L ? 0 : (l19 < 0L ? -1 : 1)) < 0);
            l11 = l17;
            return l10 + l11;
        }
        while ((l13 = (l12 = l10 - (l14 = this.o())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 || (l13 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1)) <= 0) {
        }
        return l14;
    }
}

