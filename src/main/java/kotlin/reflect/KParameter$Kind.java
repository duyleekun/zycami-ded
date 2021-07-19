/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

public final class KParameter$Kind
extends Enum {
    public static final /* enum */ KParameter$Kind EXTENSION_RECEIVER;
    public static final /* enum */ KParameter$Kind INSTANCE;
    public static final /* enum */ KParameter$Kind VALUE;
    private static final /* synthetic */ KParameter$Kind[] a;

    static {
        KParameter$Kind kParameter$Kind;
        KParameter$Kind[] kParameter$KindArray = new KParameter$Kind[3];
        INSTANCE = kParameter$Kind = new KParameter$Kind("INSTANCE", 0);
        kParameter$KindArray[0] = kParameter$Kind;
        int n10 = 1;
        EXTENSION_RECEIVER = kParameter$Kind = new KParameter$Kind("EXTENSION_RECEIVER", n10);
        kParameter$KindArray[n10] = kParameter$Kind;
        n10 = 2;
        VALUE = kParameter$Kind = new KParameter$Kind("VALUE", n10);
        kParameter$KindArray[n10] = kParameter$Kind;
        a = kParameter$KindArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private KParameter$Kind() {
        void var2_-1;
        void var1_-1;
    }

    public static KParameter$Kind valueOf(String string2) {
        return Enum.valueOf(KParameter$Kind.class, string2);
    }

    public static KParameter$Kind[] values() {
        return (KParameter$Kind[])a.clone();
    }
}

