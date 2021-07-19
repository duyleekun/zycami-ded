/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsMediaFileVideoRetriever$1;
import com.meicam.sdk.NvsMediaFileVideoRetriever$2;
import com.meicam.sdk.NvsMediaFileVideoRetriever$3;
import com.meicam.sdk.NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
import java.nio.ByteBuffer;

public class NvsMediaFileVideoRetriever {
    public static final int RETRIEVER_ERROR_CODE_CANCEL = 1;
    public static final int RETRIEVER_ERROR_CODE_NO_ERROR = 0;
    public static final int RETRIEVER_ERROR_UNKNOWN = 65535;
    public static final int RETRIEVER_ERROR_VIDEO_DECODER_ERROR = 4;
    public static final int RETRIEVER_ERROR_VIDEO_DECODING_ERROR = 5;
    public static final int RETRIEVER_ERROR_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int RETRIEVER_ERROR_VIDEO_ENCODING_ERROR = 3;
    public static final int VIDEO_RETRIEVER_FLAG_ONE_FRAME_IN_SEGMENT = 1;
    private final String TAG;
    private Handler mCallbackHanlder = null;
    private NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback m_callback = null;
    private long m_contextInterface;

    public NvsMediaFileVideoRetriever() {
        long l10;
        this.TAG = "NvsMediaFileVideoRetriever";
        this.m_contextInterface = l10 = this.nativeInit();
    }

    private native void nativeCancelTask(long var1, long var3);

    private native void nativeClose(long var1);

    private native long nativeDecodeVideoSegment(long var1, String var3, long var4, long var6, int var8, int var9, int var10);

    private native NvsAVFileInfo nativeGetAVFileInfo(String var1, int var2);

    private native long nativeInit();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cancelTask(long l10) {
        boolean bl2 = this.isReleased();
        if (bl2) return;
        synchronized (this) {
            long l11 = this.m_contextInterface;
            this.nativeCancelTask(l11, l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long decodeVideoSegment(String string2, long l10, long l11, int n10, int n11, int n12) {
        synchronized (this) {
            long l12 = this.m_contextInterface;
            return this.nativeDecodeVideoSegment(l12, string2, l10, l11, n10, n11, n12);
        }
    }

    public void finalize() {
        this.release();
        super.finalize();
    }

    public NvsAVFileInfo getAVFileInfo(String string2) {
        return this.nativeGetAVFileInfo(string2, 0);
    }

    public boolean isReleased() {
        long l10 = this.m_contextInterface;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void notifyFinish(long l10, int n10) {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.m_callback;
        Handler handler = this.mCallbackHanlder;
        if (nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback != null) {
            if (handler != null) {
                NvsMediaFileVideoRetriever$2 nvsMediaFileVideoRetriever$2 = new NvsMediaFileVideoRetriever$2(this, nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, l10, n10);
                handler.post((Runnable)nvsMediaFileVideoRetriever$2);
            } else {
                nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifyFinsih(l10, n10);
            }
        }
    }

    public void notifyProgress(long l10, float f10) {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.m_callback;
        Handler handler = this.mCallbackHanlder;
        if (nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback != null) {
            if (handler != null) {
                NvsMediaFileVideoRetriever$1 nvsMediaFileVideoRetriever$1 = new NvsMediaFileVideoRetriever$1(this, nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, l10, f10);
                handler.post((Runnable)nvsMediaFileVideoRetriever$1);
            } else {
                nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifyProgress(l10, f10);
            }
        }
    }

    public void notifySengmentData(long l10, ByteBuffer byteBuffer, int n10, int n11, int n12, int n13) {
        NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = this.m_callback;
        Handler handler = this.mCallbackHanlder;
        if (nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback != null) {
            if (handler != null) {
                NvsMediaFileVideoRetriever$3 nvsMediaFileVideoRetriever$3 = new NvsMediaFileVideoRetriever$3(this, nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, l10, byteBuffer, n10, n11, n12, n13);
                handler.post((Runnable)nvsMediaFileVideoRetriever$3);
            } else {
                nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback.notifySengmentData(l10, byteBuffer, n10, n11, n12, n13);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        boolean bl2 = this.isReleased();
        if (bl2) {
            return;
        }
        synchronized (this) {
            long l10 = this.m_contextInterface;
            this.nativeClose(l10);
            bl2 = false;
            Object var4_3 = null;
            this.m_callback = null;
            this.m_contextInterface = l10 = 0L;
            return;
        }
    }

    public void setMeidaFileVideoRetrieverCallback(NvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback, Handler handler) {
        this.m_callback = nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
        this.mCallbackHanlder = handler;
        if (nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback != null && handler == null) {
            handler = Looper.getMainLooper();
            nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback = new Handler((Looper)handler);
            this.mCallbackHanlder = nvsMediaFileVideoRetriever$MeidaFileVideoRetrieverCallback;
        }
    }
}

