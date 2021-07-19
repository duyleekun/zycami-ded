/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$1;
import com.google.common.collect.MultimapBuilder$2;
import com.google.common.collect.MultimapBuilder$3;
import com.google.common.collect.MultimapBuilder$4;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Ordering;
import java.util.Comparator;

public abstract class MultimapBuilder {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    private MultimapBuilder() {
    }

    public /* synthetic */ MultimapBuilder(MultimapBuilder$1 var1_1) {
        this();
    }

    public static MultimapBuilder$MultimapBuilderWithKeys enumKeys(Class clazz) {
        Preconditions.checkNotNull(clazz);
        MultimapBuilder$4 multimapBuilder$4 = new MultimapBuilder$4(clazz);
        return multimapBuilder$4;
    }

    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys() {
        return MultimapBuilder.hashKeys(8);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys hashKeys(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedKeys");
        MultimapBuilder$1 multimapBuilder$1 = new MultimapBuilder$1(n10);
        return multimapBuilder$1;
    }

    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys() {
        return MultimapBuilder.linkedHashKeys(8);
    }

    public static MultimapBuilder$MultimapBuilderWithKeys linkedHashKeys(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedKeys");
        MultimapBuilder$2 multimapBuilder$2 = new MultimapBuilder$2(n10);
        return multimapBuilder$2;
    }

    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys() {
        return MultimapBuilder.treeKeys(Ordering.natural());
    }

    public static MultimapBuilder$MultimapBuilderWithKeys treeKeys(Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        MultimapBuilder$3 multimapBuilder$3 = new MultimapBuilder$3(comparator);
        return multimapBuilder$3;
    }

    public abstract Multimap build();

    public Multimap build(Multimap multimap) {
        Multimap multimap2 = this.build();
        multimap2.putAll(multimap);
        return multimap2;
    }
}

