/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

public class ItemTouchHelper$Callback$1
implements Interpolator {
    public float getInterpolation(float f10) {
        return f10 * f10 * f10 * f10 * f10;
    }
}

