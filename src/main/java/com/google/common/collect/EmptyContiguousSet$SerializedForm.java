/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.EmptyContiguousSet$1;
import java.io.Serializable;

public final class EmptyContiguousSet$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final DiscreteDomain domain;

    private EmptyContiguousSet$SerializedForm(DiscreteDomain discreteDomain) {
        this.domain = discreteDomain;
    }

    public /* synthetic */ EmptyContiguousSet$SerializedForm(DiscreteDomain discreteDomain, EmptyContiguousSet$1 emptyContiguousSet$1) {
        this(discreteDomain);
    }

    private Object readResolve() {
        DiscreteDomain discreteDomain = this.domain;
        EmptyContiguousSet emptyContiguousSet = new EmptyContiguousSet(discreteDomain);
        return emptyContiguousSet;
    }
}

