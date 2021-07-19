/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import com.zhiyun.cama.camera.ble.BleViewModel$MoveState;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;

public class CameraFragment$i {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;
    public static final /* synthetic */ int[] d;
    public static final /* synthetic */ int[] e;

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
        int n14;
        Object object5;
        int n15;
        Object object6;
        int n16;
        Object object7;
        int n17;
        Object object8;
        int n18 = CameraSet$StoryState.values().length;
        int[] nArray = new int[n18];
        e = nArray;
        int n19 = 1;
        try {
            object8 = CameraSet$StoryState.STORY_LIST;
            n17 = object8.ordinal();
            nArray[n17] = n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n18 = 2;
        try {
            object8 = e;
            object7 = CameraSet$StoryState.STORY_RECORD;
            n16 = object7.ordinal();
            object8[n16] = (CameraSet$StoryState)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n17 = 3;
        try {
            object7 = e;
            object6 = CameraSet$StoryState.STORY_DRAFT_TO_REVIEW;
            n15 = object6.ordinal();
            object7[n15] = (CameraSet$StoryState)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n16 = 4;
        try {
            object6 = e;
            object5 = CameraSet$StoryState.STORY_REVIEW;
            n14 = object5.ordinal();
            object6[n14] = (CameraSet$StoryState)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 5;
        try {
            object5 = e;
            object4 = CameraSet$StoryState.STORY_DRAFT;
            n13 = object4.ordinal();
            object5[n13] = (CameraSet$StoryState)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 6;
        try {
            object4 = e;
            object3 = CameraSet$StoryState.STORY_PERSONAL;
            n12 = object3.ordinal();
            object4[n12] = (CameraSet$StoryState)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 7;
        try {
            object3 = e;
            object2 = CameraSet$StoryState.STORY_MORE;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (CameraSet$StoryState)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 8;
        try {
            object2 = e;
            enum_ = CameraSet$StoryState.STORY_SAVE;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = BleViewModel$PanoramaState.values().length;
        object2 = new int[n11];
        d = (int[])object2;
        try {
            enum_ = BleViewModel$PanoramaState.START;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = d;
            enum_ = BleViewModel$PanoramaState.SPLICE;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = d;
            enum_ = BleViewModel$PanoramaState.CANCEL;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = d;
            enum_ = BleViewModel$PanoramaState.END;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = d;
            enum_ = BleViewModel$PanoramaState.ERROR;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = BleViewModel$MoveState.values().length;
        object2 = new int[n11];
        c = (int[])object2;
        try {
            enum_ = BleViewModel$MoveState.STARTED;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = c;
            enum_ = BleViewModel$MoveState.STOPOVER;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = c;
            enum_ = BleViewModel$MoveState.CANCELLED;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = c;
            enum_ = BleViewModel$MoveState.COMPLETED;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = c;
            enum_ = BleViewModel$MoveState.ERROR;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = CameraSet$Panorama.values().length;
        object2 = new int[n11];
        b = (int[])object2;
        try {
            enum_ = CameraSet$Panorama.P_CLONE;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = CameraSet$Panorama.P_3x3;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = CameraSet$Panorama.P_240;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = CameraSet$Panorama.P_180;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = CameraSet$Mode.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = CameraSet$Mode.dolly_zoom;
            n10 = enum_.ordinal();
            object2[n10] = (CameraSet$StoryState)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = CameraSet$Mode.panorama;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)CameraSet$Mode.photograph;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.slow_motion;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.delay_video;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.sport_delay;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.live;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.story;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = CameraSet$Mode.video;
            n19 = ((Enum)object).ordinal();
            nArray[n19] = n17 = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

