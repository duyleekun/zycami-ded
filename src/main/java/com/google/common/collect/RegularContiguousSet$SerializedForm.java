/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet;
import com.google.common.collect.RegularContiguousSet$1;
import java.io.Serializable;

public final class RegularContiguousSet$SerializedForm
implements Serializable {
    public final DiscreteDomain domain;
    public final Range range;

    private RegularContiguousSet$SerializedForm(Range range, DiscreteDomain discreteDomain) {
        this.range = range;
        this.domain = discreteDomain;
    }

    public /* synthetic */ RegularContiguousSet$SerializedForm(Range range, DiscreteDomain discreteDomain, RegularContiguousSet.1 var3_3) {
        this(range, discreteDomain);
    }

    private Object readResolve() {
        Range range = this.range;
        DiscreteDomain discreteDomain = this.domain;
        RegularContiguousSet regularContiguousSet = new RegularContiguousSet(range, discreteDomain);
        return regularContiguousSet;
    }
}

