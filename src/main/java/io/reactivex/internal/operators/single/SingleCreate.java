/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.m0;
import e.a.t0.a;
import io.reactivex.internal.operators.single.SingleCreate$Emitter;

public final class SingleCreate
extends i0 {
    public final m0 a;

    public SingleCreate(m0 m02) {
        this.a = m02;
    }

    public void e1(l0 object) {
        SingleCreate$Emitter singleCreate$Emitter = new SingleCreate$Emitter((l0)object);
        object.onSubscribe(singleCreate$Emitter);
        object = this.a;
        try {
            object.subscribe(singleCreate$Emitter);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            singleCreate$Emitter.onError(throwable);
        }
    }
}

