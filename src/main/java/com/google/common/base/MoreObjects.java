/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.MoreObjects$ToStringHelper;
import java.util.Objects;

public final class MoreObjects {
    private MoreObjects() {
    }

    public static Object firstNonNull(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        Objects.requireNonNull(object2, "Both parameters are null");
        return object2;
    }

    public static MoreObjects$ToStringHelper toStringHelper(Class object) {
        object = ((Class)object).getSimpleName();
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper((String)object, null);
        return moreObjects$ToStringHelper;
    }

    public static MoreObjects$ToStringHelper toStringHelper(Object object) {
        object = object.getClass().getSimpleName();
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper((String)object, null);
        return moreObjects$ToStringHelper;
    }

    public static MoreObjects$ToStringHelper toStringHelper(String string2) {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper(string2, null);
        return moreObjects$ToStringHelper;
    }
}

