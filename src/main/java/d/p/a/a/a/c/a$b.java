/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import d.p.a.a.a.c.a;
import d.p.a.a.a.c.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public final class a$b
implements GenericArrayType {
    private final Type a;

    public a$b(Type type) {
        this.a = type = d.p.a.a.a.c.a.a(type);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof GenericArrayType;
        if (bl3 && (bl2 = b.a(this, (Type)(object = (GenericArrayType)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type getGenericComponentType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = d.p.a.a.a.c.a.d(this.a);
        stringBuilder.append(string2);
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }
}

