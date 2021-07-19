/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.media.AudioManager
 */
package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI$a;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI {
    private static final String TAG = "TXCAudioEngineJNI";
    private static WeakReference mAudioCaptureDataListener;
    private static TXCAudioEngineJNI$a mAudioDumpingListener;
    private static WeakReference mMixedAllDataListener;
    private static AudioManager sAudioManager;

    static {
        WeakReference<Object> weakReference;
        g.f();
        TXCAudioEngineJNI.nativeCacheClassForNative();
        mAudioDumpingListener = null;
        mAudioCaptureDataListener = null;
        mMixedAllDataListener = weakReference = new WeakReference<Object>(null);
    }

    public static void InitTraeEngineLibrary(Context object) {
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String string2;
        String string3;
        String string4;
        block31: {
            string4 = "/lib";
            string3 = "add_libpath:";
            string2 = TAG;
            if (object == null) {
                TXCLog.e(string2, "InitTraeEngineLibrary failed, context is null!");
                return;
            }
            object = object.getApplicationInfo();
            charSequence3 = ((ApplicationInfo)object).nativeLibraryDir;
            charSequence2 = new StringBuilder();
            charSequence = ((ApplicationInfo)object).dataDir;
            charSequence2.append((String)charSequence);
            charSequence2.append(string4);
            charSequence2 = charSequence2.toString();
            charSequence = new StringBuilder();
            String string5 = "/data/data/";
            ((StringBuilder)charSequence).append(string5);
            object = ((ApplicationInfo)object).packageName;
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string4);
            object = ((StringBuilder)charSequence).toString();
            string4 = g.g();
            if (string4 != null) break block31;
            string4 = "";
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)charSequence3);
        charSequence3 = ((StringBuilder)charSequence).toString();
        TXCAudioEngineJNI.nativeAppendLibraryPath((String)charSequence3);
        charSequence3 = new StringBuilder();
        ((StringBuilder)charSequence3).append(string3);
        ((StringBuilder)charSequence3).append((String)charSequence2);
        charSequence3 = ((StringBuilder)charSequence3).toString();
        TXCAudioEngineJNI.nativeAppendLibraryPath((String)charSequence3);
        charSequence3 = new StringBuilder();
        ((StringBuilder)charSequence3).append(string3);
        ((StringBuilder)charSequence3).append((String)object);
        object = ((StringBuilder)charSequence3).toString();
        TXCAudioEngineJNI.nativeAppendLibraryPath((String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string4);
        object = ((StringBuilder)object).toString();
        try {
            TXCAudioEngineJNI.nativeAppendLibraryPath((String)object);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            string4 = "init trae engine library failed.";
            TXCLog.e(string2, string4, unsatisfiedLinkError);
        }
    }

    public static void SetAudioDumpingListener(TXCAudioEngineJNI$a tXCAudioEngineJNI$a) {
        mAudioDumpingListener = tXCAudioEngineJNI$a;
    }

    private static AudioManager getAudioManager() {
        AudioManager audioManager = sAudioManager;
        if (audioManager == null) {
            audioManager = TXCAudioEngine.getInstance().getAppContext();
            String string2 = "audio";
            sAudioManager = audioManager = (AudioManager)audioManager.getSystemService(string2);
        }
        return sAudioManager;
    }

    public static int getAudioMode() {
        block3: {
            AudioManager audioManager;
            try {
                audioManager = TXCAudioEngineJNI.getAudioManager();
                if (audioManager == null) break block3;
            }
            catch (Exception exception) {}
            return audioManager.getMode();
        }
        return -1;
    }

    public static StatusBucket getStatus(int n10) {
        return TXCAudioEngineJNI.nativeGetStatus(n10);
    }

    public static int getSystemVolume() {
        block4: {
            int n10;
            try {
                n10 = TXCAudioEngineJNI.getAudioMode();
                n10 = n10 == 0 ? 3 : 0;
            }
            catch (Exception exception) {}
            AudioManager audioManager = TXCAudioEngineJNI.getAudioManager();
            if (audioManager == null) break block4;
            return audioManager.getStreamVolume(n10);
        }
        return -1;
    }

    public static boolean isAppInBackground() {
        return g.a(TXCAudioEngine.getInstance().getAppContext());
    }

    public static native void nativeAppendLibraryPath(String var0);

    public static native void nativeCacheClassForNative();

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean nativeCheckTraeEngine(Context var0) {
        block6: {
            var1_1 = "TXCAudioEngineJNI";
            if (var0 == null) {
                TXCLog.e(var1_1, "nativeCheckTraeEngine failed, context is null!");
                return false;
            }
            var2_2 = "traeimp-rtmp";
            var3_3 = g.a((String)var2_2);
            var4_4 = true;
            if (var3_3) {
                TXCLog.e(var1_1, "link traeimp-rtmp success !");
                return var4_4;
            }
            var0 = var0.getApplicationInfo();
            var2_2 = var0.nativeLibraryDir;
            var5_5 = new StringBuilder();
            var6_6 = var0.dataDir;
            var5_5.append(var6_6);
            var6_6 = "/lib";
            var5_5.append(var6_6);
            var5_5 = var5_5.toString();
            var7_7 /* !! */  = new StringBuilder();
            var8_8 = "/data/data/";
            var7_7 /* !! */ .append((String)var8_8);
            var0 = var0.packageName;
            var7_7 /* !! */ .append((String)var0);
            var7_7 /* !! */ .append(var6_6);
            var0 = var7_7 /* !! */ .toString();
            var6_6 = g.g();
            if (var6_6 == null) {
                var6_6 = "";
            }
            var7_7 /* !! */  = "/libtraeimp-rtmp.so";
            var9_9 /* !! */  = new StringBuilder();
            var9_9 /* !! */ .append((String)var2_2);
            var9_9 /* !! */ .append((String)var7_7 /* !! */ );
            var9_9 /* !! */  = var9_9 /* !! */ .toString();
            var8_8 = new File((String)var9_9 /* !! */ );
            var10_10 = var8_8.exists();
            if (var10_10) lbl-1000:
            // 4 sources

            {
                while (true) {
                    var11_11 = var4_4;
                    break block6;
                    break;
                }
            }
            var8_8 = new StringBuilder();
            var9_9 /* !! */  = "nativeCheckTraeEngine load so error ";
            var8_8.append((String)var9_9 /* !! */ );
            var8_8.append((String)var2_2);
            var8_8.append((String)var7_7 /* !! */ );
            var2_2 = var8_8.toString();
            TXCLog.w(var1_1, (String)var2_2);
            var8_8 = new StringBuilder();
            var8_8.append((String)var5_5);
            var8_8.append((String)var7_7 /* !! */ );
            var8_8 = var8_8.toString();
            var2_2 = new File((String)var8_8);
            var3_3 = var2_2.exists();
            if (var3_3) ** GOTO lbl-1000
            var2_2 = new StringBuilder();
            var2_2.append((String)var9_9 /* !! */ );
            var2_2.append((String)var5_5);
            var2_2.append((String)var7_7 /* !! */ );
            var2_2 = var2_2.toString();
            TXCLog.w(var1_1, (String)var2_2);
            var5_5 = new StringBuilder();
            var5_5.append((String)var0);
            var5_5.append((String)var7_7 /* !! */ );
            var5_5 = var5_5.toString();
            var2_2 = new File((String)var5_5);
            var3_3 = var2_2.exists();
            if (var3_3) ** GOTO lbl-1000
            var2_2 = new StringBuilder();
            var2_2.append((String)var9_9 /* !! */ );
            var2_2.append((String)var0);
            var2_2.append((String)var7_7 /* !! */ );
            var0 = var2_2.toString();
            TXCLog.w(var1_1, (String)var0);
            var2_2 = new StringBuilder();
            var2_2.append(var6_6);
            var2_2.append((String)var7_7 /* !! */ );
            var2_2 = var2_2.toString();
            var0 = new File((String)var2_2);
            var11_11 = var0.exists();
            if (!var11_11) ** break;
            ** while (true)
            var0 = new StringBuilder();
            var0.append((String)var9_9 /* !! */ );
            var0.append(var6_6);
            var0.append((String)var7_7 /* !! */ );
            var0 = var0.toString();
            TXCLog.w(var1_1, (String)var0);
            var11_11 = false;
            var0 = null;
        }
        if (var11_11) {
            return var4_4;
        }
        TXCLog.e(var1_1, "nativeCheckTraeEngine failed, can not find trae libs !");
        return false;
    }

    public static native void nativeClean();

    public static native void nativeDeleteAudioSessionDuplicate();

    public static native void nativeEnableAudioEarMonitoring(boolean var0);

    public static native void nativeEnableAudioVolumeEvaluation(boolean var0, int var1);

    public static native void nativeEnableAutoRestartDevice(boolean var0);

    public static native void nativeEnableCaptureEOSMode(boolean var0);

    public static native void nativeEnableEncodedDataCallback(boolean var0);

    public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean var0);

    public static native void nativeEnableInbandFEC(boolean var0);

    public static native void nativeEnableMixMode(boolean var0);

    public static native void nativeForceCallbackMixedPlayAudioFrame(boolean var0);

    public static native int nativeGetEncoderChannels();

    public static native TXCAudioEncoderConfig nativeGetEncoderConfig();

    public static native int nativeGetEncoderSampleRate();

    public static native int nativeGetMixingPlayoutVolumeLevel();

    public static native int nativeGetRemotePlayoutVolumeLevel(String var0);

    public static native int nativeGetSoftwareCaptureVolumeLevel();

    public static native StatusBucket nativeGetStatus(int var0);

    public static native void nativeInitAudioDevice();

    public static native void nativeInitBeforeEngineCreate(Context var0);

    public static native boolean nativeIsAudioDeviceCapturing();

    public static native boolean nativeIsAudioDevicePlaying();

    public static native boolean nativeIsDataCallbackFormatInvalid(int var0, int var1, int var2);

    public static native boolean nativeIsRemoteAudioPlaying(String var0);

    public static native void nativeMuteLocalAudio(boolean var0);

    public static native void nativeMuteRemoteAudio(String var0, boolean var1);

    public static native void nativeMuteRemoteAudioInSpeaker(String var0, boolean var1);

    public static native void nativeNewAudioSessionDuplicate(Context var0);

    public static native void nativeNotifySystemEarMonitoringInitializing();

    public static native void nativePauseAudioCapture(boolean var0);

    public static native void nativePauseLocalAudio();

    public static native void nativeResumeAudioCapture();

    public static native void nativeResumeLocalAudio();

    public static native void nativeSendCustomPCMData(byte[] var0, int var1, long var2, int var4, int var5);

    public static native void nativeSetAudioEarMonitoringVolume(int var0);

    public static native void nativeSetAudioEncoderParam(int var0, int var1);

    public static native void nativeSetAudioEngineCaptureDataCallback(boolean var0);

    public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean var0);

    public static native void nativeSetAudioEngineEncodedDataCallback(boolean var0);

    public static native void nativeSetAudioEngineMixedAllDataCallback(boolean var0);

    public static native void nativeSetAudioEngineRemoteStreamDataListener(String var0, boolean var1);

    public static native void nativeSetAudioPlayoutTunnelEnabled(boolean var0);

    public static native void nativeSetAudioQuality(int var0, int var1);

    public static native void nativeSetAudioRoute(int var0);

    public static native void nativeSetCaptureDataCallbackFormat(int var0, int var1, int var2);

    public static native void nativeSetCaptureVoiceChanger(int var0);

    public static native void nativeSetEncoderChannels(int var0);

    public static native void nativeSetEncoderFECPercent(float var0);

    public static native void nativeSetEncoderSampleRate(int var0);

    public static native void nativeSetEventCallbackEnabled(boolean var0);

    public static native void nativeSetLocalProcessedDataCallbackFormat(int var0, int var1, int var2);

    public static native void nativeSetMaxSelectedPlayStreams(int var0);

    public static native void nativeSetMixingPlayoutVolume(float var0);

    public static native void nativeSetPlayoutDataCallbackFormat(int var0, int var1, int var2);

    public static native void nativeSetPlayoutDataListener(boolean var0);

    public static native void nativeSetPlayoutDevice(int var0);

    public static native void nativeSetRecordReverb(int var0);

    public static native void nativeSetRemoteAudioBlockThreshold(String var0, long var1);

    public static native void nativeSetRemoteAudioCacheParams(String var0, boolean var1, int var2, int var3, int var4);

    public static native void nativeSetRemoteAudioJitterCycle(String var0, long var1);

    public static native void nativeSetRemotePlayoutVolume(String var0, int var1);

    public static native void nativeSetRemoteStreamDataCallbackFormat(String var0, int var1, int var2, int var3);

    public static native void nativeSetSoftAEC(int var0);

    public static native void nativeSetSoftAGC(int var0);

    public static native void nativeSetSoftANS(int var0);

    public static native void nativeSetSoftwareCaptureVolume(float var0);

    public static native void nativeSetSystemEarMonitoring(TXSystemAudioKit var0);

    public static native void nativeSetSystemVolumeType(int var0);

    public static native void nativeSetTRAEConfig(String var0);

    public static native void nativeStartLocalAudio(int var0, boolean var1);

    public static native int nativeStartLocalAudioDumping(int var0, int var1, String var2);

    public static native String nativeStartRemoteAudio(TXCAudioEngine var0, boolean var1, String var2);

    public static native void nativeStopLocalAudio();

    public static native void nativeStopLocalAudioDumping();

    public static native void nativeStopRemoteAudio(String var0);

    public static native void nativeUseSysAudioDevice(boolean var0);

    public static void onError(String string2, int n10, String string3, String string4) {
        TXCAudioEngine.getInstance().onError(string2, n10, string3, string4);
    }

    public static void onEvent(String string2, int n10, String string3, String string4) {
        TXCAudioEngine.getInstance().onEvent(string2, n10, string3, string4);
    }

    public static void onLocalAudioWriteFail() {
        TXCAudioEngineJNI$a tXCAudioEngineJNI$a = mAudioDumpingListener;
        if (tXCAudioEngineJNI$a != null) {
            tXCAudioEngineJNI$a.a();
        }
    }

    public static void onMixedAllData(byte[] byArray, int n10, int n11) {
        d d10 = (d)mMixedAllDataListener.get();
        if (d10 != null) {
            d10.a(byArray, n10, n11);
        }
    }

    public static void onRecordEncData(byte[] byArray, long l10, int n10, int n11) {
        WeakReference weakReference = mAudioCaptureDataListener;
        if (weakReference != null && (weakReference = weakReference.get()) != null) {
            weakReference = mAudioCaptureDataListener.get();
            Object object = weakReference;
            object = (f)((Object)weakReference);
            int n12 = 16;
            object.b(byArray, l10, n10, n11, n12);
        }
    }

    public static void onRecordError(int n10, String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onRecordError: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "TXCAudioEngineJNI";
        TXCLog.e(string3, (String)object);
        object = mAudioCaptureDataListener;
        if (object != null && (object = ((Reference)object).get()) != null) {
            object = (f)mAudioCaptureDataListener.get();
            object.a(n10, string2);
        }
    }

    public static void onRecordPcmData(byte[] byArray, long l10, int n10, int n11, int n12) {
        WeakReference weakReference = mAudioCaptureDataListener;
        if (weakReference != null && (weakReference = weakReference.get()) != null) {
            weakReference = mAudioCaptureDataListener.get();
            Object object = weakReference;
            object = (f)((Object)weakReference);
            object.a(byArray, l10, n10, n11, n12);
        }
    }

    public static void onRecordRawPcmData(byte[] byArray, long l10, int n10, int n11, int n12) {
        WeakReference weakReference = mAudioCaptureDataListener;
        if (weakReference != null && (weakReference = weakReference.get()) != null) {
            weakReference = mAudioCaptureDataListener.get();
            Object object = weakReference;
            object = (f)((Object)weakReference);
            object.a(byArray, l10, n10, n11, n12, false);
        }
    }

    public static void onWarning(String string2, int n10, String string3, String string4) {
        TXCAudioEngine.getInstance().onWarning(string2, n10, string3, string4);
    }

    public static void pauseAudioCapture(boolean bl2) {
        TXCAudioEngineJNI.nativePauseAudioCapture(bl2);
    }

    public static void resumeAudioCapture() {
        TXCAudioEngineJNI.nativeResumeAudioCapture();
    }

    public static void sendCustomPCMData(a a10) {
        byte[] byArray = a10.f;
        int n10 = byArray.length;
        long l10 = a10.e;
        int n11 = a10.a;
        int n12 = a10.b;
        TXCAudioEngineJNI.nativeSendCustomPCMData(byArray, n10, l10, n11, n12);
    }

    public static void sendCustomPCMData(byte[] byArray, int n10, int n11) {
        int n12 = byArray.length;
        TXCAudioEngineJNI.nativeSendCustomPCMData(byArray, n12, 0L, n10, n11);
    }

    public static void setAudioCaptureDataListener(WeakReference weakReference) {
        boolean bl2;
        mAudioCaptureDataListener = weakReference;
        boolean bl3 = false;
        boolean bl4 = true;
        if (weakReference == null) {
            bl2 = false;
            weakReference = null;
        } else {
            bl2 = bl4;
        }
        TXCAudioEngineJNI.nativeSetAudioEngineCaptureDataCallback(bl2);
        weakReference = mAudioCaptureDataListener;
        if (weakReference == null) {
            bl2 = false;
            weakReference = null;
        } else {
            bl2 = bl4;
        }
        TXCAudioEngineJNI.nativeSetAudioEngineCaptureRawDataCallback(bl2);
        weakReference = mAudioCaptureDataListener;
        if (weakReference != null) {
            bl3 = bl4;
        }
        TXCAudioEngineJNI.nativeSetAudioEngineEncodedDataCallback(bl3);
    }

    public static void setMixedAllDataListener(d d10) {
        boolean bl2;
        WeakReference<d> weakReference;
        mMixedAllDataListener = weakReference = new WeakReference<d>(d10);
        if (d10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            d10 = null;
        }
        TXCAudioEngineJNI.nativeSetAudioEngineMixedAllDataCallback(bl2);
    }
}

