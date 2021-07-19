/*
 * Decompiled with CFR 0.151.
 */
package com.ryanharter.auto.value.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.ryanharter.auto.value.gson.GenerateTypeAdapter;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Map;

public final class GenerateTypeAdapter$1
implements TypeAdapterFactory {
    private final Class a;
    private final Map b;

    public GenerateTypeAdapter$1() {
        Object object = Array.newInstance(Type.class, 0).getClass();
        this.a = object;
        this.b = object = Collections.synchronizedMap(object);
    }

    private Constructor a(Class clazz) {
        CharSequence charSequence;
        Class clazz2 = Gson.class;
        Object object = (Constructor)this.b.get(clazz);
        if (object != null) {
            return object;
        }
        object = clazz.getName();
        boolean bl2 = ((String)object).startsWith((String)(charSequence = "android."));
        if (!(bl2 || (bl2 = ((String)object).startsWith((String)(charSequence = "java."))) || (bl2 = ((String)object).startsWith((String)(charSequence = "kotlin."))))) {
            Object object2;
            block22: {
                bl2 = true;
                Object object3 = clazz.getName();
                Object object4 = "$";
                object2 = "_";
                object3 = ((String)object3).replace((CharSequence)object4, (CharSequence)object2);
                object4 = clazz.getClassLoader();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object3 = "_GsonTypeAdapter";
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
                object3 = ((ClassLoader)object4).loadClass((String)object3);
                object4 = null;
                object2 = new Class[bl2];
                object2[0] = clazz2;
                object2 = ((Class)object3).getDeclaredConstructor((Class<?>)object2);
                try {
                    ((Constructor)object2).setAccessible(bl2);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    int n10 = 2;
                    object2 = new Class[n10];
                    object2[0] = clazz2;
                    clazz2 = this.a;
                    object2[bl2] = clazz2;
                    object2 = ((Class)object3).getDeclaredConstructor((Class<?>)object2);
                    try {
                        ((Constructor)object2).setAccessible(bl2);
                    }
                    catch (NoSuchMethodException noSuchMethodException2) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Unable to find binding constructor for ");
                        ((StringBuilder)charSequence).append((String)object);
                        object = ((StringBuilder)charSequence).toString();
                        clazz2 = new RuntimeException((String)object, noSuchMethodException2);
                        throw clazz2;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        clazz2 = clazz.getSuperclass();
                        object2 = this.a(clazz2);
                        if (object2 == null) break block22;
                        ((Constructor)object2).setAccessible(bl2);
                    }
                }
            }
            this.b.put(clazz, object2);
            return object2;
        }
        return null;
    }

    public TypeAdapter create(Gson object, TypeToken objectArray) {
        Object[] objectArray2;
        int n10;
        GenericDeclaration genericDeclaration;
        Serializable serializable;
        CharSequence charSequence;
        block21: {
            Class<GenerateTypeAdapter> clazz;
            charSequence = "Unable to invoke ";
            serializable = objectArray.getRawType();
            genericDeclaration = GenerateTypeAdapter.class;
            boolean bl2 = ((Class)serializable).isAnnotationPresent((Class<? extends Annotation>)genericDeclaration);
            n10 = 0;
            objectArray2 = null;
            if (!bl2) {
                return null;
            }
            genericDeclaration = ((Class)serializable).getSuperclass();
            boolean bl3 = genericDeclaration.isAnnotationPresent(clazz = GenerateTypeAdapter.class);
            if (bl3) {
                return object.getAdapter((Class)genericDeclaration);
            }
            genericDeclaration = this.a((Class)serializable);
            if (genericDeclaration == null) {
                return null;
            }
            objectArray2 = ((Constructor)genericDeclaration).getParameterTypes();
            n10 = objectArray2.length;
            bl3 = false;
            clazz = null;
            int n11 = 1;
            if (n10 != n11) break block21;
            objectArray = new Object[n11];
            objectArray[0] = object;
            object = ((Constructor)genericDeclaration).newInstance(objectArray);
            return (TypeAdapter)object;
        }
        n10 = 2;
        objectArray2 = new Object[n10];
        objectArray2[0] = object;
        object = objectArray.getType();
        object = (ParameterizedType)object;
        object = object.getActualTypeArguments();
        objectArray2[n11] = object;
        object = ((Constructor)genericDeclaration).newInstance(objectArray2);
        try {
            return (TypeAdapter)object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = invocationTargetException.getCause();
            boolean bl4 = object instanceof RuntimeException;
            if (!bl4) {
                bl4 = object instanceof Error;
                if (bl4) {
                    throw (Error)object;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Could not create generated TypeAdapter instance for type ");
                ((StringBuilder)charSequence).append(serializable);
                charSequence = ((StringBuilder)charSequence).toString();
                objectArray = new RuntimeException((String)charSequence, (Throwable)object);
                throw objectArray;
            }
            throw (RuntimeException)object;
        }
        catch (InstantiationException instantiationException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)charSequence);
            ((StringBuilder)serializable).append(genericDeclaration);
            charSequence = ((StringBuilder)serializable).toString();
            objectArray = new RuntimeException((String)charSequence, instantiationException);
            throw objectArray;
        }
        catch (IllegalAccessException illegalAccessException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append((String)charSequence);
            ((StringBuilder)serializable).append(genericDeclaration);
            charSequence = ((StringBuilder)serializable).toString();
            objectArray = new RuntimeException((String)charSequence, illegalAccessException);
            throw objectArray;
        }
    }
}

