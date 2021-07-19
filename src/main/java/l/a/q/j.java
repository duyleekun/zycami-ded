/*
 * Decompiled with CFR 0.151.
 */
package l.a.q;

public abstract class j {
    public static final String a = "1";
    public static final int b;

    public static final int b(int n10) {
        String string2;
        String string3 = Integer.toHexString(n10);
        boolean bl2 = string3.startsWith(string2 = a);
        if (bl2) {
            n10 = 0;
        }
        return n10;
    }

    public abstract void a();
}

