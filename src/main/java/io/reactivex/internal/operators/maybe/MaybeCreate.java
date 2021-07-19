/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.q;
import e.a.t;
import e.a.t0.a;
import e.a.u;
import io.reactivex.internal.operators.maybe.MaybeCreate$Emitter;

public final class MaybeCreate
extends q {
    public final u a;

    public MaybeCreate(u u10) {
        this.a = u10;
    }

    public void t1(t object) {
        MaybeCreate$Emitter maybeCreate$Emitter = new MaybeCreate$Emitter((t)object);
        object.onSubscribe(maybeCreate$Emitter);
        object = this.a;
        try {
            object.a(maybeCreate$Emitter);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            maybeCreate$Emitter.onError(throwable);
        }
    }
}

