/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache$CallbackInfo;
import androidx.lifecycle.ClassesInfoCache$MethodReference;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    public static ClassesInfoCache sInstance;
    private final Map mCallbackMap;
    private final Map mHasLifecycleMethods;

    static {
        ClassesInfoCache classesInfoCache;
        sInstance = classesInfoCache = new ClassesInfoCache();
    }

    public ClassesInfoCache() {
        HashMap hashMap;
        this.mCallbackMap = hashMap = new HashMap();
        this.mHasLifecycleMethods = hashMap = new HashMap();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private ClassesInfoCache$CallbackInfo createInfo(Class serializable, Method[] object) {
        void var2_8;
        void var2_6;
        Object object2;
        int n10;
        Object object3 = ((Class)serializable).getSuperclass();
        HashMap hashMap = new HashMap();
        if (object3 != null && (object3 = this.getInfo((Class)object3)) != null) {
            object3 = ((ClassesInfoCache$CallbackInfo)object3).mHandlerToEvent;
            hashMap.putAll(object3);
        }
        object3 = ((Class)serializable).getInterfaces();
        int n11 = ((Class<?>[])object3).length;
        Object var7_15 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            boolean bl2;
            object2 = object3[n10];
            object2 = this.getInfo(object2).mHandlerToEvent.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Map.Entry entry = (Map.Entry)object2.next();
                ClassesInfoCache$MethodReference classesInfoCache$MethodReference = (ClassesInfoCache$MethodReference)entry.getKey();
                Lifecycle$Event lifecycle$Event = (Lifecycle$Event)((Object)entry.getValue());
                this.verifyAndPutHandler(hashMap, classesInfoCache$MethodReference, lifecycle$Event, (Class)serializable);
            }
        }
        if (var2_6 == null) {
            Method[] methodArray = this.getDeclaredMethods((Class)serializable);
        }
        int n12 = ((void)var2_8).length;
        n11 = 0;
        n10 = 0;
        Object var7_16 = null;
        while (true) {
            if (n11 >= n12) {
                ClassesInfoCache$CallbackInfo classesInfoCache$CallbackInfo = new ClassesInfoCache$CallbackInfo(hashMap);
                this.mCallbackMap.put(serializable, classesInfoCache$CallbackInfo);
                object3 = this.mHasLifecycleMethods;
                Boolean bl3 = n10 != 0;
                object3.put(serializable, bl3);
                return classesInfoCache$CallbackInfo;
            }
            object2 = var2_8[n11];
            OnLifecycleEvent onLifecycleEvent = ((Method)object2).getAnnotation(OnLifecycleEvent.class);
            int n13 = 1;
            if (onLifecycleEvent != null) {
                Class<?>[] classArray = ((Method)object2).getParameterTypes();
                int n14 = classArray.length;
                if (n14 > 0) {
                    Class<LifecycleOwner> clazz = classArray[0];
                    Class<LifecycleOwner> clazz2 = LifecycleOwner.class;
                    n14 = (int)(clazz.isAssignableFrom(clazz2) ? 1 : 0);
                    if (n14 == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        throw illegalArgumentException;
                    }
                    n14 = n13;
                } else {
                    n14 = 0;
                    Object var15_34 = null;
                }
                Lifecycle$Event lifecycle$Event = onLifecycleEvent.value();
                int n15 = classArray.length;
                int n16 = 2;
                if (n15 > n13) {
                    Class<Lifecycle$Event> clazz = classArray[n13];
                    Class<Lifecycle$Event> clazz3 = Lifecycle$Event.class;
                    n14 = (int)(clazz.isAssignableFrom(clazz3) ? 1 : 0);
                    if (n14 == 0) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid parameter type. second arg must be an event");
                        throw illegalArgumentException;
                    }
                    Lifecycle$Event lifecycle$Event2 = Lifecycle$Event.ON_ANY;
                    if (lifecycle$Event != lifecycle$Event2) {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        throw illegalArgumentException;
                    }
                    n14 = n16;
                }
                if ((n10 = classArray.length) > n16) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("cannot have more than 2 params");
                    throw illegalArgumentException;
                }
                ClassesInfoCache$MethodReference classesInfoCache$MethodReference = new ClassesInfoCache$MethodReference(n14, (Method)object2);
                this.verifyAndPutHandler(hashMap, classesInfoCache$MethodReference, lifecycle$Event, (Class)serializable);
                n10 = n13;
            }
            ++n11;
        }
    }

    private Method[] getDeclaredMethods(Class clazz) {
        try {
            return clazz.getDeclaredMethods();
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError);
            throw illegalArgumentException;
        }
    }

    private void verifyAndPutHandler(Map object, ClassesInfoCache$MethodReference object2, Lifecycle$Event lifecycle$Event, Class clazz) {
        Lifecycle$Event lifecycle$Event2 = (Lifecycle$Event)((Object)object.get(object2));
        if (lifecycle$Event2 != null && lifecycle$Event != lifecycle$Event2) {
            object = ((ClassesInfoCache$MethodReference)object2).mMethod;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            object = ((Method)object).getName();
            stringBuilder.append((String)object);
            stringBuilder.append(" in ");
            object = clazz.getName();
            stringBuilder.append((String)object);
            stringBuilder.append(" already declared with different @OnLifecycleEvent value: previous value ");
            stringBuilder.append((Object)lifecycle$Event2);
            stringBuilder.append(", new value ");
            stringBuilder.append((Object)lifecycle$Event);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        if (lifecycle$Event2 == null) {
            object.put(object2, lifecycle$Event);
        }
    }

    public ClassesInfoCache$CallbackInfo getInfo(Class clazz) {
        ClassesInfoCache$CallbackInfo classesInfoCache$CallbackInfo = (ClassesInfoCache$CallbackInfo)this.mCallbackMap.get(clazz);
        if (classesInfoCache$CallbackInfo != null) {
            return classesInfoCache$CallbackInfo;
        }
        return this.createInfo(clazz, null);
    }

    public boolean hasLifecycleMethods(Class clazz) {
        Object object = (Method[])this.mHasLifecycleMethods.get(clazz);
        if (object != null) {
            return (Boolean)object;
        }
        object = this.getDeclaredMethods(clazz);
        int n10 = ((Method[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = object[i10];
            Class<OnLifecycleEvent> clazz2 = OnLifecycleEvent.class;
            if ((object2 = ((Method)object2).getAnnotation(clazz2)) == null) continue;
            this.createInfo(clazz, (Method[])object);
            return true;
        }
        object = this.mHasLifecycleMethods;
        Boolean bl2 = Boolean.FALSE;
        object.put(clazz, bl2);
        return false;
    }
}

