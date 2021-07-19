/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.a;

import androidx.lifecycle.LiveData;
import d.v.c.v0.y.a.a;
import d.v.c.v0.y.a.b$a;
import d.v.c.v0.y.a.b$b;
import d.v.c.v0.y.a.b$c;
import d.v.c.v0.y.b.e;
import d.v.e.l.c1;
import java.util.Map;

public class b
implements a {
    private e a;
    private d.v.c.v0.y.c.a b;
    private c1 c;

    public b() {
        Object object = e.l();
        this.a = object;
        this.b = object = d.v.c.v0.y.c.a.a();
        this.c = object = c1.b();
    }

    public static /* synthetic */ e r(b b10) {
        return b10.a;
    }

    public static /* synthetic */ d.v.c.v0.y.c.a s(b b10) {
        return b10.b;
    }

    private LiveData t(boolean bl2, int n10, int n11) {
        c1 c12 = this.c;
        b$b b$b = new b$b(this, c12, bl2, n10, n11);
        return b$b.d();
    }

    private LiveData u(boolean bl2, int n10, int n11, int n12) {
        c1 c12 = this.c;
        b$a b$a = new b$a(this, c12, n12, bl2, n10, n11);
        return b$a.d();
    }

    public static b v() {
        return b$c.a();
    }

    public LiveData a(boolean bl2, int n10, int n11) {
        return this.t(bl2, n10, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public LiveData b(boolean bl2, Map object) {
        String string2 = (String)object.get("page");
        String string3 = (String)object.get("pageSize");
        if (string2 == null) return null;
        if (string3 == null) {
            return null;
        }
        String string4 = "typeId";
        object = (String)object.get(string4);
        try {
            int n10 = Integer.parseInt(string2);
            int n11 = Integer.parseInt(string3);
            if (object == null) {
                return this.a(bl2, n10, n11);
            }
            int n12 = Integer.parseInt((String)object);
            return this.l(bl2, n10, n11, n12);
        }
        catch (Exception exception) {}
        return null;
    }

    public void d() {
    }

    public LiveData l(boolean bl2, int n10, int n11, int n12) {
        return this.u(bl2, n10, n11, n12);
    }

    public LiveData p() {
        return this.a.h();
    }

    public void release() {
    }

    public void updateStickerPath(String string2, String string3) {
        this.a.B(string2, string3);
    }
}

