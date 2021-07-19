/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$Callback
 *  android.media.MediaCodec$CodecException
 *  android.media.MediaFormat
 *  android.util.Log
 */
package com.meicam.nvconvertorlib;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import com.meicam.nvconvertorlib.NvMediaEncodecCallback;
import java.nio.ByteBuffer;

public class NvMediaEncodecCallback$1
extends MediaCodec.Callback {
    public final /* synthetic */ NvMediaEncodecCallback this$0;

    public NvMediaEncodecCallback$1(NvMediaEncodecCallback nvMediaEncodecCallback) {
        this.this$0 = nvMediaEncodecCallback;
    }

    public void onError(MediaCodec object, MediaCodec.CodecException object2) {
        object = NvMediaEncodecCallback.access$000(this.this$0);
        if (object == null) {
            return;
        }
        int n10 = -1;
        if (object2 != null) {
            n10 = object2.getErrorCode();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onErrorCode:");
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "NvMediaEncodecCallback";
        Log.d((String)string2, (String)object2);
        if (n10 == 0) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("An error occur in file writer, the error code: ");
        ((StringBuilder)object2).append(n10);
        object = ((StringBuilder)object2).toString();
        Log.e((String)string2, (String)object);
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int n10) {
        Log.d((String)"NvMediaEncodecCallback", (String)"onInputBufferAvailable");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int n10, MediaCodec.BufferInfo object) {
        int n11;
        Object object2 = NvMediaEncodecCallback.access$000(this.this$0);
        if (object2 == null) {
            return;
        }
        if (object == null) {
            return;
        }
        object2 = mediaCodec.getOutputBuffer(n10);
        NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker = NvMediaEncodecCallback.access$000(this.this$0);
        nvAndroidSurfaceFileWriterVideoWorker.SendVideoData((ByteBuffer)object2, (MediaCodec.BufferInfo)object);
        if (object != null) {
            n11 = object.flags & 4;
            if (n11 != 0) {
                object = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)this.this$0).m_videoEncodeEosSyncEvent;
                synchronized (object) {
                    object2 = this.this$0;
                    object2 = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)object2);
                    object2 = ((NvAndroidSurfaceFileWriterVideoWorker)object2).m_videoEncodeEosSyncEvent;
                    object2.notifyAll();
                }
            }
        } else {
            object = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)this.this$0).m_videoEncodeEosSyncEvent;
            synchronized (object) {
                object2 = this.this$0;
                object2 = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)object2);
                object2 = ((NvAndroidSurfaceFileWriterVideoWorker)object2).m_videoEncodeEosSyncEvent;
                object2.notifyAll();
            }
        }
        n11 = 0;
        object = null;
        try {
            mediaCodec.releaseOutputBuffer(n10, false);
            return;
        }
        catch (Exception exception) {
            String string2 = "NvMediaEncodecCallback";
            object = "MediaCodec.releaseOutputBuffer failed!";
            Log.e((String)string2, (String)object);
            exception.printStackTrace();
        }
    }

    public void onOutputFormatChanged(MediaCodec object, MediaFormat mediaFormat) {
        object = NvMediaEncodecCallback.access$000(this.this$0);
        if (object == null) {
            return;
        }
        Log.d((String)"NvMediaEncodecCallback", (String)"onOutputFormatChanged");
    }
}

