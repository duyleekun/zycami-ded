/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class ImmutableList$SubList
extends ImmutableList {
    public final transient int length;
    public final transient int offset;
    public final /* synthetic */ ImmutableList this$0;

    public ImmutableList$SubList(ImmutableList immutableList, int n10, int n11) {
        this.this$0 = immutableList;
        this.offset = n10;
        this.length = n11;
    }

    public Object get(int n10) {
        int n11 = this.length;
        Preconditions.checkElementIndex(n10, n11);
        ImmutableList immutableList = this.this$0;
        int n12 = this.offset;
        return immutableList.get(n10 += n12);
    }

    public Object[] internalArray() {
        return this.this$0.internalArray();
    }

    public int internalArrayEnd() {
        int n10 = this.this$0.internalArrayStart();
        int n11 = this.offset;
        n10 += n11;
        n11 = this.length;
        return n10 + n11;
    }

    public int internalArrayStart() {
        int n10 = this.this$0.internalArrayStart();
        int n11 = this.offset;
        return n10 + n11;
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.length;
    }

    public ImmutableList subList(int n10, int n11) {
        int n12 = this.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        ImmutableList immutableList = this.this$0;
        int n13 = this.offset;
        return immutableList.subList(n10 += n13, n11 += n13);
    }
}

