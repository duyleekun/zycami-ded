/*
 * Decompiled with CFR 0.151.
 */
package androidx.loader.content;

public final class ModernAsyncTask$Status
extends Enum {
    private static final /* synthetic */ ModernAsyncTask$Status[] $VALUES;
    public static final /* enum */ ModernAsyncTask$Status FINISHED;
    public static final /* enum */ ModernAsyncTask$Status PENDING;
    public static final /* enum */ ModernAsyncTask$Status RUNNING;

    static {
        ModernAsyncTask$Status modernAsyncTask$Status;
        ModernAsyncTask$Status modernAsyncTask$Status2;
        ModernAsyncTask$Status modernAsyncTask$Status3;
        PENDING = modernAsyncTask$Status3 = new ModernAsyncTask$Status("PENDING", 0);
        int n10 = 1;
        RUNNING = modernAsyncTask$Status2 = new ModernAsyncTask$Status("RUNNING", n10);
        int n11 = 2;
        FINISHED = modernAsyncTask$Status = new ModernAsyncTask$Status("FINISHED", n11);
        ModernAsyncTask$Status[] modernAsyncTask$StatusArray = new ModernAsyncTask$Status[3];
        modernAsyncTask$StatusArray[0] = modernAsyncTask$Status3;
        modernAsyncTask$StatusArray[n10] = modernAsyncTask$Status2;
        modernAsyncTask$StatusArray[n11] = modernAsyncTask$Status;
        $VALUES = modernAsyncTask$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ModernAsyncTask$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static ModernAsyncTask$Status valueOf(String string2) {
        return Enum.valueOf(ModernAsyncTask$Status.class, string2);
    }

    public static ModernAsyncTask$Status[] values() {
        return (ModernAsyncTask$Status[])$VALUES.clone();
    }
}

