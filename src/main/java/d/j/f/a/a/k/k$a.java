/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.k;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

public class k$a
implements PrivilegedAction {
    public Method a;

    public k$a(Method method) {
        this.a = method;
    }

    public Object run() {
        Method method = this.a;
        if (method == null) {
            return null;
        }
        method.setAccessible(true);
        return null;
    }
}

