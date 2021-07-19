/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import java.util.Map;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$g
extends n {
    private final Method a;
    private final int b;
    private final h c;

    public n$g(Method method, int n10, h h10) {
        this.a = method;
        this.b = n10;
        this.c = h10;
    }

    public void d(p object, Map object2) {
        Object[] objectArray = null;
        if (object2 != null) {
            boolean bl2;
            object2 = object2.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Object object3 = (Map.Entry)object2.next();
                String string2 = (String)object3.getKey();
                if (string2 != null) {
                    if ((object3 = object3.getValue()) != null) {
                        h h10 = this.c;
                        object3 = (String)h10.convert(object3);
                        ((p)object).b(string2, (String)object3);
                        continue;
                    }
                    object = this.a;
                    int n10 = this.b;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Header map contained null value for key '");
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append("'.");
                    object3 = ((StringBuilder)object3).toString();
                    objectArray = new Object[]{};
                    throw w.o((Method)object, n10, (String)object3, objectArray);
                }
                object = this.a;
                int n11 = this.b;
                objectArray = new Object[]{};
                throw w.o((Method)object, n11, "Header map contained null key.", objectArray);
            }
            return;
        }
        object = this.a;
        int n12 = this.b;
        objectArray = new Object[]{};
        throw w.o((Method)object, n12, "Header map was null.", objectArray);
    }
}

