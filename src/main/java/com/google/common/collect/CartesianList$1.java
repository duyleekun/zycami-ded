/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class CartesianList$1
extends ImmutableList {
    public final /* synthetic */ CartesianList this$0;
    public final /* synthetic */ int val$index;

    public CartesianList$1(CartesianList cartesianList, int n10) {
        this.this$0 = cartesianList;
        this.val$index = n10;
    }

    public Object get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        CartesianList cartesianList = this.this$0;
        int n12 = this.val$index;
        n11 = CartesianList.access$100(cartesianList, n12, n10);
        return ((List)CartesianList.access$000(this.this$0).get(n10)).get(n11);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return CartesianList.access$000(this.this$0).size();
    }
}

