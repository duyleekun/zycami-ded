/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

import com.google.common.graph.ElementOrder$Type;

public class ElementOrder$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ElementOrder$Type elementOrder$Type;
        int n12 = ElementOrder$Type.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$common$graph$ElementOrder$Type = nArray;
        try {
            elementOrder$Type = ElementOrder$Type.UNORDERED;
            n11 = elementOrder$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$graph$ElementOrder$Type;
            elementOrder$Type = ElementOrder$Type.INSERTION;
            n11 = elementOrder$Type.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$graph$ElementOrder$Type;
            elementOrder$Type = ElementOrder$Type.STABLE;
            n11 = elementOrder$Type.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$common$graph$ElementOrder$Type;
            elementOrder$Type = ElementOrder$Type.SORTED;
            n11 = elementOrder$Type.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

