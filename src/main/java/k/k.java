/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class k {
    private final Method a;
    private final List b;

    public k(Method object, List list) {
        this.a = object;
        this.b = object = Collections.unmodifiableList(list);
    }

    public static k c(Method method, List list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        ArrayList arrayList = new ArrayList(list);
        k k10 = new k(method, arrayList);
        return k10;
    }

    public List a() {
        return this.b;
    }

    public Method b() {
        return this.a;
    }

    public String toString() {
        Object object = this.a.getDeclaringClass().getName();
        Object[] objectArray = new Object[]{object, object = this.a.getName(), object = this.b};
        return String.format("%s.%s() %s", objectArray);
    }
}

