/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

public class l0 {
    private boolean a;
    private String b;
    private Object c;

    public l0(boolean bl2) {
        this.a = bl2;
    }

    public l0(boolean bl2, Object object) {
        this.a = bl2;
        this.c = object;
    }

    public l0(boolean bl2, String string2) {
        this.a = bl2;
        this.b = string2;
    }

    public Object a() {
        return this.c;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.a;
    }

    public void d(Object object) {
        this.c = object;
    }

    public l0 e(String string2) {
        this.b = string2;
        return this;
    }

    public l0 f(boolean bl2) {
        this.a = bl2;
        return this;
    }
}

