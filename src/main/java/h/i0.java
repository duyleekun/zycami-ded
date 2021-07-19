/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.x1.n;
import h.i0$a;
import h.j0;
import java.util.Arrays;

public final class i0 {
    public static final int h = 8192;
    public static final int i = 1024;
    public static final i0$a j;
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public i0 f;
    public i0 g;

    static {
        i0$a i0$a;
        j = i0$a = new i0$a(null);
    }

    public i0() {
        byte[] byArray = new byte[8192];
        this.a = byArray;
        this.e = true;
        this.d = false;
    }

    public i0(byte[] byArray, int n10, int n11, boolean bl2, boolean bl3) {
        f0.p(byArray, "data");
        this.a = byArray;
        this.b = n10;
        this.c = n11;
        this.d = bl2;
        this.e = bl3;
    }

    public final void a() {
        i0 i02;
        int n10;
        Object object = this.g;
        int n11 = 0;
        Object object2 = null;
        if (object != this) {
            n10 = 1;
        } else {
            n10 = 0;
            i02 = null;
        }
        if (n10 != 0) {
            f0.m(object);
            int n12 = ((i0)object).e;
            if (n12 == 0) {
                return;
            }
            n12 = this.c;
            n10 = this.b;
            n12 -= n10;
            i02 = this.g;
            f0.m(i02);
            n10 = i02.c;
            n10 = 8192 - n10;
            i0 i03 = this.g;
            f0.m(i03);
            boolean bl2 = i03.d;
            if (!bl2) {
                object2 = this.g;
                f0.m(object2);
                n11 = ((i0)object2).b;
            }
            if (n12 > (n10 += n11)) {
                return;
            }
            object2 = this.g;
            f0.m(object2);
            this.g((i0)object2, n12);
            this.b();
            j0.d(this);
            return;
        }
        object2 = "cannot compact".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final i0 b() {
        i0 i02;
        i0 i03 = this.f;
        if (i03 == this) {
            i03 = null;
        }
        i0 i04 = this.g;
        f0.m(i04);
        i04.f = i02 = this.f;
        i04 = this.f;
        f0.m(i04);
        i04.g = i02 = this.g;
        this.f = null;
        this.g = null;
        return i03;
    }

    public final i0 c(i0 i02) {
        i0 i03;
        f0.p(i02, "segment");
        i02.g = this;
        i02.f = i03 = this.f;
        i03 = this.f;
        f0.m(i03);
        i03.g = i02;
        this.f = i02;
        return i02;
    }

    public final i0 d() {
        this.d = true;
        byte[] byArray = this.a;
        int n10 = this.b;
        int n11 = this.c;
        i0 i02 = new i0(byArray, n10, n11, true, false);
        return i02;
    }

    /*
     * Unable to fully structure code
     */
    public final i0 e(int var1_1) {
        if (var1_1 <= 0) ** GOTO lbl-1000
        var2_2 = this.c;
        var3_3 = this.b;
        if (var1_1 <= (var2_2 -= var3_3)) {
            var2_2 = 1;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = 0;
            var4_4 = null;
        }
        if (var2_2 != 0) {
            var2_2 = 1024;
            if (var1_1 >= var2_2) {
                var4_4 = this.d();
            } else {
                var4_4 = j0.e();
                var5_5 = this.a;
                var6_6 = var4_4.a;
                var7_7 = this.b;
                var8_8 = var7_7 + var1_1;
                var9_9 = 2;
                n.f1(var5_5, var6_6, 0, var7_7, var8_8, var9_9, null);
            }
            var4_4.c = var3_3 = var4_4.b + var1_1;
            this.b = var3_3 = this.b + var1_1;
            var10_10 = this.g;
            f0.m(var10_10);
            var10_10.c((i0)var4_4);
            return var4_4;
        }
        var4_4 = "byteCount out of range".toString();
        var10_11 = new IllegalArgumentException((String)var4_4);
        throw var10_11;
    }

    public final i0 f() {
        i0 i02;
        Object object = this.a;
        int n10 = ((byte[])object).length;
        byte[] byArray = Arrays.copyOf(object, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        int n11 = this.b;
        int n12 = this.c;
        object = i02;
        i02 = new i0(byArray, n11, n12, false, true);
        return i02;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void g(i0 object, int n10) {
        int n11;
        byte[] byArray;
        int n12;
        int n13;
        Object object2 = "sink";
        f0.p(object, (String)object2);
        int n14 = ((i0)object).e;
        if (n14 == 0) {
            String string2 = "only owner can write".toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        int n15 = ((i0)object).c;
        n14 = n15 + n10;
        int n16 = 8192;
        if (n14 > n16) {
            n14 = (int)(((i0)object).d ? 1 : 0);
            if (n14 != 0) {
                object = new IllegalArgumentException();
                throw object;
            }
            n14 = n15 + n10;
            n13 = ((i0)object).b;
            if ((n14 -= n13) > n16) {
                object = new IllegalArgumentException();
                throw object;
            }
            byte[] byArray2 = ((i0)object).a;
            n12 = 0;
            int n17 = 2;
            byArray = byArray2;
            n.f1(byArray2, byArray2, 0, n13, n15, n17, null);
            n14 = ((i0)object).c;
            n16 = ((i0)object).b;
            ((i0)object).c = n14 -= n16;
            n14 = 0;
            object2 = null;
            ((i0)object).b = 0;
        }
        object2 = this.a;
        byArray = ((i0)object).a;
        int n18 = ((i0)object).c;
        n12 = this.b;
        n13 = n12 + n10;
        n.W0((byte[])object2, byArray, n18, n12, n13);
        ((i0)object).c = n14 = ((i0)object).c + n10;
        this.b = n11 = this.b + n10;
    }
}

