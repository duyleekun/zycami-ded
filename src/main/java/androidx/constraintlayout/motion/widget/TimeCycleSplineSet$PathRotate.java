/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;

public class TimeCycleSplineSet$PathRotate
extends TimeCycleSplineSet {
    public boolean setPathRotate(View view, KeyCache keyCache, float f10, long l10, double d10, double d11) {
        float f11 = this.get(f10, l10, view, keyCache);
        f10 = (float)Math.toDegrees(Math.atan2(d11, d10));
        view.setRotation(f11 += f10);
        return this.mContinue;
    }

    public boolean setProperty(View view, float f10, long l10, KeyCache keyCache) {
        return this.mContinue;
    }
}

