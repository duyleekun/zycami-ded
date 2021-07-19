/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.d;
import e.a.s0.b;
import io.reactivex.subjects.CompletableSubject;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject$CompletableDisposable
extends AtomicReference
implements b {
    private static final long serialVersionUID = -7650903191002190468L;
    public final d downstream;

    public CompletableSubject$CompletableDisposable(d d10, CompletableSubject completableSubject) {
        this.downstream = d10;
        this.lazySet(completableSubject);
    }

    public void dispose() {
        CompletableSubject completableSubject = this.getAndSet(null);
        if (completableSubject != null) {
            completableSubject.o1(this);
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

