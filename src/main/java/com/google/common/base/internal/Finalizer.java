/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base.internal;

import java.io.Serializable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer
implements Runnable {
    private static final String FINALIZABLE_REFERENCE = "com.google.common.base.FinalizableReference";
    private static final Constructor bigThreadConstructor;
    private static final Field inheritableThreadLocals;
    private static final Logger logger;
    private final WeakReference finalizableReferenceClassReference;
    private final PhantomReference frqReference;
    private final ReferenceQueue queue;

    static {
        AccessibleObject accessibleObject;
        logger = Logger.getLogger(Finalizer.class.getName());
        bigThreadConstructor = accessibleObject = Finalizer.getBigThreadConstructor();
        accessibleObject = accessibleObject == null ? Finalizer.getInheritableThreadLocalsField() : null;
        inheritableThreadLocals = accessibleObject;
    }

    private Finalizer(Class clazz, ReferenceQueue weakReference, PhantomReference phantomReference) {
        this.queue = weakReference;
        this.finalizableReferenceClassReference = weakReference = new WeakReference<Class>(clazz);
        this.frqReference = phantomReference;
    }

    private boolean cleanUp(Reference reference) {
        Method method = this.getFinalizeReferentMethod();
        if (method == null) {
            return false;
        }
        do {
            reference.clear();
            Object[] objectArray = this.frqReference;
            if (reference == objectArray) {
                return false;
            }
            objectArray = new Object[]{};
            try {
                method.invoke(reference, objectArray);
            }
            catch (Throwable throwable) {
                objectArray = logger;
                Level level = Level.SEVERE;
                String string2 = "Error cleaning up after reference.";
                objectArray.log(level, string2, throwable);
            }
        } while ((reference = this.queue.poll()) != null);
        return true;
    }

    private static Constructor getBigThreadConstructor() {
        Class clazz;
        int n10;
        Class[] classArray;
        Class<Thread> clazz2 = Thread.class;
        int n11 = 5;
        try {
            classArray = new Class[n11];
            n10 = 0;
            clazz = ThreadGroup.class;
        }
        catch (Throwable throwable) {
            return null;
        }
        classArray[0] = clazz;
        n10 = 1;
        clazz = Runnable.class;
        classArray[n10] = clazz;
        n10 = 2;
        clazz = String.class;
        classArray[n10] = clazz;
        n10 = 3;
        clazz = Long.TYPE;
        classArray[n10] = clazz;
        n10 = 4;
        clazz = Boolean.TYPE;
        classArray[n10] = clazz;
        return clazz2.getConstructor(classArray);
    }

    private Method getFinalizeReferentMethod() {
        Class clazz = (Class)this.finalizableReferenceClassReference.get();
        if (clazz == null) {
            return null;
        }
        Object object = "finalizeReferent";
        Class[] classArray = null;
        try {
            classArray = new Class[]{};
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new AssertionError((Object)noSuchMethodException);
            throw object;
        }
        return clazz.getMethod((String)object, classArray);
    }

    private static Field getInheritableThreadLocalsField() {
        boolean bl2;
        Object object = Thread.class;
        Object object2 = "inheritableThreadLocals";
        try {
            object = ((Class)object).getDeclaredField((String)object2);
            bl2 = true;
        }
        catch (Throwable throwable) {
            object = logger;
            object2 = Level.INFO;
            ((Logger)object).log((Level)object2, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
        ((Field)object).setAccessible(bl2);
        return object;
    }

    public static void startFinalizer(Class object, ReferenceQueue object2, PhantomReference object3) {
        String string2;
        Object object4 = ((Class)object).getName();
        boolean bl2 = ((String)object4).equals(string2 = FINALIZABLE_REFERENCE);
        if (bl2) {
            block18: {
                int n10;
                block17: {
                    object4 = new Finalizer((Class)object, (ReferenceQueue)object2, (PhantomReference)object3);
                    object = Finalizer.class.getName();
                    object2 = bigThreadConstructor;
                    n10 = 1;
                    string2 = null;
                    if (object2 != null) {
                        long l10 = 0L;
                        int n11 = 5;
                        Object[] objectArray = new Object[n11];
                        int n12 = 0;
                        objectArray[0] = null;
                        objectArray[n10] = object4;
                        n12 = 2;
                        objectArray[n12] = object;
                        n12 = 3;
                        Object object5 = l10;
                        objectArray[n12] = object5;
                        int n13 = 4;
                        Serializable serializable = Boolean.FALSE;
                        objectArray[n13] = serializable;
                        object2 = ((Constructor)object2).newInstance(objectArray);
                        try {
                            object2 = (Thread)object2;
                            break block17;
                        }
                        catch (Throwable throwable) {
                            object5 = logger;
                            serializable = Level.INFO;
                            objectArray = "Failed to create a thread without inherited thread-local values";
                            ((Logger)object5).log((Level)serializable, (String)objectArray, throwable);
                        }
                    }
                    object2 = null;
                }
                if (object2 == null) {
                    object2 = new Thread(null, (Runnable)object4, (String)object);
                }
                ((Thread)object2).setDaemon(n10 != 0);
                object = inheritableThreadLocals;
                if (object == null) break block18;
                try {
                    ((Field)object).set(object2, null);
                }
                catch (Throwable throwable) {
                    object3 = logger;
                    object4 = Level.INFO;
                    string2 = "Failed to clear thread local values inherited by reference finalizer thread.";
                    ((Logger)object3).log((Level)object4, string2, throwable);
                }
            }
            ((Thread)object2).start();
            return;
        }
        object = new IllegalArgumentException("Expected com.google.common.base.FinalizableReference.");
        throw object;
    }

    public void run() {
        while (true) {
            Object object;
            try {
                object = this.queue;
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            object = ((ReferenceQueue)object).remove();
            boolean bl2 = this.cleanUp((Reference)object);
            if (bl2) continue;
            return;
            break;
        }
    }
}

