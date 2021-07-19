/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.i.f;
import g.h0.n.i.f$a$a;
import g.h0.n.i.j$a;

public final class f$a {
    private f$a() {
    }

    public /* synthetic */ f$a(u u10) {
        this();
    }

    public static final /* synthetic */ f a(f$a f$a, Class clazz) {
        return f$a.b(clazz);
    }

    private final f b(Class object) {
        String string2;
        CharSequence charSequence;
        boolean bl2;
        Object object2 = object;
        while (object2 != null && (bl2 = f0.g(charSequence = ((Class)object2).getSimpleName(), string2 = "OpenSSLSocketImpl") ^ true)) {
            if ((object2 = ((Class)object2).getSuperclass()) != null) continue;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("No OpenSSLSocketImpl superclass of socket of type ");
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            object2 = new AssertionError(object);
            throw object2;
        }
        f0.m(object2);
        object = new f((Class)object2);
        return object;
    }

    public final j$a c(String string2) {
        f0.p(string2, "packageName");
        f$a$a f$a$a = new f$a$a(string2);
        return f$a$a;
    }

    public final j$a d() {
        return f.g();
    }
}

