/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;

public class KeyCycleOscillator$ElevationSet
extends KeyCycleOscillator {
    public void setProperty(View view, float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            f10 = this.get(f10);
            view.setElevation(f10);
        }
    }
}

