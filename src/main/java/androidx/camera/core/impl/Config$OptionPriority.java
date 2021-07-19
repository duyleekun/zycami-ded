/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

public final class Config$OptionPriority
extends Enum {
    private static final /* synthetic */ Config$OptionPriority[] $VALUES;
    public static final /* enum */ Config$OptionPriority ALWAYS_OVERRIDE;
    public static final /* enum */ Config$OptionPriority OPTIONAL;
    public static final /* enum */ Config$OptionPriority REQUIRED;

    static {
        Config$OptionPriority config$OptionPriority;
        Config$OptionPriority config$OptionPriority2;
        Config$OptionPriority config$OptionPriority3;
        ALWAYS_OVERRIDE = config$OptionPriority3 = new Config$OptionPriority("ALWAYS_OVERRIDE", 0);
        int n10 = 1;
        REQUIRED = config$OptionPriority2 = new Config$OptionPriority("REQUIRED", n10);
        int n11 = 2;
        OPTIONAL = config$OptionPriority = new Config$OptionPriority("OPTIONAL", n11);
        Config$OptionPriority[] config$OptionPriorityArray = new Config$OptionPriority[3];
        config$OptionPriorityArray[0] = config$OptionPriority3;
        config$OptionPriorityArray[n10] = config$OptionPriority2;
        config$OptionPriorityArray[n11] = config$OptionPriority;
        $VALUES = config$OptionPriorityArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Config$OptionPriority() {
        void var2_-1;
        void var1_-1;
    }

    public static Config$OptionPriority valueOf(String string2) {
        return Enum.valueOf(Config$OptionPriority.class, string2);
    }

    public static Config$OptionPriority[] values() {
        return (Config$OptionPriority[])$VALUES.clone();
    }
}

