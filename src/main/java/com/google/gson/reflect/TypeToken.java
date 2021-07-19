/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.reflect;

import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.$Gson$Types;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class TypeToken {
    public final int hashCode;
    public final Class rawType;
    public final Type type;

    public TypeToken() {
        int n10;
        Class clazz;
        Type type;
        this.type = type = TypeToken.getSuperclassTypeParameter(this.getClass());
        this.rawType = clazz = $Gson$Types.getRawType(type);
        this.hashCode = n10 = type.hashCode();
    }

    public TypeToken(Type type) {
        int n10;
        Class clazz;
        this.type = type = $Gson$Types.canonicalize((Type)$Gson$Preconditions.checkNotNull(type));
        this.rawType = clazz = $Gson$Types.getRawType(type);
        this.hashCode = n10 = type.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type object, Class ... object2) {
        String string2 = "Unexpected type. Expected one of: ";
        StringBuilder stringBuilder = new StringBuilder(string2);
        int n10 = ((Class[])object2).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = object2[i10].getName();
            stringBuilder.append(string3);
            string3 = ", ";
            stringBuilder.append(string3);
        }
        stringBuilder.append("but got: ");
        object2 = object.getClass().getName();
        stringBuilder.append((String)object2);
        stringBuilder.append(", for type token: ");
        object = object.toString();
        stringBuilder.append((String)object);
        stringBuilder.append('.');
        object2 = stringBuilder.toString();
        object = new AssertionError(object2);
        return object;
    }

    public static TypeToken get(Class clazz) {
        TypeToken typeToken = new TypeToken(clazz);
        return typeToken;
    }

    public static TypeToken get(Type type) {
        TypeToken typeToken = new TypeToken(type);
        return typeToken;
    }

    public static TypeToken getArray(Type type) {
        type = $Gson$Types.arrayOf(type);
        TypeToken typeToken = new TypeToken(type);
        return typeToken;
    }

    public static TypeToken getParameterized(Type type, Type ... typeArray) {
        type = $Gson$Types.newParameterizedTypeWithOwner(null, type, typeArray);
        TypeToken typeToken = new TypeToken(type);
        return typeToken;
    }

    public static Type getSuperclassTypeParameter(Class object) {
        boolean bl2 = (object = ((Class)object).getGenericSuperclass()) instanceof Class;
        if (!bl2) {
            return $Gson$Types.canonicalize(((ParameterizedType)object).getActualTypeArguments()[0]);
        }
        object = new RuntimeException("Missing type parameter.");
        throw object;
    }

    private static boolean isAssignableFrom(Type clazz, GenericArrayType type) {
        boolean bl2 = (type = type.getGenericComponentType()) instanceof ParameterizedType;
        if (bl2) {
            bl2 = clazz instanceof GenericArrayType;
            if (bl2) {
                clazz = ((GenericArrayType)((Object)clazz)).getGenericComponentType();
            } else {
                bl2 = clazz instanceof Class;
                if (bl2) {
                    clazz = clazz;
                    while (bl2 = clazz.isArray()) {
                        clazz = clazz.getComponentType();
                    }
                }
            }
            type = (ParameterizedType)type;
            HashMap hashMap = new HashMap();
            return TypeToken.isAssignableFrom(clazz, (ParameterizedType)type, hashMap);
        }
        return true;
    }

    private static boolean isAssignableFrom(Type object, ParameterizedType parameterizedType, Map map) {
        HashMap hashMap;
        Object object2;
        int n10 = 0;
        HashMap hashMap2 = null;
        if (object == null) {
            return false;
        }
        boolean bl2 = parameterizedType.equals(object);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        Class clazz = $Gson$Types.getRawType((Type)object);
        int n11 = 0;
        Type[] typeArray = null;
        boolean bl4 = object instanceof ParameterizedType;
        if (bl4) {
            typeArray = object;
            typeArray = (ParameterizedType)object;
        }
        if (typeArray != null) {
            int n12;
            object = typeArray.getActualTypeArguments();
            object2 = clazz.getTypeParameters();
            hashMap = null;
            for (int i10 = 0; i10 < (n12 = ((Type[])object).length); ++i10) {
                boolean bl5;
                Object object3 = object[i10];
                Object object4 = object2[i10];
                while (bl5 = object3 instanceof TypeVariable) {
                    object3 = ((TypeVariable)object3).getName();
                    object3 = (Type)map.get(object3);
                }
                object4 = object4.getName();
                map.put(object4, object3);
            }
            boolean bl6 = TypeToken.typeEquals((ParameterizedType)typeArray, parameterizedType, map);
            if (bl6) {
                return bl3;
            }
        }
        object = clazz.getGenericInterfaces();
        n11 = ((Type[])object).length;
        while (n10 < n11) {
            object2 = object[n10];
            hashMap = new HashMap(map);
            bl4 = TypeToken.isAssignableFrom(object2, parameterizedType, hashMap);
            if (bl4) {
                return bl3;
            }
            ++n10;
        }
        object = clazz.getGenericSuperclass();
        hashMap2 = new HashMap(map);
        return TypeToken.isAssignableFrom((Type)object, parameterizedType, hashMap2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean matches(Type object, Type type, Map map) {
        boolean bl2 = type.equals(object);
        if (bl2) return true;
        bl2 = object instanceof TypeVariable;
        if (!bl2) return false;
        object = ((TypeVariable)object).getName();
        boolean bl3 = type.equals(object = map.get(object));
        if (!bl3) return false;
        return true;
    }

    private static boolean typeEquals(ParameterizedType typeArray, ParameterizedType typeArray2, Map map) {
        Type type = typeArray.getRawType();
        Type type2 = typeArray2.getRawType();
        int n10 = type.equals(type2);
        type2 = null;
        if (n10 != 0) {
            int n11;
            typeArray = typeArray.getActualTypeArguments();
            typeArray2 = typeArray2.getActualTypeArguments();
            type = null;
            for (n10 = 0; n10 < (n11 = typeArray.length); ++n10) {
                Type type3 = typeArray[n10];
                Type type4 = typeArray2[n10];
                n11 = (int)(TypeToken.matches(type3, type4, map) ? 1 : 0);
                if (n11 != 0) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean equals(Object object) {
        Type type;
        boolean bl2;
        boolean bl3 = object instanceof TypeToken;
        if (bl3 && (bl2 = $Gson$Types.equals(type = this.type, (Type)(object = ((TypeToken)object).type)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final Class getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public boolean isAssignableFrom(TypeToken object) {
        object = ((TypeToken)object).getType();
        return this.isAssignableFrom((Type)object);
    }

    public boolean isAssignableFrom(Class clazz) {
        return this.isAssignableFrom((Type)clazz);
    }

    public boolean isAssignableFrom(Type classArray) {
        int n10 = 0;
        Serializable serializable = null;
        if (classArray == null) {
            return false;
        }
        Type type = this.type;
        boolean bl2 = type.equals(classArray);
        int n11 = 1;
        if (bl2) {
            return n11 != 0;
        }
        type = this.type;
        boolean bl3 = type instanceof Class;
        if (bl3) {
            serializable = this.rawType;
            classArray = $Gson$Types.getRawType((Type)classArray);
            return serializable.isAssignableFrom((Class<?>)classArray);
        }
        bl3 = type instanceof ParameterizedType;
        if (bl3) {
            type = (ParameterizedType)type;
            serializable = new HashMap();
            return TypeToken.isAssignableFrom((Type)classArray, (ParameterizedType)type, (Map)((Object)serializable));
        }
        bl3 = type instanceof GenericArrayType;
        if (bl3) {
            boolean bl4;
            type = this.rawType;
            Class clazz = $Gson$Types.getRawType((Type)classArray);
            bl2 = ((Class)type).isAssignableFrom(clazz);
            if (bl2 && (bl4 = TypeToken.isAssignableFrom((Type)classArray, (GenericArrayType)(type = (GenericArrayType)this.type)))) {
                n10 = n11;
            }
            return n10 != 0;
        }
        classArray = new Class[3];
        classArray[0] = Class.class;
        classArray[n11] = ParameterizedType.class;
        classArray[2] = GenericArrayType.class;
        throw TypeToken.buildUnexpectedTypeError(type, classArray);
    }

    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }
}

