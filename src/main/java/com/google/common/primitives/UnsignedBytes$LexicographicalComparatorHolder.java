/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedBytes;
import java.util.Comparator;

public class UnsignedBytes$LexicographicalComparatorHolder {
    public static final Comparator BEST_COMPARATOR;
    public static final String UNSAFE_COMPARATOR_NAME;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = UnsignedBytes$LexicographicalComparatorHolder.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append("$UnsafeComparator");
        UNSAFE_COMPARATOR_NAME = stringBuilder.toString();
        BEST_COMPARATOR = UnsignedBytes$LexicographicalComparatorHolder.getBestComparator();
    }

    public static Comparator getBestComparator() {
        Object object;
        try {
            object = UNSAFE_COMPARATOR_NAME;
        }
        catch (Throwable throwable) {
            return UnsignedBytes.lexicographicalComparatorJavaImpl();
        }
        object = Class.forName((String)object);
        object = object.getEnumConstants();
        object = object[0];
        return (Comparator)object;
    }
}

