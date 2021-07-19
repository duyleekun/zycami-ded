/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.view.PreviewView$ImplementationMode;
import androidx.camera.view.PreviewView$ScaleType;

public class PreviewView$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode;
    public static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12 = PreviewView$ImplementationMode.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode = nArray;
        int n13 = 1;
        try {
            object2 = PreviewView$ImplementationMode.COMPATIBLE;
            n11 = ((Enum)object2).ordinal();
            nArray[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 2;
        try {
            object2 = $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode;
            enum_ = PreviewView$ImplementationMode.PERFORMANCE;
            n10 = enum_.ordinal();
            object2[n10] = (PreviewView$ImplementationMode)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = PreviewView$ScaleType.values().length;
        object2 = new int[n11];
        $SwitchMap$androidx$camera$view$PreviewView$ScaleType = (int[])object2;
        try {
            enum_ = PreviewView$ScaleType.FILL_END;
            n10 = enum_.ordinal();
            object2[n10] = (PreviewView$ImplementationMode)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            object2 = PreviewView$ScaleType.FILL_CENTER;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            object = (Object)PreviewView$ScaleType.FILL_START;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            object = PreviewView$ScaleType.FIT_END;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            object = PreviewView$ScaleType.FIT_CENTER;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$camera$view$PreviewView$ScaleType;
            object = PreviewView$ScaleType.FIT_START;
            n13 = ((Enum)object).ordinal();
            nArray[n13] = n11 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

