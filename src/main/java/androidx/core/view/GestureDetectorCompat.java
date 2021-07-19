/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 */
package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplBase;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2;

public final class GestureDetectorCompat {
    private final GestureDetectorCompat$GestureDetectorCompatImpl mImpl;

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 > n11) {
            GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 gestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 = new GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
            this.mImpl = gestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2;
        } else {
            GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase = new GestureDetectorCompat$GestureDetectorCompatImplBase(context, onGestureListener, handler);
            this.mImpl = gestureDetectorCompat$GestureDetectorCompatImplBase;
        }
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public void setIsLongpressEnabled(boolean bl2) {
        this.mImpl.setIsLongpressEnabled(bl2);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}

