/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import e.a.s0.b;
import java.util.concurrent.atomic.AtomicReference;

public final class AutoDisposableHelper
extends Enum
implements b {
    public static final /* enum */ AutoDisposableHelper DISPOSED;
    private static final /* synthetic */ AutoDisposableHelper[] a;

    static {
        AutoDisposableHelper autoDisposableHelper;
        DISPOSED = autoDisposableHelper = new AutoDisposableHelper("DISPOSED", 0);
        AutoDisposableHelper[] autoDisposableHelperArray = new AutoDisposableHelper[]{autoDisposableHelper};
        a = autoDisposableHelperArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AutoDisposableHelper() {
        void var2_-1;
        void var1_-1;
    }

    public static boolean dispose(AtomicReference object) {
        AutoDisposableHelper autoDisposableHelper;
        b b10 = (b)((AtomicReference)object).get();
        if (b10 != (autoDisposableHelper = DISPOSED) && (object = (b)((AtomicReference)object).getAndSet(autoDisposableHelper)) != autoDisposableHelper) {
            if (object != null) {
                object.dispose();
            }
            return true;
        }
        return false;
    }

    public static AutoDisposableHelper valueOf(String string2) {
        return Enum.valueOf(AutoDisposableHelper.class, string2);
    }

    public static AutoDisposableHelper[] values() {
        return (AutoDisposableHelper[])a.clone();
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}

