/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.v0.o;
import e.a.w0.e.e.a;
import e.a.y0.l;
import io.reactivex.internal.operators.observable.ObservableConcatMap$ConcatMapDelayErrorObserver;
import io.reactivex.internal.operators.observable.ObservableConcatMap$SourceObserver;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.util.ErrorMode;

public final class ObservableConcatMap
extends a {
    public final o b;
    public final int c;
    public final ErrorMode d;

    public ObservableConcatMap(e0 e02, o o10, int n10, ErrorMode errorMode) {
        super(e02);
        int n11;
        this.b = o10;
        this.d = errorMode;
        this.c = n11 = Math.max(8, n10);
    }

    public void K5(g0 object) {
        Object object2 = this.a;
        Object object3 = this.b;
        boolean bl2 = ObservableScalarXMap.b(object2, (g0)object, object3);
        if (bl2) {
            return;
        }
        object2 = this.d;
        object3 = ErrorMode.IMMEDIATE;
        if (object2 == object3) {
            object2 = new l((g0)object);
            object = this.a;
            o o10 = this.b;
            int n10 = this.c;
            object3 = new ObservableConcatMap$SourceObserver((g0)object2, o10, n10);
            object.subscribe((g0)object3);
        } else {
            boolean bl3;
            object2 = this.a;
            o o11 = this.b;
            int n11 = this.c;
            ErrorMode errorMode = this.d;
            ErrorMode errorMode2 = ErrorMode.END;
            if (errorMode == errorMode2) {
                bl3 = true;
            } else {
                bl3 = false;
                errorMode = null;
            }
            object3 = new ObservableConcatMap$ConcatMapDelayErrorObserver((g0)object, o11, n11, bl3);
            object2.subscribe((g0)object3);
        }
    }
}

