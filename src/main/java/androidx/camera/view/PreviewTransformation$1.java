/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.view.PreviewView$ScaleType;

public class PreviewTransformation$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PreviewView$ScaleType previewView$ScaleType;
        int n12 = PreviewView$ScaleType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$view$PreviewView$ScaleType = nArray;
        try {
            previewView$ScaleType = PreviewView$ScaleType.FIT_CENTER;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            previewView$ScaleType = PreviewView$ScaleType.FILL_CENTER;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            previewView$ScaleType = PreviewView$ScaleType.FIT_END;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            previewView$ScaleType = PreviewView$ScaleType.FILL_END;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            previewView$ScaleType = PreviewView$ScaleType.FIT_START;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            previewView$ScaleType = PreviewView$ScaleType.FILL_START;
            n11 = previewView$ScaleType.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

