/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.SurfaceView
 *  android.view.TextureView
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.liteav.n;
import com.tencent.liteav.renderer.TXCFocusIndicatorView;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView$1;
import com.tencent.rtmp.ui.TXCloudVideoView$2;
import com.tencent.rtmp.ui.TXCloudVideoView$a;
import com.tencent.rtmp.ui.TXDashBoard;

public class TXCloudVideoView
extends FrameLayout
implements View.OnTouchListener {
    private static final int FOCUS_AREA_SIZE_DP = 70;
    private static final String TAG = "TXCloudVideoView";
    private float mBottom;
    private n mCapture;
    private int mCaptureHeight;
    private int mCaptureWidth;
    private int mCurrentScale;
    public TXDashBoard mDashBoard;
    private boolean mFocus;
    private int mFocusAreaSize;
    public TXCFocusIndicatorView mFocusIndicatorView;
    public TXCGLSurfaceView mGLSurfaceView;
    private float mLeft;
    private float mRight;
    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener;
    public SurfaceView mSurfaceView;
    private float mTop;
    private TXCloudVideoView$a mTouchFocusRunnable;
    private String mUserId;
    public TextureView mVideoView;
    private boolean mZoom;

    public TXCloudVideoView(Context context) {
        this(context, null);
    }

    public TXCloudVideoView(Context context, AttributeSet object) {
        super(context, object);
        this.mCaptureWidth = 0;
        this.mCaptureHeight = 0;
        this.mLeft = 0.0f;
        this.mRight = 0.0f;
        this.mTop = 0.0f;
        this.mBottom = 0.0f;
        this.mFocusAreaSize = 0;
        this.mUserId = "";
        this.mFocus = false;
        this.mZoom = false;
        this.mCurrentScale = 1;
        this.mScaleGestureDetector = null;
        Object object2 = new TXCloudVideoView$2(this);
        this.mScaleGestureListener = object2;
        this.mTouchFocusRunnable = object2 = new TXCloudVideoView$a(this, null);
        super(context);
        this.mDashBoard = object;
        object2 = this.mScaleGestureListener;
        super(context, (ScaleGestureDetector.OnScaleGestureListener)object2);
        this.mScaleGestureDetector = object;
    }

    public TXCloudVideoView(SurfaceView surfaceView) {
        Context context = surfaceView.getContext();
        this(context, null);
        this.mSurfaceView = surfaceView;
    }

    public static /* synthetic */ float access$000(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mLeft;
    }

    public static /* synthetic */ float access$002(TXCloudVideoView tXCloudVideoView, float f10) {
        tXCloudVideoView.mLeft = f10;
        return f10;
    }

    public static /* synthetic */ float access$100(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mRight;
    }

    public static /* synthetic */ float access$102(TXCloudVideoView tXCloudVideoView, float f10) {
        tXCloudVideoView.mRight = f10;
        return f10;
    }

    public static /* synthetic */ float access$200(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mTop;
    }

    public static /* synthetic */ float access$202(TXCloudVideoView tXCloudVideoView, float f10) {
        tXCloudVideoView.mTop = f10;
        return f10;
    }

    public static /* synthetic */ float access$300(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mBottom;
    }

    public static /* synthetic */ float access$302(TXCloudVideoView tXCloudVideoView, float f10) {
        tXCloudVideoView.mBottom = f10;
        return f10;
    }

    public static /* synthetic */ n access$400(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mCapture;
    }

    public static /* synthetic */ int access$500(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mCurrentScale;
    }

    public static /* synthetic */ int access$502(TXCloudVideoView tXCloudVideoView, int n10) {
        tXCloudVideoView.mCurrentScale = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$700(TXCloudVideoView tXCloudVideoView) {
        return tXCloudVideoView.mFocus;
    }

    private int clamp(int n10, int n11, int n12) {
        if (n10 > n12) {
            return n12;
        }
        if (n10 < n11) {
            return n11;
        }
        return n10;
    }

    private Rect getTouchRect(int n10, int n11, int n12, int n13, float f10) {
        TXCGLSurfaceView tXCGLSurfaceView;
        int n14 = this.mFocusAreaSize;
        if (n14 == 0 && (tXCGLSurfaceView = this.mGLSurfaceView) != null) {
            tXCGLSurfaceView = tXCGLSurfaceView.getResources().getDisplayMetrics();
            float f11 = ((DisplayMetrics)tXCGLSurfaceView).density * 70.0f;
            float f12 = 0.5f;
            this.mFocusAreaSize = n14 = (int)(f11 += f12);
        }
        int n15 = Float.valueOf((float)this.mFocusAreaSize * f10).intValue();
        n14 = n15 / 2;
        n10 -= n14;
        n10 = this.clamp(n10, 0, n12 -= n15);
        n11 -= n14;
        n11 = this.clamp(n11, 0, n13 -= n15);
        n13 = n10 + n15;
        Rect rect = new Rect(n10, n11, n13, n15 += n11);
        return rect;
    }

    public static int px2dip(Context context, float f10) {
        float f11 = context.getResources().getDisplayMetrics().density;
        return (int)(f10 / f11 + 0.5f);
    }

    private void updateDbMargin() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            float f10 = this.mLeft;
            int n10 = (int)f10;
            float f11 = this.mTop;
            int n11 = (int)f11;
            float f12 = this.mRight;
            int n12 = (int)f12;
            float f13 = this.mBottom;
            int n13 = (int)f13;
            tXDashBoard.a(n10, n11, n12, n13);
        }
    }

    public void addVideoView(TextureView textureView) {
        TextureView textureView2 = this.mVideoView;
        if (textureView2 != null) {
            this.removeView((View)textureView2);
        }
        this.mVideoView = textureView;
        this.addView((View)textureView);
        this.resetLogView();
    }

    public void addVideoView(TXCGLSurfaceView tXCGLSurfaceView) {
        TXCGLSurfaceView tXCGLSurfaceView2 = this.mGLSurfaceView;
        if (tXCGLSurfaceView2 != null) {
            this.removeView((View)tXCGLSurfaceView2);
        }
        this.mGLSurfaceView = tXCGLSurfaceView;
        this.addView((View)tXCGLSurfaceView);
        this.resetLogView();
    }

    public void appendEventInfo(String string2) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(string2);
        }
    }

    public void clearLastFrame(boolean bl2) {
        if (bl2) {
            int n10 = 8;
            this.setVisibility(n10);
        }
    }

    public void clearLog() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a();
        }
    }

    public void disableLog(boolean bl2) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(bl2);
        }
    }

    public TXCGLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public TextureView getHWVideoView() {
        return this.mVideoView;
    }

    public SurfaceView getSurfaceView() {
        return this.mSurfaceView;
    }

    public String getUserId() {
        return this.mUserId;
    }

    public TextureView getVideoView() {
        return this.mVideoView;
    }

    public void onDestroy() {
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        this.updateDbMargin();
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            Context context = this.getContext();
            float f10 = this.getWidth();
            float f11 = (float)((double)TXCloudVideoView.px2dip(context, f10) / 30.0);
            tXDashBoard.setStatusTextSize(f11);
            tXDashBoard = this.mDashBoard;
            context = this.getContext();
            n11 = this.getWidth();
            f10 = n11;
            n10 = TXCloudVideoView.px2dip(context, f10);
            double d10 = n10;
            double d11 = 25.0;
            f11 = (float)(d10 /= d11);
            tXDashBoard.setEventTextSize(f11);
        }
        if ((bl2 = this.mCaptureWidth) && (n10 = this.mCaptureHeight) != 0) {
            this.updateVideoViewSize((int)(bl2 ? 1 : 0), n10);
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public boolean onTouch(View object, MotionEvent motionEvent) {
        int n10;
        int n11;
        int n12 = motionEvent.getPointerCount();
        if (n12 == (n11 = 1) && (n12 = motionEvent.getAction()) == 0) {
            TXCloudVideoView$a tXCloudVideoView$a = this.mTouchFocusRunnable;
            tXCloudVideoView$a.a((View)object);
            this.mTouchFocusRunnable.a(motionEvent);
            object = this.mTouchFocusRunnable;
            long l10 = 100;
            this.postDelayed((Runnable)object, l10);
        } else {
            n10 = motionEvent.getPointerCount();
            if (n10 > n11 && (n10 = motionEvent.getAction()) == (n12 = 2)) {
                object = this.mTouchFocusRunnable;
                this.removeCallbacks((Runnable)object);
                n10 = -1;
                this.onTouchFocus(n10, n10);
                object = this.mScaleGestureDetector;
                if (object != null && (n12 = (int)(this.mZoom ? 1 : 0)) != 0) {
                    object.onTouchEvent(motionEvent);
                }
            }
        }
        n10 = (int)(this.mZoom ? 1 : 0);
        if (n10 != 0 && (n10 = motionEvent.getAction()) == 0) {
            this.performClick();
        }
        return this.mZoom;
    }

    public void onTouchFocus(int n10, int n11) {
        Object object = this.mGLSurfaceView;
        if (object == null) {
            return;
        }
        if (n10 >= 0 && n11 >= 0) {
            int n12;
            int n13;
            Object object2;
            object = this.mFocusIndicatorView;
            if (object == null) {
                object2 = this.getContext();
                object = new TXCFocusIndicatorView((Context)object2);
                this.mFocusIndicatorView = object;
                n13 = 0;
                object2 = null;
                object.setVisibility(0);
                object = this.mFocusIndicatorView;
                this.addView((View)object);
            } else {
                n12 = this.indexOfChild((View)object);
                if (n12 != (n13 = this.getChildCount() + -1)) {
                    object = this.mFocusIndicatorView;
                    this.removeView((View)object);
                    object = this.mFocusIndicatorView;
                    this.addView((View)object);
                }
            }
            int n14 = this.mGLSurfaceView.getWidth();
            int n15 = this.mGLSurfaceView.getHeight();
            object2 = this;
            Rect rect = this.getTouchRect(n10, n11, n14, n15, 1.0f);
            TXCFocusIndicatorView tXCFocusIndicatorView = this.mFocusIndicatorView;
            n12 = rect.left;
            n13 = rect.top;
            n10 = rect.right - n12;
            tXCFocusIndicatorView.show(n12, n13, n10);
            return;
        }
        TXCFocusIndicatorView tXCFocusIndicatorView = this.mFocusIndicatorView;
        if (tXCFocusIndicatorView != null) {
            n11 = 8;
            tXCFocusIndicatorView.setVisibility(n11);
        }
    }

    public void removeFocusIndicatorView() {
        TXCFocusIndicatorView tXCFocusIndicatorView = this.mFocusIndicatorView;
        if (tXCFocusIndicatorView != null) {
            this.removeView(tXCFocusIndicatorView);
            tXCFocusIndicatorView = null;
            this.mFocusIndicatorView = null;
        }
    }

    public void removeVideoView() {
        Object object = this.mVideoView;
        if (object != null) {
            this.removeView((View)object);
            this.mVideoView = null;
        }
        if ((object = this.mGLSurfaceView) != null) {
            this.removeView((View)object);
            this.mGLSurfaceView = null;
        }
        this.mSurfaceView = null;
    }

    public void resetLogView() {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            this.removeView((View)tXDashBoard);
            tXDashBoard = this.mDashBoard;
            this.addView((View)tXDashBoard);
        }
    }

    public void setDashBoardStatusInfo(CharSequence charSequence) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(charSequence);
        }
    }

    public void setLogMargin(float f10, float f11, float f12, float f13) {
        this.mLeft = f10;
        this.mRight = f11;
        this.mTop = f12;
        this.mBottom = f13;
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            int n10 = (int)f10;
            int n11 = (int)f12;
            int n12 = (int)f11;
            int n13 = (int)f13;
            tXDashBoard.a(n10, n11, n12, n13);
        }
    }

    public void setLogMarginRatio(float f10, float f11, float f12, float f13) {
        this.getWidth();
        this.getHeight();
        TXCloudVideoView$1 tXCloudVideoView$1 = new TXCloudVideoView$1(this, f10, f11, f12, f13);
        this.postDelayed(tXCloudVideoView$1, 100);
    }

    public void setLogText(Bundle bundle, Bundle bundle2, int n10) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.a(bundle, bundle2, n10);
        }
    }

    public void setMirror(boolean bl2) {
    }

    public void setRenderMode(int n10) {
    }

    public void setRenderRotation(int n10) {
    }

    public void setUserId(String string2) {
        this.mUserId = string2;
    }

    /*
     * WARNING - void declaration
     */
    public void showLog(boolean bl2) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            void var1_4;
            if (bl2) {
                int n10 = 2;
            } else {
                boolean bl3 = false;
            }
            tXDashBoard.setShowLevel((int)var1_4);
        }
    }

    public void showVideoDebugLog(int n10) {
        TXDashBoard tXDashBoard = this.mDashBoard;
        if (tXDashBoard != null) {
            tXDashBoard.setShowLevel(n10);
        }
    }

    public void start(boolean bl2, boolean bl3, n n10) {
        TXCGLSurfaceView tXCGLSurfaceView;
        this.mFocus = bl2;
        this.mZoom = bl3;
        if (bl2 || bl3) {
            this.setOnTouchListener(this);
            this.mCapture = n10;
        }
        if ((tXCGLSurfaceView = this.mGLSurfaceView) != null) {
            bl3 = false;
            tXCGLSurfaceView.setVisibility(0);
        }
    }

    public void stop(boolean bl2) {
        TXCGLSurfaceView tXCGLSurfaceView;
        int n10 = this.mFocus;
        if (n10 != 0 || (n10 = this.mZoom) != 0) {
            this.setOnTouchListener(null);
        }
        this.mCapture = null;
        if (bl2 && (tXCGLSurfaceView = this.mGLSurfaceView) != null) {
            n10 = 8;
            tXCGLSurfaceView.setVisibility(n10);
        }
    }

    public void updateVideoViewSize(int n10, int n11) {
        TXCGLSurfaceView tXCGLSurfaceView = this.mGLSurfaceView;
        if (tXCGLSurfaceView != null || (tXCGLSurfaceView = this.mVideoView) != null) {
            int n12 = this.getWidth();
            int n13 = this.getHeight();
            if (n11 != 0 && n13 != 0) {
                this.mCaptureWidth = n10;
                this.mCaptureHeight = n11;
                float f10 = n10;
                float f11 = 1.0f;
                f10 *= f11;
                float f12 = n11;
                f10 /= f12;
                f12 = n12;
                f11 *= f12;
                float f13 = n13;
                float f14 = f10 - (f11 /= f13);
                float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                int n14 = 0;
                if (f15 > 0) {
                    n13 = (int)(f12 /= f10);
                    n10 = (this.getHeight() - n13) / 2;
                } else {
                    n12 = (int)(f13 *= f10);
                    n14 = (this.getWidth() - n12) / 2;
                    n10 = 0;
                    f10 = 0.0f;
                }
                ViewGroup.LayoutParams layoutParams = tXCGLSurfaceView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = (FrameLayout.LayoutParams)layoutParams;
                    f15 = layoutParams.width;
                    if (f15 == n12 && (f15 = (float)layoutParams.height) == n13) {
                        return;
                    }
                    layoutParams.width = n12;
                    layoutParams.height = n13;
                } else {
                    layoutParams = new FrameLayout.LayoutParams(n12, n13);
                }
                layoutParams.leftMargin = n14;
                layoutParams.topMargin = n10;
                tXCGLSurfaceView.setLayoutParams(layoutParams);
            }
        }
    }
}

