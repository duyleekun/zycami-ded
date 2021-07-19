/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public final class UseCase$State
extends Enum {
    private static final /* synthetic */ UseCase$State[] $VALUES;
    public static final /* enum */ UseCase$State ACTIVE;
    public static final /* enum */ UseCase$State INACTIVE;

    static {
        UseCase$State useCase$State;
        UseCase$State useCase$State2;
        ACTIVE = useCase$State2 = new UseCase$State("ACTIVE", 0);
        int n10 = 1;
        INACTIVE = useCase$State = new UseCase$State("INACTIVE", n10);
        UseCase$State[] useCase$StateArray = new UseCase$State[2];
        useCase$StateArray[0] = useCase$State2;
        useCase$StateArray[n10] = useCase$State;
        $VALUES = useCase$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UseCase$State() {
        void var2_-1;
        void var1_-1;
    }

    public static UseCase$State valueOf(String string2) {
        return Enum.valueOf(UseCase$State.class, string2);
    }

    public static UseCase$State[] values() {
        return (UseCase$State[])$VALUES.clone();
    }
}

