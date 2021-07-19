/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextCallback;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextDetectActionCallback;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextErrorCallback;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextInternalCallback;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextLandmarkCallback;
import com.meicam.sdk.NvsUtils;

public class NvsARFaceContext {
    public static final int OBJECT_LAND_MARK_TYPE_ANIMAL = 1;
    public static final int OBJECT_LAND_MARK_TYPE_FACE = 0;
    public static final int OBJECT_TRACKING_TYPE_ANIMAL = 1;
    public static final int OBJECT_TRACKING_TYPE_FACE;
    public NvsARFaceContext$NvsARFaceContextCallback m_callback = null;
    public NvsARFaceContext$NvsARFaceContextInternalCallback m_callbackinternal = null;
    private long m_contextInterface;
    public NvsARFaceContext$NvsARFaceContextDetectActionCallback m_detectActionCallback = null;
    public NvsARFaceContext$NvsARFaceContextErrorCallback m_errorCallback = null;
    public NvsARFaceContext$NvsARFaceContextLandmarkCallback m_landmarkCallback = null;
    public Handler mainHandler;

    public NvsARFaceContext() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mainHandler = handler = new Handler(looper);
    }

    private void createInternalCallback() {
        NvsARFaceContext$NvsARFaceContextInternalCallback nvsARFaceContext$NvsARFaceContextInternalCallback = this.m_callbackinternal;
        if (nvsARFaceContext$NvsARFaceContextInternalCallback != null) {
            return;
        }
        this.m_callbackinternal = nvsARFaceContext$NvsARFaceContextInternalCallback = new NvsARFaceContext$1(this);
    }

    private native void nativeCleanup(long var1);

    private native boolean nativeIsObjectTracking(long var1, int var3);

    private native void nativeSetARFaceCallback(long var1, NvsARFaceContext$NvsARFaceContextInternalCallback var3);

    private native void nativeSetDualBufferInputUsed(long var1, boolean var3);

    private native void nativeSetReloadCurSticker(long var1, boolean var3);

    public void finalize() {
        this.release();
        super.finalize();
    }

    public boolean isFaceTracking() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        return this.nativeIsObjectTracking(l10, 0);
    }

    public boolean isObjectTracking(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_contextInterface;
        return this.nativeIsObjectTracking(l10, n10);
    }

    public void release() {
        this.m_callbackinternal = null;
        long l10 = this.m_contextInterface;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeCleanup(l10);
            this.m_contextInterface = l11;
        }
    }

    public void setContextCallback(NvsARFaceContext$NvsARFaceContextCallback object) {
        this.m_callback = object;
        if (object != null) {
            this.createInternalCallback();
        } else {
            object = this.m_errorCallback;
            if (object == null && (object = this.m_landmarkCallback) == null && (object = this.m_detectActionCallback) == null) {
                object = null;
                this.m_callbackinternal = null;
            }
        }
        long l10 = this.m_contextInterface;
        object = this.m_callbackinternal;
        this.nativeSetARFaceCallback(l10, (NvsARFaceContext$NvsARFaceContextInternalCallback)object);
    }

    public void setContextDetectActionCallback(NvsARFaceContext$NvsARFaceContextDetectActionCallback object) {
        this.m_detectActionCallback = object;
        if (object != null) {
            this.createInternalCallback();
        } else {
            object = this.m_errorCallback;
            if (object == null && (object = this.m_callback) == null && (object = this.m_landmarkCallback) == null) {
                object = null;
                this.m_callbackinternal = null;
            }
        }
        long l10 = this.m_contextInterface;
        object = this.m_callbackinternal;
        this.nativeSetARFaceCallback(l10, (NvsARFaceContext$NvsARFaceContextInternalCallback)object);
    }

    public void setContextErrorCallback(NvsARFaceContext$NvsARFaceContextErrorCallback object) {
        this.m_errorCallback = object;
        if (object != null) {
            this.createInternalCallback();
        } else {
            object = this.m_callback;
            if (object == null && (object = this.m_landmarkCallback) == null && (object = this.m_detectActionCallback) == null) {
                object = null;
                this.m_callbackinternal = null;
            }
        }
        long l10 = this.m_contextInterface;
        object = this.m_callbackinternal;
        this.nativeSetARFaceCallback(l10, (NvsARFaceContext$NvsARFaceContextInternalCallback)object);
    }

    public void setContextInterface(long l10) {
        this.m_contextInterface = l10;
    }

    public void setContextLandmarkCallback(NvsARFaceContext$NvsARFaceContextLandmarkCallback object) {
        this.m_landmarkCallback = object;
        if (object != null) {
            this.createInternalCallback();
        } else {
            object = this.m_callback;
            if (object == null && (object = this.m_errorCallback) == null && (object = this.m_detectActionCallback) == null) {
                object = null;
                this.m_callbackinternal = null;
            }
        }
        long l10 = this.m_contextInterface;
        object = this.m_callbackinternal;
        this.nativeSetARFaceCallback(l10, (NvsARFaceContext$NvsARFaceContextInternalCallback)object);
    }

    public void setDualBufferInputUsed(boolean bl2) {
        long l10 = this.m_contextInterface;
        this.nativeSetDualBufferInputUsed(l10, bl2);
    }

    public void setReloadCurSticker() {
        long l10 = this.m_contextInterface;
        this.nativeSetReloadCurSticker(l10, true);
    }
}

