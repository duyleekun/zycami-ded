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
import androidx.constraintlayout.widget.ConstraintAttribute;

public class KeyCycleOscillator$CustomSet
extends KeyCycleOscillator {
    public float[] value;

    public KeyCycleOscillator$CustomSet() {
        float[] fArray = new float[1];
        this.value = fArray;
    }

    public void setProperty(View view, float f10) {
        float[] fArray = this.value;
        fArray[0] = f10 = this.get(f10);
        ConstraintAttribute constraintAttribute = this.mCustom;
        fArray = this.value;
        constraintAttribute.setInterpolatedValue(view, fArray);
    }
}

