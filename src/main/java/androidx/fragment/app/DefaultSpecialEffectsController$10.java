/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class DefaultSpecialEffectsController$10 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
        int n12 = SpecialEffectsController$Operation$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = nArray;
        try {
            specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.GONE;
            n11 = specialEffectsController$Operation$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.INVISIBLE;
            n11 = specialEffectsController$Operation$State.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.REMOVED;
            n11 = specialEffectsController$Operation$State.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE;
            n11 = specialEffectsController$Operation$State.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

