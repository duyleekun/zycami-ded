/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

public class rd {
    private int a;
    private int b;

    public rd(int n10) {
        this(n10, 0);
    }

    public rd(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public int a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof rd;
        if (n10 == 0) {
            return false;
        }
        object = (rd)object;
        n10 = this.a;
        int n11 = ((rd)object).a;
        if (n10 != n11) {
            return false;
        }
        n10 = this.b;
        int n12 = ((rd)object).b;
        if (n10 != n12) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a * 31;
        int n11 = this.b;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cmd{code=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", param=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

