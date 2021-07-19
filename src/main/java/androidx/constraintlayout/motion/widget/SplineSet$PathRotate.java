/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.SplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.SplineSet;

public class SplineSet$PathRotate
extends SplineSet {
    public void setPathRotate(View view, float f10, double d10, double d11) {
        f10 = this.get(f10);
        float f11 = (float)Math.toDegrees(Math.atan2(d11, d10));
        view.setRotation(f10 += f11);
    }

    public void setProperty(View view, float f10) {
    }
}

