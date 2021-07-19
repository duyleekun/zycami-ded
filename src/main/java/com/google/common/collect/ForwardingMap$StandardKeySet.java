/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$KeySet;

public class ForwardingMap$StandardKeySet
extends Maps$KeySet {
    public final /* synthetic */ ForwardingMap this$0;

    public ForwardingMap$StandardKeySet(ForwardingMap forwardingMap) {
        this.this$0 = forwardingMap;
        super(forwardingMap);
    }
}

