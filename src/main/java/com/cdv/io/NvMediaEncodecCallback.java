/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$Callback
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 */
package com.cdv.io;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.cdv.io.NvMediaEncodecCallback$1;
import java.nio.ByteBuffer;

public class NvMediaEncodecCallback {
    private static final String TAG = "NvMediaEncodecCallback";
    private HandlerThread mCallbackThread = null;
    private long m_contextInterface = -1;

    public NvMediaEncodecCallback(long l10) {
        this.m_contextInterface = l10;
    }

    public static /* synthetic */ long access$000(NvMediaEncodecCallback nvMediaEncodecCallback) {
        return nvMediaEncodecCallback.m_contextInterface;
    }

    public static /* synthetic */ void access$100(long l10, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        NvMediaEncodecCallback.nativeOnOutputBufferAvailable(l10, byteBuffer, bufferInfo);
    }

    public static /* synthetic */ void access$200(long l10, int n10) {
        NvMediaEncodecCallback.nativeOnError(l10, n10);
    }

    public static /* synthetic */ void access$300(long l10, MediaFormat mediaFormat) {
        NvMediaEncodecCallback.nativeOnOutputFormatChanged(l10, mediaFormat);
    }

    private void closeCallbackThread() {
        HandlerThread handlerThread = this.mCallbackThread;
        if (handlerThread == null) {
            return;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            boolean bl2 = handlerThread.isAlive();
            if (bl2) {
                handlerThread = this.mCallbackThread;
                handlerThread.quitSafely();
            }
            handlerThread = this.mCallbackThread;
            try {
                handlerThread.join();
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            bl2 = false;
            handlerThread = null;
            this.mCallbackThread = null;
        }
    }

    private static native void nativeOnError(long var0, int var2);

    private static native void nativeOnOutputBufferAvailable(long var0, ByteBuffer var2, MediaCodec.BufferInfo var3);

    private static native void nativeOnOutputFormatChanged(long var0, MediaFormat var2);

    public void cleanUp() {
        this.closeCallbackThread();
    }

    public boolean setCallbackToCodec(MediaCodec mediaCodec) {
        Handler handler = null;
        if (mediaCodec == null) {
            return false;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object = this.mCallbackThread;
            String string2 = "NvMediaEncodecCallback";
            if (object == null) {
                String string3 = "callback handler";
                this.mCallbackThread = object = new HandlerThread(string3);
                if (object == null) {
                    Log.e((String)string2, (String)"Failed to create background handler thread!");
                    return false;
                }
                object.start();
            }
            if ((object = this.mCallbackThread.getLooper()) == null) {
                this.closeCallbackThread();
                Log.e((String)string2, (String)"Failed to getLooper of the background thread!");
                return false;
            }
            handler = new Handler((Looper)object);
            object = new NvMediaEncodecCallback$1(this);
            mediaCodec.setCallback((MediaCodec.Callback)object, handler);
            return true;
        }
        return false;
    }
}

