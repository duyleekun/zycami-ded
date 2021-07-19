/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import io.reactivex.internal.operators.observable.BlockingObservableIterable$BlockingObservableIterator;
import java.util.Iterator;

public final class BlockingObservableIterable
implements Iterable {
    public final e0 a;
    public final int b;

    public BlockingObservableIterable(e0 e02, int n10) {
        this.a = e02;
        this.b = n10;
    }

    public Iterator iterator() {
        int n10 = this.b;
        BlockingObservableIterable$BlockingObservableIterator blockingObservableIterable$BlockingObservableIterator = new BlockingObservableIterable$BlockingObservableIterator(n10);
        this.a.subscribe(blockingObservableIterable$BlockingObservableIterator);
        return blockingObservableIterable$BlockingObservableIterator;
    }
}

