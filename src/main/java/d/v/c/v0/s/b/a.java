/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.s.b;

import androidx.lifecycle.LiveData;
import d.v.c.v0.s.b.a$a;
import d.v.c.v0.s.b.a$b;
import d.v.c.v0.s.b.b;
import d.v.c.v0.s.c.e;
import d.v.e.l.c1;
import java.util.Map;

public class a
implements b {
    private final e a;
    private final d.v.c.v0.s.d.a b;
    private c1 c;

    public a() {
        Object object = c1.b();
        this.c = object;
        this.a = object = e.k();
        this.b = object = d.v.c.v0.s.d.a.a();
    }

    public static /* synthetic */ e r(a a10) {
        return a10.a;
    }

    public static /* synthetic */ d.v.c.v0.s.d.a s(a a10) {
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
            int n10 = Integer.parseInt(string2);
            int n11 = Integer.parseInt((String)object);
            try {
                return this.a(bl2, n10, n11);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public void d() {
    }

    public LiveData n() {
        return this.a.h();
    }

    public void release() {
    }

    public void updateFontPath(String string2, String string3) {
        this.a.D(string2, string3);
    }
}

