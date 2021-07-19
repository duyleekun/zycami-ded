/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.m2.v;
import f.m2.z$a;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.reflect.TypesJVMKt;

public final class z
implements WildcardType,
v {
    private static final z c;
    public static final z$a d;
    private final Type a;
    private final Type b;

    static {
        Object object = new z$a(null);
        d = object;
        c = object = new z(null, null);
    }

    public z(Type type, Type type2) {
        this.a = type;
        this.b = type2;
    }

    public static final /* synthetic */ z a() {
        return c;
    }

    public boolean equals(Object objectArray) {
        boolean bl2;
        Object[] objectArray2;
        Object[] objectArray3;
        boolean bl3 = objectArray instanceof WildcardType;
        if (bl3 && (bl3 = Arrays.equals(objectArray3 = this.getUpperBounds(), objectArray2 = (objectArray = (WildcardType)objectArray).getUpperBounds())) && (bl2 = Arrays.equals(objectArray3 = this.getLowerBounds(), objectArray = objectArray.getLowerBounds()))) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public Type[] getLowerBounds() {
        Type[] typeArray = this.b;
        if (typeArray == null) {
            typeArray = new Type[]{};
        } else {
            int n10 = 1;
            Type[] typeArray2 = new Type[n10];
            typeArray2[0] = typeArray;
            typeArray = typeArray2;
        }
        return typeArray;
    }

    public String getTypeName() {
        Object object = this.b;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("? super ");
            String string2 = TypesJVMKt.b(this.b);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            Object object2;
            boolean bl2;
            object = this.a;
            if (object != null && (bl2 = f0.g(object, object2 = Object.class) ^ true)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("? extends ");
                object2 = TypesJVMKt.b(this.a);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
            } else {
                object = "?";
            }
        }
        return object;
    }

    public Type[] getUpperBounds() {
        int n10 = 1;
        Type[] typeArray = new Type[n10];
        Object object = this.a;
        if (object == null) {
            object = Object.class;
        }
        typeArray[0] = object;
        return typeArray;
    }

    public int hashCode() {
        int n10 = Arrays.hashCode(this.getUpperBounds());
        int n11 = Arrays.hashCode(this.getLowerBounds());
        return n10 ^ n11;
    }

    public String toString() {
        return this.getTypeName();
    }
}

