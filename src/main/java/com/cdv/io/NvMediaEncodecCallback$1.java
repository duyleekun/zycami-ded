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
package com.cdv.io;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import com.cdv.io.NvMediaEncodecCallback;
import java.nio.ByteBuffer;

public class NvMediaEncodecCallback$1
extends MediaCodec.Callback {
    public final /* synthetic */ NvMediaEncodecCallback this$0;

    public NvMediaEncodecCallback$1(NvMediaEncodecCallback nvMediaEncodecCallback) {
        this.this$0 = nvMediaEncodecCallback;
    }

    public void onError(MediaCodec object, MediaCodec.CodecException object2) {
        long l10;
        object = this.this$0;
        long l11 = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)object);
        long l12 = l11 - (l10 = 0L);
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 <= 0) {
            return;
        }
        object3 = -1;
        if (object2 != null) {
            object3 = object2.getErrorCode();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onErrorCode:");
        ((StringBuilder)object2).append((int)object3);
        object2 = ((StringBuilder)object2).toString();
        Log.d((String)"NvMediaEncodecCallback", (String)object2);
        NvMediaEncodecCallback.access$200(NvMediaEncodecCallback.access$000(this.this$0), (int)object3);
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int n10) {
        Log.d((String)"NvMediaEncodecCallback", (String)"onInputBufferAvailable");
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int n10, MediaCodec.BufferInfo object) {
        long l10;
        Object object2 = this.this$0;
        long l11 = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)object2);
        long l12 = l11 - (l10 = 0L);
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 <= 0) {
            return;
        }
        if (object == null) {
            return;
        }
        object2 = mediaCodec.getOutputBuffer(n10);
        NvMediaEncodecCallback nvMediaEncodecCallback = this.this$0;
        long l13 = NvMediaEncodecCallback.access$000(nvMediaEncodecCallback);
        NvMediaEncodecCallback.access$100(l13, (ByteBuffer)object2, object);
        object = null;
        try {
            mediaCodec.releaseOutputBuffer(n10, false);
        }
        catch (Exception exception) {
            String string2 = "NvMediaEncodecCallback";
            object = "MediaCodec.releaseOutputBuffer failed!";
            Log.e((String)string2, (String)object);
            exception.printStackTrace();
        }
    }

    public void onOutputFormatChanged(MediaCodec object, MediaFormat mediaFormat) {
        long l10;
        object = this.this$0;
        long l11 = NvMediaEncodecCallback.access$000((NvMediaEncodecCallback)object);
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 <= 0) {
            return;
        }
        Log.d((String)"NvMediaEncodecCallback", (String)"onOutputFormatChanged");
        NvMediaEncodecCallback.access$300(NvMediaEncodecCallback.access$000(this.this$0), mediaFormat);
    }
}

