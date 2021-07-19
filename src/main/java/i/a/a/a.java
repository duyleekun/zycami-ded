/*
 * Decompiled with CFR 0.151.
 */
package i.a.a;

import i.a.a.c;

public class a
implements c {
    private int a;
    private int b;

    public a(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public boolean a(int n10) {
        int n11 = this.a;
        n10 = n11 <= n10 && n10 <= (n11 = this.b) ? 1 : 0;
        return n10 != 0;
    }

    public boolean b(a a10) {
        int n10;
        int n11 = this.a;
        int n12 = a10.getEnd();
        if (n11 <= n12 && (n11 = this.b) >= (n10 = a10.getStart())) {
            n10 = 1;
        } else {
            n10 = 0;
            a10 = null;
        }
        return n10 != 0;
    }

    public int compareTo(Object object) {
        int n10 = object instanceof c;
        if (n10 == 0) {
            return -1;
        }
        object = (c)object;
        n10 = this.a;
        int n11 = object.getStart();
        if ((n10 -= n11) == 0) {
            n10 = this.b;
            int n12 = object.getEnd();
            n10 -= n12;
        }
        return n10;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof c;
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        n11 = this.a;
        int n12 = (object = (c)object).getStart();
        if (n11 == n12 && (n11 = this.b) == (n10 = object.getEnd())) {
            bl2 = true;
        }
        return bl2;
    }

    public int getEnd() {
        return this.b;
    }

    public int getStart() {
        return this.a;
    }

    public int hashCode() {
        int n10 = this.a % 100;
        int n11 = this.b % 100;
        return n10 + n11;
    }

    public int size() {
        int n10 = this.b;
        int n11 = this.a;
        return n10 - n11 + 1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(":");
        n10 = this.b;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

