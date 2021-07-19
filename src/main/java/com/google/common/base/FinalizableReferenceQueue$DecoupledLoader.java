/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue;
import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinalizableReferenceQueue$DecoupledLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

    public URL getBaseUrl() {
        Object object = new StringBuilder();
        char c10 = '.';
        char c11 = '/';
        Object object2 = "com.google.common.base.internal.Finalizer".replace(c10, c11);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(".class");
        object = ((StringBuilder)object).toString();
        object2 = this.getClass().getClassLoader().getResource((String)object);
        if (object2 != null) {
            Object object3 = ((URL)object2).toString();
            c11 = (char)(((String)object3).endsWith((String)object) ? 1 : 0);
            if (c11 != '\u0000') {
                int n10 = ((String)object3).length();
                int n11 = ((String)object).length();
                object = ((String)object3).substring(0, n10 -= n11);
                object3 = new URL((URL)object2, (String)object);
                return object3;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unsupported path style: ");
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IOException((String)object2);
            throw object;
        }
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }

    public Class loadFinalizer() {
        Object object;
        Object object2;
        try {
            object2 = this.getBaseUrl();
        }
        catch (Exception exception) {
            object = FinalizableReferenceQueue.access$000();
            Level level = Level.WARNING;
            ((Logger)object).log(level, LOADING_ERROR, exception);
            return null;
        }
        object2 = this.newLoader((URL)object2);
        object = "com.google.common.base.internal.Finalizer";
        return ((ClassLoader)object2).loadClass((String)object);
    }

    public URLClassLoader newLoader(URL uRL) {
        URL[] uRLArray = new URL[]{uRL};
        URLClassLoader uRLClassLoader = new URLClassLoader(uRLArray, null);
        return uRLClassLoader;
    }
}

