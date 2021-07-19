/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import java.util.Objects;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$k
extends n {
    private final Method a;
    private final int b;
    private final String c;
    private final h d;
    private final boolean e;

    public n$k(Method method, int n10, String string2, h h10, boolean bl2) {
        this.a = method;
        this.b = n10;
        Objects.requireNonNull(string2, "name == null");
        this.c = string2;
        this.d = h10;
        this.e = bl2;
    }

    public void a(p object, Object object2) {
        if (object2 != null) {
            String string2 = this.c;
            object2 = (String)this.d.convert(object2);
            boolean bl2 = this.e;
            ((p)object).f(string2, (String)object2, bl2);
            return;
        }
        object = this.a;
        int n10 = this.b;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Path parameter \"");
        Object[] objectArray = this.c;
        charSequence.append((String)objectArray);
        charSequence.append("\" value must not be null.");
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        throw w.o((Method)object, n10, (String)charSequence, objectArray);
    }
}

