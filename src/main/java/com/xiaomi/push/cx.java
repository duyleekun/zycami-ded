/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.net.InetSocketAddress;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class cx {
    private int a;
    private String a;

    public cx(String string2, int n10) {
        this.a = string2;
        this.a = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static cx a(String string2, int n10) {
        int n11;
        String string3 = ":";
        int n12 = string2.lastIndexOf(string3);
        if (n12 == (n11 = -1)) return new cx(string2, n10);
        n11 = 0;
        String string4 = string2.substring(0, n12);
        ++n12;
        try {
            string2 = string2.substring(n12);
            int n13 = Integer.parseInt(string2);
            if (n13 > 0) {
                n10 = n13;
            }
        }
        catch (NumberFormatException numberFormatException) {}
        string2 = string4;
        return new cx(string2, n10);
    }

    public static InetSocketAddress a(String object, int n10) {
        object = cx.a((String)object, n10);
        String string2 = ((cx)object).a();
        int n11 = ((cx)object).a();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(string2, n11);
        return inetSocketAddress;
    }

    public int a() {
        return this.a;
    }

    public String a() {
        return this.a;
    }

    public String toString() {
        int n10 = this.a;
        if (n10 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = this.a;
            stringBuilder.append(string2);
            stringBuilder.append(":");
            int n11 = this.a;
            stringBuilder.append(n11);
            return stringBuilder.toString();
        }
        return this.a;
    }
}

