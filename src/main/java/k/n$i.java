/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.b0;
import g.s;
import java.io.IOException;
import java.lang.reflect.Method;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$i
extends n {
    private final Method a;
    private final int b;
    private final s c;
    private final h d;

    public n$i(Method method, int n10, s s10, h h10) {
        this.a = method;
        this.b = n10;
        this.c = s10;
        this.d = h10;
    }

    public void a(p p10, Object object) {
        Object object2;
        if (object == null) {
            return;
        }
        try {
            object2 = this.d;
        }
        catch (IOException iOException) {
            object2 = this.a;
            int n10 = this.b;
            Object[] objectArray = new StringBuilder();
            objectArray.append("Unable to convert ");
            objectArray.append(object);
            objectArray.append(" to RequestBody");
            object = objectArray.toString();
            objectArray = new Object[]{iOException};
            throw w.o((Method)object2, n10, (String)object, objectArray);
        }
        object2 = object2.convert(object);
        object2 = (b0)object2;
        object = this.c;
        p10.d((s)object, (b0)object2);
    }
}

