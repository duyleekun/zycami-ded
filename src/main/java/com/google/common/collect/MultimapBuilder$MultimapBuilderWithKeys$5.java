/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SortedSetMultimapBuilder;
import com.google.common.collect.MultimapBuilder$TreeSetSupplier;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;
import java.util.Map;

public class MultimapBuilder$MultimapBuilderWithKeys$5
extends MultimapBuilder$SortedSetMultimapBuilder {
    public final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    public final /* synthetic */ Comparator val$comparator;

    public MultimapBuilder$MultimapBuilderWithKeys$5(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, Comparator comparator) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$comparator = comparator;
    }

    public SortedSetMultimap build() {
        Map map = this.this$0.createMap();
        Comparator comparator = this.val$comparator;
        MultimapBuilder$TreeSetSupplier multimapBuilder$TreeSetSupplier = new MultimapBuilder$TreeSetSupplier(comparator);
        return Multimaps.newSortedSetMultimap(map, multimapBuilder$TreeSetSupplier);
    }
}

