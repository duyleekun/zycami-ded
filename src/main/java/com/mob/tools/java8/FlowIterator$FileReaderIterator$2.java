/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosureV;
import com.mob.tools.java8.FlowIterator$FileReaderIterator;

public class FlowIterator$FileReaderIterator$2
implements Closure$IClosureV {
    public final /* synthetic */ FlowIterator$FileReaderIterator this$0;

    public FlowIterator$FileReaderIterator$2(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator) {
        this.this$0 = flowIterator$FileReaderIterator;
    }

    public void call() {
        FlowIterator$FileReaderIterator.access$300(this.this$0).close();
        FlowIterator$FileReaderIterator.access$302(this.this$0, null);
    }
}

