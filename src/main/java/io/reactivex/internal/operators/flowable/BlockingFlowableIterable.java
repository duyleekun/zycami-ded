/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable$BlockingFlowableIterator;
import java.util.Iterator;

public final class BlockingFlowableIterable
implements Iterable {
    public final j a;
    public final int b;

    public BlockingFlowableIterable(j j10, int n10) {
        this.a = j10;
        this.b = n10;
    }

    public Iterator iterator() {
        int n10 = this.b;
        BlockingFlowableIterable$BlockingFlowableIterator blockingFlowableIterable$BlockingFlowableIterator = new BlockingFlowableIterable$BlockingFlowableIterator(n10);
        this.a.l6(blockingFlowableIterable$BlockingFlowableIterator);
        return blockingFlowableIterable$BlockingFlowableIterator;
    }
}

