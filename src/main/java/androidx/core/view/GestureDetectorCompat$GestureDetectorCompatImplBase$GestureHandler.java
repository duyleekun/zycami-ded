/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 */
package androidx.core.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImplBase;

public class GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler
extends Handler {
    public final /* synthetic */ GestureDetectorCompat$GestureDetectorCompatImplBase this$0;

    public GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompatImplBase) {
        this.this$0 = gestureDetectorCompatImplBase;
    }

    public GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler(GestureDetectorCompat$GestureDetectorCompatImplBase gestureDetectorCompat$GestureDetectorCompatImplBase, Handler handler) {
        this.this$0 = gestureDetectorCompat$GestureDetectorCompatImplBase;
        gestureDetectorCompat$GestureDetectorCompatImplBase = handler.getLooper();
        super((Looper)gestureDetectorCompat$GestureDetectorCompatImplBase);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 == n11) {
            object = this.this$0;
            GestureDetector.OnGestureListener onGestureListener = ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mListener;
            object = ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mCurrentDownEvent;
            onGestureListener.onShowPress((MotionEvent)object);
            return;
        }
        int n12 = 2;
        if (n10 == n12) {
            object = this.this$0;
            ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).dispatchLongPress();
            return;
        }
        n12 = 3;
        if (n10 != n12) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown message ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            RuntimeException runtimeException = new RuntimeException((String)object);
            throw runtimeException;
        }
        object = this.this$0;
        GestureDetector.OnDoubleTapListener onDoubleTapListener = ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mDoubleTapListener;
        if (onDoubleTapListener == null) return;
        n12 = (int)(((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mStillDown ? 1 : 0);
        if (n12 == 0) {
            object = ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mCurrentDownEvent;
            onDoubleTapListener.onSingleTapConfirmed((MotionEvent)object);
            return;
        }
        ((GestureDetectorCompat$GestureDetectorCompatImplBase)object).mDeferConfirmSingleTap = n11;
    }
}

