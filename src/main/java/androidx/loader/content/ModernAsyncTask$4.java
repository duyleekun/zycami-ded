/*
 * Decompiled with CFR 0.151.
 */
package androidx.loader.content;

import androidx.loader.content.ModernAsyncTask$Status;

public class ModernAsyncTask$4 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ModernAsyncTask$Status modernAsyncTask$Status;
        int n12 = ModernAsyncTask$Status.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = nArray;
        try {
            modernAsyncTask$Status = ModernAsyncTask$Status.RUNNING;
            n11 = modernAsyncTask$Status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$loader$content$ModernAsyncTask$Status;
            modernAsyncTask$Status = ModernAsyncTask$Status.FINISHED;
            n11 = modernAsyncTask$Status.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

