/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$EnumSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

public class MultimapBuilder$MultimapBuilderWithKeys$6
extends MultimapBuilder$SetMultimapBuilder {
    public final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    public final /* synthetic */ Class val$valueClass;

    public MultimapBuilder$MultimapBuilderWithKeys$6(MultimapBuilder$MultimapBuilderWithKeys multimapBuilder$MultimapBuilderWithKeys, Class clazz) {
        this.this$0 = multimapBuilder$MultimapBuilderWithKeys;
        this.val$valueClass = clazz;
    }

    public SetMultimap build() {
        Class clazz = this.val$valueClass;
        MultimapBuilder$EnumSetSupplier multimapBuilder$EnumSetSupplier = new MultimapBuilder$EnumSetSupplier(clazz);
        return Multimaps.newSetMultimap(this.this$0.createMap(), multimapBuilder$EnumSetSupplier);
    }
}

