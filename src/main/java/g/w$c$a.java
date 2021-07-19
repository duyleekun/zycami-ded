/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.b0;
import g.b0$a;
import g.s;
import g.s$a;
import g.w;
import g.w$b;
import g.w$c;

public final class w$c$a {
    private w$c$a() {
    }

    public /* synthetic */ w$c$a(u u10) {
        this();
    }

    public final w$c a(s object, b0 object2) {
        boolean bl2;
        Object object3;
        f0.p(object2, "body");
        if (object != null) {
            object3 = ((s)object).e("Content-Type");
        } else {
            bl2 = false;
            object3 = null;
        }
        boolean bl3 = true;
        if (object3 == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object3 = null;
        }
        if (bl2) {
            if (object != null) {
                object3 = ((s)object).e("Content-Length");
            } else {
                bl2 = false;
                object3 = null;
            }
            if (object3 != null) {
                bl3 = false;
            }
            if (bl3) {
                object3 = new w$c((s)object, (b0)object2, null);
                return object3;
            }
            object2 = "Unexpected header: Content-Length".toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object2 = "Unexpected header: Content-Type".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public final w$c b(b0 b02) {
        f0.p(b02, "body");
        return this.a(null, b02);
    }

    public final w$c c(String string2, String object) {
        f0.p(string2, "name");
        f0.p(object, "value");
        object = b0$a.o(b0.Companion, (String)object, null, 1, null);
        return this.d(string2, null, (b0)object);
    }

    public final w$c d(String object, String object2, b0 b02) {
        f0.p(object, "name");
        f0.p(b02, "body");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=");
        w$b w$b = w.n;
        w$b.a(stringBuilder, (String)object);
        if (object2 != null) {
            object = "; filename=";
            stringBuilder.append((String)object);
            w$b.a(stringBuilder, (String)object2);
        }
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        object2 = new s$a();
        object = ((s$a)object2).h("Content-Disposition", (String)object).i();
        return this.a((s)object, b02);
    }
}

