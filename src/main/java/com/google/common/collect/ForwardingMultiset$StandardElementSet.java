/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$ElementSet;
import java.util.Iterator;

public class ForwardingMultiset$StandardElementSet
extends Multisets$ElementSet {
    public final /* synthetic */ ForwardingMultiset this$0;

    public ForwardingMultiset$StandardElementSet(ForwardingMultiset forwardingMultiset) {
        this.this$0 = forwardingMultiset;
    }

    public Iterator iterator() {
        return Multisets.elementIterator(this.multiset().entrySet().iterator());
    }

    public Multiset multiset() {
        return this.this$0;
    }
}

