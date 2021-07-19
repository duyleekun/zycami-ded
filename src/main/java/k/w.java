/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.d0;
import g.v;
import h.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import k.w$a;
import k.w$b;
import k.w$c;

public final class w {
    public static final Type[] a = new Type[0];

    private w() {
    }

    public static d0 a(d0 d02) {
        m m10 = new m();
        d02.source().i0(m10);
        v v10 = d02.contentType();
        long l10 = d02.contentLength();
        return d0.create(v10, l10, m10);
    }

    public static void b(Type object) {
        boolean bl2;
        boolean bl3 = object instanceof Class;
        if (bl3 && (bl2 = ((Class)(object = (Class)object)).isPrimitive())) {
            object = new IllegalArgumentException();
            throw object;
        }
    }

    private static Class c(TypeVariable type) {
        boolean bl2 = (type = type.getGenericDeclaration()) instanceof Class;
        type = bl2 ? (Class)type : null;
        return type;
    }

    public static boolean d(Type objectArray, Type object) {
        boolean bl2 = true;
        if (objectArray == object) {
            return bl2;
        }
        boolean bl3 = objectArray instanceof Class;
        if (bl3) {
            return objectArray.equals(object);
        }
        bl3 = objectArray instanceof ParameterizedType;
        if (bl3) {
            boolean bl4;
            Type type;
            bl3 = object instanceof ParameterizedType;
            if (!bl3) {
                return false;
            }
            objectArray = (ParameterizedType)objectArray;
            object = (ParameterizedType)object;
            Type type2 = objectArray.getOwnerType();
            if (!((type2 == (type = object.getOwnerType()) || type2 != null && (bl3 = type2.equals(type))) && (bl3 = (type2 = objectArray.getRawType()).equals(type = object.getRawType())) && (bl4 = Arrays.equals(objectArray = objectArray.getActualTypeArguments(), object = object.getActualTypeArguments())))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = objectArray instanceof GenericArrayType;
        if (bl3) {
            bl2 = object instanceof GenericArrayType;
            if (!bl2) {
                return false;
            }
            objectArray = (GenericArrayType)objectArray;
            object = (GenericArrayType)object;
            objectArray = objectArray.getGenericComponentType();
            object = object.getGenericComponentType();
            return w.d((Type)objectArray, (Type)object);
        }
        bl3 = objectArray instanceof WildcardType;
        if (bl3) {
            boolean bl5;
            Object[] objectArray2;
            bl3 = object instanceof WildcardType;
            if (!bl3) {
                return false;
            }
            objectArray = (WildcardType)objectArray;
            object = (WildcardType)object;
            Object[] objectArray3 = objectArray.getUpperBounds();
            bl3 = Arrays.equals(objectArray3, objectArray2 = object.getUpperBounds());
            if (!bl3 || !(bl5 = Arrays.equals(objectArray = objectArray.getLowerBounds(), object = object.getLowerBounds()))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = objectArray instanceof TypeVariable;
        if (bl3) {
            boolean bl6;
            Object d10;
            bl3 = object instanceof TypeVariable;
            if (!bl3) {
                return false;
            }
            objectArray = (TypeVariable)objectArray;
            object = (TypeVariable)object;
            Object d11 = objectArray.getGenericDeclaration();
            if (d11 != (d10 = object.getGenericDeclaration()) || !(bl6 = (objectArray = objectArray.getName()).equals(object = object.getName()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static Type e(Type object, Class object2, Class clazz) {
        int n10;
        if (clazz == object2) {
            return object;
        }
        boolean bl2 = clazz.isInterface();
        if (bl2) {
            object = ((Class)object2).getInterfaces();
            int n11 = ((Class<?>[])object).length;
            for (n10 = 0; n10 < n11; ++n10) {
                Class<?> clazz2 = object[n10];
                if (clazz2 == clazz) {
                    return ((Class)object2).getGenericInterfaces()[n10];
                }
                clazz2 = object[n10];
                boolean bl3 = clazz.isAssignableFrom(clazz2);
                if (!bl3) continue;
                object2 = ((Class)object2).getGenericInterfaces()[n10];
                object = object[n10];
                return w.e((Type)object2, (Class)object, clazz);
            }
        }
        if (!(bl2 = ((Class)object2).isInterface())) {
            while (object2 != (object = Object.class)) {
                object = ((Class)object2).getSuperclass();
                if (object == clazz) {
                    return ((Class)object2).getGenericSuperclass();
                }
                n10 = (int)(clazz.isAssignableFrom((Class<?>)object) ? 1 : 0);
                if (n10 != 0) {
                    return w.e(((Class)object2).getGenericSuperclass(), object, clazz);
                }
                object2 = object;
            }
        }
        return clazz;
    }

    public static Type f(int n10, ParameterizedType typeArray) {
        Object object = (typeArray = typeArray.getActualTypeArguments())[n10];
        boolean bl2 = object instanceof WildcardType;
        if (bl2) {
            object = ((WildcardType)object).getLowerBounds();
            bl2 = false;
            typeArray = null;
            object = object[0];
        }
        return object;
    }

    public static Type g(int n10, ParameterizedType parameterizedType) {
        int n11;
        Type[] typeArray = parameterizedType.getActualTypeArguments();
        if (n10 >= 0 && n10 < (n11 = typeArray.length)) {
            Object object = typeArray[n10];
            boolean bl2 = object instanceof WildcardType;
            if (bl2) {
                object = ((WildcardType)object).getUpperBounds();
                bl2 = false;
                parameterizedType = null;
                object = object[0];
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(n10);
        stringBuilder.append(" not in range [0,");
        n10 = typeArray.length;
        stringBuilder.append(n10);
        stringBuilder.append(") for ");
        stringBuilder.append(parameterizedType);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static Class h(Type object) {
        Object object2 = "type == null";
        Objects.requireNonNull(object, (String)object2);
        boolean bl2 = object instanceof Class;
        if (bl2) {
            return (Class)object;
        }
        bl2 = object instanceof ParameterizedType;
        if (bl2) {
            bl2 = (object = ((ParameterizedType)object).getRawType()) instanceof Class;
            if (bl2) {
                return (Class)object;
            }
            object = new IllegalArgumentException();
            throw object;
        }
        bl2 = object instanceof GenericArrayType;
        StringBuilder stringBuilder = null;
        if (bl2) {
            return Array.newInstance(w.h(((GenericArrayType)object).getGenericComponentType()), 0).getClass();
        }
        bl2 = object instanceof TypeVariable;
        if (bl2) {
            return Object.class;
        }
        bl2 = object instanceof WildcardType;
        if (bl2) {
            return w.h(((WildcardType)object).getUpperBounds()[0]);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(object);
        stringBuilder.append("> is of type ");
        object = object.getClass().getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static Type i(Type object, Class clazz, Class type) {
        boolean bl2 = type.isAssignableFrom(clazz);
        if (bl2) {
            type = w.e((Type)object, clazz, type);
            return w.q((Type)object, clazz, type);
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public static boolean j(Type object) {
        int n10 = object instanceof Class;
        IllegalArgumentException illegalArgumentException = null;
        if (n10 != 0) {
            return false;
        }
        n10 = object instanceof ParameterizedType;
        boolean bl2 = true;
        if (n10 != 0) {
            for (Type type : ((ParameterizedType)object).getActualTypeArguments()) {
                boolean bl3 = w.j(type);
                if (!bl3) continue;
                return bl2;
            }
            return false;
        }
        n10 = object instanceof GenericArrayType;
        if (n10 != 0) {
            return w.j(((GenericArrayType)object).getGenericComponentType());
        }
        n10 = object instanceof TypeVariable;
        if (n10 != 0) {
            return bl2;
        }
        n10 = object instanceof WildcardType;
        if (n10 != 0) {
            return bl2;
        }
        String string2 = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a Class, ParameterizedType, or GenericArrayType, but <");
        stringBuilder.append(object);
        stringBuilder.append("> is of type ");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    private static int k(Object[] object, Object object2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = ((Object[])object).length); ++i10) {
            Object object3 = object[i10];
            n10 = (int)(object2.equals(object3) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static boolean l(Annotation[] annotationArray, Class clazz) {
        for (Annotation annotation : annotationArray) {
            boolean bl2 = clazz.isInstance(annotation);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static RuntimeException m(Method method, String string2, Object ... objectArray) {
        return w.n(method, null, string2, objectArray);
    }

    public static RuntimeException n(Method object, Throwable throwable, String string2, Object ... object2) {
        string2 = String.format(string2, object2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("\n    for method ");
        string2 = ((Method)object).getDeclaringClass().getSimpleName();
        stringBuilder.append(string2);
        stringBuilder.append(".");
        object = ((Method)object).getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object, throwable);
        return object2;
    }

    public static RuntimeException o(Method method, int n10, String string2, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(++n10);
        stringBuilder.append(")");
        String string3 = stringBuilder.toString();
        return w.m(method, string3, objectArray);
    }

    public static RuntimeException p(Method method, Throwable throwable, int n10, String string2, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" (parameter #");
        stringBuilder.append(++n10);
        stringBuilder.append(")");
        String string3 = stringBuilder.toString();
        return w.n(method, throwable, string3, objectArray);
    }

    public static Type q(Type typeArray, Class type, Type type2) {
        int n10;
        Object object;
        int n11;
        while ((n11 = type2 instanceof TypeVariable) != 0) {
            object = w.r((Type)typeArray, type, (TypeVariable)(type2 = (TypeVariable)type2));
            if (object == type2) {
                return object;
            }
            type2 = object;
        }
        n11 = type2 instanceof Class;
        if (n11 != 0) {
            object = type2;
            object = (Class)type2;
            n10 = object.isArray();
            if (n10 != 0) {
                type2 = object.getComponentType();
                if (type2 != (typeArray = w.q((Type)typeArray, type, type2))) {
                    object = new w$a((Type)typeArray);
                }
                return object;
            }
        }
        if ((n11 = type2 instanceof GenericArrayType) != 0) {
            object = (type2 = (GenericArrayType)type2).getGenericComponentType();
            if (object != (typeArray = w.q((Type)typeArray, type, object))) {
                type2 = new w$a((Type)typeArray);
            }
            return type2;
        }
        n11 = type2 instanceof ParameterizedType;
        n10 = 1;
        int n12 = 0;
        if (n11 != 0) {
            object = (type2 = (ParameterizedType)type2).getOwnerType();
            Type type3 = w.q((Type)typeArray, type, object);
            if (type3 != object) {
                n11 = n10;
            } else {
                n11 = 0;
                object = null;
            }
            Type[] typeArray2 = type2.getActualTypeArguments();
            int n13 = typeArray2.length;
            while (n12 < n13) {
                Type type4;
                Type type5 = typeArray2[n12];
                if ((type5 = w.q((Type)typeArray, type, type5)) != (type4 = typeArray2[n12])) {
                    if (n11 == 0) {
                        object = typeArray2.clone();
                        typeArray2 = object;
                        typeArray2 = object;
                        n11 = n10;
                    }
                    typeArray2[n12] = type5;
                }
                ++n12;
            }
            if (n11 != 0) {
                type = type2.getRawType();
                typeArray = new w$b(type3, type, typeArray2);
                type2 = typeArray;
            }
            return type2;
        }
        n11 = type2 instanceof WildcardType;
        if (n11 != 0) {
            type2 = (WildcardType)type2;
            object = type2.getLowerBounds();
            Object object2 = type2.getUpperBounds();
            int n14 = ((Type[])object).length;
            if (n14 == n10) {
                object2 = object[0];
                if ((typeArray = w.q((Type)typeArray, type, (Type)object2)) != (type = object[0])) {
                    type2 = new Type[n10];
                    type2[0] = Object.class;
                    object = new Type[n10];
                    object[0] = typeArray;
                    type = new w$c((Type[])type2, (Type[])object);
                    return type;
                }
            } else {
                n11 = ((Type[])object2).length;
                if (n11 == n10 && (typeArray = w.q((Type)typeArray, type, (Type)(object = object2[0]))) != (type = object2[0])) {
                    type2 = new Type[n10];
                    type2[0] = typeArray;
                    typeArray = a;
                    type = new w$c((Type[])type2, typeArray);
                    return type;
                }
            }
        }
        return type2;
    }

    private static Type r(Type type, Class clazz, TypeVariable typeVariable) {
        Class clazz2 = w.c(typeVariable);
        if (clazz2 == null) {
            return typeVariable;
        }
        int n10 = (type = w.e(type, clazz, clazz2)) instanceof ParameterizedType;
        if (n10 != 0) {
            n10 = w.k(clazz2.getTypeParameters(), typeVariable);
            return ((ParameterizedType)type).getActualTypeArguments()[n10];
        }
        return typeVariable;
    }

    public static void s(Throwable throwable) {
        boolean bl2 = throwable instanceof VirtualMachineError;
        if (!bl2) {
            bl2 = throwable instanceof ThreadDeath;
            if (!bl2) {
                bl2 = throwable instanceof LinkageError;
                if (!bl2) {
                    return;
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }

    public static String t(Type object) {
        boolean bl2 = object instanceof Class;
        object = bl2 ? ((Class)object).getName() : object.toString();
        return object;
    }
}

