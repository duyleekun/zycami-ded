/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

public class FinalizableReferenceQueue$SystemLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    public static boolean disabled;

    public Class loadFinalizer() {
        block5: {
            String string2;
            ClassLoader classLoader;
            boolean bl2 = disabled;
            if (bl2) {
                return null;
            }
            try {
                classLoader = ClassLoader.getSystemClassLoader();
                if (classLoader == null) break block5;
                string2 = "com.google.common.base.internal.Finalizer";
            }
            catch (SecurityException securityException) {
                FinalizableReferenceQueue.access$000().info("Not allowed to access system class loader.");
                return null;
            }
            try {
                return classLoader.loadClass(string2);
            }
            catch (ClassNotFoundException classNotFoundException) {}
        }
        return null;
    }
}

