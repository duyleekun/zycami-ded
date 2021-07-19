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
import com.meicam.sdk.NvsMediaFileConvertor$1;
import com.meicam.sdk.NvsMediaFileConvertor$2;
import com.meicam.sdk.NvsMediaFileConvertor$3;
import com.meicam.sdk.NvsMediaFileConvertor$MeidaFileConvertorCallback;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicReference;

public class NvsMediaFileConvertor {
    public static final String CONVERTOR_AUDIO_BITRATE = "audio bitrate";
    public static final String CONVERTOR_AUDIO_CHANNEL_MAP = "convertor-audio-channel-map";
    public static final String CONVERTOR_AUDIO_ENCODER_NAME = "audio encoder name";
    public static final String CONVERTOR_BITRATE = "bitrate";
    public static final String CONVERTOR_CUSTOM_AUDIO_CHANNEL = "custom-audio-channel";
    public static final String CONVERTOR_CUSTOM_AUDIO_PCM_FILE = "custom-audio-pcm-file";
    public static final String CONVERTOR_CUSTOM_AUDIO_SAMPLE_RATE = "custom-audio-sample-rate";
    public static final String CONVERTOR_CUSTOM_VIDEO_FRAME_RATE = "custom-video-frame-rate";
    public static final String CONVERTOR_CUSTOM_VIDEO_HEIGHT = "custom-video-height";
    public static final String CONVERTOR_DETECTED_AUDIO_MUTE_FACTOR = "detected_audio_mute";
    public static final String CONVERTOR_DISABLE_HARDWARE_VIDEO_DECODER = "disable_hardware_video_decoder";
    public static final int CONVERTOR_ERROR_CODE_CANCEL = 1;
    public static final int CONVERTOR_ERROR_CODE_NO_ERROR = 0;
    public static final int CONVERTOR_ERROR_UNKNOWN = 65535;
    public static final int CONVERTOR_ERROR_VIDEO_DECODER_ERROR = 4;
    public static final int CONVERTOR_ERROR_VIDEO_DECODING_ERROR = 5;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int CONVERTOR_ERROR_VIDEO_ENCODING_ERROR = 3;
    public static final String CONVERTOR_GOP_SIZE = "gopsize";
    public static final String CONVERTOR_MAX_CACHE_SIZE_IN_MEMORY = "max_cache_size_in_memory";
    public static final String CONVERTOR_NO_AUDIO = "convertor-no-audio";
    public static final String CONVERTOR_NO_VIDEO = "convertor-no-video";
    public static final String CONVERTOR_REVERSE_AUDIO_STREAM = "convertor-reverse-audio";
    private final String TAG;
    private AtomicReference mCallbackHanlder;
    private AtomicReference m_callback;
    private long m_contextInterface;

    public NvsMediaFileConvertor() {
        long l10;
        AtomicReference<Object> atomicReference;
        this.TAG = "NvsMediaFileConvertor";
        this.m_callback = atomicReference = new AtomicReference<Object>(null);
        this.mCallbackHanlder = atomicReference = new AtomicReference<Object>(null);
        this.m_contextInterface = l10 = this.nativeInit();
    }

    private native void nativeCancelTask(long var1, long var3);

    private native void nativeClose(long var1);

    private native long nativeConvertMeidaFile(long var1, String var3, String var4, boolean var5, long var6, long var8, Hashtable var10);

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
    public long convertMeidaFile(String string2, String string3, boolean bl2, long l10, long l11, Hashtable hashtable) {
        synchronized (this) {
            long l12 = this.m_contextInterface;
            return this.nativeConvertMeidaFile(l12, string2, string3, bl2, l10, l11, hashtable);
        }
    }

    public void finalize() {
        this.release();
        super.finalize();
    }

    public boolean isReleased() {
        long l10 = this.m_contextInterface;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void notifyAudioMuteRage(long l10, long l11, long l12) {
        Object object = this.m_callback.get();
        Object object2 = object;
        object2 = (NvsMediaFileConvertor$MeidaFileConvertorCallback)object;
        Object object3 = object = this.mCallbackHanlder.get();
        object3 = (Handler)object;
        if (object2 != null) {
            if (object3 != null) {
                NvsMediaFileConvertor$3 nvsMediaFileConvertor$3;
                object = nvsMediaFileConvertor$3;
                nvsMediaFileConvertor$3 = new NvsMediaFileConvertor$3(this, (NvsMediaFileConvertor$MeidaFileConvertorCallback)object2, l10, l11, l12);
                object3.post((Runnable)nvsMediaFileConvertor$3);
            } else {
                object2.notifyAudioMuteRage(l10, l11, l12);
            }
        }
    }

    public void notifyFinish(long l10, String string2, String string3, int n10) {
        Object object = this.m_callback.get();
        Object object2 = object;
        object2 = (NvsMediaFileConvertor$MeidaFileConvertorCallback)object;
        Object object3 = object = this.mCallbackHanlder.get();
        object3 = (Handler)object;
        if (object2 != null) {
            if (object3 != null) {
                NvsMediaFileConvertor$2 nvsMediaFileConvertor$2;
                object = nvsMediaFileConvertor$2;
                nvsMediaFileConvertor$2 = new NvsMediaFileConvertor$2(this, (NvsMediaFileConvertor$MeidaFileConvertorCallback)object2, l10, string2, string3, n10);
                object3.post((Runnable)nvsMediaFileConvertor$2);
            } else {
                object2.onFinish(l10, string2, string3, n10);
            }
        }
    }

    public void notifyProgress(long l10, float f10) {
        Object object = this.m_callback.get();
        Object object2 = object;
        object2 = (NvsMediaFileConvertor$MeidaFileConvertorCallback)object;
        object = (Handler)this.mCallbackHanlder.get();
        if (object2 != null) {
            if (object != null) {
                NvsMediaFileConvertor$1 nvsMediaFileConvertor$1 = new NvsMediaFileConvertor$1(this, (NvsMediaFileConvertor$MeidaFileConvertorCallback)object2, l10, f10);
                object.post((Runnable)nvsMediaFileConvertor$1);
            } else {
                object2.onProgress(l10, f10);
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
            AtomicReference atomicReference = this.m_callback;
            atomicReference.set(null);
            this.m_contextInterface = l10 = 0L;
            return;
        }
    }

    public void setMeidaFileConvertorCallback(NvsMediaFileConvertor$MeidaFileConvertorCallback object, Handler handler) {
        this.m_callback.set(object);
        AtomicReference atomicReference = this.mCallbackHanlder;
        atomicReference.set(handler);
        if (object != null && handler == null) {
            object = this.mCallbackHanlder;
            atomicReference = Looper.getMainLooper();
            handler = new Handler((Looper)atomicReference);
            ((AtomicReference)object).set(handler);
        }
    }

    public void setMeidaFileConvertorCallback(NvsMediaFileConvertor$MeidaFileConvertorCallback object, boolean bl2) {
        AtomicReference atomicReference = this.m_callback;
        atomicReference.set(object);
        if (object != null && bl2) {
            object = this.mCallbackHanlder;
            atomicReference = Looper.getMainLooper();
            Handler handler = new Handler((Looper)atomicReference);
            ((AtomicReference)object).set(handler);
        }
    }
}

