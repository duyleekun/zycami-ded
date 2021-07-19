/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.UseCase$State;

public class UseCase$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$UseCase$State;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        UseCase$State useCase$State;
        int n12 = UseCase$State.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$core$UseCase$State = nArray;
        try {
            useCase$State = UseCase$State.INACTIVE;
            n11 = useCase$State.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$core$UseCase$State;
            useCase$State = UseCase$State.ACTIVE;
            n11 = useCase$State.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

