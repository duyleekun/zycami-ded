/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.editorinterface.decoration.DecorationType;

public class h2$c {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DecorationType decorationType;
        int n12 = DecorationType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            decorationType = DecorationType.GIF_PASTER;
            n11 = decorationType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            decorationType = DecorationType.IMAGE_PASTER;
            n11 = decorationType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            decorationType = DecorationType.FONT;
            n11 = decorationType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            decorationType = DecorationType.CAPTION;
            n11 = decorationType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

