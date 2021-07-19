/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import java.util.Map;

public final class Maps$13
implements Function {
    public final /* synthetic */ Maps$EntryTransformer val$transformer;

    public Maps$13(Maps$EntryTransformer maps$EntryTransformer) {
        this.val$transformer = maps$EntryTransformer;
    }

    public Map.Entry apply(Map.Entry entry) {
        return Maps.transformEntry(this.val$transformer, entry);
    }
}

