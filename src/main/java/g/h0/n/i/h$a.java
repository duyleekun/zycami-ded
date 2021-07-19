/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.u;
import g.h0.n.i.h;
import java.lang.reflect.Method;

public final class h$a {
    private h$a() {
    }

    public /* synthetic */ h$a(u u10) {
        this();
    }

    public final h a() {
        Object object = null;
        Object object2 = "dalvik.system.CloseGuard";
        object2 = Class.forName((String)object2);
        Object object3 = "get";
        Class[] classArray = null;
        Object object4 = new Class[]{};
        object3 = ((Class)object2).getMethod((String)object3, (Class<?>)object4);
        object4 = "open";
        int n10 = 1;
        Object object5 = new Class[n10];
        Class<String> clazz = String.class;
        object5[0] = clazz;
        object4 = ((Class)object2).getMethod((String)object4, (Class<?>)object5);
        object5 = "warnIfOpen";
        classArray = new Class[]{};
        try {
            object2 = ((Class)object2).getMethod((String)object5, classArray);
            object = object3;
        }
        catch (Exception exception) {
            object2 = null;
            object4 = null;
        }
        object3 = new h((Method)object, (Method)object4, (Method)object2);
        return object3;
    }
}

