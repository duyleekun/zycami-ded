/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.h;
import g.h0.n.i.k;
import g.h0.n.i.l;

public final class l$a {
    private l$a() {
    }

    public /* synthetic */ l$a(u u10) {
        this();
    }

    public static /* synthetic */ k b(l$a l$a, String string2, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            string2 = "com.android.org.conscrypt";
        }
        return l$a.a(string2);
    }

    public final k a(String clazz) {
        Object object;
        Object object2;
        block21: {
            block22: {
                object2 = "packageName";
                f0.p(clazz, (String)object2);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)((Object)clazz));
                Object object3 = ".OpenSSLSocketImpl";
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                object2 = Class.forName((String)object2);
                if (object2 == null) break block21;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)((Object)clazz));
                object = ".OpenSSLSocketFactoryImpl";
                ((StringBuilder)object3).append((String)object);
                object3 = ((StringBuilder)object3).toString();
                object3 = Class.forName((String)object3);
                if (object3 == null) break block22;
                object = new StringBuilder();
                ((StringBuilder)object).append((String)((Object)clazz));
                clazz = ".SSLParametersImpl";
                ((StringBuilder)object).append((String)((Object)clazz));
                clazz = ((StringBuilder)object).toString();
                clazz = Class.forName((String)((Object)clazz));
                String string2 = "paramsClass";
                f0.o(clazz, string2);
                object = new l((Class)object2, (Class)object3, clazz);
            }
            object2 = "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>";
            clazz = new Class((String)object2);
            throw clazz;
        }
        object2 = "null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>";
        try {
            clazz = new Class((String)object2);
            throw clazz;
        }
        catch (Exception exception) {
            object2 = h.e.g();
            int n10 = 5;
            ((h)object2).m("unable to load android socket classes", n10, exception);
            object = null;
        }
        return object;
    }
}

