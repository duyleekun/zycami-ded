/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.reflect.Reflection;
import com.google.common.reflect.Types$1;
import com.google.common.reflect.Types$2;
import com.google.common.reflect.Types$ClassOwnership;
import com.google.common.reflect.Types$JavaVersion;
import com.google.common.reflect.Types$ParameterizedTypeImpl;
import com.google.common.reflect.Types$TypeVariableImpl;
import com.google.common.reflect.Types$TypeVariableInvocationHandler;
import com.google.common.reflect.Types$WildcardTypeImpl;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

public final class Types {
    private static final Joiner COMMA_JOINER;
    private static final Function TYPE_NAME;

    static {
        Types$1 types$1 = new Types$1();
        TYPE_NAME = types$1;
        COMMA_JOINER = Joiner.on(", ").useForNull("null");
    }

    private Types() {
    }

    public static /* synthetic */ Type access$100(Type[] typeArray) {
        return Types.subtypeOfComponentType(typeArray);
    }

    public static /* synthetic */ void access$200(Type[] typeArray, String string2) {
        Types.disallowPrimitiveType(typeArray, string2);
    }

    public static /* synthetic */ Type[] access$300(Collection collection) {
        return Types.toArray(collection);
    }

    public static /* synthetic */ Function access$400() {
        return TYPE_NAME;
    }

    public static /* synthetic */ Joiner access$500() {
        return COMMA_JOINER;
    }

    public static /* synthetic */ Iterable access$700(Iterable iterable) {
        return Types.filterUpperBounds(iterable);
    }

    private static void disallowPrimitiveType(Type[] typeArray, String string2) {
        for (Type type : typeArray) {
            boolean bl2 = type instanceof Class;
            if (!bl2) continue;
            type = (Class)type;
            bl2 = ((Class)type).isPrimitive() ^ true;
            String string3 = "Primitive type '%s' used as %s";
            Preconditions.checkArgument(bl2, string3, (Object)type, (Object)string2);
        }
    }

    private static Iterable filterUpperBounds(Iterable iterable) {
        Predicate predicate = Predicates.not(Predicates.equalTo(Object.class));
        return Iterables.filter(iterable, predicate);
    }

    public static Class getArrayClass(Class clazz) {
        return Array.newInstance(clazz, 0).getClass();
    }

    public static Type getComponentType(Type type) {
        Preconditions.checkNotNull(type);
        AtomicReference atomicReference = new AtomicReference();
        Types$2 types$2 = new Types$2(atomicReference);
        Type[] typeArray = new Type[]{type};
        types$2.visit(typeArray);
        return (Type)atomicReference.get();
    }

    public static Type newArrayType(Type typeArray) {
        int n10 = typeArray instanceof WildcardType;
        if (n10 != 0) {
            int n11;
            Type[] typeArray2 = (typeArray = (WildcardType)typeArray).getLowerBounds();
            int n12 = typeArray2.length;
            n12 = n12 <= (n11 = 1) ? n11 : 0;
            String string2 = "Wildcard cannot have more than one lower bounds.";
            Preconditions.checkArgument(n12 != 0, string2);
            n12 = typeArray2.length;
            if (n12 == n11) {
                return Types.supertypeOf(Types.newArrayType(typeArray2[0]));
            }
            n10 = (typeArray = typeArray.getUpperBounds()).length;
            if (n10 != n11) {
                n11 = 0;
            }
            Preconditions.checkArgument(n11 != 0, "Wildcard should have only one upper bound.");
            return Types.subtypeOf(Types.newArrayType(typeArray[0]));
        }
        return Types$JavaVersion.CURRENT.newArrayType((Type)typeArray);
    }

    public static TypeVariable newArtificialTypeVariable(GenericDeclaration genericDeclaration, String string2, Type ... typeArray) {
        int n10 = typeArray.length;
        if (n10 == 0) {
            int n11 = 1;
            typeArray = new Type[n11];
            n10 = 0;
            Class<Object> clazz = Object.class;
            typeArray[0] = clazz;
        }
        return Types.newTypeVariableImpl(genericDeclaration, string2, typeArray);
    }

    public static ParameterizedType newParameterizedType(Class clazz, Type ... typeArray) {
        Class clazz2 = Types$ClassOwnership.JVM_BEHAVIOR.getOwnerType(clazz);
        Types$ParameterizedTypeImpl types$ParameterizedTypeImpl = new Types$ParameterizedTypeImpl(clazz2, clazz, typeArray);
        return types$ParameterizedTypeImpl;
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Class clazz, Type ... typeArray) {
        boolean bl2;
        if (type == null) {
            return Types.newParameterizedType(clazz, typeArray);
        }
        Preconditions.checkNotNull(typeArray);
        Type type2 = clazz.getEnclosingClass();
        if (type2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            type2 = null;
        }
        Preconditions.checkArgument(bl2, "Owner type for unenclosed %s", (Object)clazz);
        type2 = new Type(type, clazz, typeArray);
        return type2;
    }

    private static TypeVariable newTypeVariableImpl(GenericDeclaration genericDeclaration, String object, Type[] typeArray) {
        Types$TypeVariableImpl types$TypeVariableImpl = new Types$TypeVariableImpl(genericDeclaration, (String)object, typeArray);
        object = new Types$TypeVariableInvocationHandler(types$TypeVariableImpl);
        return (TypeVariable)Reflection.newProxy(TypeVariable.class, (InvocationHandler)object);
    }

    public static WildcardType subtypeOf(Type type) {
        Type[] typeArray = new Type[]{};
        Type[] typeArray2 = new Type[]{type};
        Types$WildcardTypeImpl types$WildcardTypeImpl = new Types$WildcardTypeImpl(typeArray, typeArray2);
        return types$WildcardTypeImpl;
    }

    private static Type subtypeOfComponentType(Type[] object) {
        int n10 = ((Type[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Type type = Types.getComponentType(object[i10]);
            if (type == null) continue;
            boolean bl2 = type instanceof Class;
            if (bl2) {
                object = type;
                object = (Class)type;
                n10 = (int)(((Class)object).isPrimitive() ? 1 : 0);
                if (n10 != 0) {
                    return object;
                }
            }
            return Types.subtypeOf(type);
        }
        return null;
    }

    public static WildcardType supertypeOf(Type typeArray) {
        int n10 = 1;
        Type[] typeArray2 = new Type[n10];
        typeArray2[0] = typeArray;
        typeArray = new Type[n10];
        typeArray[0] = Object.class;
        Types$WildcardTypeImpl types$WildcardTypeImpl = new Types$WildcardTypeImpl(typeArray2, typeArray);
        return types$WildcardTypeImpl;
    }

    private static Type[] toArray(Collection collection) {
        Type[] typeArray = new Type[]{};
        return collection.toArray(typeArray);
    }

    public static String toString(Type object) {
        boolean bl2 = object instanceof Class;
        object = bl2 ? ((Class)object).getName() : object.toString();
        return object;
    }
}

