/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.a;

import androidx.lifecycle.LiveData;
import d.v.c.v0.r.a.a$a;
import d.v.c.v0.r.a.a$b;
import d.v.c.v0.r.a.b;
import d.v.c.v0.r.b.g;
import d.v.e.l.c1;
import java.util.Map;

public class a
implements b {
    private g a;
    private d.v.c.v0.r.c.a b;
    private c1 c;

    public a() {
        Object object = g.k();
        this.a = object;
        this.b = object = d.v.c.v0.r.c.a.a();
        this.c = object = c1.b();
    }

    public static /* synthetic */ g r(a a10) {
        return a10.a;
    }

    public static /* synthetic */ d.v.c.v0.r.c.a s(a a10) {
        return a10.b;
    }

    private LiveData t(boolean bl2, int n10, int n11) {
        c1 c12 = this.c;
        a$a a$a = new a$a(this, c12, bl2, n10, n11);
        return a$a.d();
    }

    public static a u() {
        return a$b.a();
    }

    public LiveData a(boolean bl2, int n10, int n11) {
        return this.t(bl2, n10, n11);
    }

    public LiveData b(boolean bl2, Map object) {
        String string2 = (String)object.get("page");
        object = (String)object.get("pageSize");
        if (string2 != null && object != null) {
            int n10;
            try {
                n10 = Integer.parseInt(string2);
            }
            catch (Exception exception) {}
            int n11 = Integer.parseInt((String)object);
            return this.a(bl2, n10, n11);
        }
        return null;
    }

    public void d() {
    }

    public LiveData m() {
        return this.a.f();
    }

    public void release() {
    }

    public void updateFilterPath(String string2, String string3) {
        this.a.H(string2, string3);
    }

    public void updateFilterThumbPath(String string2, String string3) {
        this.a.I(string2, string3);
    }
}

