/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.f;

import com.zhiyun.editorinterface.decoration.DecorationType;

public class k$a {
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
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

