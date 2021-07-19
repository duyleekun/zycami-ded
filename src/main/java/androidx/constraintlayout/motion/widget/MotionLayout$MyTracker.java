/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 */
package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker;

public class MotionLayout$MyTracker
implements MotionLayout$MotionTracker {
    private static MotionLayout$MyTracker me;
    public VelocityTracker tracker;

    static {
        MotionLayout$MyTracker motionLayout$MyTracker;
        me = motionLayout$MyTracker = new MotionLayout$MyTracker();
    }

    private MotionLayout$MyTracker() {
    }

    public static MotionLayout$MyTracker obtain() {
        VelocityTracker velocityTracker;
        MotionLayout$MyTracker motionLayout$MyTracker = me;
        motionLayout$MyTracker.tracker = velocityTracker = VelocityTracker.obtain();
        return me;
    }

    public void addMovement(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
    }

    public void clear() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
    }

    public void computeCurrentVelocity(int n10) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(n10);
        }
    }

    public void computeCurrentVelocity(int n10, float f10) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(n10, f10);
        }
    }

    public float getXVelocity() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getXVelocity();
        }
        return 0.0f;
    }

    public float getXVelocity(int n10) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getXVelocity(n10);
        }
        return 0.0f;
    }

    public float getYVelocity() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getYVelocity();
        }
        return 0.0f;
    }

    public float getYVelocity(int n10) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return this.getYVelocity(n10);
        }
        return 0.0f;
    }

    public void recycle() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            velocityTracker = null;
            this.tracker = null;
        }
    }
}

