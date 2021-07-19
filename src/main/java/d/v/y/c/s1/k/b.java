/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.k;

import d.v.y.c.s1.k.e;
import d.v.y.d.a;
import d.v.y.d.k;
import java.io.PrintStream;

public class b
extends e {
    private static final int g = 0;
    private static final int h = 1;
    private boolean b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;

    private byte[] e() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.c;
        stringBuilder.append((String)object);
        char c10 = '+';
        stringBuilder.append(c10);
        CharSequence charSequence = this.d;
        stringBuilder.append((String)charSequence);
        boolean bl2 = this.e;
        if (bl2) {
            stringBuilder.append(c10);
            charSequence = "h264";
            stringBuilder.append((String)charSequence);
        }
        if (bl2 = this.f) {
            stringBuilder.append(c10);
            object = "h265";
            stringBuilder.append((String)object);
        }
        stringBuilder.append('\u0000');
        object = System.out;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("device_info = ");
        String string2 = stringBuilder.toString();
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        ((PrintStream)object).println((String)charSequence);
        return k.h(stringBuilder.toString());
    }

    private void k(byte[] objectArray) {
        int n10;
        objectArray = k.c(objectArray).split("\\+");
        byte by2 = objectArray[0];
        this.c = (String)by2;
        int n11 = 1;
        byte by3 = objectArray[n11];
        this.d = (String)by3;
        for (int i10 = 2; i10 < (n10 = objectArray.length); ++i10) {
            String string2 = "h264";
            byte by4 = objectArray[i10];
            boolean bl2 = string2.equals(by4);
            if (bl2) {
                this.e = n11;
            }
            if ((n10 = (int)((string2 = "h265").equals(by4) ? 1 : 0)) == 0) continue;
            this.f = n11;
        }
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 4;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = by2 = (byte)(this.b ? 1 : 0);
        byte[] byArray3 = this.e();
        byte[][] byArrayArray = new byte[2][];
        byArrayArray[0] = byArray2;
        byArrayArray[n10] = byArray3;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.b = false;
        this.c = null;
        this.d = null;
        this.e = false;
        this.f = false;
    }

    public String d() {
        return this.c;
    }

    public String f() {
        return this.d;
    }

    public boolean g() {
        return this.b;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public void j(String string2) {
        this.c = string2;
    }

    public void l(String string2) {
        this.d = string2;
    }

    public void m(boolean bl2) {
        this.b = bl2;
    }

    public void n(boolean bl2) {
        this.e = bl2;
    }

    public void o(boolean bl2) {
        this.f = bl2;
    }

    public boolean parseFrom(byte[] byArray) {
        int n10 = 0;
        int n11 = byArray[0];
        int n12 = 4;
        if (n11 == n12) {
            n11 = 1;
            n12 = byArray[n11];
            if (n12 == n11) {
                n10 = n11;
            }
            this.b = n10;
            if (n10 != 0) {
                n10 = 2;
                byArray = a.d(byArray, n10);
                this.k(byArray);
            }
            return n11 != 0;
        }
        return false;
    }
}

