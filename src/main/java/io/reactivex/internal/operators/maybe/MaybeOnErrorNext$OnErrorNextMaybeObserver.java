/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w;
import e.a.w0.b.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext$OnErrorNextMaybeObserver$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext$OnErrorNextMaybeObserver
extends AtomicReference
implements t,
b {
    private static final long serialVersionUID = 2026620218879969836L;
    public final boolean allowFatal;
    public final t downstream;
    public final o resumeFunction;

    public MaybeOnErrorNext$OnErrorNextMaybeObserver(t t10, o o10, boolean bl2) {
        this.downstream = t10;
        this.resumeFunction = o10;
        this.allowFatal = bl2;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        boolean bl2 = this.allowFatal;
        if (!bl2 && !(bl2 = object instanceof Exception)) {
            this.downstream.onError((Throwable)object);
            return;
        }
        try {
            object3 = this.resumeFunction;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.downstream;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            object2.onError(compositeException);
            return;
        }
        object3 = object3.apply(object);
        object2 = "The resumeFunction returned a null MaybeSource";
        object3 = a.g(object3, (String)object2);
        object3 = (w)object3;
        DisposableHelper.replace(this, null);
        object2 = this.downstream;
        object = new MaybeOnErrorNext$OnErrorNextMaybeObserver$a((t)object2, this);
        object3.g((t)object);
    }

    public void onSubscribe(b object) {
        boolean bl2 = DisposableHelper.setOnce(this, (b)object);
        if (bl2) {
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.downstream.onSuccess(object);
    }
}

