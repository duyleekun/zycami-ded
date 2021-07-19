/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMapValues;
import java.util.Map;

public class ImmutableMapValues$2
extends ImmutableList {
    public final /* synthetic */ ImmutableMapValues this$0;
    public final /* synthetic */ ImmutableList val$entryList;

    public ImmutableMapValues$2(ImmutableMapValues immutableMapValues, ImmutableList immutableList) {
        this.this$0 = immutableMapValues;
        this.val$entryList = immutableList;
    }

    public Object get(int n10) {
        return ((Map.Entry)this.val$entryList.get(n10)).getValue();
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.val$entryList.size();
    }
}

