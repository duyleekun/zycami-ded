/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.graphics.SurfaceTexture
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.meicam.sdk.NvsLiveWindow$InternalVideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameCallback;
import com.meicam.sdk.NvsLiveWindow$VideoFrameInfo;
import com.meicam.sdk.NvsLiveWindowExt$1;
import com.meicam.sdk.NvsUtils;
import java.util.ArrayList;

public class NvsLiveWindowExt
extends TextureView
implements TextureView.SurfaceTextureListener {
    public static final int FILLMODE_PRESERVEASPECTCROP = 0;
    public static final int FILLMODE_PRESERVEASPECTFIT = 1;
    public static final int FILLMODE_PRESERVEASPECTFIT_BLUR = 3;
    public static final int FILLMODE_STRETCH = 2;
    public static final int HDR_DISPLAY_MODE_DEPEND_DEVICE = 1;
    public static final int HDR_DISPLAY_MODE_SDR = 0;
    public static final int HDR_DISPLAY_MODE_TONE_MAP_SDR = 2;
    public int m_fillMode = 0;
    private Object m_frameInfoMutex;
    public int m_hdrDisplayMode = 0;
    public long m_internalObject = 0L;
    private View m_overlayBuddy = null;
    private ArrayList m_pendingVideoFrameInfoList;
    private Surface m_surface;
    private boolean m_verbose = false;
    private NvsLiveWindow$VideoFrameCallback m_videoFrameCallback = null;

    public NvsLiveWindowExt(Context object) {
        super(object);
        super();
        this.m_pendingVideoFrameInfoList = object;
        super();
        this.m_frameInfoMutex = object;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindowExt(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super();
        this.m_pendingVideoFrameInfoList = object;
        super();
        this.m_frameInfoMutex = object;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindowExt(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        super();
        this.m_pendingVideoFrameInfoList = object;
        super();
        this.m_frameInfoMutex = object;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public NvsLiveWindowExt(Context object, AttributeSet attributeSet, int n10, int n11) {
        super(object, attributeSet, n10, n11);
        super();
        this.m_pendingVideoFrameInfoList = object;
        super();
        this.m_frameInfoMutex = object;
        NvsUtils.checkFunctionInMainThread();
        this.init();
    }

    public static /* synthetic */ Object access$000(NvsLiveWindowExt nvsLiveWindowExt) {
        return nvsLiveWindowExt.m_frameInfoMutex;
    }

    public static /* synthetic */ ArrayList access$100(NvsLiveWindowExt nvsLiveWindowExt) {
        return nvsLiveWindowExt.m_pendingVideoFrameInfoList;
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
        this.setSurfaceTextureListener(this);
        boolean bl2 = this.isInEditMode();
        if (!bl2 && !(bl2 = (l12 = (l11 = this.m_internalObject) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = true;
            this.nativeInit(bl2);
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

    public void invalidate() {
        super.invalidate();
        View view = this.m_overlayBuddy;
        if (view != null) {
            view.invalidate();
        }
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
        this.m_overlayBuddy = null;
        this.m_videoFrameCallback = null;
        long l10 = this.m_internalObject;
        this.nativeSetVideoFrameCallback(l10, null);
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            this.destroyCurrentSurface();
            l10 = this.m_internalObject;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                this.nativeClose(l10);
                this.m_internalObject = l11;
            }
        }
        this.setSurfaceTextureListener(null);
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

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.destroyCurrentSurface();
        int n12 = this.isInEditMode();
        if (n12 == 0 && n10 >= (n12 = 1) && n11 >= n12) {
            Surface surface;
            this.m_surface = surface = new Surface(surfaceTexture);
            long l10 = this.m_internalObject;
            this.nativeSurfaceChanged(l10, surface, n10, n11);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean bl2 = this.isInEditMode();
        if (!bl2) {
            this.destroyCurrentSurface();
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.destroyCurrentSurface();
        int n12 = this.isInEditMode();
        if (n12 == 0 && n10 >= (n12 = 1) && n11 >= n12) {
            Surface surface;
            this.m_surface = surface = new Surface(surfaceTexture);
            long l10 = this.m_internalObject;
            this.nativeSurfaceChanged(l10, surface, n10, n11);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void onSurfaceTextureUpdated(SurfaceTexture object) {
        long l10;
        Object object2;
        boolean bl2;
        Object object3;
        Object object4;
        Object object5 = this.m_videoFrameCallback;
        if (object5 == null) {
            return;
        }
        long l11 = this.m_internalObject;
        this.nativeRecordUpdateTime(l11);
        l11 = object.getTimestamp();
        boolean bl3 = this.m_verbose;
        if (bl3) {
            object = "Meishe";
            object4 = new StringBuilder();
            object3 = "surface texture updated, frame id=";
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append(l11);
            object4 = ((StringBuilder)object4).toString();
            Log.d((String)object, (String)object4);
        }
        bl3 = false;
        object = null;
        object4 = this.m_frameInfoMutex;
        // MONITORENTER : object4
        object3 = this.m_pendingVideoFrameInfoList;
        object3 = ((ArrayList)object3).iterator();
        while (bl2 = object3.hasNext()) {
            object2 = object3.next();
            object2 = (NvsLiveWindow$VideoFrameInfo)object2;
            l10 = ((NvsLiveWindow$VideoFrameInfo)object2).frameId;
            long l12 = l10 - l11;
            Object object6 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object6 != false) continue;
            bl3 = this.m_verbose;
            if (bl3) {
                object = "Meishe";
                object3 = new StringBuilder();
                String string2 = "Found frame info, frame id=";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append(l11);
                object3 = ((StringBuilder)object3).toString();
                Log.d((String)object, (String)object3);
            }
            object = object2;
            break;
        }
        if (object == null) {
            object5 = this.m_pendingVideoFrameInfoList;
            int n10 = ((ArrayList)object5).isEmpty();
            if (n10 == 0) {
                object = this.m_pendingVideoFrameInfoList;
                n10 = object.size() + -1;
                object = object.get(n10);
                object = (NvsLiveWindow$VideoFrameInfo)object;
                object5 = this.m_pendingVideoFrameInfoList;
                ((ArrayList)object5).clear();
            }
        } else {
            Object object7;
            while ((object7 = ((ArrayList)(object3 = this.m_pendingVideoFrameInfoList)).isEmpty()) == 0) {
                object3 = this.m_pendingVideoFrameInfoList;
                bl2 = false;
                object2 = null;
                object3 = ((ArrayList)object3).get(0);
                object3 = (NvsLiveWindow$VideoFrameInfo)object3;
                l10 = ((NvsLiveWindow$VideoFrameInfo)object3).frameId;
                long l13 = l10 - l11;
                object7 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object7 >= 0) break;
                object3 = this.m_pendingVideoFrameInfoList;
                ((ArrayList)object3).remove(0);
            }
        }
        // MONITOREXIT : object4
        if (object == null) return;
        object5 = this.m_videoFrameCallback;
        object5.onVideoFrameRendered((NvsLiveWindow$VideoFrameInfo)object);
    }

    public void repaintVideoFrame() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRepaintVideoFrame(l10);
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

    public void setOverlayBuddy(View view) {
        NvsUtils.checkFunctionInMainThread();
        this.m_overlayBuddy = view;
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
            object = new NvsLiveWindowExt$1(this);
            this.nativeSetVideoFrameCallback(l10, (NvsLiveWindow$InternalVideoFrameCallback)object);
        } else {
            long l11 = this.m_internalObject;
            object = null;
            this.nativeSetVideoFrameCallback(l11, null);
        }
    }

    public Bitmap takeScreenshot() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeTakeScreenshot(l10);
    }
}

