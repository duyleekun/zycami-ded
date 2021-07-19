/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 */
package com.meicam.nvconvertorlib;

import android.graphics.SurfaceTexture;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import java.util.concurrent.Semaphore;

public class NvAndroidSurfaceFileWriterVideoWorker$2
implements Runnable {
    public final /* synthetic */ NvAndroidSurfaceFileWriterVideoWorker this$0;

    public NvAndroidSurfaceFileWriterVideoWorker$2(NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker) {
        this.this$0 = nvAndroidSurfaceFileWriterVideoWorker;
    }

    public void run() {
        Object object = this.this$0;
        Object object2 = this.this$0;
        object2 = ((NvAndroidSurfaceFileWriterVideoWorker)object2).m_textureId;
        Object object3 = object2[0];
        CharSequence charSequence = new SurfaceTexture((int)object3);
        ((NvAndroidSurfaceFileWriterVideoWorker)object).m_surfaceTexture = charSequence;
        object = this.this$0;
        object = ((NvAndroidSurfaceFileWriterVideoWorker)object).m_surfaceTextureCreationSemaphore;
        try {
            ((Semaphore)object).release();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            charSequence.append("");
            object2 = exception.getMessage();
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            object2 = "VideoWorker";
            Logger.e((String)object2, charSequence);
            exception.printStackTrace();
        }
    }
}

