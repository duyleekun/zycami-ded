/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Arrays;

public final class b
implements Cloneable {
    private int[] a;
    private int b;

    public b() {
        this.b = 0;
        int[] nArray = new int[1];
        this.a = nArray;
    }

    public b(int[] nArray, int n10) {
        this.a = nArray;
        this.b = n10;
    }

    private void b(int n10) {
        int[] nArray = this.a;
        int n11 = nArray.length * 32;
        if (n10 > n11) {
            int[] nArray2 = cn.sharesdk.framework.utils.QRCodeUtil.b.c(n10);
            nArray = this.a;
            int n12 = nArray.length;
            System.arraycopy(nArray, 0, nArray2, 0, n12);
            this.a = nArray2;
        }
    }

    private static int[] c(int n10) {
        return new int[(n10 + 31) / 32];
    }

    public int a() {
        return this.b;
    }

    public void a(int n10, int n11) {
        int n12;
        if (n11 >= 0 && n11 <= (n12 = 32)) {
            n12 = this.b + n11;
            this.b(n12);
            while (n11 > 0) {
                n12 = n11 + -1;
                n12 = n10 >> n12;
                int n13 = 1;
                if ((n12 &= n13) != n13) {
                    n13 = 0;
                }
                this.a(n13 != 0);
                n11 += -1;
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Num bits must be between 0 and 32");
        throw illegalArgumentException;
    }

    public void a(int n10, byte[] byArray, int n11, int n12) {
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13;
            int n14;
            byte by2 = 0;
            for (n14 = 0; n14 < (n13 = 8); ++n14) {
                n13 = (int)(this.a(n10) ? 1 : 0);
                if (n13 != 0) {
                    n13 = 7 - n14;
                    int n15 = 1;
                    n13 = n15 << n13;
                    by2 = (byte)(by2 | n13);
                }
                ++n10;
            }
            n14 = n11 + i10;
            byArray[n14] = by2 = (byte)by2;
        }
    }

    public void a(b b10) {
        int n10 = b10.b;
        int n11 = this.b + n10;
        this.b(n11);
        for (n11 = 0; n11 < n10; ++n11) {
            boolean bl2 = b10.a(n11);
            this.a(bl2);
        }
    }

    public void a(boolean bl2) {
        int n10;
        int n11 = this.b;
        int n12 = 1;
        this.b(n11 += n12);
        if (bl2) {
            int[] nArray = this.a;
            n11 = this.b;
            int n13 = n11 / 32;
            int n14 = nArray[n13];
            n11 &= 0x1F;
            nArray[n13] = n11 = n12 << n11 | n14;
        }
        this.b = n10 = this.b + n12;
    }

    public boolean a(int n10) {
        int[] nArray = this.a;
        int n11 = n10 / 32;
        int n12 = nArray[n11];
        n10 &= 0x1F;
        n11 = 1;
        if ((n10 = n11 << n10 & n12) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public int b() {
        return (this.b + 7) / 8;
    }

    public void b(b object) {
        int[] nArray = this.a;
        int n10 = nArray.length;
        int[] nArray2 = ((b)object).a;
        int n11 = nArray2.length;
        if (n10 == n11) {
            int n12;
            nArray = null;
            for (n10 = 0; n10 < (n12 = (nArray2 = this.a).length); ++n10) {
                n12 = nArray2[n10];
                int[] nArray3 = ((b)object).a;
                int n13 = nArray3[n10];
                nArray2[n10] = n12 ^= n13;
            }
            return;
        }
        object = new IllegalArgumentException("Sizes don't match");
        throw object;
    }

    public b c() {
        int[] nArray = (int[])this.a.clone();
        int n10 = this.b;
        b b10 = new b(nArray, n10);
        return b10;
    }

    public /* synthetic */ Object clone() {
        return this.c();
    }

    public boolean equals(Object object) {
        int[] nArray;
        boolean bl2;
        int n10 = object instanceof b;
        boolean bl3 = false;
        if (n10 == 0) {
            return false;
        }
        object = (b)object;
        n10 = this.b;
        int n11 = ((b)object).b;
        if (n10 == n11 && (bl2 = Arrays.equals(nArray = this.a, (int[])(object = (Object)((b)object).a)))) {
            bl3 = true;
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.b * 31;
        int n11 = Arrays.hashCode(this.a);
        return n10 + n11;
    }

    public String toString() {
        int n10;
        int n11 = this.b;
        StringBuilder stringBuilder = new StringBuilder(n11);
        for (n11 = 0; n11 < (n10 = this.b); ++n11) {
            n10 = n11 & 7;
            if (n10 == 0) {
                n10 = 32;
                stringBuilder.append((char)n10);
            }
            n10 = (n10 = (int)(this.a(n11) ? 1 : 0)) != 0 ? 88 : 46;
            stringBuilder.append((char)n10);
        }
        return stringBuilder.toString();
    }
}

