/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.c7;

import com.zhiyun.cama.camera.data.CameraSet$Guide;
import com.zhiyun.cama.camera.data.CameraSet$HitchcockGuide;

public class p$a {
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
        int n13 = CameraSet$HitchcockGuide.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object3 = CameraSet$HitchcockGuide.START;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = b;
            object2 = CameraSet$HitchcockGuide.TWO;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (CameraSet$HitchcockGuide)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = b;
            enum_ = CameraSet$HitchcockGuide.THREE;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$HitchcockGuide)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = CameraSet$Guide.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = CameraSet$Guide.START;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$HitchcockGuide)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = CameraSet$Guide.TWO;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)CameraSet$Guide.THREE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.FOUR;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.FIVE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.SIX;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.SEVEN;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.STORY_MORE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.STORY_CUSTOM_ONE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Guide.STORY_CUSTOM_TWO;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 10;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

