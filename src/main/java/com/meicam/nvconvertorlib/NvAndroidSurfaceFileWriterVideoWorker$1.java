/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.meicam.nvconvertorlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;

public class NvAndroidSurfaceFileWriterVideoWorker$1
extends Handler {
    public final /* synthetic */ NvAndroidSurfaceFileWriterVideoWorker this$0;

    public NvAndroidSurfaceFileWriterVideoWorker$1(NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker, Looper looper) {
        this.this$0 = nvAndroidSurfaceFileWriterVideoWorker;
        super(looper);
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        if (n10 == 0) {
            object = this.this$0;
            ((NvAndroidSurfaceFileWriterVideoWorker)object).Cleanup();
        }
    }
}

