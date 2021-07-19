/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

import com.zhiyun.cama.camera.data.CameraSet$Mode;

public class CameraSet$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CameraSet$Mode cameraSet$Mode;
        int n12 = CameraSet$Mode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            cameraSet$Mode = CameraSet$Mode.story;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.panorama;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.photograph;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.video;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.slow_motion;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.delay_video;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.sport_delay;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cameraSet$Mode = CameraSet$Mode.live;
            n11 = cameraSet$Mode.ordinal();
            nArray[n11] = n10 = 8;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

