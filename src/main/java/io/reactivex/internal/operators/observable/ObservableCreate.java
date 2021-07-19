/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.c0;
import e.a.g0;
import e.a.t0.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableCreate$CreateEmitter;

public final class ObservableCreate
extends z {
    public final c0 a;

    public ObservableCreate(c0 c02) {
        this.a = c02;
    }

    public void K5(g0 object) {
        ObservableCreate$CreateEmitter observableCreate$CreateEmitter = new ObservableCreate$CreateEmitter((g0)object);
        object.onSubscribe(observableCreate$CreateEmitter);
        object = this.a;
        try {
            object.subscribe(observableCreate$CreateEmitter);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            observableCreate$CreateEmitter.onError(throwable);
        }
    }
}

