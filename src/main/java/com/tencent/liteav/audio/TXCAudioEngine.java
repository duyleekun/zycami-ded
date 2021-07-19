/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceReverbType;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine$1;
import com.tencent.liteav.audio.a;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI$a;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TXCAudioEngine
implements b,
com.tencent.liteav.audio.impl.earmonitor.a {
    private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
    private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
    private static final long SYSTEM_AUDIO_KIT_RESTART_INTERVAL = 0L;
    private static final String TAG = "AudioEngine :TXCAudioEngine_java";
    private static volatile boolean has_init;
    private static boolean has_trae;
    private static WeakReference mAudioCoreDataListener;
    public static Context mContext;
    public static final HashMap mJitterDataListenerMap;
    private static final Object mJitterDataListenerMapLock;
    public static final HashMap mJitterEventListenerMap;
    private static final Object mJitterEventListenerMapLock;
    public static TXCAudioEngine sInstance;
    private TXSystemAudioKit mAudioKit;
    private final ArrayList mCallbackList;
    public boolean mDeviceIsRecording;
    public boolean mIsCallComed;
    public boolean mIsCustomRecord;

    static {
        SYSTEM_AUDIO_KIT_RESTART_INTERVAL = TimeUnit.SECONDS.toMillis(2);
        Object object = new TXCAudioEngine();
        sInstance = object;
        mContext = null;
        has_trae = false;
        mAudioCoreDataListener = null;
        object = new HashMap();
        mJitterDataListenerMap = object;
        mJitterDataListenerMapLock = object = new Object();
        object = new HashMap();
        mJitterEventListenerMap = object;
        mJitterEventListenerMapLock = object = new Object();
        has_init = false;
    }

    private TXCAudioEngine() {
        ArrayList arrayList;
        this.mCallbackList = arrayList = new ArrayList();
        this.mDeviceIsRecording = false;
        this.mIsCustomRecord = false;
        this.mIsCallComed = false;
    }

    public static void CreateInstance(Context context, String string2) {
        Class<TXCAudioEngine> clazz = TXCAudioEngine.class;
        synchronized (clazz) {
            TXCAudioEngine.CreateInstanceWithoutInitDevice(context, string2);
            TXCAudioEngineJNI.nativeInitAudioDevice();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void CreateInstanceWithoutInitDevice(Context object, String object2) {
        Class<TXCAudioEngine> clazz = TXCAudioEngine.class;
        synchronized (clazz) {
            Object object3;
            String string2 = TAG;
            String string3 = "CreateInstance: ";
            TXCLog.i(string2, string3);
            string2 = object.getApplicationContext();
            mContext = string2;
            boolean bl2 = has_init;
            if (bl2) {
                object = TAG;
                object3 = "CreateInstance already created~ ";
                TXCLog.i((String)object, (String)object3);
                return;
            }
            bl2 = TXCAudioEngineJNI.nativeCheckTraeEngine((Context)object);
            boolean bl3 = true;
            if (bl2) {
                has_trae = bl3;
            }
            if (!(bl2 = has_trae)) {
                bl2 = bl3;
            } else {
                bl2 = false;
                string2 = null;
            }
            TXCAudioEngineJNI.nativeUseSysAudioDevice(bl2);
            bl2 = has_trae;
            if (bl2) {
                TXCAudioEngineJNI.InitTraeEngineLibrary((Context)object);
                TXCAudioEngineJNI.nativeSetTRAEConfig((String)object3);
                TXCAudioEngineJNI.nativeInitBeforeEngineCreate((Context)object);
                object3 = com.tencent.liteav.audio.impl.a.a();
                object = object.getApplicationContext();
                ((com.tencent.liteav.audio.impl.a)object3).a((Context)object);
                object = com.tencent.liteav.audio.impl.a.a();
                object3 = sInstance;
                ((com.tencent.liteav.audio.impl.a)object).a((b)object3);
                object = mContext;
                TXCAudioEngineJNI.nativeNewAudioSessionDuplicate((Context)object);
            } else {
                TXCMultAudioTrackPlayer.getInstance();
                TXCAudioSysRecord.getInstance();
            }
            has_init = bl3;
            return;
        }
    }

    public static /* synthetic */ void access$000(TXCAudioEngine tXCAudioEngine) {
        tXCAudioEngine.startSystemAudioKit();
    }

    /*
     * WARNING - void declaration
     */
    public static String buildTRAEConfig(Context object, Boolean object2, boolean bl2, long l10) {
        int n10;
        int n11;
        Object object3;
        void var7_10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("");
        charSequence.append("sharp {\n");
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("  os android\n");
        charSequence = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("  trae {\n");
        charSequence = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("    dev {\n");
        charSequence = stringBuilder.toString();
        if (object2 != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            charSequence = "  closeOpensl ";
            stringBuilder.append((String)charSequence);
            boolean n112 = (Boolean)object2;
            object2 = n112 ? "n" : "y";
            stringBuilder.append((String)object2);
            object2 = "\n";
            stringBuilder.append((String)object2);
            charSequence = stringBuilder.toString();
        }
        object2 = a.a();
        Object[] objectArray = "timestamp_rollback_to_stable_samplerate";
        long l11 = ((a)object2).b((String)objectArray, 0L);
        long l12 = System.currentTimeMillis() - l11;
        long l13 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
        int n12 = 1;
        Boolean bl3 = null;
        if (l13 < 0) {
            int n13 = n12;
        } else {
            boolean bl4 = false;
            object2 = null;
        }
        int n14 = 3;
        objectArray = new Object[n14];
        Boolean bl5 = bl2;
        objectArray[0] = bl5;
        bl3 = (boolean)var7_10;
        objectArray[n12] = bl3;
        n12 = 2;
        objectArray[n12] = object3 = Long.valueOf(l10);
        String string2 = "low latency samplerate, enable: %b, isBlocked: %b, blockTime: %d";
        TXCLog.i(TAG, string2, objectArray);
        object3 = "  }\n";
        if (var7_10 == false && bl2 && (n11 = TXCAudioEngine.getLowLatencySampleRate((Context)object)) == (n10 = 48000)) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("  component 1\n");
            object = ((StringBuilder)object).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("  cap {\n");
            object = ((StringBuilder)object2).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = "    hw_sr 48000\n";
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object2);
            stringBuilder2.append((String)object3);
            object2 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object2);
            stringBuilder2.append("  play {\n");
            object2 = stringBuilder2.toString();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append((String)object2);
            stringBuilder2.append((String)object);
            object = stringBuilder2.toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = "  }";
            ((StringBuilder)object2).append((String)object);
            charSequence = ((StringBuilder)object2).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append("    }\n");
        object = ((StringBuilder)object).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append((String)object3);
        object = ((StringBuilder)object2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("}");
        return ((StringBuilder)object2).toString();
    }

    private TXSystemAudioKit createManufacturerAudioKit(Context object) {
        object = Build.MANUFACTURER;
        String string2 = "huawei";
        boolean bl2 = ((String)object).equalsIgnoreCase(string2);
        if (bl2) {
            object = new HuaweiAudioKit();
            return object;
        }
        return null;
    }

    public static void enableAudioEarMonitoring(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableAudioEarMonitoring: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(bl2);
    }

    public static boolean enableAudioVolumeEvaluation(boolean bl2, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableAudioVolumeEvaluation : ");
        charSequence.append(bl2);
        charSequence.append("interval:");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(bl2, n10);
        return true;
    }

    public static TXCAudioEngine getInstance() {
        return sInstance;
    }

    private static int getLowLatencySampleRate(Context object) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11 && (object = (AudioManager)object.getSystemService(string2 = "audio")) != null) {
            string2 = "android.media.property.OUTPUT_SAMPLE_RATE";
            object = object.getProperty(string2);
            try {
                return Integer.parseInt((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                string2 = TAG;
                String string3 = "can't parse low latency samplerate";
                TXCLog.e(string2, string3, numberFormatException);
            }
        }
        return -1;
    }

    public static int getMixingPlayoutVolumeLevel() {
        return TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
    }

    private void handleAudioEvent(String string2, int n10, String string3, String string4) {
        string2 = "timestamp_rollback_to_stable_samplerate";
        int n11 = 10055;
        if (n10 == n11) {
            a a10 = a.a();
            long l10 = System.currentTimeMillis();
            a10.a(string2, l10);
        } else {
            n11 = 10056;
            if (n10 == n11) {
                Object object = a.a();
                long l11 = 0L;
                ((a)object).a(string2, l11);
                string2 = TAG;
                object = "audio device restart when using stable samplerate";
                TXCLog.i(string2, (String)object);
            }
        }
    }

    public static boolean hasTrae() {
        return has_trae;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void onAudioJitterBufferNotify(String string2, int n10, String string3) {
        Object object;
        Object object2;
        Object object3 = mJitterEventListenerMapLock;
        synchronized (object3) {
            object2 = mJitterEventListenerMap;
            object = ((HashMap)object2).get(string2);
            if (object == null) return;
            object2 = ((HashMap)object2).get(string2);
            object2 = (WeakReference)object2;
            object2 = ((Reference)object2).get();
            object2 = (c)object2;
        }
        if (object2 == null) return;
        object3 = TAG;
        object = new StringBuilder();
        String string4 = "onAudioJitterBufferNotify  cur state ";
        ((StringBuilder)object).append(string4);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i((String)object3, (String)object);
        object2.a(string2, n10, string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void onAudioPlayPcmData(String string2, byte[] byArray, long l10, int n10, int n11) {
        Object object;
        Object object2 = mJitterDataListenerMapLock;
        synchronized (object2) {
            object = mJitterDataListenerMap;
            Object object3 = ((HashMap)object).get(string2);
            if (object3 == null) return;
            object = ((HashMap)object).get(string2);
            object = (WeakReference)object;
            object = ((Reference)object).get();
            object = (e)object;
            object3 = object;
        }
        if (object == null) return;
        object.a(string2, byArray, l10, n10, n11);
    }

    public static void onCorePlayPcmData(byte[] byArray, long l10, int n10, int n11) {
        WeakReference weakReference = mAudioCoreDataListener;
        if (weakReference != null) {
            weakReference = weakReference.get();
            Object object = weakReference;
            object = (e)((Object)weakReference);
            if (object != null) {
                object.a(null, byArray, l10, n10, n11);
            }
        }
    }

    public static void setAudioEarMonitoringVolume(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setAudioEarMonitoringVolume: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(n10);
    }

    public static void setAudioRoute(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setAudioRoute: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetAudioRoute(n10);
    }

    public static void setPlayoutDataListener(e e10) {
        boolean bl2;
        WeakReference<e> weakReference;
        mAudioCoreDataListener = weakReference = new WeakReference<e>(e10);
        if (e10 == null) {
            bl2 = false;
            e10 = null;
        } else {
            bl2 = true;
        }
        TXCAudioEngineJNI.nativeSetPlayoutDataListener(bl2);
    }

    public static void setSystemVolumeType(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setSystemVolumeType: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetSystemVolumeType(n10);
    }

    private void startSystemAudioKit() {
        TXSystemAudioKit tXSystemAudioKit = this.mAudioKit;
        if (tXSystemAudioKit == null && (tXSystemAudioKit = mContext) != null) {
            this.mAudioKit = tXSystemAudioKit = this.createManufacturerAudioKit((Context)tXSystemAudioKit);
            if (tXSystemAudioKit != null) {
                TXCAudioEngineJNI.nativeNotifySystemEarMonitoringInitializing();
                tXSystemAudioKit = this.mAudioKit;
                Context context = mContext;
                tXSystemAudioKit.initialize(context, this);
            } else {
                tXSystemAudioKit = null;
                TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
            }
        }
    }

    public void EnableMixMode(boolean bl2) {
        TXCAudioEngineJNI.nativeEnableMixMode(bl2);
    }

    public boolean IsDataCallbackFormatInvalid(int n10, int n11, int n12) {
        return TXCAudioEngineJNI.nativeIsDataCallbackFormatInvalid(n10, n11, n12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addEventCallback(WeakReference weakReference) {
        if (weakReference == null) {
            return;
        }
        ArrayList arrayList = this.mCallbackList;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.mCallbackList;
            arrayList2.add(weakReference);
            boolean bl2 = true;
            TXCAudioEngineJNI.nativeSetEventCallbackEnabled(bl2);
            return;
        }
    }

    public void clean() {
        TXCAudioEngineJNI.nativeClean();
    }

    public void enableAutoRestartDevice(boolean bl2) {
        TXCAudioEngineJNI.nativeEnableAutoRestartDevice(bl2);
    }

    public boolean enableCaptureEOSMode(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableEosMode ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeEnableCaptureEOSMode(bl2);
        return true;
    }

    public void enableEncodedDataCallback(boolean bl2) {
        TXCAudioEngineJNI.nativeEnableEncodedDataCallback(bl2);
    }

    public void enableEncodedDataPackWithTRAEHeaderCallback(boolean bl2) {
        TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(bl2);
    }

    public void enableInbandFEC(boolean bl2) {
        TXCAudioEngineJNI.nativeEnableInbandFEC(bl2);
    }

    public void enableSoftAEC(boolean bl2, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableSoftAEC: enable = ");
        charSequence.append(bl2);
        charSequence.append(" level = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        if (!bl2) {
            n10 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftAEC(n10);
    }

    public void enableSoftAGC(boolean bl2, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableSoftAGC: enable = ");
        charSequence.append(bl2);
        charSequence.append(" level = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        if (!bl2) {
            n10 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftAGC(n10);
    }

    public void enableSoftANS(boolean bl2, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableSoftANS: enable = ");
        charSequence.append(bl2);
        charSequence.append(" level = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        if (!bl2) {
            n10 = 0;
        }
        TXCAudioEngineJNI.nativeSetSoftANS(n10);
    }

    public void forceCallbackMixedPlayAudioFrame(boolean bl2) {
        TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(bl2);
    }

    public int getAECType() {
        return 2;
    }

    public Context getAppContext() {
        return mContext;
    }

    public TXCAudioEncoderConfig getAudioEncoderConfig() {
        return TXCAudioEngineJNI.nativeGetEncoderConfig();
    }

    public int getEncoderChannels() {
        return TXCAudioEngineJNI.nativeGetEncoderChannels();
    }

    public int getEncoderSampleRate() {
        return TXCAudioEngineJNI.nativeGetEncoderSampleRate();
    }

    public int getPlayAECType() {
        boolean bl2 = has_trae;
        if (bl2) {
            return 2;
        }
        return 0;
    }

    public int getPlayChannels() {
        return 2;
    }

    public int getPlaySampleRate() {
        return 48000;
    }

    public int getRemotePlayoutVolumeLevel(String string2) {
        if (string2 == null) {
            return 0;
        }
        return TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(string2);
    }

    public int getSoftwareCaptureVolumeLevel() {
        return TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
    }

    public StatusBucket getStatus(int n10) {
        return TXCAudioEngineJNI.getStatus(n10);
    }

    public boolean isAudioDeviceCapturing() {
        boolean bl2 = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("isRecording: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        return bl2;
    }

    public boolean isRemoteAudioPlaying(String string2) {
        if (string2 == null) {
            return false;
        }
        return TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(string2);
    }

    public boolean muteLocalAudio(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setRecordMute: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeMuteLocalAudio(bl2);
        return true;
    }

    public void muteRemoteAudio(String string2, boolean bl2) {
        if (string2 == null) {
            return;
        }
        TXCAudioEngineJNI.nativeMuteRemoteAudio(string2, bl2);
    }

    public void muteRemoteAudioInSpeaker(String string2, boolean bl2) {
        if (string2 == null) {
            return;
        }
        TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(string2, bl2);
    }

    public void onAudioKitError(TXSystemAudioKit tXSystemAudioKit) {
        Object object = this.mAudioKit;
        if (object != tXSystemAudioKit) {
            return;
        }
        object = "onAudioKitError";
        TXCLog.i(TAG, (String)object);
        tXSystemAudioKit = this.mAudioKit;
        if (tXSystemAudioKit != null) {
            tXSystemAudioKit.stopSystemEarMonitoring();
            this.mAudioKit.uninitialize();
            tXSystemAudioKit = null;
            this.mAudioKit = null;
        }
        object = Looper.getMainLooper();
        tXSystemAudioKit = new Handler((Looper)object);
        object = new TXCAudioEngine$1(this);
        long l10 = SYSTEM_AUDIO_KIT_RESTART_INTERVAL;
        tXSystemAudioKit.postDelayed((Runnable)object, l10);
    }

    public void onAudioKitInitFinished(TXSystemAudioKit objectArray, boolean bl2) {
        Object object;
        Object object2 = this.mAudioKit;
        if (object2 != objectArray) {
            return;
        }
        int n10 = 1;
        objectArray = new Object[n10];
        objectArray[0] = object = Boolean.valueOf(bl2);
        object2 = TAG;
        object = "system audio kit init finished, ret: %b.";
        TXCLog.i((String)object2, (String)object, objectArray);
        if (!bl2) {
            n10 = 0;
            objectArray = null;
            TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
        }
    }

    public void onCallStateChanged(int n10) {
        String string2 = TAG;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    TXCLog.i(string2, "TelephonyManager.CALL_STATE_OFFHOOK!");
                    TXCAudioEngineJNI.pauseAudioCapture(n11 != 0);
                    TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
                    TXAudioEffectManagerImpl.getCacheInstance().interruptAllMusics();
                    TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getAutoCacheHolder();
                    tXAudioEffectManagerImpl.interruptAllMusics();
                    this.mIsCallComed = n11;
                }
            } else {
                String string3 = "TelephonyManager.CALL_STATE_RINGING!";
                TXCLog.i(string2, string3);
            }
        } else {
            Object object = "TelephonyManager.CALL_STATE_IDLE!";
            TXCLog.i(string2, (String)object);
            n10 = (int)(this.mIsCallComed ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                this.mIsCallComed = false;
                TXCAudioEngineJNI.resumeAudioCapture();
                TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
                TXAudioEffectManagerImpl.getCacheInstance().recoverAllMusics();
                object = TXAudioEffectManagerImpl.getAutoCacheHolder();
                ((TXAudioEffectManagerImpl)object).recoverAllMusics();
            }
        }
    }

    public void onEarMonitoringInitialized(TXSystemAudioKit object, boolean bl2) {
        Object object2;
        Object object3 = this.mAudioKit;
        if (object3 != object) {
            return;
        }
        int n10 = 1;
        object = new Object[n10];
        object[0] = object2 = Boolean.valueOf(bl2);
        object3 = TAG;
        object2 = "onEarMonitoringInitialized result: %b";
        TXCLog.i((String)object3, (String)object2, object);
        if (bl2) {
            object = this.mAudioKit;
            TXCAudioEngineJNI.nativeSetSystemEarMonitoring((TXSystemAudioKit)object);
        } else {
            n10 = 0;
            object = null;
            TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(String string2, int n10, String string3, String string4) {
        Object object = new ArrayList();
        Object object2 = this.mCallbackList;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.mCallbackList;
            int n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                return;
            }
            object3 = this.mCallbackList;
            object3 = ((ArrayList)object3).iterator();
            while (bl2 = object3.hasNext()) {
                Object object4 = object3.next();
                object4 = (WeakReference)object4;
                object4 = ((Reference)object4).get();
                if ((object4 = (com.tencent.liteav.basic.b.a)object4) != null) {
                    ((ArrayList)object).add(object4);
                    continue;
                }
                object3.remove();
            }
            object3 = this.mCallbackList;
            n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                n11 = 0;
                object3 = null;
                TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
            }
        }
        object = ((ArrayList)object).iterator();
        boolean bl3;
        while (bl3 = object.hasNext()) {
            object2 = (com.tencent.liteav.basic.b.a)object.next();
            object2.c(string2, n10, string3, string4);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onEvent(String string2, int n10, String string3, String string4) {
        this.handleAudioEvent(string2, n10, string3, string4);
        Object object = new ArrayList();
        Object object2 = this.mCallbackList;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.mCallbackList;
            int n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                return;
            }
            object3 = this.mCallbackList;
            object3 = ((ArrayList)object3).iterator();
            while (bl2 = object3.hasNext()) {
                Object object4 = object3.next();
                object4 = (WeakReference)object4;
                object4 = ((Reference)object4).get();
                if ((object4 = (com.tencent.liteav.basic.b.a)object4) != null) {
                    ((ArrayList)object).add(object4);
                    continue;
                }
                object3.remove();
            }
            object3 = this.mCallbackList;
            n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                n11 = 0;
                object3 = null;
                TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
            }
        }
        object = ((ArrayList)object).iterator();
        boolean bl3;
        while (bl3 = object.hasNext()) {
            object2 = (com.tencent.liteav.basic.b.a)object.next();
            object2.a(string2, n10, string3, string4);
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onWarning(String string2, int n10, String string3, String string4) {
        this.handleAudioEvent(string2, n10, string3, string4);
        Object object = new ArrayList();
        Object object2 = this.mCallbackList;
        synchronized (object2) {
            boolean bl2;
            Object object3 = this.mCallbackList;
            int n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                return;
            }
            object3 = this.mCallbackList;
            object3 = ((ArrayList)object3).iterator();
            while (bl2 = object3.hasNext()) {
                Object object4 = object3.next();
                object4 = (WeakReference)object4;
                object4 = ((Reference)object4).get();
                if ((object4 = (com.tencent.liteav.basic.b.a)object4) != null) {
                    ((ArrayList)object).add(object4);
                    continue;
                }
                object3.remove();
            }
            object3 = this.mCallbackList;
            n11 = ((ArrayList)object3).size();
            if (n11 <= 0) {
                n11 = 0;
                object3 = null;
                TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false);
            }
        }
        object = ((ArrayList)object).iterator();
        boolean bl3;
        while (bl3 = object.hasNext()) {
            object2 = (com.tencent.liteav.basic.b.a)object.next();
            object2.b(string2, n10, string3, string4);
        }
        return;
    }

    public int pauseAudioCapture(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("pauseAudioCapture: ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.pauseAudioCapture(bl2);
        return 0;
    }

    public void pauseLocalAudio() {
        TXCAudioEngineJNI.nativePauseLocalAudio();
    }

    public int resumeAudioCapture() {
        TXCLog.i(TAG, "resumeRecord");
        TXCAudioEngineJNI.resumeAudioCapture();
        return 0;
    }

    public void resumeLocalAudio() {
        TXCAudioEngineJNI.nativeResumeLocalAudio();
    }

    public void sendCustomPCMData(com.tencent.liteav.basic.structs.a a10) {
        TXCAudioEngineJNI.sendCustomPCMData(a10);
    }

    public void sendCustomPCMData(byte[] byArray, int n10, int n11) {
        TXCAudioEngineJNI.sendCustomPCMData(byArray, n10, n11);
    }

    public boolean setAudioCaptureDataListener(f f10) {
        WeakReference<f> weakReference = TAG;
        String string2 = "setRecordListener ";
        TXCLog.i((String)((Object)weakReference), string2);
        if (f10 == null) {
            f10 = null;
            TXCAudioEngineJNI.setAudioCaptureDataListener(null);
        } else {
            weakReference = new WeakReference<f>(f10);
            TXCAudioEngineJNI.setAudioCaptureDataListener(weakReference);
        }
        return true;
    }

    public void setAudioDumpingListener(TXCAudioEngineJNI$a tXCAudioEngineJNI$a) {
        TXCAudioEngineJNI.SetAudioDumpingListener(tXCAudioEngineJNI$a);
    }

    public boolean setAudioEncoderParam(int n10, int n11) {
        TXCAudioEngineJNI.nativeSetAudioEncoderParam(n10, n11);
        return true;
    }

    public void setAudioQuality(int n10, int n11) {
        TXCAudioEngineJNI.nativeSetAudioQuality(n10, n11);
    }

    public void setCaptureDataCallbackFormat(int n10, int n11, int n12) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setCaptureDataCallbackFormat: sampleRate-");
        charSequence.append(n10);
        charSequence.append(" channels-");
        charSequence.append(n11);
        charSequence.append(" length-");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(n10, n11, n12);
    }

    public void setEncoderChannels(int n10) {
        TXCAudioEngineJNI.nativeSetEncoderChannels(n10);
    }

    public boolean setEncoderFECPercent(float f10) {
        TXCAudioEngineJNI.nativeSetEncoderFECPercent(f10);
        return true;
    }

    public void setEncoderSampleRate(int n10) {
        TXCAudioEngineJNI.nativeSetEncoderSampleRate(n10);
    }

    public void setLocalProcessedDataCallbackFormat(int n10, int n11, int n12) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setLocalProcessedDataCallbackFormat: sampleRate-");
        charSequence.append(n10);
        charSequence.append(" channels-");
        charSequence.append(n11);
        charSequence.append(" length-");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetLocalProcessedDataCallbackFormat(n10, n11, n12);
    }

    public void setMaxSelectedPlayStreams(int n10) {
        TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(n10);
    }

    public void setMixedAllDataListener(d d10) {
        TXCAudioEngineJNI.setMixedAllDataListener(d10);
    }

    public boolean setMixingPlayoutVolume(float f10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setPlayoutVolume: ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(f10);
        return true;
    }

    public void setPlayoutDataCallbackFormat(int n10, int n11, int n12) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setPlayoutDataCallbackFormat: sampleRate-");
        charSequence.append(n10);
        charSequence.append(" channels-");
        charSequence.append(n11);
        charSequence.append(" length-");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(n10, n11, n12);
    }

    public void setRemoteAudioCacheParams(String string2, boolean bl2, int n10, int n11, int n12) {
        TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(string2, bl2, n10, n11, n12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setRemoteAudioStreamEventListener(String string2, c c10) {
        if (string2 == null) {
            return;
        }
        Object object = mJitterEventListenerMapLock;
        synchronized (object) {
            HashMap hashMap = mJitterEventListenerMap;
            WeakReference<c> weakReference = new WeakReference<c>(c10);
            hashMap.put(string2, weakReference);
            return;
        }
    }

    public void setRemotePlayoutVolume(String string2, int n10) {
        if (string2 == null) {
            return;
        }
        TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(string2, n10);
    }

    public void setRemoteStreamDataCallbackFormat(String string2, int n10, int n11, int n12) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setRemoteStreamDataCallbackFormat: id-");
        charSequence.append(string2);
        charSequence.append(" sampleRate-");
        charSequence.append(n10);
        charSequence.append(" channels-");
        charSequence.append(n11);
        charSequence.append(" length-");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(string2, n10, n11, n12);
    }

    public boolean setReverbType(TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setReverbType: ");
        int n10 = tXAudioEffectManager$TXVoiceReverbType.getNativeValue();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetRecordReverb(tXAudioEffectManager$TXVoiceReverbType.getNativeValue());
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void setSetAudioEngineRemoteStreamDataListener(String string2, e e10) {
        boolean bl2;
        if (string2 == null) {
            return;
        }
        Object object = mJitterDataListenerMapLock;
        // MONITORENTER : object
        HashMap hashMap = mJitterDataListenerMap;
        WeakReference<e> weakReference = new WeakReference<e>(e10);
        hashMap.put(string2, weakReference);
        // MONITOREXIT : object
        if (e10 == null) {
            bl2 = false;
            e10 = null;
        } else {
            bl2 = true;
        }
        TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(string2, bl2);
    }

    public boolean setSoftwareCaptureVolume(float f10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setRecordVolume: ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(f10);
        return true;
    }

    public void setSystemAudioKitEnabled() {
        this.startSystemAudioKit();
    }

    public boolean setVoiceChangerType(TXAudioEffectManager$TXVoiceChangerType tXAudioEffectManager$TXVoiceChangerType) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setVoiceChangerType ");
        int n10 = tXAudioEffectManager$TXVoiceChangerType.getNativeValue();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(tXAudioEffectManager$TXVoiceChangerType.getNativeValue());
        return true;
    }

    public int startLocalAudio(int n10, boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("startLocalAudio audioFormat:");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        charSequence = mContext;
        if (charSequence == null) {
            TXCLog.i(string2, "Please call CreateInstance fisrt!!!");
            return -901;
        }
        TXCAudioEngineJNI.InitTraeEngineLibrary((Context)charSequence);
        TXCAudioEngineJNI.nativeStartLocalAudio(n10, bl2);
        this.mDeviceIsRecording = true;
        return 0;
    }

    public int startLocalAudioDumping(int n10, int n11, String string2) {
        return TXCAudioEngineJNI.nativeStartLocalAudioDumping(n10, n11, string2);
    }

    public void startRemoteAudio(String string2, boolean bl2) {
        TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, bl2, string2);
        com.tencent.liteav.basic.c.c c10 = com.tencent.liteav.basic.c.c.a();
        String string3 = "Audio";
        long l10 = c10.a(string3, "LIVE_JitterCycle");
        TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(string2, l10);
        long l11 = com.tencent.liteav.basic.c.c.a().a(string3, "LoadingThreshold");
        TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(string2, l11);
    }

    public int stopLocalAudio() {
        TXCLog.i(TAG, "stopLocalAudio");
        TXCAudioEngineJNI.nativeStopLocalAudio();
        this.mDeviceIsRecording = false;
        return 0;
    }

    public void stopLocalAudioDumping() {
        TXCAudioEngineJNI.nativeStopLocalAudioDumping();
    }

    public void stopRemoteAudio(String string2) {
        if (string2 == null) {
            return;
        }
        TXCAudioEngineJNI.nativeStopRemoteAudio(string2);
    }
}

