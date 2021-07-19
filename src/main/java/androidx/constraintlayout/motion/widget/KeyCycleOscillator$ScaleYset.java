/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;

public class KeyCycleOscillator$ScaleYset
extends KeyCycleOscillator {
    public void setProperty(View view, float f10) {
        f10 = this.get(f10);
        view.setScaleY(f10);
    }
}

