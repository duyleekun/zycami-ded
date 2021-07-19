/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;

public class u6$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

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
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = CameraSet$Panorama.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = CameraSet$Panorama.P_3x3;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = CameraSet$Panorama.P_240;
            n12 = object3.ordinal();
            object4[n12] = (CameraSet$Panorama)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = CameraSet$Panorama.P_CLONE;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (CameraSet$Panorama)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            enum_ = CameraSet$Panorama.P_180;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$Panorama)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = CameraSet$Mode.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = CameraSet$Mode.video;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$Panorama)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = CameraSet$Mode.photograph;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)CameraSet$Mode.dolly_zoom;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.sport_delay;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

