/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

public final class Equivalence$Equals
extends Equivalence
implements Serializable {
    public static final Equivalence$Equals INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Equivalence$Equals equivalence$Equals;
        INSTANCE = equivalence$Equals = new Equivalence$Equals();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public boolean doEquivalent(Object object, Object object2) {
        return object.equals(object2);
    }

    public int doHash(Object object) {
        return object.hashCode();
    }
}

