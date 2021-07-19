/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.FluentIterable$3;
import java.util.Iterator;

public class FluentIterable$3$1
extends AbstractIndexedListIterator {
    public final /* synthetic */ FluentIterable$3 this$0;

    public FluentIterable$3$1(FluentIterable$3 fluentIterable$3, int n10) {
        this.this$0 = fluentIterable$3;
        super(n10);
    }

    public Iterator get(int n10) {
        return this.this$0.val$inputs[n10].iterator();
    }
}

