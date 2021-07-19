/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.disposables;

import e.a.s0.b;
import e.a.w0.b.a;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

public final class DisposableHelper
extends Enum
implements b {
    public static final /* enum */ DisposableHelper DISPOSED;
    private static final /* synthetic */ DisposableHelper[] a;

    static {
        DisposableHelper disposableHelper;
        DISPOSED = disposableHelper = new DisposableHelper("DISPOSED", 0);
        DisposableHelper[] disposableHelperArray = new DisposableHelper[]{disposableHelper};
        a = disposableHelperArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DisposableHelper() {
        void var2_-1;
        void var1_-1;
    }

    public static boolean dispose(AtomicReference object) {
        DisposableHelper disposableHelper;
        b b10 = (b)((AtomicReference)object).get();
        if (b10 != (disposableHelper = DISPOSED) && (object = (b)((AtomicReference)object).getAndSet(disposableHelper)) != disposableHelper) {
            if (object != null) {
                object.dispose();
            }
            return true;
        }
        return false;
    }

    public static boolean isDisposed(b b10) {
        boolean bl2;
        DisposableHelper disposableHelper = DISPOSED;
        if (b10 == disposableHelper) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public static boolean replace(AtomicReference atomicReference, b b10) {
        b b11;
        boolean bl2;
        do {
            DisposableHelper disposableHelper;
            if ((b11 = (b)atomicReference.get()) != (disposableHelper = DISPOSED)) continue;
            if (b10 != null) {
                b10.dispose();
            }
            return false;
        } while (!(bl2 = atomicReference.compareAndSet(b11, b10)));
        return true;
    }

    public static void reportDisposableSet() {
        ProtocolViolationException protocolViolationException = new ProtocolViolationException("Disposable already set!");
        e.a.a1.a.Y(protocolViolationException);
    }

    public static boolean set(AtomicReference atomicReference, b b10) {
        b b11;
        boolean bl2;
        do {
            DisposableHelper disposableHelper;
            if ((b11 = (b)atomicReference.get()) != (disposableHelper = DISPOSED)) continue;
            if (b10 != null) {
                b10.dispose();
            }
            return false;
        } while (!(bl2 = atomicReference.compareAndSet(b11, b10)));
        if (b11 != null) {
            b11.dispose();
        }
        return true;
    }

    public static boolean setOnce(AtomicReference atomicReference, b b10) {
        e.a.w0.b.a.g(b10, "d is null");
        boolean bl2 = atomicReference.compareAndSet(null, b10);
        if (!bl2) {
            b10.dispose();
            atomicReference = atomicReference.get();
            b10 = DISPOSED;
            if (atomicReference != b10) {
                DisposableHelper.reportDisposableSet();
            }
            return false;
        }
        return true;
    }

    public static boolean trySet(AtomicReference atomicReference, b b10) {
        DisposableHelper disposableHelper = null;
        boolean bl2 = atomicReference.compareAndSet(null, b10);
        if (!bl2) {
            if ((atomicReference = atomicReference.get()) == (disposableHelper = DISPOSED)) {
                b10.dispose();
            }
            return false;
        }
        return true;
    }

    public static boolean validate(b object, b b10) {
        if (b10 == null) {
            object = new NullPointerException("next is null");
            e.a.a1.a.Y((Throwable)object);
            return false;
        }
        if (object != null) {
            b10.dispose();
            DisposableHelper.reportDisposableSet();
            return false;
        }
        return true;
    }

    public static DisposableHelper valueOf(String string2) {
        return Enum.valueOf(DisposableHelper.class, string2);
    }

    public static DisposableHelper[] values() {
        return (DisposableHelper[])a.clone();
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}

