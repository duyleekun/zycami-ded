/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder$ArrayListSupplier;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Multimaps;
import java.util.Map;

public class MultimapBuilder$MultimapBuilderWithKeys$1
extends MultimapBuilder$ListMultimapBuilder {
    public final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    public final /* synthetic */ int val$expectedValuesPerKey;

    public MultimapBuilder$MultimapBuilderWithKeys$1(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, int n10) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$expectedValuesPerKey = n10;
    }

    public ListMultimap build() {
        Map map = this.this$0.createMap();
        int n10 = this.val$expectedValuesPerKey;
        MultimapBuilder$ArrayListSupplier multimapBuilder$ArrayListSupplier = new MultimapBuilder$ArrayListSupplier(n10);
        return Multimaps.newListMultimap(map, multimapBuilder$ArrayListSupplier);
    }
}

