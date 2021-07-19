/*
 * Decompiled with CFR 0.151.
 */
package e.a.t0;

import io.reactivex.internal.util.ExceptionHelper;

public final class a {
    private a() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static RuntimeException a(Throwable throwable) {
        throw ExceptionHelper.f(throwable);
    }

    public static void b(Throwable throwable) {
        boolean bl2 = throwable instanceof VirtualMachineError;
        if (!bl2) {
            bl2 = throwable instanceof ThreadDeath;
            if (!bl2) {
                bl2 = throwable instanceof LinkageError;
                if (!bl2) {
                    return;
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }
}

