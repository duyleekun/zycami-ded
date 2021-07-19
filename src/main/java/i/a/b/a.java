/*
 * Decompiled with CFR 0.151.
 */
package i.a.b;

import i.a.a.c;

public class a
extends i.a.a.a
implements c {
    private final String c;

    public a(int n10, int n11, String string2) {
        super(n10, n11);
        this.c = string2;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append("=");
        string2 = this.c;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

