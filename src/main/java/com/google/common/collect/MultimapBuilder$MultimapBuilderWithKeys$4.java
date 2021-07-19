/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$LinkedHashSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import java.util.Map;

public class MultimapBuilder$MultimapBuilderWithKeys$4
extends MultimapBuilder$SetMultimapBuilder {
    public final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    public final /* synthetic */ int val$expectedValuesPerKey;

    public MultimapBuilder$MultimapBuilderWithKeys$4(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, int n10) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$expectedValuesPerKey = n10;
    }

    public SetMultimap build() {
        Map map = this.this$0.createMap();
        int n10 = this.val$expectedValuesPerKey;
        MultimapBuilder$LinkedHashSetSupplier multimapBuilder$LinkedHashSetSupplier = new MultimapBuilder$LinkedHashSetSupplier(n10);
        return Multimaps.newSetMultimap(map, multimapBuilder$LinkedHashSetSupplier);
    }
}

