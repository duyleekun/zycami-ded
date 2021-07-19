/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;

public class RecyclerView$7 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy;
        int n12 = RecyclerView$Adapter$StateRestorationPolicy.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = nArray;
        try {
            recyclerView$Adapter$StateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.PREVENT;
            n11 = recyclerView$Adapter$StateRestorationPolicy.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy;
            recyclerView$Adapter$StateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY;
            n11 = recyclerView$Adapter$StateRestorationPolicy.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

