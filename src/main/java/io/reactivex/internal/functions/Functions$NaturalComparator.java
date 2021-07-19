/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import java.util.Comparator;

public final class Functions$NaturalComparator
extends Enum
implements Comparator {
    public static final /* enum */ Functions$NaturalComparator INSTANCE;
    private static final /* synthetic */ Functions$NaturalComparator[] a;

    static {
        Functions$NaturalComparator functions$NaturalComparator;
        INSTANCE = functions$NaturalComparator = new Functions$NaturalComparator("INSTANCE", 0);
        Functions$NaturalComparator[] functions$NaturalComparatorArray = new Functions$NaturalComparator[]{functions$NaturalComparator};
        a = functions$NaturalComparatorArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Functions$NaturalComparator() {
        void var2_-1;
        void var1_-1;
    }

    public static Functions$NaturalComparator valueOf(String string2) {
        return Enum.valueOf(Functions$NaturalComparator.class, string2);
    }

    public static Functions$NaturalComparator[] values() {
        return (Functions$NaturalComparator[])a.clone();
    }

    public int compare(Object object, Object object2) {
        return ((Comparable)object).compareTo(object2);
    }
}

