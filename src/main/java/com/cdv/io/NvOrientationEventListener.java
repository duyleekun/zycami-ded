/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package com.cdv.io;

import android.content.Context;
import android.view.OrientationEventListener;
import com.cdv.io.NvOrientationEventListener$1;

public class NvOrientationEventListener {
    private static final String TAG = "OrientationEventListener";
    private int m_cameraId = -1;
    private OrientationEventListener m_orientationEventListener;

    private NvOrientationEventListener(int n10, Context context) {
        this.m_cameraId = n10;
        NvOrientationEventListener$1 nvOrientationEventListener$1 = new NvOrientationEventListener$1(this, context, 3);
        this.m_orientationEventListener = nvOrientationEventListener$1;
    }

    public static /* synthetic */ int access$000(NvOrientationEventListener nvOrientationEventListener) {
        return nvOrientationEventListener.m_cameraId;
    }

    public static /* synthetic */ void access$100(int n10, int n11) {
        NvOrientationEventListener.notifyOrientation(n10, n11);
    }

    private static native void notifyOrientation(int var0, int var1);

    public void disableListener() {
        OrientationEventListener orientationEventListener = this.m_orientationEventListener;
        boolean bl2 = orientationEventListener.canDetectOrientation();
        if (bl2) {
            orientationEventListener = this.m_orientationEventListener;
            orientationEventListener.disable();
        }
    }

    public void enableListener() {
        OrientationEventListener orientationEventListener = this.m_orientationEventListener;
        boolean bl2 = orientationEventListener.canDetectOrientation();
        if (bl2) {
            orientationEventListener = this.m_orientationEventListener;
            orientationEventListener.enable();
        }
    }
}

