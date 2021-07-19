/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;

public abstract class SensorRotationListener
extends OrientationEventListener {
    public static final int INVALID_SURFACE_ROTATION = 255;
    private int mRotation = -1;

    public SensorRotationListener(Context context) {
        super(context);
    }

    public void onOrientationChanged(int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        n11 = 315;
        n10 = n10 < n11 && n10 >= (n11 = 45) ? (n10 >= (n11 = 225) ? 1 : (n10 >= (n11 = 135) ? 2 : 3)) : 0;
        n11 = this.mRotation;
        if (n11 != n10) {
            this.mRotation = n10;
            this.onRotationChanged(n10);
        }
    }

    public abstract void onRotationChanged(int var1);
}

