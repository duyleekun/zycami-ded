/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import k.w;

public final class w$b
implements ParameterizedType {
    private final Type a;
    private final Type b;
    private final Type[] c;

    public w$b(Type object, Type type, Type ... typeArray) {
        Class<?> clazz;
        Type type2;
        int n10 = type instanceof Class;
        int n11 = 0;
        if (n10 != 0) {
            int n12;
            n10 = 1;
            if (object == null) {
                n12 = n10;
            } else {
                n12 = 0;
                type2 = null;
            }
            clazz = type;
            clazz = ((Class)type).getEnclosingClass();
            if (clazz != null) {
                n10 = 0;
            }
            if (n12 != n10) {
                throw object;
            }
        }
        n10 = typeArray.length;
        while (n11 < n10) {
            type2 = typeArray[n11];
            clazz = "typeArgument == null";
            Objects.requireNonNull(type2, clazz);
            w.b(type2);
            ++n11;
        }
        this.a = object;
        this.b = type;
        object = (Type[])typeArray.clone();
        this.c = object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof ParameterizedType;
        if (bl3 && (bl2 = w.d(this, (Type)(object = (ParameterizedType)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type[] getActualTypeArguments() {
        return (Type[])this.c.clone();
    }

    public Type getOwnerType() {
        return this.a;
    }

    public Type getRawType() {
        return this.b;
    }

    public int hashCode() {
        Object[] objectArray = this.c;
        int n10 = Arrays.hashCode(objectArray);
        int n11 = this.b.hashCode();
        n10 ^= n11;
        Type type = this.a;
        if (type != null) {
            n11 = type.hashCode();
        } else {
            n11 = 0;
            type = null;
        }
        return n10 ^ n11;
    }

    public String toString() {
        int n10;
        Object object = this.c;
        int n11 = ((Type[])object).length;
        if (n11 == 0) {
            return w.t(this.b);
        }
        int n12 = ((Type[])object).length;
        n12 = (n12 + n10) * 30;
        StringBuilder stringBuilder = new StringBuilder(n12);
        object = w.t(this.b);
        stringBuilder.append((String)object);
        stringBuilder.append("<");
        object = w.t(this.c[0]);
        stringBuilder.append((String)object);
        for (n10 = 1; n10 < (n12 = ((Type[])(object = this.c)).length); ++n10) {
            stringBuilder.append(", ");
            object = w.t(this.c[n10]);
            stringBuilder.append((String)object);
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}

