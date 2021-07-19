/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.MotionEvent
 */
package androidx.core.view;

import android.view.GestureDetector;
import android.view.MotionEvent;

public interface GestureDetectorCompat$GestureDetectorCompatImpl {
    public boolean isLongpressEnabled();

    public boolean onTouchEvent(MotionEvent var1);

    public void setIsLongpressEnabled(boolean var1);

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener var1);
}

