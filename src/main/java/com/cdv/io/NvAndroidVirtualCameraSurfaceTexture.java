/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 */
package com.cdv.io;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

public class NvAndroidVirtualCameraSurfaceTexture
implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "Virtual Camera";
    private SurfaceTexture m_surfaceTexture;
    private int m_texId = 0;

    public NvAndroidVirtualCameraSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.m_surfaceTexture = surfaceTexture;
    }

    private static native void notifyCameraFrameAvailable(int var0);

    public void attachToGLContext(int n10) {
        Object object = this.m_surfaceTexture;
        object.attachToGLContext(n10);
        try {
            this.m_texId = n10;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = "Virtual Camera";
            Log.e((String)string2, (String)object);
            exception.printStackTrace();
        }
    }

    public void detachFromGLContext() {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        surfaceTexture.detachFromGLContext();
        surfaceTexture = null;
        try {
            this.m_texId = 0;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = "Virtual Camera";
            Log.e((String)string2, (String)charSequence);
            exception.printStackTrace();
        }
    }

    public void expendCacheTexImage() {
        int n10;
        Object var2_2 = null;
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            Object object = this.m_surfaceTexture;
            try {
                object.updateTexImage();
                continue;
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("");
                String string2 = exception.getMessage();
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                string2 = "Virtual Camera";
                Log.e((String)string2, (String)object);
                exception.printStackTrace();
                break;
            }
        }
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.m_surfaceTexture;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        NvAndroidVirtualCameraSurfaceTexture.notifyCameraFrameAvailable(this.m_texId);
    }

    public void release() {
        this.m_surfaceTexture.setOnFrameAvailableListener(null);
        this.m_surfaceTexture = null;
    }

    public void setupOnFrameAvailableListener(Handler handler) {
        int n10;
        int n11;
        if (handler != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            SurfaceTexture surfaceTexture = this.m_surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this, handler);
        } else {
            handler = this.m_surfaceTexture;
            handler.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
        }
    }
}

