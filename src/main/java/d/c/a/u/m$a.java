/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package d.c.a.u;

import android.graphics.Bitmap;

public class m$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Bitmap.Config config;
        int n12 = Bitmap.Config.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            config = Bitmap.Config.ALPHA_8;
            n11 = config.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            config = Bitmap.Config.RGB_565;
            n11 = config.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            config = Bitmap.Config.ARGB_4444;
            n11 = config.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            config = Bitmap.Config.RGBA_F16;
            n11 = config.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            config = Bitmap.Config.ARGB_8888;
            n11 = config.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

