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

public class SplineSet$PivotXset
extends SplineSet {
    public void setProperty(View view, float f10) {
        f10 = this.get(f10);
        view.setPivotX(f10);
    }
}

