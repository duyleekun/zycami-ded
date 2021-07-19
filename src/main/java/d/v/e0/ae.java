/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

public class ae {
    private boolean a;
    private boolean b;
    private boolean c;

    public ae() {
    }

    public ae(boolean bl2, boolean bl3, boolean bl4) {
        this.a = bl2;
        this.b = bl3;
        this.c = bl4;
    }

    private static boolean a(int n10, int n11) {
        int n12 = 1;
        if ((n10 &= (n11 = n12 << n11)) != n11) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static ae b(int n10) {
        boolean bl2;
        ae ae2 = new ae();
        ae2.a = bl2 = ae.a(n10, 0);
        ae2.b = bl2 = ae.a(n10, 1);
        n10 = (int)(ae.a(n10, 2) ? 1 : 0);
        ae2.c = n10;
        return ae2;
    }

    public static int c(ae ae2) {
        boolean bl2;
        int n10 = (int)(ae2.a ? 1 : 0);
        n10 = n10 != 0 ? 1 : 0;
        boolean bl3 = ae2.b;
        if (bl3) {
            n10 |= 2;
        }
        if (bl2 = ae2.c) {
            n10 |= 4;
        }
        return n10;
    }

    public boolean d() {
        return this.a;
    }

    public boolean e() {
        return this.b;
    }

    public boolean f() {
        return this.c;
    }

    public void g(boolean bl2) {
        this.a = bl2;
    }

    public void h(ae ae2) {
        boolean bl2 = ae2.a;
        this.g(bl2);
        bl2 = ae2.b;
        this.i(bl2);
        boolean bl3 = ae2.c;
        this.j(bl3);
    }

    public void i(boolean bl2) {
        this.b = bl2;
    }

    public void j(boolean bl2) {
        this.c = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Reverse{pitch=");
        boolean bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", roll=");
        bl2 = this.b;
        stringBuilder.append(bl2);
        stringBuilder.append(", yaw=");
        bl2 = this.c;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

