/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import e.a.w0.e.b.w0;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapDelayed;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapImmediate;
import io.reactivex.internal.operators.flowable.FlowableConcatMap$a;
import io.reactivex.internal.util.ErrorMode;

public final class FlowableConcatMap
extends a {
    public final o c;
    public final int d;
    public final ErrorMode e;

    public FlowableConcatMap(j j10, o o10, int n10, ErrorMode errorMode) {
        super(j10);
        this.c = o10;
        this.d = n10;
        this.e = errorMode;
    }

    public static d K8(d d10, o o10, int n10, ErrorMode object) {
        boolean bl2;
        int[] nArray = FlowableConcatMap$a.a;
        int bl22 = ((Enum)object).ordinal();
        boolean bl3 = nArray[bl22];
        if (bl3 != (bl2 = true)) {
            boolean bl4 = 2 != 0;
            if (bl3 != bl4) {
                object = new FlowableConcatMap$ConcatMapImmediate(d10, o10, n10);
                return object;
            }
            object = new FlowableConcatMap$ConcatMapDelayed(d10, o10, n10, bl2);
            return object;
        }
        object = new FlowableConcatMap$ConcatMapDelayed(d10, o10, n10, false);
        return object;
    }

    public void m6(d d10) {
        j j10 = this.b;
        o o10 = this.c;
        boolean bl2 = w0.b(j10, d10, o10);
        if (bl2) {
            return;
        }
        j10 = this.b;
        o10 = this.c;
        int n10 = this.d;
        ErrorMode errorMode = this.e;
        d10 = FlowableConcatMap.K8(d10, o10, n10, errorMode);
        j10.subscribe(d10);
    }
}

