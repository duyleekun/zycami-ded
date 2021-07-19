/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.e;
import e.a.t0.a;
import io.reactivex.internal.operators.completable.CompletableCreate$Emitter;

public final class CompletableCreate
extends e.a.a {
    public final e a;

    public CompletableCreate(e e10) {
        this.a = e10;
    }

    public void L0(d object) {
        CompletableCreate$Emitter completableCreate$Emitter = new CompletableCreate$Emitter((d)object);
        object.onSubscribe(completableCreate$Emitter);
        object = this.a;
        try {
            object.a(completableCreate$Emitter);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            completableCreate$Emitter.onError(throwable);
        }
    }
}

