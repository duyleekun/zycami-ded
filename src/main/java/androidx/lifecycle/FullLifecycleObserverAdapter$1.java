/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$Event;

public class FullLifecycleObserverAdapter$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Lifecycle$Event lifecycle$Event;
        int n12 = Lifecycle$Event.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$lifecycle$Lifecycle$Event = nArray;
        try {
            lifecycle$Event = Lifecycle$Event.ON_CREATE;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_START;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_RESUME;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_PAUSE;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_STOP;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_DESTROY;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$lifecycle$Lifecycle$Event;
            lifecycle$Event = Lifecycle$Event.ON_ANY;
            n11 = lifecycle$Event.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

