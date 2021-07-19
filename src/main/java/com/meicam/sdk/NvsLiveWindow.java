/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.util.AttributeSet
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.meicam.sdk.NvsLiveWindow$1;
import com.meicam.sdk.NvsLiveWindow$InternalVideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameCallback;
import com.meicam.sdk.NvsUtils;

public class NvsLiveWindow
extends SurfaceView
implements SurfaceHolder.Callback {
    public static final int FILLMODE_PRESERVEASPECTCROP = 0;
    public static final int FILLMODE_PRESERVEASPECTFIT = 1;
    public static final int FILLMODE_PRESERVEASPECTFIT_BLUR = 3;
    public static final int FILLMODE_STRETCH = 2;
    public static final int HDR_DISPLAY_MODE_DEPEND_DEVICE = 1;
    public static final int HDR_DISPLAY_MODE_SDR = 0;
    public static final int HDR_DISPLAY_MODE_TONE_MAP_SDR = 2;
    public int m_fillMode = 0;
    public int m_hdrDisplayMode = 0;
    public long m_internalObject = 0L;
    private Surface m_surface;
    private NvsLiveWindow$VideoFrameCallback m_videoFrameCallback = null;

    public NvsLiveWindow(Context context) {
        super(context);
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindow(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public static /* synthetic */ NvsLiveWindow$VideoFrameCallback access$000(NvsLiveWindow nvsLiveWindow) {
        return nvsLiveWindow.m_videoFrameCallback;
    }

    private void destroyCurrentSurface() {
        Surface surface;
        boolean bl2 = this.isInEditMode();
        if (!bl2 && (surface = this.m_surface) != null) {
            long l10 = this.m_internalObject;
            this.nativeSurfaceDestroyed(l10);
            this.m_surface.release();
            bl2 = false;
            surface = null;
            this.m_surface = null;
        }
    }

    private void init() {
        long l10;
        long l11;
        long l12;
        boolean bl2 = this.isInEditMode();
        if (!bl2 && !(bl2 = (l12 = (l11 = this.m_internalObject) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = false;
            this.nativeInit(false);
            SurfaceHolder surfaceHolder = this.getHolder();
            surfaceHolder.addCallback((SurfaceHolder.Callback)this);
        }
    }

    private native void nativeClearVideoFrame(long var1);

    private native void nativeClose(long var1);

    private native boolean nativeGetStopRenderingBeforeNextSurfaceChange(long var1);

    private native void nativeInit(boolean var1);

    private native PointF nativeMapCanonicalToView(long var1, PointF var3);

    private native PointF nativeMapNormalizedToView(long var1, PointF var3);

    private native PointF nativeMapViewToCanonical(long var1, PointF var3);

    private native PointF nativeMapViewToNormalized(long var1, PointF var3);

    private native void nativeOnSizeChanged(long var1, int var3, int var4);

    private native void nativeRecordUpdateTime(long var1);

    private native void nativeRepaintVideoFrame(long var1);

    private native void nativeSetBackgroundColor(long var1, float var3, float var4, float var5);

    private native void nativeSetFillMode(long var1, int var3);

    private native void nativeSetHDRDisplayMode(long var1, int var3);

    private native void nativeSetStopRenderingBeforeNextSurfaceChange(long var1, boolean var3);

    private native void nativeSetVideoFrameCallback(long var1, NvsLiveWindow$InternalVideoFrameCallback var3);

    private native void nativeSurfaceChanged(long var1, Surface var3, int var4, int var5);

    private native void nativeSurfaceDestroyed(long var1);

    private native Bitmap nativeTakeScreenshot(long var1);

    public void clearVideoFrame() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeClearVideoFrame(l10);
    }

    public int getFillMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_fillMode;
    }

    public int getHDRDisplayMode() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_hdrDisplayMode;
    }

    public boolean getStopRenderingBeforeNextSurfaceChange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetStopRenderingBeforeNextSurfaceChange(l10);
    }

    public PointF mapCanonicalToView(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapCanonicalToView(l10, pointF);
    }

    public PointF mapNormalizedToView(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapNormalizedToView(l10, pointF);
    }

    public PointF mapViewToCanonical(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapViewToCanonical(l10, pointF);
    }

    public PointF mapViewToNormalized(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMapViewToNormalized(l10, pointF);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.init();
    }

    public void onDetachedFromWindow() {
        long l10;
        long l11;
        long l12;
        long l13;
        SurfaceHolder surfaceHolder = null;
        this.m_videoFrameCallback = null;
        long l14 = this.m_internalObject;
        this.nativeSetVideoFrameCallback(l14, null);
        boolean bl2 = this.isInEditMode();
        if (!bl2 && (l13 = (l12 = (l11 = this.m_internalObject) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            this.nativeClose(l11);
            this.m_internalObject = l10;
            surfaceHolder = this.getHolder();
            surfaceHolder.removeCallback((SurfaceHolder.Callback)this);
        }
        super.onDetachedFromWindow();
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            long l10 = this.m_internalObject;
            this.nativeOnSizeChanged(l10, n10, n11);
        }
        super.onSizeChanged(n10, n11, n12, n13);
    }

    public void setBackgroundColor(float f10, float f11, float f12) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetBackgroundColor(l10, f10, f11, f12);
    }

    public void setFillMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.m_fillMode;
        if (n10 == n11) {
            return;
        }
        this.m_fillMode = n10;
        long l10 = this.m_internalObject;
        this.nativeSetFillMode(l10, n10);
    }

    public void setHDRDisplayMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = this.m_hdrDisplayMode;
        if (n10 == n11) {
            return;
        }
        this.m_hdrDisplayMode = n10;
        long l10 = this.m_internalObject;
        this.nativeSetHDRDisplayMode(l10, n10);
    }

    public void setStopRenderingBeforeNextSurfaceChange(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetStopRenderingBeforeNextSurfaceChange(l10, bl2);
    }

    public void setVideoFrameCallback(NvsLiveWindow$VideoFrameCallback object) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl2 = this.isInEditMode();
        if (bl2) {
            return;
        }
        this.m_videoFrameCallback = object;
        if (object != null) {
            long l10 = this.m_internalObject;
            object = new NvsLiveWindow$1(this);
            this.nativeSetVideoFrameCallback(l10, (NvsLiveWindow$InternalVideoFrameCallback)object);
        } else {
            long l11 = this.m_internalObject;
            object = null;
            this.nativeSetVideoFrameCallback(l11, null);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n10, int n11, int n12) {
        n10 = (int)(this.isInEditMode() ? 1 : 0);
        if (n10 == 0 && n11 >= (n10 = 1) && n12 >= n10) {
            long l10 = this.m_internalObject;
            Surface surface = surfaceHolder.getSurface();
            this.nativeSurfaceChanged(l10, surface, n11, n12);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            long l10 = this.m_internalObject;
            this.nativeSurfaceDestroyed(l10);
        }
    }

    public Bitmap takeScreenshot() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeTakeScreenshot(l10);
    }
}

