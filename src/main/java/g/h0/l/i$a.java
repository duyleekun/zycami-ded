/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

public final class i$a {
    private final i$a[] a;
    private final int b;
    private final int c;

    public i$a() {
        i$a[] i$aArray = new i$a[256];
        this.a = i$aArray;
        this.b = 0;
        this.c = 0;
    }

    public i$a(int n10, int n11) {
        this.a = null;
        this.b = n10;
        n10 = n11 & 7;
        if (n10 == 0) {
            n10 = 8;
        }
        this.c = n10;
    }

    public final i$a[] a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }
}

