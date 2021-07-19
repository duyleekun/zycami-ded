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
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.util.ArrayList;

public class NvAndroidSurfaceFileWriter$1
extends Handler {
    public final /* synthetic */ NvAndroidSurfaceFileWriter this$0;

    public NvAndroidSurfaceFileWriter$1(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, Looper looper) {
        this.this$0 = nvAndroidSurfaceFileWriter;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        int n10;
        int n11 = ((Message)object).what;
        if (n11 != 0 && n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                return;
            }
            String string2 = "handleMessage: NV_ANDROID_SURFACE_FILE_WRITER_ENCODER_REVERSE_CONTINUE_EVENT_TYPE";
            Logger.e("SurfaceFileWriter", string2);
            Message message = new Message();
            message.what = n10;
            message.obj = object = ((Message)object).obj;
            object = this.this$0.m_processEventHandler;
            object.sendMessage(message);
            return;
        }
        object = (NvVideoFrame)((Message)object).obj;
        Object object2 = this.this$0.m_mp4muxSyncObject;
        synchronized (object2) {
            Object object3 = this.this$0;
            object3 = ((NvAndroidSurfaceFileWriter)object3).m_mp4MuxBuffer;
            if (object3 != null) {
                ((ArrayList)object3).add(object);
            }
            object = this.this$0;
            object = ((NvAndroidSurfaceFileWriter)object).m_mp4muxSyncObject;
            object.notifyAll();
            return;
        }
    }
}

