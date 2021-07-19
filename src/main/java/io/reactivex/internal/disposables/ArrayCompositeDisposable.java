/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.disposables;

import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable
extends AtomicReferenceArray
implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int n10) {
        super(n10);
    }

    public void dispose() {
        b b10;
        Object e10 = this.get(0);
        if (e10 != (b10 = DisposableHelper.DISPOSED)) {
            int n10 = this.length();
            for (int i10 = 0; i10 < n10; ++i10) {
                DisposableHelper disposableHelper;
                b10 = (b)this.get(i10);
                if (b10 == (disposableHelper = DisposableHelper.DISPOSED) || (b10 = (b)this.getAndSet(i10, disposableHelper)) == disposableHelper || b10 == null) continue;
                b10.dispose();
            }
        }
    }

    public boolean isDisposed() {
        DisposableHelper disposableHelper;
        boolean bl2 = false;
        Object e10 = this.get(0);
        if (e10 == (disposableHelper = DisposableHelper.DISPOSED)) {
            bl2 = true;
        }
        return bl2;
    }

    public b replaceResource(int n10, b b10) {
        b b11;
        boolean bl2;
        do {
            DisposableHelper disposableHelper;
            if ((b11 = (b)this.get(n10)) != (disposableHelper = DisposableHelper.DISPOSED)) continue;
            b10.dispose();
            return null;
        } while (!(bl2 = this.compareAndSet(n10, b11, b10)));
        return b11;
    }

    public boolean setResource(int n10, b b10) {
        b b11;
        boolean bl2;
        do {
            DisposableHelper disposableHelper;
            if ((b11 = (b)this.get(n10)) != (disposableHelper = DisposableHelper.DISPOSED)) continue;
            b10.dispose();
            return false;
        } while (!(bl2 = this.compareAndSet(n10, b11, b10)));
        if (b11 != null) {
            b11.dispose();
        }
        return true;
    }
}

