/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1.e0;

import androidx.fragment.app.FragmentManager;
import d.v.c.l1.e0.c;

public class c$a {
    private String a;
    private boolean b;

    public c a() {
        c c10 = new c();
        String string2 = this.a;
        c10.u(string2);
        boolean bl2 = this.b;
        if (bl2) {
            c10.v();
        }
        return c10;
    }

    public c$a b(String string2) {
        this.a = string2;
        return this;
    }

    public c$a c() {
        this.b = true;
        return this;
    }

    public c d(FragmentManager fragmentManager) {
        block4: {
            try {
                boolean bl2 = fragmentManager.isDestroyed();
                if (!bl2) break block4;
                return null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        c c10 = this.a();
        c10.q(fragmentManager);
        return c10;
    }
}

