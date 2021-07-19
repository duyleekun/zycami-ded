/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.l0;
import e.a.s0.b;
import io.reactivex.subjects.SingleSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject$SingleDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -7650903191002190468L;
    public final l0 downstream;

    public SingleSubject$SingleDisposable(l0 l02, SingleSubject singleSubject) {
        this.downstream = l02;
        this.lazySet(singleSubject);
    }

    public void dispose() {
        SingleSubject singleSubject = this.getAndSet(null);
        if (singleSubject != null) {
            singleSubject.V1(this);
        }
    }

    public boolean isDisposed() {
        boolean bl2;
        Object v10 = this.get();
        if (v10 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }
}

