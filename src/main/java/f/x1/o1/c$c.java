/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.g$a;
import f.x1.o1.c;
import java.util.Map;

public final class c$c
implements Map.Entry,
g$a {
    private final c a;
    private final int b;

    public c$c(c c10, int n10) {
        f0.p(c10, "map");
        this.a = c10;
        this.b = n10;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3 = object instanceof Map.Entry;
        if (bl3 && (bl3 = f0.g(object3 = (object = (Map.Entry)object).getKey(), object2 = this.getKey())) && (bl2 = f0.g(object = object.getValue(), object3 = this.getValue()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Object getKey() {
        Object[] objectArray = c.c(this.a);
        int n10 = this.b;
        return objectArray[n10];
    }

    public Object getValue() {
        Object[] objectArray = c.g(this.a);
        f0.m(objectArray);
        int n10 = this.b;
        return objectArray[n10];
    }

    public int hashCode() {
        int n10;
        Object object = this.getKey();
        int n11 = 0;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        Object object2 = this.getValue();
        if (object2 != null) {
            n11 = object2.hashCode();
        }
        return n10 ^ n11;
    }

    public Object setValue(Object object) {
        this.a.p();
        Object[] objectArray = c.b(this.a);
        int n10 = this.b;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        return object2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getKey();
        stringBuilder.append(object);
        stringBuilder.append('=');
        object = this.getValue();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

