/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Equivalence;
import java.io.Serializable;

public final class Equivalence$Identity
extends Equivalence
implements Serializable {
    public static final Equivalence$Identity INSTANCE;
    private static final long serialVersionUID = 1L;

    static {
        Equivalence$Identity equivalence$Identity;
        INSTANCE = equivalence$Identity = new Equivalence$Identity();
    }

    private Object readResolve() {
        return INSTANCE;
    }

    public boolean doEquivalent(Object object, Object object2) {
        return false;
    }

    public int doHash(Object object) {
        return System.identityHashCode(object);
    }
}

