/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.m2.v;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.reflect.TypesJVMKt;

public final class a
implements GenericArrayType,
v {
    private final Type a;

    public a(Type type) {
        f0.p(type, "elementType");
        this.a = type;
    }

    public boolean equals(Object object) {
        Type type;
        boolean bl2;
        boolean bl3 = object instanceof GenericArrayType;
        if (bl3 && (bl2 = f0.g(type = this.getGenericComponentType(), object = ((GenericArrayType)object).getGenericComponentType()))) {
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

    public String getTypeName() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = TypesJVMKt.b(this.a);
        stringBuilder.append(string2);
        stringBuilder.append("[]");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return this.getGenericComponentType().hashCode();
    }

    public String toString() {
        return this.getTypeName();
    }
}

