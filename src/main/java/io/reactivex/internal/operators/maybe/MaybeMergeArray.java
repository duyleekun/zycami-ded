/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.j;
import e.a.w;
import i.g.d;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$ClqSimpleQueue;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$MergeMaybeObserver;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$MpscFillOnceSimpleQueue;
import io.reactivex.internal.operators.maybe.MaybeMergeArray$a;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeMergeArray
extends j {
    public final w[] b;

    public MaybeMergeArray(w[] wArray) {
        this.b = wArray;
    }

    public void m6(d object) {
        w[] wArray = this.b;
        int n10 = wArray.length;
        int n11 = j.f0();
        MaybeMergeArray$a maybeMergeArray$a = n10 <= n11 ? new MaybeMergeArray$MpscFillOnceSimpleQueue(n10) : new MaybeMergeArray$ClqSimpleQueue();
        MaybeMergeArray$MergeMaybeObserver maybeMergeArray$MergeMaybeObserver = new MaybeMergeArray$MergeMaybeObserver((d)object, n10, maybeMergeArray$a);
        object.onSubscribe(maybeMergeArray$MergeMaybeObserver);
        object = maybeMergeArray$MergeMaybeObserver.error;
        n10 = wArray.length;
        maybeMergeArray$a = null;
        for (n11 = 0; n11 < n10; ++n11) {
            Object v10;
            w w10 = wArray[n11];
            boolean bl2 = maybeMergeArray$MergeMaybeObserver.isCancelled();
            if (bl2 || (v10 = ((AtomicReference)object).get()) != null) break;
            w10.g(maybeMergeArray$MergeMaybeObserver);
        }
    }
}

