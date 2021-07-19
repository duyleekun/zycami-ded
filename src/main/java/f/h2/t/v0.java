/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.n0;
import f.h2.t.v0$a;
import f.m2.s;
import f.x1.t;
import java.util.List;
import kotlin.reflect.KVariance;

public final class v0
implements s {
    public static final v0$a f;
    private volatile List a;
    private final Object b;
    private final String c;
    private final KVariance d;
    private final boolean e;

    static {
        v0$a v0$a;
        f = v0$a = new v0$a(null);
    }

    public v0(Object object, String string2, KVariance kVariance, boolean bl2) {
        f0.p(string2, "name");
        f0.p((Object)kVariance, "variance");
        this.b = object;
        this.c = string2;
        this.d = kVariance;
        this.e = bl2;
    }

    public static /* synthetic */ void e() {
    }

    public boolean d() {
        return this.e;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof v0;
        if (!bl2) return false;
        Object object2 = this.b;
        object = (v0)object;
        Object object3 = ((v0)object).b;
        bl2 = f0.g(object2, object3);
        if (!bl2) return false;
        object2 = this.getName();
        boolean bl3 = f0.g(object2, object = ((v0)object).getName());
        if (!bl3) return false;
        return true;
    }

    public String getName() {
        return this.c;
    }

    public List getUpperBounds() {
        List list = this.a;
        if (list == null) {
            this.a = list = t.k(n0.l(Object.class));
        }
        return list;
    }

    public KVariance h() {
        return this.d;
    }

    public int hashCode() {
        int n10;
        Object object = this.b;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        int n11 = this.getName().hashCode();
        return (n10 *= 31) + n11;
    }

    public final void j(List object) {
        f0.p(object, "upperBounds");
        Object object2 = this.a;
        if (object2 == null) {
            this.a = object;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Upper bounds of type parameter '");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append("' have already been initialized.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public String toString() {
        return f.a(this);
    }
}

