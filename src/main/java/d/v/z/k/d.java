/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.k;

import d.v.z.k.c;
import d.v.z.o.f;
import java.util.Arrays;

public class d
implements c {
    private static final int c = 0;
    public static final int d = 2;
    private final int a;
    private final byte[] b;

    private d(int n10) {
        this.a = n10;
        byte[] byArray = f.q(n10, 2, true);
        this.b = byArray;
    }

    private d(byte[] byArray) {
        int n10 = byArray[0];
        boolean bl2 = true;
        byte by2 = byArray[bl2];
        this.a = n10 = f.v((byte)n10, by2, bl2);
        this.b = byArray;
    }

    public static d a() {
        return d.v.z.k.d.b(0);
    }

    public static d b(int n10) {
        d d10 = new d(n10);
        return d10;
    }

    public static d c(byte[] byArray) {
        d d10 = new d(byArray);
        return d10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            boolean bl3;
            object = (d)object;
            int n10 = this.a;
            int n11 = ((d)object).a;
            if (n10 != n11 || !(bl3 = Arrays.equals((byte[])(object2 = (Object)this.b), (byte[])(object = (Object)((d)object).b)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getCode() {
        return this.a;
    }

    public byte[] getCodeByte() {
        return this.b;
    }
}

