/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.b.b;

public class a {
    private int OooO00o;
    private int OooO0O0;

    public a() {
        this(1, 10);
    }

    public a(int n10) {
        this(1, n10);
    }

    public a(int n10, int n11) {
        int n12 = 50;
        if (n11 > n12) {
            n11 = n12;
        }
        this.OooO00o = n10;
        this.OooO0O0 = n11;
    }

    public int getPageNum() {
        return this.OooO00o;
    }

    public int getPageSize() {
        return this.OooO0O0;
    }
}

