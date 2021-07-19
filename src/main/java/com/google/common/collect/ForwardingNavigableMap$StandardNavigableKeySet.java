/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableMap;
import com.google.common.collect.Maps$NavigableKeySet;

public class ForwardingNavigableMap$StandardNavigableKeySet
extends Maps$NavigableKeySet {
    public final /* synthetic */ ForwardingNavigableMap this$0;

    public ForwardingNavigableMap$StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
        this.this$0 = forwardingNavigableMap;
        super(forwardingNavigableMap);
    }
}

