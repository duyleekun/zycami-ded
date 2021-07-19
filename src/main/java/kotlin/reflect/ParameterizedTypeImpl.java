/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

import f.h2.t.f0;
import f.m2.v;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1;
import kotlin.reflect.TypesJVMKt;

public final class ParameterizedTypeImpl
implements ParameterizedType,
v {
    private final Type[] a;
    private final Class b;
    private final Type c;

    public ParameterizedTypeImpl(Class typeArray, Type type, List list) {
        f0.p(typeArray, "rawType");
        f0.p(list, "typeArguments");
        this.b = typeArray;
        this.c = type;
        typeArray = new Type[]{};
        typeArray = list.toArray(typeArray);
        Objects.requireNonNull(typeArray, "null cannot be cast to non-null type kotlin.Array<T>");
        this.a = typeArray;
    }

    public boolean equals(Object objectArray) {
        boolean bl2;
        Type type;
        Object[] objectArray2;
        boolean bl3 = objectArray instanceof ParameterizedType;
        if (bl3 && (bl3 = f0.g(objectArray2 = this.b, type = (objectArray = (ParameterizedType)objectArray).getRawType())) && (bl3 = f0.g(objectArray2 = this.c, type = objectArray.getOwnerType())) && (bl2 = Arrays.equals(objectArray2 = this.getActualTypeArguments(), objectArray = objectArray.getActualTypeArguments()))) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public Type[] getActualTypeArguments() {
        return this.a;
    }

    public Type getOwnerType() {
        return this.c;
    }

    public Type getRawType() {
        return this.b;
    }

    public String getTypeName() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.c;
        if (object != null) {
            object = TypesJVMKt.b((Type)object);
            stringBuilder.append((String)object);
            stringBuilder.append("$");
            object = this.b.getSimpleName();
            stringBuilder.append((String)object);
        } else {
            object = TypesJVMKt.b(this.b);
            stringBuilder.append((String)object);
        }
        object = this.a;
        int n10 = ((Type[])object).length;
        int n11 = 1;
        n10 = n10 == 0 ? n11 : 0;
        if ((n10 ^= n11) != 0) {
            n11 = 0;
            ParameterizedTypeImpl$getTypeName$1$1 parameterizedTypeImpl$getTypeName$1$1 = ParameterizedTypeImpl$getTypeName$1$1.INSTANCE;
            int n12 = 50;
            String string2 = "<";
            String string3 = ">";
            ArraysKt___ArraysKt.og(object, stringBuilder, null, string2, string3, 0, null, parameterizedTypeImpl$getTypeName$1$1, n12, null);
        }
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public int hashCode() {
        int n10;
        Class clazz = this.b;
        int n11 = clazz.hashCode();
        Type type = this.c;
        if (type != null) {
            n10 = type.hashCode();
        } else {
            n10 = 0;
            type = null;
        }
        n11 ^= n10;
        n10 = Arrays.hashCode(this.getActualTypeArguments());
        return n11 ^ n10;
    }

    public String toString() {
        return this.getTypeName();
    }
}

