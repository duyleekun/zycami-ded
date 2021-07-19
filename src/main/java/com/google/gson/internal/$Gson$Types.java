/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types$GenericArrayTypeImpl;
import com.google.gson.internal.$Gson$Types$ParameterizedTypeImpl;
import com.google.gson.internal.$Gson$Types$WildcardTypeImpl;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class $Gson$Types {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];

    private $Gson$Types() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public static GenericArrayType arrayOf(Type type) {
        $Gson$Types$GenericArrayTypeImpl $Gson$Types$GenericArrayTypeImpl = new $Gson$Types$GenericArrayTypeImpl(type);
        return $Gson$Types$GenericArrayTypeImpl;
    }

    public static Type canonicalize(Type typeArray) {
        boolean bl2 = typeArray instanceof Class;
        if (bl2) {
            bl2 = (typeArray = (Class)typeArray).isArray();
            if (bl2) {
                typeArray = $Gson$Types.canonicalize(typeArray.getComponentType());
                $Gson$Types$GenericArrayTypeImpl $Gson$Types$GenericArrayTypeImpl = new $Gson$Types$GenericArrayTypeImpl((Type)typeArray);
                typeArray = $Gson$Types$GenericArrayTypeImpl;
            }
            return typeArray;
        }
        bl2 = typeArray instanceof ParameterizedType;
        if (bl2) {
            typeArray = (ParameterizedType)typeArray;
            Type type = typeArray.getOwnerType();
            Type type2 = typeArray.getRawType();
            typeArray = typeArray.getActualTypeArguments();
            $Gson$Types$ParameterizedTypeImpl $Gson$Types$ParameterizedTypeImpl = new $Gson$Types$ParameterizedTypeImpl(type, type2, typeArray);
            return $Gson$Types$ParameterizedTypeImpl;
        }
        bl2 = typeArray instanceof GenericArrayType;
        if (bl2) {
            typeArray = (GenericArrayType)typeArray;
            typeArray = typeArray.getGenericComponentType();
            $Gson$Types$GenericArrayTypeImpl $Gson$Types$GenericArrayTypeImpl = new $Gson$Types$GenericArrayTypeImpl((Type)typeArray);
            return $Gson$Types$GenericArrayTypeImpl;
        }
        bl2 = typeArray instanceof WildcardType;
        if (bl2) {
            typeArray = (WildcardType)typeArray;
            Type[] typeArray2 = typeArray.getUpperBounds();
            typeArray = typeArray.getLowerBounds();
            $Gson$Types$WildcardTypeImpl $Gson$Types$WildcardTypeImpl = new $Gson$Types$WildcardTypeImpl(typeArray2, typeArray);
            return $Gson$Types$WildcardTypeImpl;
        }
        return typeArray;
    }

    public static void checkNotPrimitive(Type type) {
        boolean bl2;
        boolean bl3 = type instanceof Class;
        if (bl3 && (bl2 = ((Class)(type = (Class)type)).isPrimitive())) {
            bl2 = false;
            type = null;
        } else {
            bl2 = true;
        }
        $Gson$Preconditions.checkArgument(bl2);
    }

    private static Class declaringClassOf(TypeVariable type) {
        boolean bl2 = (type = type.getGenericDeclaration()) instanceof Class;
        type = bl2 ? (Class)type : null;
        return type;
    }

    public static boolean equal(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean equals(Type objectArray, Type objectArray2) {
        boolean bl2 = true;
        if (objectArray == objectArray2) {
            return bl2;
        }
        boolean bl3 = objectArray instanceof Class;
        if (bl3) {
            return objectArray.equals(objectArray2);
        }
        bl3 = objectArray instanceof ParameterizedType;
        if (bl3) {
            boolean bl4;
            Type type;
            bl3 = objectArray2 instanceof ParameterizedType;
            if (!bl3) {
                return false;
            }
            objectArray = (ParameterizedType)objectArray;
            objectArray2 = (ParameterizedType)objectArray2;
            Type type2 = objectArray.getOwnerType();
            bl3 = $Gson$Types.equal(type2, type = objectArray2.getOwnerType());
            if (!(bl3 && (bl3 = (type2 = objectArray.getRawType()).equals(type = objectArray2.getRawType())) && (bl4 = Arrays.equals(objectArray = objectArray.getActualTypeArguments(), objectArray2 = objectArray2.getActualTypeArguments())))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = objectArray instanceof GenericArrayType;
        if (bl3) {
            bl2 = objectArray2 instanceof GenericArrayType;
            if (!bl2) {
                return false;
            }
            objectArray = (GenericArrayType)objectArray;
            objectArray2 = (GenericArrayType)objectArray2;
            objectArray = objectArray.getGenericComponentType();
            objectArray2 = objectArray2.getGenericComponentType();
            return $Gson$Types.equals((Type)objectArray, (Type)objectArray2);
        }
        bl3 = objectArray instanceof WildcardType;
        if (bl3) {
            boolean bl5;
            Object[] objectArray3;
            bl3 = objectArray2 instanceof WildcardType;
            if (!bl3) {
                return false;
            }
            objectArray = (WildcardType)objectArray;
            objectArray2 = (WildcardType)objectArray2;
            Object[] objectArray4 = objectArray.getUpperBounds();
            bl3 = Arrays.equals(objectArray4, objectArray3 = objectArray2.getUpperBounds());
            if (!bl3 || !(bl5 = Arrays.equals(objectArray = objectArray.getLowerBounds(), objectArray2 = objectArray2.getLowerBounds()))) {
                bl2 = false;
            }
            return bl2;
        }
        bl3 = objectArray instanceof TypeVariable;
        if (bl3) {
            boolean bl6;
            Object d10;
            bl3 = objectArray2 instanceof TypeVariable;
            if (!bl3) {
                return false;
            }
            objectArray = (TypeVariable)objectArray;
            objectArray2 = (TypeVariable)objectArray2;
            Object d11 = objectArray.getGenericDeclaration();
            if (d11 != (d10 = objectArray2.getGenericDeclaration()) || !(bl6 = (objectArray = objectArray.getName()).equals(objectArray2 = objectArray2.getName()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static Type getArrayComponentType(Type type) {
        boolean bl2 = type instanceof GenericArrayType;
        type = bl2 ? ((GenericArrayType)type).getGenericComponentType() : ((Class)type).getComponentType();
        return type;
    }

    public static Type getCollectionElementType(Type type, Class clazz) {
        boolean bl2 = (type = $Gson$Types.getSupertype(type, clazz, Collection.class)) instanceof WildcardType;
        if (bl2) {
            type = ((WildcardType)type).getUpperBounds()[0];
        }
        if (bl2 = type instanceof ParameterizedType) {
            return ((ParameterizedType)type).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type getGenericSupertype(Type object, Class object2, Class clazz) {
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
                return $Gson$Types.getGenericSupertype((Type)object2, (Class)object, clazz);
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
                    return $Gson$Types.getGenericSupertype(((Class)object2).getGenericSuperclass(), object, clazz);
                }
                object2 = object;
            }
        }
        return clazz;
    }

    public static Type[] getMapKeyAndValueTypes(Type typeArray, Class clazz) {
        Class<Object> clazz2 = Object.class;
        Class clazz3 = String.class;
        Class<Properties> clazz4 = Properties.class;
        int n10 = 1;
        int n11 = 2;
        if (typeArray == clazz4) {
            typeArray = new Type[n11];
            typeArray[0] = clazz3;
            typeArray[n10] = clazz3;
            return typeArray;
        }
        clazz3 = Map.class;
        boolean bl2 = (typeArray = $Gson$Types.getSupertype((Type)typeArray, clazz, clazz3)) instanceof ParameterizedType;
        if (bl2) {
            return ((ParameterizedType)typeArray).getActualTypeArguments();
        }
        typeArray = new Type[n11];
        typeArray[0] = clazz2;
        typeArray[n10] = clazz2;
        return typeArray;
    }

    public static Class getRawType(Type object) {
        boolean bl2 = object instanceof Class;
        if (bl2) {
            return (Class)object;
        }
        bl2 = object instanceof ParameterizedType;
        if (bl2) {
            object = ((ParameterizedType)object).getRawType();
            $Gson$Preconditions.checkArgument(object instanceof Class);
            return (Class)object;
        }
        bl2 = object instanceof GenericArrayType;
        IllegalArgumentException illegalArgumentException = null;
        if (bl2) {
            return Array.newInstance($Gson$Types.getRawType(((GenericArrayType)object).getGenericComponentType()), 0).getClass();
        }
        bl2 = object instanceof TypeVariable;
        if (bl2) {
            return Object.class;
        }
        bl2 = object instanceof WildcardType;
        if (bl2) {
            return $Gson$Types.getRawType(((WildcardType)object).getUpperBounds()[0]);
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

    public static Type getSupertype(Type object, Class clazz, Class type) {
        boolean bl2 = object instanceof WildcardType;
        if (bl2) {
            object = ((WildcardType)object).getUpperBounds();
            bl2 = false;
            object = object[0];
        }
        $Gson$Preconditions.checkArgument(type.isAssignableFrom(clazz));
        type = $Gson$Types.getGenericSupertype((Type)object, clazz, type);
        return $Gson$Types.resolve((Type)object, clazz, type);
    }

    public static int hashCodeOrZero(Object object) {
        int n10;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    private static int indexOf(Object[] object, Object object2) {
        int n10 = ((Object[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            boolean bl2 = object2.equals(object3);
            if (!bl2) continue;
            return i10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type ... typeArray) {
        $Gson$Types$ParameterizedTypeImpl $Gson$Types$ParameterizedTypeImpl = new $Gson$Types$ParameterizedTypeImpl(type, type2, typeArray);
        return $Gson$Types$ParameterizedTypeImpl;
    }

    public static Type resolve(Type type, Class clazz, Type type2) {
        HashSet hashSet = new HashSet();
        return $Gson$Types.resolve(type, clazz, type2, hashSet);
    }

    private static Type resolve(Type type, Class type2, Type type3, Collection collection) {
        int n10;
        Object object;
        int n11;
        while ((n11 = type3 instanceof TypeVariable) != 0) {
            object = type3;
            object = (TypeVariable)type3;
            n10 = collection.contains(object);
            if (n10 != 0) {
                return type3;
            }
            collection.add(object);
            type3 = $Gson$Types.resolveTypeVariable(type, type2, object);
            if (type3 != object) continue;
            return type3;
        }
        n11 = type3 instanceof Class;
        if (n11 != 0) {
            object = type3;
            object = (Class)type3;
            n10 = object.isArray();
            if (n10 != 0) {
                type3 = object.getComponentType();
                if (type3 != (type = $Gson$Types.resolve(type, type2, type3, collection))) {
                    object = $Gson$Types.arrayOf(type);
                }
                return object;
            }
        }
        if ((n11 = type3 instanceof GenericArrayType) != 0) {
            object = (type3 = (GenericArrayType)type3).getGenericComponentType();
            if (object != (type = $Gson$Types.resolve(type, type2, object, collection))) {
                type3 = $Gson$Types.arrayOf(type);
            }
            return type3;
        }
        n11 = type3 instanceof ParameterizedType;
        n10 = 1;
        int n12 = 0;
        if (n11 != 0) {
            object = (type3 = (ParameterizedType)type3).getOwnerType();
            Type type4 = $Gson$Types.resolve(type, type2, object, collection);
            if (type4 != object) {
                n11 = n10;
            } else {
                n11 = 0;
                object = null;
            }
            Type[] typeArray = type3.getActualTypeArguments();
            int n13 = typeArray.length;
            while (n12 < n13) {
                Type type5;
                Type type6 = typeArray[n12];
                if ((type6 = $Gson$Types.resolve(type, type2, type6, collection)) != (type5 = typeArray[n12])) {
                    if (n11 == 0) {
                        object = typeArray.clone();
                        typeArray = object;
                        typeArray = object;
                        n11 = n10;
                    }
                    typeArray[n12] = type6;
                }
                ++n12;
            }
            if (n11 != 0) {
                type = type3.getRawType();
                type3 = $Gson$Types.newParameterizedTypeWithOwner(type4, type, typeArray);
            }
            return type3;
        }
        n11 = type3 instanceof WildcardType;
        if (n11 != 0) {
            type3 = (WildcardType)type3;
            object = type3.getLowerBounds();
            Type[] typeArray = type3.getUpperBounds();
            int n14 = ((Type[])object).length;
            if (n14 == n10) {
                Type type7 = object[0];
                if ((type = $Gson$Types.resolve(type, type2, type7, collection)) != (type2 = object[0])) {
                    return $Gson$Types.supertypeOf(type);
                }
            } else {
                n11 = typeArray.length;
                if (n11 == n10 && (type = $Gson$Types.resolve(type, type2, (Type)(object = typeArray[0]), collection)) != (type2 = typeArray[0])) {
                    return $Gson$Types.subtypeOf(type);
                }
            }
        }
        return type3;
    }

    public static Type resolveTypeVariable(Type type, Class clazz, TypeVariable typeVariable) {
        Class clazz2 = $Gson$Types.declaringClassOf(typeVariable);
        if (clazz2 == null) {
            return typeVariable;
        }
        int n10 = (type = $Gson$Types.getGenericSupertype(type, clazz, clazz2)) instanceof ParameterizedType;
        if (n10 != 0) {
            n10 = $Gson$Types.indexOf(clazz2.getTypeParameters(), typeVariable);
            return ((ParameterizedType)type).getActualTypeArguments()[n10];
        }
        return typeVariable;
    }

    public static WildcardType subtypeOf(Type typeArray) {
        Type[] typeArray2;
        Object object;
        int n10 = typeArray instanceof WildcardType;
        if (n10 != 0) {
            typeArray = ((WildcardType)typeArray).getUpperBounds();
        } else {
            n10 = 1;
            object = new Type[n10];
            typeArray2 = null;
            object[0] = typeArray;
            typeArray = object;
        }
        typeArray2 = EMPTY_TYPE_ARRAY;
        object = new $Gson$Types$WildcardTypeImpl(typeArray, typeArray2);
        return object;
    }

    public static WildcardType supertypeOf(Type typeArray) {
        Object object;
        boolean bl2 = typeArray instanceof WildcardType;
        int n10 = 1;
        if (bl2) {
            typeArray = ((WildcardType)typeArray).getLowerBounds();
        } else {
            object = new Type[n10];
            object[0] = typeArray;
            typeArray = object;
        }
        Type[] typeArray2 = new Type[n10];
        typeArray2[0] = Object.class;
        object = new $Gson$Types$WildcardTypeImpl(typeArray2, typeArray);
        return object;
    }

    public static String typeToString(Type object) {
        boolean bl2 = object instanceof Class;
        object = bl2 ? ((Class)object).getName() : object.toString();
        return object;
    }
}

