/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines.intrinsics;

public final class CoroutineSingletons
extends Enum {
    public static final /* enum */ CoroutineSingletons COROUTINE_SUSPENDED;
    public static final /* enum */ CoroutineSingletons RESUMED;
    public static final /* enum */ CoroutineSingletons UNDECIDED;
    private static final /* synthetic */ CoroutineSingletons[] a;

    static {
        CoroutineSingletons coroutineSingletons;
        CoroutineSingletons[] coroutineSingletonsArray = new CoroutineSingletons[3];
        COROUTINE_SUSPENDED = coroutineSingletons = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        coroutineSingletonsArray[0] = coroutineSingletons;
        int n10 = 1;
        UNDECIDED = coroutineSingletons = new CoroutineSingletons("UNDECIDED", n10);
        coroutineSingletonsArray[n10] = coroutineSingletons;
        n10 = 2;
        RESUMED = coroutineSingletons = new CoroutineSingletons("RESUMED", n10);
        coroutineSingletonsArray[n10] = coroutineSingletons;
        a = coroutineSingletonsArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CoroutineSingletons() {
        void var2_-1;
        void var1_-1;
    }

    public static CoroutineSingletons valueOf(String string2) {
        return Enum.valueOf(CoroutineSingletons.class, string2);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[])a.clone();
    }
}

