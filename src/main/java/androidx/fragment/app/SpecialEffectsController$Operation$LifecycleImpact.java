/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

public final class SpecialEffectsController$Operation$LifecycleImpact
extends Enum {
    private static final /* synthetic */ SpecialEffectsController$Operation$LifecycleImpact[] $VALUES;
    public static final /* enum */ SpecialEffectsController$Operation$LifecycleImpact ADDING;
    public static final /* enum */ SpecialEffectsController$Operation$LifecycleImpact NONE;
    public static final /* enum */ SpecialEffectsController$Operation$LifecycleImpact REMOVING;

    static {
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact;
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact2;
        SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact3;
        NONE = specialEffectsController$Operation$LifecycleImpact3 = new SpecialEffectsController$Operation$LifecycleImpact("NONE", 0);
        int n10 = 1;
        ADDING = specialEffectsController$Operation$LifecycleImpact2 = new SpecialEffectsController$Operation$LifecycleImpact("ADDING", n10);
        int n11 = 2;
        REMOVING = specialEffectsController$Operation$LifecycleImpact = new SpecialEffectsController$Operation$LifecycleImpact("REMOVING", n11);
        SpecialEffectsController$Operation$LifecycleImpact[] specialEffectsController$Operation$LifecycleImpactArray = new SpecialEffectsController$Operation$LifecycleImpact[3];
        specialEffectsController$Operation$LifecycleImpactArray[0] = specialEffectsController$Operation$LifecycleImpact3;
        specialEffectsController$Operation$LifecycleImpactArray[n10] = specialEffectsController$Operation$LifecycleImpact2;
        specialEffectsController$Operation$LifecycleImpactArray[n11] = specialEffectsController$Operation$LifecycleImpact;
        $VALUES = specialEffectsController$Operation$LifecycleImpactArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SpecialEffectsController$Operation$LifecycleImpact() {
        void var2_-1;
        void var1_-1;
    }

    public static SpecialEffectsController$Operation$LifecycleImpact valueOf(String string2) {
        return Enum.valueOf(SpecialEffectsController$Operation$LifecycleImpact.class, string2);
    }

    public static SpecialEffectsController$Operation$LifecycleImpact[] values() {
        return (SpecialEffectsController$Operation$LifecycleImpact[])$VALUES.clone();
    }
}

