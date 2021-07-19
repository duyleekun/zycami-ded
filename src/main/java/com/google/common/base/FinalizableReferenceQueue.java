/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReference;
import com.google.common.base.FinalizableReferenceQueue$DecoupledLoader;
import com.google.common.base.FinalizableReferenceQueue$DirectLoader;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import com.google.common.base.FinalizableReferenceQueue$SystemLoader;
import java.io.Closeable;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue
implements Closeable {
    private static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    private static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    private static final Method startFinalizer;
    public final PhantomReference frqRef;
    public final ReferenceQueue queue;
    public final boolean threadStarted;

    static {
        FinalizableReferenceQueue$FinalizerLoader[] finalizableReferenceQueue$FinalizerLoaderArray = new FinalizableReferenceQueue$FinalizerLoader[3];
        FinalizableReferenceQueue$FinalizerLoader finalizableReferenceQueue$FinalizerLoader = new FinalizableReferenceQueue$SystemLoader();
        finalizableReferenceQueue$FinalizerLoaderArray[0] = finalizableReferenceQueue$FinalizerLoader;
        finalizableReferenceQueue$FinalizerLoader = new FinalizableReferenceQueue$DecoupledLoader();
        finalizableReferenceQueue$FinalizerLoaderArray[1] = finalizableReferenceQueue$FinalizerLoader;
        finalizableReferenceQueue$FinalizerLoader = new FinalizableReferenceQueue$DirectLoader();
        finalizableReferenceQueue$FinalizerLoaderArray[2] = finalizableReferenceQueue$FinalizerLoader;
        startFinalizer = FinalizableReferenceQueue.getStartFinalizer(FinalizableReferenceQueue.loadFinalizer(finalizableReferenceQueue$FinalizerLoaderArray));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FinalizableReferenceQueue() {
        ReferenceQueue referenceQueue;
        this.queue = referenceQueue = new ReferenceQueue();
        Object object = new PhantomReference(this, referenceQueue);
        this.frqRef = object;
        int n10 = 1;
        try {
            Class<FinalizableReference> clazz;
            Method object2 = startFinalizer;
            int n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = clazz = FinalizableReference.class;
            objectArray[n10] = referenceQueue;
            int n12 = 2;
            objectArray[n12] = object;
            object2.invoke(null, objectArray);
        }
        catch (Throwable throwable) {
            object = logger;
            Level level = Level.INFO;
            String string2 = "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.";
            ((Logger)object).log(level, string2, throwable);
            n10 = 0;
            level = null;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError((Object)illegalAccessException);
            throw object;
        }
        this.threadStarted = n10;
    }

    public static /* synthetic */ Logger access$000() {
        return logger;
    }

    public static Method getStartFinalizer(Class clazz) {
        Class clazz2;
        int n10;
        Class[] classArray;
        Object object = "startFinalizer";
        int n11 = 3;
        try {
            classArray = new Class[n11];
            n10 = 0;
            clazz2 = Class.class;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new AssertionError((Object)noSuchMethodException);
            throw object;
        }
        classArray[0] = clazz2;
        n10 = 1;
        clazz2 = ReferenceQueue.class;
        classArray[n10] = clazz2;
        n10 = 2;
        clazz2 = PhantomReference.class;
        classArray[n10] = clazz2;
        return clazz.getMethod((String)object, classArray);
    }

    private static Class loadFinalizer(FinalizableReferenceQueue$FinalizerLoader ... object) {
        int n10 = ((FinalizableReferenceQueue$FinalizerLoader[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Class clazz = object[i10].loadFinalizer();
            if (clazz == null) continue;
            return clazz;
        }
        object = new AssertionError();
        throw object;
    }

    public void cleanUp() {
        Object object;
        boolean bl2 = this.threadStarted;
        if (bl2) {
            return;
        }
        while ((object = this.queue.poll()) != null) {
            ((Reference)object).clear();
            object = (FinalizableReference)object;
            try {
                object.finalizeReferent();
            }
            catch (Throwable throwable) {
                Logger logger = FinalizableReferenceQueue.logger;
                Level level = Level.SEVERE;
                String string2 = "Error cleaning up after reference.";
                logger.log(level, string2, throwable);
            }
        }
    }

    public void close() {
        this.frqRef.enqueue();
        this.cleanUp();
    }
}

