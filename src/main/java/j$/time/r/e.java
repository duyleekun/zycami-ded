/*
 * Decompiled with CFR 0.151.
 */
package j$.time.r;

import j$.time.r.f;
import j$.time.r.g;
import java.security.PrivilegedAction;
import java.util.List;

class e
implements PrivilegedAction {
    final /* synthetic */ List a;

    e(List list) {
        this.a = list;
    }

    public Object run() {
        Object object = g.class;
        Object object2 = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (object2 != null) {
            ClassLoader classLoader;
            boolean bl2 = true;
            try {
                classLoader = ((Class)object).getClassLoader();
            }
            catch (Exception exception) {
                object2 = new Error(exception);
                throw object2;
            }
            object2 = Class.forName((String)object2, bl2, classLoader);
            object2 = ((Class)object2).newInstance();
            object = ((Class)object).cast(object2);
            object = (g)object;
            g.d((g)object);
            object2 = this.a;
            object2.add(object);
        } else {
            object = new f();
            g.d((g)object);
        }
        return null;
    }
}

