/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import d.p.a.a.a.c.a;
import d.p.a.a.a.c.b;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

public final class a$d
implements WildcardType {
    private final Type a;
    private final Type b;

    /*
     * Enabled aggressive block sorting
     */
    public a$d(Type[] object, Type[] typeArray) {
        Object var2_8;
        Class<Object> clazz = Object.class;
        int n10 = ((void)var2_8).length;
        int n11 = 1;
        if (n10 > n11) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        n10 = ((Type[])object).length;
        if (n10 != n11) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        n10 = ((void)var2_8).length;
        if (n10 != n11) {
            Type type;
            Objects.requireNonNull(object[0]);
            d.p.a.a.a.c.a.b(object[0]);
            var2_8 = null;
            this.b = null;
            this.a = type = d.p.a.a.a.c.a.a(object[0]);
            return;
        }
        Objects.requireNonNull(var2_8[0]);
        void var6_12 = var2_8[0];
        d.p.a.a.a.c.a.b((Type)var6_12);
        Type type = object[0];
        if (type == clazz) {
            Type type2;
            this.b = type2 = d.p.a.a.a.c.a.a((Type)var2_8[0]);
            this.a = clazz;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof WildcardType;
        if (bl3 && (bl2 = d.p.a.a.a.c.b.a(this, (Type)(object = (WildcardType)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Type[] getLowerBounds() {
        Type[] typeArray;
        Type type = this.b;
        if (type != null) {
            int n10 = 1;
            typeArray = new Type[n10];
            typeArray[0] = type;
        } else {
            typeArray = d.p.a.a.a.c.a.a;
        }
        return typeArray;
    }

    public Type[] getUpperBounds() {
        Type type = this.a;
        Type[] typeArray = new Type[]{type};
        return typeArray;
    }

    public int hashCode() {
        Type type = this.b;
        int n10 = type != null ? type.hashCode() + 31 : 1;
        int n11 = this.a.hashCode() + 31;
        return n10 ^ n11;
    }

    public String toString() {
        Object object = this.b;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("? super ");
            String string2 = d.p.a.a.a.c.a.d(this.b);
            ((StringBuilder)object).append(string2);
            return ((StringBuilder)object).toString();
        }
        object = this.a;
        Class<Object> clazz = Object.class;
        if (object == clazz) {
            return "?";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("? extends ");
        clazz = d.p.a.a.a.c.a.d(this.a);
        ((StringBuilder)object).append((String)((Object)clazz));
        return ((StringBuilder)object).toString();
    }
}

