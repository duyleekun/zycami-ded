/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import java.util.Collection;

public class Multimaps$UnmodifiableMultimap$1
implements Function {
    public final /* synthetic */ Multimaps$UnmodifiableMultimap this$0;

    public Multimaps$UnmodifiableMultimap$1(Multimaps$UnmodifiableMultimap multimaps$UnmodifiableMultimap) {
        this.this$0 = multimaps$UnmodifiableMultimap;
    }

    public Collection apply(Collection collection) {
        return Multimaps.access$000(collection);
    }
}

