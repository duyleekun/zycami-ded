/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

public class c {
    public static c d;
    private String a;
    private Throwable b;
    private Object[] c;

    static {
        c c10;
        d = c10 = new c(null);
    }

    public c(String string2) {
        this(string2, null, null);
    }

    public c(String string2, Object[] objectArray, Throwable throwable) {
        this.a = string2;
        this.b = throwable;
        this.c = objectArray;
    }

    public Object[] a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public Throwable c() {
        return this.b;
    }
}

