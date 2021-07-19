/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.a1.a;
import e.a.s0.b;
import i.g.e;
import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class f {
    private f() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("It is not allowed to subscribe with a(n) ");
        stringBuilder.append(string2);
        stringBuilder.append(" multiple times. Please create a fresh instance of ");
        stringBuilder.append(string2);
        stringBuilder.append(" and subscribe that to the target source instead.");
        return stringBuilder.toString();
    }

    public static void b(Class object) {
        object = f.a(((Class)object).getName());
        ProtocolViolationException protocolViolationException = new ProtocolViolationException((String)object);
        a.Y(protocolViolationException);
    }

    public static boolean c(AtomicReference atomicReference, b b10, Class clazz) {
        e.a.w0.b.a.g(b10, "next is null");
        boolean bl2 = atomicReference.compareAndSet(null, b10);
        if (!bl2) {
            b10.dispose();
            atomicReference = atomicReference.get();
            b10 = DisposableHelper.DISPOSED;
            if (atomicReference != b10) {
                f.b(clazz);
            }
            return false;
        }
        return true;
    }

    public static boolean d(AtomicReference atomicReference, e e10, Class clazz) {
        e.a.w0.b.a.g(e10, "next is null");
        boolean bl2 = atomicReference.compareAndSet(null, e10);
        if (!bl2) {
            e10.cancel();
            atomicReference = atomicReference.get();
            e10 = SubscriptionHelper.CANCELLED;
            if (atomicReference != e10) {
                f.b(clazz);
            }
            return false;
        }
        return true;
    }

    public static boolean e(b b10, b b11, Class clazz) {
        String string2 = "next is null";
        e.a.w0.b.a.g(b11, string2);
        if (b10 != null) {
            b11.dispose();
            b11 = DisposableHelper.DISPOSED;
            if (b10 != b11) {
                f.b(clazz);
            }
            return false;
        }
        return true;
    }

    public static boolean f(e e10, e e11, Class clazz) {
        String string2 = "next is null";
        e.a.w0.b.a.g(e11, string2);
        if (e10 != null) {
            e11.cancel();
            e11 = SubscriptionHelper.CANCELLED;
            if (e10 != e11) {
                f.b(clazz);
            }
            return false;
        }
        return true;
    }
}

