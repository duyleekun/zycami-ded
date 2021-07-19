/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a {
    public static final a a;
    private volatile int a;
    private final byte[] a = 0;

    static {
        a a10;
        byte[] byArray = new byte[]{};
        a = a10 = new a(byArray);
    }

    private a(byte[] byArray) {
        this.a = byArray;
    }

    public static a a(byte[] byArray) {
        int n10 = byArray.length;
        return com.xiaomi.push.a.a(byArray, 0, n10);
    }

    public static a a(byte[] object, int n10, int n11) {
        byte[] byArray = new byte[n11];
        System.arraycopy(object, n10, byArray, 0, n11);
        object = new a;
        object(byArray);
        return object;
    }

    public int a() {
        return this.a.length;
    }

    public byte[] a() {
        byte[] byArray = this.a;
        int n10 = byArray.length;
        byte[] byArray2 = new byte[n10];
        System.arraycopy(byArray, 0, byArray2, 0, n10);
        return byArray2;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof a;
        if (!bl3) {
            return false;
        }
        object = (a)object;
        byte[] byArray = this.a;
        int n10 = byArray.length;
        object = ((a)object).a;
        int n11 = ((Object)object).length;
        if (n10 != n11) {
            return false;
        }
        for (n11 = 0; n11 < n10; ++n11) {
            byte by2 = byArray[n11];
            Object object2 = object[n11];
            if (by2 == object2) continue;
            return false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a;
        if (n10 == 0) {
            byte[] byArray = this.a;
            int n11 = byArray.length;
            int n12 = n11;
            for (int i10 = 0; i10 < n11; ++i10) {
                n12 *= 31;
                byte by2 = byArray[i10];
                n12 += by2;
            }
            n10 = n12 == 0 ? 1 : n12;
            this.a = n10;
        }
        return n10;
    }
}

