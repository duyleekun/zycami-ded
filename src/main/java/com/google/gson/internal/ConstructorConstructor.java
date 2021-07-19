/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.ConstructorConstructor$1;
import com.google.gson.internal.ConstructorConstructor$10;
import com.google.gson.internal.ConstructorConstructor$11;
import com.google.gson.internal.ConstructorConstructor$12;
import com.google.gson.internal.ConstructorConstructor$13;
import com.google.gson.internal.ConstructorConstructor$14;
import com.google.gson.internal.ConstructorConstructor$2;
import com.google.gson.internal.ConstructorConstructor$3;
import com.google.gson.internal.ConstructorConstructor$4;
import com.google.gson.internal.ConstructorConstructor$6;
import com.google.gson.internal.ConstructorConstructor$7;
import com.google.gson.internal.ConstructorConstructor$8;
import com.google.gson.internal.ConstructorConstructor$9;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

public final class ConstructorConstructor {
    private final ReflectionAccessor accessor;
    private final Map instanceCreators;

    public ConstructorConstructor(Map map) {
        ReflectionAccessor reflectionAccessor;
        this.accessor = reflectionAccessor = ReflectionAccessor.getInstance();
        this.instanceCreators = map;
    }

    private ObjectConstructor newDefaultConstructor(Class genericDeclaration) {
        Object object;
        block7: {
            boolean bl2 = false;
            object = null;
            try {
                object = new Class[]{};
            }
            catch (NoSuchMethodException noSuchMethodException) {
                return null;
            }
            genericDeclaration = ((Class)genericDeclaration).getDeclaredConstructor((Class<?>)object);
            bl2 = ((AccessibleObject)((Object)genericDeclaration)).isAccessible();
            if (bl2) break block7;
            object = this.accessor;
            ((ReflectionAccessor)object).makeAccessible((AccessibleObject)((Object)genericDeclaration));
        }
        object = new ConstructorConstructor$3(this, (Constructor)genericDeclaration);
        return object;
    }

    private ObjectConstructor newDefaultImplementationConstructor(Type object, Class clazz) {
        Class clazz2 = Collection.class;
        boolean bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            clazz2 = SortedSet.class;
            bl2 = clazz2.isAssignableFrom(clazz);
            if (bl2) {
                object = new ConstructorConstructor$4(this);
                return object;
            }
            clazz2 = EnumSet.class;
            bl2 = clazz2.isAssignableFrom(clazz);
            if (bl2) {
                clazz = new Class<String>(this, (Type)object);
                return clazz;
            }
            object = Set.class;
            boolean bl3 = object.isAssignableFrom(clazz);
            if (bl3) {
                object = new ConstructorConstructor$6(this);
                return object;
            }
            object = Queue.class;
            bl3 = object.isAssignableFrom(clazz);
            if (bl3) {
                object = new ConstructorConstructor$7(this);
                return object;
            }
            object = new ConstructorConstructor$8(this);
            return object;
        }
        clazz2 = Map.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            clazz2 = ConcurrentNavigableMap.class;
            bl2 = clazz2.isAssignableFrom(clazz);
            if (bl2) {
                object = new ConstructorConstructor$9(this);
                return object;
            }
            clazz2 = ConcurrentMap.class;
            bl2 = clazz2.isAssignableFrom(clazz);
            if (bl2) {
                object = new ConstructorConstructor$10(this);
                return object;
            }
            clazz2 = SortedMap.class;
            boolean bl4 = clazz2.isAssignableFrom(clazz);
            if (bl4) {
                object = new ConstructorConstructor$11(this);
                return object;
            }
            bl4 = object instanceof ParameterizedType;
            if (bl4) {
                clazz = String.class;
                object = ((ParameterizedType)object).getActualTypeArguments();
                bl2 = false;
                clazz2 = null;
                boolean bl5 = clazz.isAssignableFrom((Class<?>)(object = TypeToken.get(object[0]).getRawType()));
                if (!bl5) {
                    object = new ConstructorConstructor$12(this);
                    return object;
                }
            }
            object = new ConstructorConstructor$13(this);
            return object;
        }
        return null;
    }

    private ObjectConstructor newUnsafeAllocator(Type type, Class clazz) {
        ConstructorConstructor$14 constructorConstructor$14 = new ConstructorConstructor$14(this, clazz, type);
        return constructorConstructor$14;
    }

    public ObjectConstructor get(TypeToken object) {
        Type type = ((TypeToken)object).getType();
        object = ((TypeToken)object).getRawType();
        Object object2 = (InstanceCreator)this.instanceCreators.get(type);
        if (object2 != null) {
            object = new ConstructorConstructor$1(this, (InstanceCreator)object2, type);
            return object;
        }
        object2 = (InstanceCreator)this.instanceCreators.get(object);
        if (object2 != null) {
            object = new ConstructorConstructor$2(this, (InstanceCreator)object2, type);
            return object;
        }
        object2 = this.newDefaultConstructor((Class)object);
        if (object2 != null) {
            return object2;
        }
        object2 = this.newDefaultImplementationConstructor(type, (Class)object);
        if (object2 != null) {
            return object2;
        }
        return this.newUnsafeAllocator(type, (Class)object);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}

