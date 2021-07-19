/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.a1.a;
import e.a.s;
import e.a.s0.b;
import e.a.t;
import e.a.v0.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCreate$Emitter
extends AtomicReference
implements s,
b {
    private static final long serialVersionUID = -2467358622224974244L;
    public final t downstream;

    public MaybeCreate$Emitter(t t10) {
        this.downstream = t10;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b)this.get());
    }

    public void onComplete() {
        Object object;
        Object object2 = this.get();
        if (object2 != (object = DisposableHelper.DISPOSED) && (object2 = (b)this.getAndSet(object)) != object) {
            try {
                object = this.downstream;
                object.onComplete();
            }
            finally {
                if (object2 != null) {
                    object2.dispose();
                }
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.tryOnError(throwable);
        if (!bl2) {
            a.Y(throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onSuccess(Object var1_1) {
        block8: {
            var2_3 /* !! */  = this.get();
            if (var2_3 /* !! */  == (var3_4 = DisposableHelper.DISPOSED) || (var2_3 /* !! */  = (b)this.getAndSet(var3_4)) == var3_4) break block8;
            if (var1_1 != null) ** GOTO lbl10
            try {
                var1_1 = this.downstream;
                var4_5 = "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.";
                var3_4 = new NullPointerException(var4_5);
                var1_1.onError((Throwable)var3_4);
                break block8;
lbl10:
                // 1 sources

                var3_4 = this.downstream;
                var3_4.onSuccess(var1_1);
            }
            finally {
                if (var2_3 /* !! */  != null) {
                    var2_3 /* !! */ .dispose();
                }
            }
        }
    }

    public void setCancellable(f f10) {
        CancellableDisposable cancellableDisposable = new CancellableDisposable(f10);
        this.setDisposable(cancellableDisposable);
    }

    public void setDisposable(b b10) {
        DisposableHelper.set(this, b10);
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        String string2 = MaybeCreate$Emitter.class.getSimpleName();
        objectArray[0] = string2;
        string2 = super.toString();
        objectArray[1] = string2;
        return String.format("%s{%s}", objectArray);
    }

    public boolean tryOnError(Throwable throwable) {
        Object object;
        Object object2;
        if (throwable == null) {
            object2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
            throwable = new NullPointerException((String)object2);
        }
        if ((object2 = this.get()) != (object = DisposableHelper.DISPOSED) && (object2 = (b)this.getAndSet(object)) != object) {
            try {
                object = this.downstream;
                object.onError(throwable);
                return true;
            }
            finally {
                if (object2 != null) {
                    object2.dispose();
                }
            }
        }
        return false;
    }
}

