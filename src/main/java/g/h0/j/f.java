/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;

public final class f {
    public static final f a;

    static {
        f f10;
        a = f10 = new f();
    }

    private f() {
    }

    public static final boolean b(String string2) {
        boolean bl2;
        f0.p(string2, "method");
        String string3 = "GET";
        boolean bl3 = f0.g(string2, string3);
        if (!bl3 && !(bl2 = f0.g(string2, string3 = "HEAD"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public static final boolean e(String string2) {
        boolean bl2;
        f0.p(string2, "method");
        String string3 = "POST";
        boolean bl3 = f0.g(string2, string3);
        if (!(bl3 || (bl3 = f0.g(string2, string3 = "PUT")) || (bl3 = f0.g(string2, string3 = "PATCH")) || (bl3 = f0.g(string2, string3 = "PROPPATCH")) || (bl2 = f0.g(string2, string3 = "REPORT")))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean a(String string2) {
        boolean bl2;
        f0.p(string2, "method");
        String string3 = "POST";
        boolean bl3 = f0.g(string2, string3);
        if (!(bl3 || (bl3 = f0.g(string2, string3 = "PATCH")) || (bl3 = f0.g(string2, string3 = "PUT")) || (bl3 = f0.g(string2, string3 = "DELETE")) || (bl2 = f0.g(string2, string3 = "MOVE")))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final boolean c(String string2) {
        f0.p(string2, "method");
        return f0.g(string2, "PROPFIND") ^ true;
    }

    public final boolean d(String string2) {
        f0.p(string2, "method");
        return f0.g(string2, "PROPFIND");
    }
}

