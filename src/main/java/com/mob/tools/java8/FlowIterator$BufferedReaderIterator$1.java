/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.FlowIterator$BufferedReaderIterator;

public class FlowIterator$BufferedReaderIterator$1
implements Closure$IClosure {
    public final /* synthetic */ FlowIterator$BufferedReaderIterator this$0;

    public FlowIterator$BufferedReaderIterator$1(FlowIterator$BufferedReaderIterator flowIterator$BufferedReaderIterator) {
        this.this$0 = flowIterator$BufferedReaderIterator;
    }

    public String call() {
        return FlowIterator$BufferedReaderIterator.access$000(this.this$0).readLine();
    }
}

