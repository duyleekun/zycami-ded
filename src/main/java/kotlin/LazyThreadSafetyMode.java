/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

public final class LazyThreadSafetyMode
extends Enum {
    public static final /* enum */ LazyThreadSafetyMode NONE;
    public static final /* enum */ LazyThreadSafetyMode PUBLICATION;
    public static final /* enum */ LazyThreadSafetyMode SYNCHRONIZED;
    private static final /* synthetic */ LazyThreadSafetyMode[] a;

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode;
        LazyThreadSafetyMode[] lazyThreadSafetyModeArray = new LazyThreadSafetyMode[3];
        SYNCHRONIZED = lazyThreadSafetyMode = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
        lazyThreadSafetyModeArray[0] = lazyThreadSafetyMode;
        int n10 = 1;
        PUBLICATION = lazyThreadSafetyMode = new LazyThreadSafetyMode("PUBLICATION", n10);
        lazyThreadSafetyModeArray[n10] = lazyThreadSafetyMode;
        n10 = 2;
        NONE = lazyThreadSafetyMode = new LazyThreadSafetyMode("NONE", n10);
        lazyThreadSafetyModeArray[n10] = lazyThreadSafetyMode;
        a = lazyThreadSafetyModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LazyThreadSafetyMode() {
        void var2_-1;
        void var1_-1;
    }

    public static LazyThreadSafetyMode valueOf(String string2) {
        return Enum.valueOf(LazyThreadSafetyMode.class, string2);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[])a.clone();
    }
}

