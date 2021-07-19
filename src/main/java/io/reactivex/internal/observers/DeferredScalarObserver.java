/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.observers;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

public abstract class DeferredScalarObserver
extends DeferredScalarDisposable
implements g0 {
    private static final long serialVersionUID = -266195175408988651L;
    public b upstream;

    public DeferredScalarObserver(g0 g02) {
        super(g02);
    }

    public void dispose() {
        super.dispose();
        this.upstream.dispose();
    }

    public void onComplete() {
        Object object = this.value;
        if (object != null) {
            this.value = null;
            this.complete(object);
        } else {
            this.complete();
        }
    }

    public void onError(Throwable throwable) {
        this.value = null;
        this.error(throwable);
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }
}

