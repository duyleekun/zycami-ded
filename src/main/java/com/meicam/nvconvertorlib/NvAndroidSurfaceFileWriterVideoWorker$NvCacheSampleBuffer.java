/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import com.meicam.nvconvertorlib.NvVideoFrame;

public class NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer {
    public NvVideoFrame m_samplesBuffer = null;
    public long m_timestamp = Long.MIN_VALUE;
    public long offsetInTmpFile = 0L;
    public int pixelFormat = 0;
    public int sampleSizeInFile = 0;
    public final /* synthetic */ NvAndroidSurfaceFileWriterVideoWorker this$0;

    public NvAndroidSurfaceFileWriterVideoWorker$NvCacheSampleBuffer(NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker) {
        this.this$0 = nvAndroidSurfaceFileWriterVideoWorker;
    }
}

