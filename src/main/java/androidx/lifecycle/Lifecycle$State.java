/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

public final class Lifecycle$State
extends Enum {
    private static final /* synthetic */ Lifecycle$State[] $VALUES;
    public static final /* enum */ Lifecycle$State CREATED;
    public static final /* enum */ Lifecycle$State DESTROYED;
    public static final /* enum */ Lifecycle$State INITIALIZED;
    public static final /* enum */ Lifecycle$State RESUMED;
    public static final /* enum */ Lifecycle$State STARTED;

    static {
        Lifecycle$State lifecycle$State;
        Lifecycle$State lifecycle$State2;
        Lifecycle$State lifecycle$State3;
        Lifecycle$State lifecycle$State4;
        Lifecycle$State lifecycle$State5;
        DESTROYED = lifecycle$State5 = new Lifecycle$State("DESTROYED", 0);
        int n10 = 1;
        INITIALIZED = lifecycle$State4 = new Lifecycle$State("INITIALIZED", n10);
        int n11 = 2;
        CREATED = lifecycle$State3 = new Lifecycle$State("CREATED", n11);
        int n12 = 3;
        STARTED = lifecycle$State2 = new Lifecycle$State("STARTED", n12);
        int n13 = 4;
        RESUMED = lifecycle$State = new Lifecycle$State("RESUMED", n13);
        Lifecycle$State[] lifecycle$StateArray = new Lifecycle$State[5];
        lifecycle$StateArray[0] = lifecycle$State5;
        lifecycle$StateArray[n10] = lifecycle$State4;
        lifecycle$StateArray[n11] = lifecycle$State3;
        lifecycle$StateArray[n12] = lifecycle$State2;
        lifecycle$StateArray[n13] = lifecycle$State;
        $VALUES = lifecycle$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Lifecycle$State() {
        void var2_-1;
        void var1_-1;
    }

    public static Lifecycle$State valueOf(String string2) {
        return Enum.valueOf(Lifecycle$State.class, string2);
    }

    public static Lifecycle$State[] values() {
        return (Lifecycle$State[])$VALUES.clone();
    }

    public boolean isAtLeast(Lifecycle$State lifecycle$State) {
        int n10 = this.compareTo(lifecycle$State);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            lifecycle$State = null;
        }
        return n10 != 0;
    }
}

