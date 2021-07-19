/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.a0;
import g.t;
import java.net.Proxy;

public final class i {
    public static final i a;

    static {
        i i10;
        a = i10 = new i();
    }

    private i() {
    }

    private final boolean b(a0 object, Proxy.Type type) {
        boolean bl2 = object.l();
        if (!bl2 && type == (object = Proxy.Type.HTTP)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final String a(a0 object, Proxy.Type type) {
        f0.p(object, "request");
        f0.p((Object)type, "proxyType");
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = ((a0)object).m();
        stringBuilder.append((String)object2);
        char c10 = ' ';
        stringBuilder.append(c10);
        object2 = a;
        boolean bl2 = super.b((a0)object, type);
        if (bl2) {
            object = ((a0)object).q();
            stringBuilder.append(object);
        } else {
            object = ((a0)object).q();
            object = ((i)object2).c((t)object);
            stringBuilder.append((String)object);
        }
        stringBuilder.append(" HTTP/1.1");
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final String c(t object) {
        f0.p(object, "url");
        String string2 = ((t)object).x();
        object = ((t)object).z();
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            char c10 = '?';
            stringBuilder.append(c10);
            stringBuilder.append((String)object);
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

