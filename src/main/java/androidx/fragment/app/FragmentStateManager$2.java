/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.lifecycle.Lifecycle$State;

public class FragmentStateManager$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Lifecycle$State lifecycle$State;
        int n12 = Lifecycle$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$lifecycle$Lifecycle$State = nArray;
        try {
            lifecycle$State = Lifecycle$State.RESUMED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            lifecycle$State = Lifecycle$State.STARTED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            lifecycle$State = Lifecycle$State.CREATED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$State;
            lifecycle$State = Lifecycle$State.INITIALIZED;
            n11 = lifecycle$State.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

