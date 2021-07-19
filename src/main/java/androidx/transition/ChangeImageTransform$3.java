/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ImageView$ScaleType
 */
package androidx.transition;

import android.widget.ImageView;

public class ChangeImageTransform$3 {
    public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ImageView.ScaleType scaleType;
        int n12 = ImageView.ScaleType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$android$widget$ImageView$ScaleType = nArray;
        try {
            scaleType = ImageView.ScaleType.FIT_XY;
            n11 = scaleType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$android$widget$ImageView$ScaleType;
            scaleType = ImageView.ScaleType.CENTER_CROP;
            n11 = scaleType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

