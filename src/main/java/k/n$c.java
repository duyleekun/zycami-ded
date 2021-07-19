/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.b0;
import java.io.IOException;
import java.lang.reflect.Method;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$c
extends n {
    private final Method a;
    private final int b;
    private final h c;

    public n$c(Method method, int n10, h h10) {
        this.a = method;
        this.b = n10;
        this.c = h10;
    }

    public void a(p object, Object object2) {
        Object[] objectArray = null;
        if (object2 != null) {
            Object object3;
            try {
                object3 = this.c;
            }
            catch (IOException iOException) {
                object3 = this.a;
                int n10 = this.b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to convert ");
                stringBuilder.append(object2);
                stringBuilder.append(" to RequestBody");
                object2 = stringBuilder.toString();
                objectArray = new Object[]{};
                throw w.p((Method)object3, iOException, n10, (String)object2, objectArray);
            }
            object3 = object3.convert(object2);
            object3 = (b0)object3;
            ((p)object).l((b0)object3);
            return;
        }
        object = this.a;
        int n11 = this.b;
        objectArray = new Object[]{};
        throw w.o((Method)object, n11, "Body parameter value must not be null.", objectArray);
    }
}

