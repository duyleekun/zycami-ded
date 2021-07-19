/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$1;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.MultimapBuilder$SortedSetMultimapBuilder;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

public abstract class MultimapBuilder$MultimapBuilderWithKeys {
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

    public MultimapBuilder$ListMultimapBuilder arrayListValues() {
        return this.arrayListValues(2);
    }

    public MultimapBuilder$ListMultimapBuilder arrayListValues(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedValuesPerKey");
        MultimapBuilder$MultimapBuilderWithKeys$1 multimapBuilder$MultimapBuilderWithKeys$1 = new MultimapBuilder$MultimapBuilderWithKeys$1(this, n10);
        return multimapBuilder$MultimapBuilderWithKeys$1;
    }

    public abstract Map createMap();

    public MultimapBuilder$SetMultimapBuilder enumSetValues(Class clazz) {
        Preconditions.checkNotNull(clazz, "valueClass");
        MultimapBuilder$MultimapBuilderWithKeys$6 multimapBuilder$MultimapBuilderWithKeys$6 = new MultimapBuilder$MultimapBuilderWithKeys$6(this, clazz);
        return multimapBuilder$MultimapBuilderWithKeys$6;
    }

    public MultimapBuilder$SetMultimapBuilder hashSetValues() {
        return this.hashSetValues(2);
    }

    public MultimapBuilder$SetMultimapBuilder hashSetValues(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedValuesPerKey");
        MultimapBuilder$MultimapBuilderWithKeys$3 multimapBuilder$MultimapBuilderWithKeys$3 = new MultimapBuilder$MultimapBuilderWithKeys$3(this, n10);
        return multimapBuilder$MultimapBuilderWithKeys$3;
    }

    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues() {
        return this.linkedHashSetValues(2);
    }

    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedValuesPerKey");
        MultimapBuilder$MultimapBuilderWithKeys$4 multimapBuilder$MultimapBuilderWithKeys$4 = new MultimapBuilder$MultimapBuilderWithKeys$4(this, n10);
        return multimapBuilder$MultimapBuilderWithKeys$4;
    }

    public MultimapBuilder$ListMultimapBuilder linkedListValues() {
        MultimapBuilder$MultimapBuilderWithKeys$2 multimapBuilder$MultimapBuilderWithKeys$2 = new MultimapBuilder$MultimapBuilderWithKeys$2(this);
        return multimapBuilder$MultimapBuilderWithKeys$2;
    }

    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues() {
        Ordering ordering = Ordering.natural();
        return this.treeSetValues(ordering);
    }

    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues(Comparator comparator) {
        Preconditions.checkNotNull(comparator, "comparator");
        MultimapBuilder$MultimapBuilderWithKeys$5 multimapBuilder$MultimapBuilderWithKeys$5 = new MultimapBuilder$MultimapBuilderWithKeys$5(this, comparator);
        return multimapBuilder$MultimapBuilderWithKeys$5;
    }
}

