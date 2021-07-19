/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.FinalizableReferenceQueue$FinalizerLoader;

public class FinalizableReferenceQueue$DirectLoader
implements FinalizableReferenceQueue$FinalizerLoader {
    public Class loadFinalizer() {
        String string2 = "com.google.common.base.internal.Finalizer";
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            AssertionError assertionError = new AssertionError((Object)classNotFoundException);
            throw assertionError;
        }
    }
}

