/*
 * Decompiled with CFR 0.151.
 */
package f.b2.k.a;

import f.b2.c;
import f.o0;
import f.q1;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public final class h
implements c {
    private Result a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        synchronized (this) {
            while (true) {
                Object object;
                if ((object = this.a) != null) {
                    object = ((Result)object).unbox-impl();
                    o0.n(object);
                    return;
                }
                this.wait();
            }
        }
    }

    public final Result b() {
        return this.a;
    }

    public final void c(Result result2) {
        this.a = result2;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public void resumeWith(Object object) {
        synchronized (this) {
            this.a = object = Result.box-impl(object);
            this.notifyAll();
            object = q1.a;
            return;
        }
    }
}

