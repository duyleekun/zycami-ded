/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gh$a {
    public static final gh$a a;
    public static final gh$a b;
    public static final gh$a c;
    public static final gh$a d;
    public static final gh$a e;
    private String a;

    static {
        gh$a gh$a;
        a = gh$a = new gh$a("get");
        b = gh$a = new gh$a("set");
        c = gh$a = new gh$a("result");
        d = gh$a = new gh$a("error");
        e = gh$a = new gh$a("command");
    }

    private gh$a(String string2) {
        this.a = string2;
    }

    public static gh$a a(String string2) {
        if (string2 == null) {
            return null;
        }
        string2 = string2.toLowerCase();
        gh$a gh$a = a;
        String string3 = gh$a.toString();
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return gh$a;
        }
        gh$a = b;
        string3 = gh$a.toString();
        bl2 = string3.equals(string2);
        if (bl2) {
            return gh$a;
        }
        gh$a = d;
        string3 = gh$a.toString();
        bl2 = string3.equals(string2);
        if (bl2) {
            return gh$a;
        }
        gh$a = c;
        string3 = gh$a.toString();
        bl2 = string3.equals(string2);
        if (bl2) {
            return gh$a;
        }
        gh$a = e;
        string3 = gh$a.toString();
        boolean bl3 = string3.equals(string2);
        if (bl3) {
            return gh$a;
        }
        return null;
    }

    public String toString() {
        return this.a;
    }
}

