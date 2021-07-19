/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Lifecycling$1;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static Map sCallbackCache;
    private static Map sClassToAdapters;

    static {
        HashMap hashMap;
        sCallbackCache = hashMap = new HashMap();
        sClassToAdapters = hashMap = new HashMap();
    }

    private Lifecycling() {
    }

    private static GeneratedAdapter createGeneratedAdapter(Constructor constructor, Object object) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        constructor = constructor.newInstance(objectArray);
        try {
            return (GeneratedAdapter)((Object)constructor);
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new RuntimeException(invocationTargetException);
            throw object;
        }
        catch (InstantiationException instantiationException) {
            object = new RuntimeException(instantiationException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new RuntimeException(illegalAccessException);
            throw object;
        }
    }

    private static Constructor generatedConstructor(Class genericDeclaration) {
        block25: {
            StringBuilder stringBuilder;
            int n10;
            Object object;
            Object object2;
            block24: {
                block23: {
                    block22: {
                        block21: {
                            object2 = ((Class)genericDeclaration).getPackage();
                            object = ((Class)genericDeclaration).getCanonicalName();
                            if (object2 == null) break block21;
                            object2 = ((Package)object2).getName();
                            break block22;
                        }
                        object2 = "";
                    }
                    boolean n11 = ((String)object2).isEmpty();
                    n10 = 1;
                    if (n11) break block23;
                    int n12 = ((String)object2).length() + n10;
                    object = object.substring(n12);
                }
                object = Lifecycling.getAdapterName((String)object);
                boolean bl2 = ((String)object2).isEmpty();
                if (bl2) break block24;
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                object2 = ".";
                stringBuilder.append((String)object2);
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
            }
            object2 = Class.forName((String)object);
            object = new Class[n10];
            boolean bl3 = false;
            stringBuilder = null;
            object[0] = genericDeclaration;
            genericDeclaration = ((Class)object2).getDeclaredConstructor((Class<?>)object);
            boolean bl4 = ((AccessibleObject)((Object)genericDeclaration)).isAccessible();
            if (bl4) break block25;
            try {
                ((Constructor)genericDeclaration).setAccessible(n10 != 0);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object2 = new RuntimeException(noSuchMethodException);
                throw object2;
            }
            catch (ClassNotFoundException classNotFoundException) {
                return null;
            }
        }
        return genericDeclaration;
    }

    public static String getAdapterName(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        string2 = string2.replace(".", "_");
        stringBuilder.append(string2);
        stringBuilder.append("_LifecycleAdapter");
        return stringBuilder.toString();
    }

    public static GenericLifecycleObserver getCallback(Object object) {
        object = Lifecycling.lifecycleEventObserver(object);
        Lifecycling$1 lifecycling$1 = new Lifecycling$1((LifecycleEventObserver)object);
        return lifecycling$1;
    }

    private static int getObserverConstructorType(Class clazz) {
        Integer n10 = (Integer)sCallbackCache.get(clazz);
        if (n10 != null) {
            return n10;
        }
        int n11 = Lifecycling.resolveObserverCallbackType(clazz);
        Map map = sCallbackCache;
        Integer n12 = n11;
        map.put(clazz, n12);
        return n11;
    }

    private static boolean isLifecycleParent(Class clazz) {
        Class<LifecycleObserver> clazz2;
        boolean bl2;
        if (clazz != null && (bl2 = (clazz2 = LifecycleObserver.class).isAssignableFrom(clazz))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public static LifecycleEventObserver lifecycleEventObserver(Object object) {
        int n10;
        boolean bl2 = object instanceof LifecycleEventObserver;
        int n11 = object instanceof FullLifecycleObserver;
        if (bl2 && n11 != 0) {
            Object object2 = object;
            object2 = (FullLifecycleObserver)object;
            object = (LifecycleEventObserver)object;
            FullLifecycleObserverAdapter fullLifecycleObserverAdapter = new FullLifecycleObserverAdapter((FullLifecycleObserver)object2, (LifecycleEventObserver)object);
            return fullLifecycleObserverAdapter;
        }
        if (n11 != 0) {
            object = (FullLifecycleObserver)object;
            FullLifecycleObserverAdapter fullLifecycleObserverAdapter = new FullLifecycleObserverAdapter((FullLifecycleObserver)object, null);
            return fullLifecycleObserverAdapter;
        }
        if (bl2) {
            return (LifecycleEventObserver)object;
        }
        Class clazz = object.getClass();
        n11 = Lifecycling.getObserverConstructorType(clazz);
        if (n11 == (n10 = 2)) {
            GeneratedAdapter[] generatedAdapterArray = sClassToAdapters;
            clazz = (List)generatedAdapterArray.get(clazz);
            n11 = clazz.size();
            int n12 = 1;
            if (n11 == n12) {
                object = Lifecycling.createGeneratedAdapter((Constructor)clazz.get(0), object);
                clazz = new SingleGeneratedAdapterObserver((GeneratedAdapter)object);
                return clazz;
            }
            n11 = clazz.size();
            generatedAdapterArray = new GeneratedAdapter[n11];
            for (n10 = 0; n10 < (n12 = clazz.size()); ++n10) {
                GeneratedAdapter generatedAdapter;
                generatedAdapterArray[n10] = generatedAdapter = Lifecycling.createGeneratedAdapter((Constructor)clazz.get(n10), object);
            }
            object = new CompositeGeneratedAdaptersObserver(generatedAdapterArray);
            return object;
        }
        clazz = new ReflectiveGenericLifecycleObserver(object);
        return clazz;
    }

    private static int resolveObserverCallbackType(Class clazz) {
        String object = clazz.getCanonicalName();
        int n10 = 1;
        if (object == null) {
            return n10;
        }
        Constructor constructor = Lifecycling.generatedConstructor(clazz);
        int n11 = 2;
        if (constructor != null) {
            Map map = sClassToAdapters;
            List<Constructor> list = Collections.singletonList(constructor);
            map.put(clazz, list);
            return n11;
        }
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        boolean bl2 = classesInfoCache.hasLifecycleMethods(clazz);
        if (bl2) {
            return n10;
        }
        Class clazz2 = clazz.getSuperclass();
        int n12 = 0;
        ArrayList arrayList = null;
        int n13 = Lifecycling.isLifecycleParent(clazz2);
        if (n13 != 0) {
            n12 = Lifecycling.getObserverConstructorType(clazz2);
            if (n12 == n10) {
                return n10;
            }
            Map map = sClassToAdapters;
            Collection collection = (Collection)map.get(clazz2);
            arrayList = new ArrayList(collection);
        }
        for (Class<?> clazz3 : clazz.getInterfaces()) {
            int n14 = Lifecycling.isLifecycleParent(clazz3);
            if (n14 == 0) continue;
            n14 = Lifecycling.getObserverConstructorType(clazz3);
            if (n14 == n10) {
                return n10;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            Map map = sClassToAdapters;
            clazz3 = (Collection)map.get(clazz3);
            arrayList.addAll(clazz3);
        }
        if (arrayList != null) {
            sClassToAdapters.put(clazz, arrayList);
            return n11;
        }
        return n10;
    }
}

