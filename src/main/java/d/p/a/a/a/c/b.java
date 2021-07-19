/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import d.p.a.a.a.c.a;
import d.p.a.a.a.c.a$c;
import d.p.a.a.a.c.a$d;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

public final class b {
    private b() {
    }

    public static boolean a(Type object, Type object2) {
        boolean bl2 = true;
        if (object == object2) {
            return bl2;
        }
        boolean bl3 = object instanceof Class;
        if (bl3) {
            bl2 = object2 instanceof GenericArrayType;
            if (bl2) {
                object = ((Class)object).getComponentType();
                object2 = ((GenericArrayType)object2).getGenericComponentType();
                return b.a(object, (Type)object2);
            }
            return object.equals(object2);
        }
        bl3 = object instanceof ParameterizedType;
        if (bl3) {
            boolean bl4;
            Type type;
            Type type2;
            bl3 = object2 instanceof ParameterizedType;
            if (!bl3) {
                return false;
            }
            object = (ParameterizedType)object;
            object2 = (ParameterizedType)object2;
            bl3 = object instanceof a$c;
            if (bl3) {
                type2 = object;
                type2 = ((a$c)object).c;
            } else {
                type2 = object.getActualTypeArguments();
            }
            boolean bl5 = object2 instanceof a$c;
            if (bl5) {
                type = object2;
                type = ((a$c)object2).c;
            } else {
                type = object2.getActualTypeArguments();
            }
            Type type3 = ((ParameterizedType)object).getOwnerType();
            Type type4 = ((ParameterizedType)object2).getOwnerType();
            boolean bl6 = b.a(type3, type4);
            if (!(bl6 && (bl4 = (object = ((ParameterizedType)object).getRawType()).equals(object2 = ((ParameterizedType)object2).getRawType())) && (bl4 = Arrays.equals((Object[])type2, (Object[])type)))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = object instanceof GenericArrayType;
        if (bl3) {
            bl2 = object2 instanceof Class;
            if (bl2) {
                object2 = ((Class)object2).getComponentType();
                object = ((GenericArrayType)object).getGenericComponentType();
                return b.a(object2, (Type)object);
            }
            bl2 = object2 instanceof GenericArrayType;
            if (!bl2) {
                return false;
            }
            object = (GenericArrayType)object;
            object2 = (GenericArrayType)object2;
            object = object.getGenericComponentType();
            object2 = object2.getGenericComponentType();
            return b.a((Type)object, (Type)object2);
        }
        bl3 = object instanceof WildcardType;
        if (bl3) {
            boolean bl7;
            Object[] objectArray;
            bl3 = object2 instanceof WildcardType;
            if (!bl3) {
                return false;
            }
            object = (WildcardType)object;
            object2 = (WildcardType)object2;
            Object[] objectArray2 = object.getUpperBounds();
            bl3 = Arrays.equals(objectArray2, objectArray = object2.getUpperBounds());
            if (!bl3 || !(bl7 = Arrays.equals((Object[])(object = object.getLowerBounds()), (Object[])(object2 = object2.getLowerBounds())))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = object instanceof TypeVariable;
        if (bl3) {
            boolean bl8;
            Object d10;
            bl3 = object2 instanceof TypeVariable;
            if (!bl3) {
                return false;
            }
            object = (TypeVariable)object;
            object2 = (TypeVariable)object2;
            Object d11 = object.getGenericDeclaration();
            if (d11 != (d10 = object2.getGenericDeclaration()) || !(bl8 = ((String)(object = object.getName())).equals(object2 = object2.getName()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static Class b(Type object) {
        boolean bl2 = object instanceof Class;
        if (bl2) {
            return (Class)object;
        }
        bl2 = object instanceof ParameterizedType;
        if (bl2) {
            return (Class)((ParameterizedType)object).getRawType();
        }
        bl2 = object instanceof GenericArrayType;
        IllegalArgumentException illegalArgumentException = null;
        if (bl2) {
            return Array.newInstance(b.b(((GenericArrayType)object).getGenericComponentType()), 0).getClass();
        }
        bl2 = object instanceof TypeVariable;
        if (bl2) {
            return Object.class;
        }
        bl2 = object instanceof WildcardType;
        if (bl2) {
            return b.b(((WildcardType)object).getUpperBounds()[0]);
        }
        String string2 = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(object);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static WildcardType c(Type typeArray) {
        Type[] typeArray2 = new Type[]{typeArray};
        typeArray = a.a;
        a$d a$d = new a$d(typeArray2, typeArray);
        return a$d;
    }

    public static WildcardType d(Type type) {
        int n10 = 1;
        Type[] typeArray = new Type[n10];
        typeArray[0] = Object.class;
        Type[] typeArray2 = new Type[n10];
        typeArray2[0] = type;
        a$d a$d = new a$d(typeArray, typeArray2);
        return a$d;
    }
}

