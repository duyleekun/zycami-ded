/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 */
package d.r.a;

import android.content.Intent;
import android.os.Bundle;
import d.r.a.g;
import d.r.a.p;
import d.r.a.u.s;

public abstract class o {
    public int a;
    public String b;

    public o(int n10) {
        int n11;
        this.a = n11 = -1;
        if (n10 >= 0) {
            this.a = n10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("PushCommand: the value of command must > 0.");
        throw illegalArgumentException;
    }

    private final void f(g g10) {
        int n10 = this.a;
        g10.c("command", n10);
        String string2 = this.b;
        g10.f("client_pkgname", string2);
        this.d(g10);
    }

    public final void a(Intent intent) {
        g g10 = g.a(intent);
        if (g10 == null) {
            s.h("PushCommand", "bundleWapper is null");
            return;
        }
        int n10 = this.a;
        String string2 = "method";
        g10.c(string2, n10);
        this.f(g10);
        g10 = g10.a;
        if (g10 != null) {
            intent.putExtras((Bundle)g10);
        }
    }

    public final void b(g g10) {
        int n10 = this.a;
        String string2 = p.a(n10);
        if (string2 == null) {
            string2 = "";
        }
        g10.f("method", string2);
        this.f(g10);
    }

    public boolean c() {
        return false;
    }

    public abstract void d(g var1);

    public abstract void e(g var1);

    public String toString() {
        return this.getClass().getSimpleName();
    }
}

