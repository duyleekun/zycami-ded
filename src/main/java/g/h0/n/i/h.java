/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.i.h$a;
import java.lang.reflect.Method;

public final class h {
    public static final h$a d;
    private final Method a;
    private final Method b;
    private final Method c;

    static {
        h$a h$a;
        d = h$a = new h$a(null);
    }

    public h(Method method, Method method2, Method method3) {
        this.a = method;
        this.b = method2;
        this.c = method3;
    }

    public final Object a(String string2) {
        f0.p(string2, "closer");
        Object object = this.a;
        if (object != null) {
            Object object2;
            try {
                object2 = new Object[]{};
            }
            catch (Exception exception) {}
            object = ((Method)object).invoke(null, (Object[])object2);
            object2 = this.b;
            f0.m(object2);
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            ((Method)object2).invoke(object, objectArray);
            return object;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean b(Object object) {
        Method method;
        boolean bl2 = false;
        if (object == null) return bl2;
        try {
            method = this.c;
        }
        catch (Exception exception) {
            return bl2;
        }
        f0.m(method);
        Object[] objectArray = new Object[]{};
        method.invoke(object, objectArray);
        return true;
    }
}

