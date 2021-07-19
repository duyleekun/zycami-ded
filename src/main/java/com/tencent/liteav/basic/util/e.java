/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

public class e {
    public int a;
    public int b;

    public e() {
    }

    public e(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof e;
        if (n11 == 0) {
            return false;
        }
        object = (e)object;
        n11 = ((e)object).a;
        int n12 = this.a;
        if (n11 != n12 || (n10 = ((e)object).b) != (n11 = this.b)) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a * 32713;
        int n11 = this.b;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size(");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

