/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

public class d$a
implements Comparable {
    public String a;
    public int b;
    public long c;

    public d$a(String string2, int n10, long l10) {
        this.a = string2;
        this.b = n10;
        this.c = l10 /= 1000000L;
    }

    public int a(d$a d$a) {
        int n10;
        int n11 = Math.abs(this.b);
        if (n11 > (n10 = Math.abs(d$a.b))) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (d$a)object;
        return this.a((d$a)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a.toUpperCase();
        stringBuilder.append(string2);
        string2 = ";";
        stringBuilder.append(string2);
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(string2);
        long l10 = this.c;
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }
}

