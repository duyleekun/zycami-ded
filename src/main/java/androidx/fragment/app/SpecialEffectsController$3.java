/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class SpecialEffectsController$3 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
    public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = SpecialEffectsController$Operation$LifecycleImpact.values().length;
        int[] nArray = new int[n13];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact = nArray;
        int n14 = 1;
        try {
            object3 = SpecialEffectsController$Operation$LifecycleImpact.ADDING;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
            object2 = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (SpecialEffectsController$Operation$LifecycleImpact)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$LifecycleImpact;
            enum_ = SpecialEffectsController$Operation$LifecycleImpact.NONE;
            n10 = enum_.ordinal();
            object2[n10] = (SpecialEffectsController$Operation$LifecycleImpact)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = SpecialEffectsController$Operation$State.values().length;
        object2 = new int[n11];
        $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = (int[])object2;
        try {
            enum_ = SpecialEffectsController$Operation$State.REMOVED;
            n10 = enum_.ordinal();
            object2[n10] = (SpecialEffectsController$Operation$LifecycleImpact)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            object2 = SpecialEffectsController$Operation$State.VISIBLE;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            object = (Object)SpecialEffectsController$Operation$State.GONE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            object = SpecialEffectsController$Operation$State.INVISIBLE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

