/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package com.meicam.nvconvertorlib;

import android.graphics.SurfaceTexture;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;

public class NvAndroidSurfaceFileWriter$2
implements Runnable {
    public final /* synthetic */ NvAndroidSurfaceFileWriter this$0;

    public NvAndroidSurfaceFileWriter$2(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        this.this$0 = nvAndroidSurfaceFileWriter;
    }

    public void run() {
        SurfaceTexture surfaceTexture;
        NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter = this.this$0;
        nvAndroidSurfaceFileWriter.surfaceTexture = surfaceTexture = nvAndroidSurfaceFileWriter.m_videoWorker.InitSurfaceTexture();
        this.this$0.semaphore.release();
    }
}

