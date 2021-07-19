/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMapValues;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;

public class ImmutableMapValues$1
extends UnmodifiableIterator {
    public final UnmodifiableIterator entryItr;
    public final /* synthetic */ ImmutableMapValues this$0;

    public ImmutableMapValues$1(ImmutableMapValues object) {
        this.this$0 = object;
        this.entryItr = object = ImmutableMapValues.access$000((ImmutableMapValues)object).entrySet().iterator();
    }

    public boolean hasNext() {
        return this.entryItr.hasNext();
    }

    public Object next() {
        return ((Map.Entry)this.entryItr.next()).getValue();
    }
}

