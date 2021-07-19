/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;

public final class RegularImmutableTable$Values
extends ImmutableList {
    public final /* synthetic */ RegularImmutableTable this$0;

    private RegularImmutableTable$Values(RegularImmutableTable regularImmutableTable) {
        this.this$0 = regularImmutableTable;
    }

    public /* synthetic */ RegularImmutableTable$Values(RegularImmutableTable regularImmutableTable, RegularImmutableTable$1 regularImmutableTable$1) {
        this(regularImmutableTable);
    }

    public Object get(int n10) {
        return this.this$0.getValue(n10);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.this$0.size();
    }
}

