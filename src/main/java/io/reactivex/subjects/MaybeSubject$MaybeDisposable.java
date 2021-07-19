/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.s0.b;
import e.a.t;
import io.reactivex.subjects.MaybeSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject$MaybeDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -7650903191002190468L;
    public final t downstream;

    public MaybeSubject$MaybeDisposable(t t10, MaybeSubject maybeSubject) {
        this.downstream = t10;
        this.lazySet(maybeSubject);
    }

    public void dispose() {
        MaybeSubject maybeSubject = this.getAndSet(null);
        if (maybeSubject != null) {
            maybeSubject.n2(this);
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

