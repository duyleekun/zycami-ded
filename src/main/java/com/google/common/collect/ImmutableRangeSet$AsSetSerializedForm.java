/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import java.io.Serializable;

public class ImmutableRangeSet$AsSetSerializedForm
implements Serializable {
    private final DiscreteDomain domain;
    private final ImmutableList ranges;

    public ImmutableRangeSet$AsSetSerializedForm(ImmutableList immutableList, DiscreteDomain discreteDomain) {
        this.ranges = immutableList;
        this.domain = discreteDomain;
    }

    public Object readResolve() {
        Object object = this.ranges;
        ImmutableRangeSet immutableRangeSet = new ImmutableRangeSet((ImmutableList)object);
        object = this.domain;
        return immutableRangeSet.asSet((DiscreteDomain)object);
    }
}

