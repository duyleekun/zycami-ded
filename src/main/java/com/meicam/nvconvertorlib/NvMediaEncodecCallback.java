/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$Callback
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 */
package com.meicam.nvconvertorlib;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import com.meicam.nvconvertorlib.NvMediaEncodecCallback$1;

public class NvMediaEncodecCallback {
    private static final String TAG = "NvMediaEncodecCallback";
    private HandlerThread mCallbackThread = null;
    private NvAndroidSurfaceFileWriterVideoWorker m_contextInterface;

    public NvMediaEncodecCallback(NvAndroidSurfaceFileWriterVideoWorker nvAndroidSurfaceFileWriterVideoWorker) {
        this.m_contextInterface = nvAndroidSurfaceFileWriterVideoWorker;
    }

    public static /* synthetic */ NvAndroidSurfaceFileWriterVideoWorker access$000(NvMediaEncodecCallback nvMediaEncodecCallback) {
        return nvMediaEncodecCallback.m_contextInterface;
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
            String string2 = TAG;
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

