/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.meicam.nvconvertorlib;

import android.os.Build;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.util.ArrayList;

public class NvAndroidSurfaceFileWriter$3
implements Runnable {
    public final /* synthetic */ NvAndroidSurfaceFileWriter this$0;

    public NvAndroidSurfaceFileWriter$3(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        this.this$0 = nvAndroidSurfaceFileWriter;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        int n10;
        Object object3 = this.this$0;
        int n11 = ((NvAndroidSurfaceFileWriter)object3).m_avgFps;
        float f10 = 1000000 / n11;
        NvAndroidSurfaceFileWriter.access$002((NvAndroidSurfaceFileWriter)object3, f10);
        object3 = this.this$0;
        n11 = ((NvAndroidSurfaceFileWriter)object3).m_avgFps;
        int cfr_ignored_0 = 1000 / n11;
        object3 = ((NvAndroidSurfaceFileWriter)object3).m_videoWorker;
        ((NvAndroidSurfaceFileWriterVideoWorker)object3).InitVideoEncoder();
        do {
            this.this$0.m_videoWorker.AwaitNewImage();
            object3 = this.this$0.m_pendingVideoFrame;
            n10 = ((ArrayList)object3).size();
            n11 = 0;
            f10 = 0.0f;
            object2 = null;
            object = null;
            if (n10 > 0) {
                long l10;
                object3 = (NvVideoFrame)this.this$0.m_pendingVideoFrame.get(0);
                Object object4 = this.this$0.m_pendingVideoFrame;
                ((ArrayList)object4).remove(0);
                boolean bl2 = Build.VERSION.SDK_INT;
                boolean bl3 = 18 != 0;
                if (bl2 >= bl3) {
                    if (object3 != null) {
                        object4 = this.this$0;
                        ((NvAndroidSurfaceFileWriter)object4).lastVideoTimeStamp = l10 = ((NvVideoFrame)object3).streamTime;
                        object4 = ((NvAndroidSurfaceFileWriter)object4).m_videoWorker;
                        int[] nArray = ((NvVideoFrame)object3).textureId;
                        int n12 = nArray[0];
                        ((NvAndroidSurfaceFileWriterVideoWorker)object4).FeedVideoEncoderToSurface(n12, l10);
                    } else {
                        object4 = this.this$0.m_videoWorker;
                        bl3 = true;
                        ((NvAndroidSurfaceFileWriterVideoWorker)object4).DrainVideoEncoder(bl3);
                        object4 = this.this$0;
                        ((NvAndroidSurfaceFileWriter)object4).lastVideoTimeStamp = l10 = ((NvAndroidSurfaceFileWriter)object4).m_endTime;
                    }
                } else if (object3 != null) {
                    object4 = this.this$0;
                    ((NvAndroidSurfaceFileWriter)object4).lastVideoTimeStamp = l10 = ((NvVideoFrame)object3).streamTime;
                    object4 = ((NvAndroidSurfaceFileWriter)object4).m_videoWorker;
                    ((NvAndroidSurfaceFileWriterVideoWorker)object4).FeedVideoEncoder((NvVideoFrame)object3, l10);
                    ((NvVideoFrame)object3).buffer = null;
                } else {
                    this.this$0.m_videoWorker.FeedVideoEncoder(null, 0L);
                    object4 = this.this$0;
                    ((NvAndroidSurfaceFileWriter)object4).lastVideoTimeStamp = l10 = ((NvAndroidSurfaceFileWriter)object4).m_endTime;
                }
                if (object3 != null) {
                    object4 = this.this$0.m_videoWorker;
                    ((NvAndroidSurfaceFileWriterVideoWorker)object4).ReturnVideoFrameToPool((NvVideoFrame)object3);
                }
            }
            object3 = this.this$0.m_videoWorker;
        } while ((n10 = (int)(((NvAndroidSurfaceFileWriterVideoWorker)object3).m_endOfInputStreamSignaled ? 1 : 0)) == 0);
        object3 = new NvVideoFrame();
        ((NvVideoFrame)object3).buffer = null;
        ((NvVideoFrame)object3).bufferSize = 0;
        n11 = 32;
        f10 = 4.5E-44f;
        ((NvVideoFrame)object3).bufferFlags = n11;
        object2 = this.this$0.m_mp4muxSyncObject;
        synchronized (object2) {
            object = this.this$0;
            object = ((NvAndroidSurfaceFileWriter)object).m_mp4MuxBuffer;
            ((ArrayList)object).add(object3);
            object3 = this.this$0;
            object3 = ((NvAndroidSurfaceFileWriter)object3).m_mp4muxSyncObject;
            object3.notifyAll();
            return;
        }
    }
}

