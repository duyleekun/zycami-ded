/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package e.a.q0;

import android.os.Looper;
import e.a.h0;
import e.a.q0.a$a;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
implements b {
    private final AtomicBoolean a;

    public a() {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean();
    }

    public static void b() {
        Object object;
        Object object2 = Looper.myLooper();
        if (object2 == (object = Looper.getMainLooper())) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Expected to be called on the main thread but was ");
        String string2 = Thread.currentThread().getName();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public abstract void a();

    public final void dispose() {
        Object object = this.a;
        Object object2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = Looper.myLooper();
            if (object == (object2 = Looper.getMainLooper())) {
                this.a();
            } else {
                object = e.a.q0.c.a.c();
                object2 = new a$a(this);
                ((h0)object).e((Runnable)object2);
            }
        }
    }

    public final boolean isDisposed() {
        return this.a.get();
    }
}

