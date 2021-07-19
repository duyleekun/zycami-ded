/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1.e0;

import androidx.fragment.app.FragmentManager;
import d.v.c.l1.e0.b;
import d.v.f.f.a;

public class b$a {
    private String a;
    private String b;
    private String c;
    private String d;
    private a e;
    private a f;

    public b a() {
        b b10 = new b();
        Object object = this.a;
        b10.y((String)object);
        object = this.b;
        b10.v((String)object);
        object = this.c;
        b10.w((String)object);
        object = this.d;
        a a10 = this.e;
        b10.u((String)object, a10);
        object = this.f;
        b10.x((a)object);
        return b10;
    }

    public b$a b(String string2, a a10) {
        this.d = string2;
        this.e = a10;
        return this;
    }

    public b$a c(String string2) {
        this.c = string2;
        return this;
    }

    public b$a d(String string2) {
        this.b = string2;
        return this;
    }

    public b$a e(a a10) {
        this.f = a10;
        return this;
    }

    public b$a f(String string2) {
        this.a = string2;
        return this;
    }

    public b g(FragmentManager fragmentManager) {
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
        b b10 = this.a();
        b10.q(fragmentManager);
        return b10;
    }
}

