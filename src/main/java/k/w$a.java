/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import k.w;

public final class w$a
implements GenericArrayType {
    private final Type a;

    public w$a(Type type) {
        this.a = type;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof GenericArrayType;
        if (bl3 && (bl2 = w.d(this, (Type)(object = (GenericArrayType)object)))) {
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
        String string2 = w.t(this.a);
        stringBuilder.append(string2);
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }
}

