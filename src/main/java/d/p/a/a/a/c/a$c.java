/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import d.p.a.a.a.c.a;
import d.p.a.a.a.c.b;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

public final class a$c
implements ParameterizedType {
    private final Type a;
    private final Type b;
    public final Type[] c;

    public a$c(Type object, Type object2, Type ... object3) {
        int n10;
        int n11;
        boolean bl2 = object2 instanceof Class;
        if (bl2) {
            Serializable serializable = object2;
            serializable = ((Class)object2).getEnclosingClass();
            String string2 = "unexpected owner type for ";
            if (object != null) {
                Class clazz;
                if (serializable == null || (clazz = d.p.a.a.a.c.b.b((Type)object)) != serializable) {
                    ((StringBuilder)serializable).append(string2);
                    ((StringBuilder)serializable).append(object2);
                    ((StringBuilder)serializable).append(": ");
                    ((StringBuilder)serializable).append(object);
                    object = ((StringBuilder)serializable).toString();
                    object3 = new IllegalArgumentException((String)object);
                    throw object3;
                }
            } else if (serializable != null) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(object2);
                ((StringBuilder)object3).append(": null");
                object2 = ((StringBuilder)object3).toString();
                super((String)object2);
                throw object;
            }
        }
        if (object == null) {
            n11 = 0;
            object = null;
        } else {
            object = d.p.a.a.a.c.a.a((Type)object);
        }
        this.a = object;
        object = d.p.a.a.a.c.a.a((Type)object2);
        this.b = object;
        object = (Type[])object3.clone();
        this.c = object;
        object = null;
        for (n11 = 0; n11 < (n10 = ((Type[])(object2 = this.c)).length); ++n11) {
            Objects.requireNonNull(object2[n11]);
            d.p.a.a.a.c.a.b(object2[n11]);
            object2 = this.c;
            object2[n11] = object3 = d.p.a.a.a.c.a.a(object2[n11]);
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof ParameterizedType;
        if (bl3 && (bl2 = d.p.a.a.a.c.b.a(this, (Type)(object = (ParameterizedType)object)))) {
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
        int n10 = Arrays.hashCode(this.c);
        int n11 = this.b.hashCode();
        n10 ^= n11;
        n11 = d.p.a.a.a.c.a.c(this.a);
        return n10 ^ n11;
    }

    public String toString() {
        int n10;
        int n11 = this.c.length;
        n11 = (n11 + n10) * 30;
        StringBuilder stringBuilder = new StringBuilder(n11);
        Object object = d.p.a.a.a.c.a.d(this.b);
        stringBuilder.append((String)object);
        object = this.c;
        n11 = ((Type[])object).length;
        if (n11 == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.append("<");
        object = d.p.a.a.a.c.a.d(this.c[0]);
        stringBuilder.append((String)object);
        for (n10 = 1; n10 < (n11 = ((Type[])(object = this.c)).length); ++n10) {
            stringBuilder.append(", ");
            object = d.p.a.a.a.c.a.d(this.c[n10]);
            stringBuilder.append((String)object);
        }
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}

