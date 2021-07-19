/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.z;

import androidx.lifecycle.LiveData;
import d.v.c.v0.z.b$a;
import d.v.c.v0.z.b$b;
import d.v.c.v0.z.d.a;
import d.v.e.l.c1;
import java.util.Map;

public class b
implements d.v.c.v0.z.a {
    private d.v.c.v0.z.c.b a;
    private a b;
    private c1 c;

    public b() {
        Object object = d.v.c.v0.z.c.b.f();
        this.a = object;
        this.b = object = d.v.c.v0.z.d.a.a();
        this.c = object = c1.b();
    }

    public static /* synthetic */ d.v.c.v0.z.c.b r(b b10) {
        return b10.a;
    }

    public static /* synthetic */ a s(b b10) {
        return b10.b;
    }

    private LiveData t(boolean bl2, int n10, int n11) {
        c1 c12 = this.c;
        b$a b$a = new b$a(this, c12, bl2, n10, n11);
        return b$a.d();
    }

    public static b u() {
        return b$b.a();
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

    public LiveData f() {
        return this.a.d();
    }

    public void release() {
    }

    public void updateTransitionPath(String string2, String string3) {
        this.a.n(string2, string3);
    }
}

