/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;

public interface MotionLayout$MotionTracker {
    public void addMovement(MotionEvent var1);

    public void clear();

    public void computeCurrentVelocity(int var1);

    public void computeCurrentVelocity(int var1, float var2);

    public float getXVelocity();

    public float getXVelocity(int var1);

    public float getYVelocity();

    public float getYVelocity(int var1);

    public void recycle();
}

