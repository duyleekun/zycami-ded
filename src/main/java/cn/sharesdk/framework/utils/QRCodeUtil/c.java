/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import java.util.Arrays;

public final class c
implements Cloneable {
    private final int a;
    private final int b;
    private final int c;
    private final int[] d;

    public c(int n10, int n11) {
        int n12 = 1;
        if (n10 >= n12 && n11 >= n12) {
            this.a = n10;
            this.b = n11;
            this.c = n10 = (n10 + 31) / 32;
            int[] nArray = new int[n10 * n11];
            this.d = nArray;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both dimensions must be greater than 0");
        throw illegalArgumentException;
    }

    private c(int n10, int n11, int n12, int[] nArray) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = nArray;
    }

    private String a(String string2, String string3, String string4) {
        int n10;
        int n11 = this.b;
        int n12 = this.a + 1;
        StringBuilder stringBuilder = new StringBuilder(n11 *= n12);
        n11 = 0;
        for (n12 = 0; n12 < (n10 = this.b); ++n12) {
            int n13;
            for (n10 = 0; n10 < (n13 = this.a); ++n10) {
                n13 = (int)(this.a(n10, n12) ? 1 : 0);
                String string5 = n13 != 0 ? string2 : string3;
                stringBuilder.append(string5);
            }
            stringBuilder.append(string4);
        }
        return stringBuilder.toString();
    }

    public c a() {
        int n10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        int[] nArray = (int[])this.d.clone();
        c c10 = new c(n10, n11, n12, nArray);
        return c10;
    }

    public String a(String string2, String string3) {
        return this.a(string2, string3, "\n");
    }

    public void a(int n10, int n11, int n12, int n13) {
        if (n11 >= 0 && n10 >= 0) {
            int n14 = 1;
            if (n13 >= n14 && n12 >= n14) {
                int n15 = this.b;
                if ((n13 += n11) <= n15 && (n12 += n10) <= (n15 = this.a)) {
                    while (n11 < n13) {
                        n15 = this.c * n11;
                        for (int i10 = n10; i10 < n12; ++i10) {
                            int[] nArray = this.d;
                            int n16 = i10 / 32 + n15;
                            int n17 = nArray[n16];
                            int n18 = i10 & 0x1F;
                            n18 = n14 << n18;
                            nArray[n16] = n17 |= n18;
                        }
                        ++n11;
                    }
                    return;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The region must fit inside the matrix");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Height and width must be at least 1");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Left and top must be nonnegative");
        throw illegalArgumentException;
    }

    public boolean a(int n10, int n11) {
        int n12 = this.c;
        n11 *= n12;
        n12 = n10 / 32;
        n11 += n12;
        int[] nArray = this.d;
        n11 = nArray[n11];
        n10 &= 0x1F;
        n10 = n11 >>> n10;
        n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    public boolean equals(Object object) {
        int[] nArray;
        boolean bl2;
        int n10 = object instanceof c;
        boolean bl3 = false;
        if (n10 == 0) {
            return false;
        }
        object = (c)object;
        n10 = this.a;
        int n11 = ((c)object).a;
        if (n10 == n11 && (n10 = this.b) == (n11 = ((c)object).b) && (n10 = this.c) == (n11 = ((c)object).c) && (bl2 = Arrays.equals(nArray = this.d, (int[])(object = (Object)((c)object).d)))) {
            bl3 = true;
        }
        return bl3;
    }

    public int hashCode() {
        int n10 = this.a;
        int n11 = (n10 * 31 + n10) * 31;
        n10 = this.b;
        n11 = (n11 + n10) * 31;
        n10 = this.c;
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.d);
        return n11 + n10;
    }

    public String toString() {
        return this.a("X ", "\t");
    }
}

