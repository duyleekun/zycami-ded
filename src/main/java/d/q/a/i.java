/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposableHelper;
import com.uber.autodispose.AutoSubscriptionHelper;
import d.q.a.p;
import e.a.a1.a;
import e.a.s0.b;
import i.g.e;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

public final class i {
    private i() {
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
        object = i.a(((Class)object).getName());
        ProtocolViolationException protocolViolationException = new ProtocolViolationException((String)object);
        a.Y(protocolViolationException);
    }

    public static boolean c(AtomicReference atomicReference, b b10, Class clazz) {
        p.a(b10, "next is null");
        boolean bl2 = atomicReference.compareAndSet(null, b10);
        if (!bl2) {
            b10.dispose();
            atomicReference = atomicReference.get();
            b10 = AutoDisposableHelper.DISPOSED;
            if (atomicReference != b10) {
                i.b(clazz);
            }
            return false;
        }
        return true;
    }

    public static boolean d(AtomicReference atomicReference, e e10, Class clazz) {
        p.a(e10, "next is null");
        boolean bl2 = atomicReference.compareAndSet(null, e10);
        if (!bl2) {
            e10.cancel();
            atomicReference = atomicReference.get();
            e10 = AutoSubscriptionHelper.CANCELLED;
            if (atomicReference != e10) {
                i.b(clazz);
            }
            return false;
        }
        return true;
    }
}

