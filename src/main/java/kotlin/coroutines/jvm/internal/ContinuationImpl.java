/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.jvm.internal;

import f.b2.c;
import f.b2.d;
import f.b2.d$b;
import f.b2.k.a.b;
import f.h2.t.f0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

public abstract class ContinuationImpl
extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient c a;

    public ContinuationImpl(c c10) {
        CoroutineContext coroutineContext = c10 != null ? c10.getContext() : null;
        this(c10, coroutineContext);
    }

    public ContinuationImpl(c c10, CoroutineContext coroutineContext) {
        super(c10);
        this._context = coroutineContext;
    }

    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        f0.m(coroutineContext);
        return coroutineContext;
    }

    public final c intercepted() {
        Object object = this.a;
        if (object == null) {
            object = this.getContext();
            d$b d$b = d.g0;
            if ((object = (d)object.get(d$b)) == null || (object = object.b(this)) == null) {
                object = this;
            }
            this.a = object;
        }
        return object;
    }

    public void releaseIntercepted() {
        c c10 = this.a;
        if (c10 != null && c10 != this) {
            CoroutineContext coroutineContext = this.getContext();
            d$b d$b = d.g0;
            coroutineContext = coroutineContext.get(d$b);
            f0.m(coroutineContext);
            coroutineContext = (d)coroutineContext;
            coroutineContext.a(c10);
        }
        this.a = c10 = b.a;
    }
}

