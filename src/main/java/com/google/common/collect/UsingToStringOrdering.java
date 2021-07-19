/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;

public final class UsingToStringOrdering
extends Ordering
implements Serializable {
    public static final UsingToStringOrdering INSTANCE;
    private static final long serialVersionUID;

    static {
        UsingToStringOrdering usingToStringOrdering;
        INSTANCE = usingToStringOrdering = new UsingToStringOrdering();
    }

    private UsingToStringOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(Object object, Object object2) {
        object = object.toString();
        object2 = object2.toString();
        return ((String)object).compareTo((String)object2);
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}

