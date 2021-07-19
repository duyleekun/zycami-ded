/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$EntrySet;
import java.util.Map;

public abstract class ForwardingMap$StandardEntrySet
extends Maps$EntrySet {
    public final /* synthetic */ ForwardingMap this$0;

    public ForwardingMap$StandardEntrySet(ForwardingMap forwardingMap) {
        this.this$0 = forwardingMap;
    }

    public Map map() {
        return this.this$0;
    }
}

