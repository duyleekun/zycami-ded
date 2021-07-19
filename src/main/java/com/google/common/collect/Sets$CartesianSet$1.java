/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;

public final class Sets$CartesianSet$1
extends ImmutableList {
    public final /* synthetic */ ImmutableList val$axes;

    public Sets$CartesianSet$1(ImmutableList immutableList) {
        this.val$axes = immutableList;
    }

    public List get(int n10) {
        return ((ImmutableSet)this.val$axes.get(n10)).asList();
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.val$axes.size();
    }
}

