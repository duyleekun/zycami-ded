/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Maps$UnmodifiableEntries;
import com.google.common.collect.Sets;
import java.util.Set;

public class Maps$UnmodifiableEntrySet
extends Maps$UnmodifiableEntries
implements Set {
    public Maps$UnmodifiableEntrySet(Set set) {
        super(set);
    }

    public boolean equals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

