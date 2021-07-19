/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManager$AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceReverbType;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$1;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$2;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$3;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$4;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$5;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$AudioEffectManagerAutoCacheHolder;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$AudioEffectManagerCacheHolder;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl$AudioEffectManagerHolder;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TXAudioEffectManagerImpl
implements TXAudioEffectManager {
    private static final int EFFECT_PLAYER_ID_TYPE = 2;
    private static final int NEW_BGM_PLAYER_ID_TYPE = 1;
    private static final int OLD_BGM_PLAYER_ID_TYPE = 0;
    private static final String TAG = "AudioCenter:TXAudioEffectManager";
    private static final Handler mMainHandler;
    private static final HashMap mMusicObserverMap;
    private final int mIdType;
    private final List mPlayingMusicIDList;

    static {
        Handler handler;
        mMusicObserverMap = handler = new HashMap();
        Looper looper = Looper.getMainLooper();
        mMainHandler = handler = new Handler(looper);
        g.f();
        TXAudioEffectManagerImpl.nativeClassInit();
    }

    private TXAudioEffectManagerImpl(int n10) {
        ArrayList arrayList;
        this.mPlayingMusicIDList = arrayList = new ArrayList();
        this.mIdType = n10;
    }

    public /* synthetic */ TXAudioEffectManagerImpl(int n10, TXAudioEffectManagerImpl$1 tXAudioEffectManagerImpl$1) {
        this(n10);
    }

    public static /* synthetic */ int access$400(TXAudioEffectManagerImpl tXAudioEffectManagerImpl) {
        return tXAudioEffectManagerImpl.mIdType;
    }

    public static /* synthetic */ long access$500(int n10, int n11) {
        return TXAudioEffectManagerImpl.convertIdToInt64(n10, n11);
    }

    public static /* synthetic */ HashMap access$600() {
        return mMusicObserverMap;
    }

    private static long convertIdToInt64(int n10, int n11) {
        long l10 = (long)n10 << 32;
        return (long)n11 | l10;
    }

    public static TXAudioEffectManagerImpl getAutoCacheHolder() {
        return TXAudioEffectManagerImpl$AudioEffectManagerAutoCacheHolder.access$300();
    }

    public static TXAudioEffectManagerImpl getCacheInstance() {
        return TXAudioEffectManagerImpl$AudioEffectManagerCacheHolder.access$200();
    }

    public static TXAudioEffectManagerImpl getInstance() {
        return TXAudioEffectManagerImpl$AudioEffectManagerHolder.access$100();
    }

    private static native void nativeClassInit();

    private native long nativeGetAvailableBGMBytes(long var1);

    private native long nativeGetCurrentPositionInMs(long var1);

    private static native long nativeGetDurationMSByPath(String var0);

    private native void nativePause(long var1);

    private native void nativeResume(long var1);

    private native void nativeSeekToPosition(long var1, long var3);

    private native void nativeSeekToTime(long var1, int var3);

    private native void nativeSetAllVolume(int var1);

    private native void nativeSetChangerType(long var1, int var3);

    private native void nativeSetMuteDataDurationToPublish(long var1, int var3);

    private native void nativeSetPitch(long var1, float var3);

    private native void nativeSetPlayoutSpeedRate(long var1, float var3);

    private native void nativeSetPlayoutVolume(long var1, int var3);

    private native void nativeSetPublishVolume(long var1, int var3);

    private native void nativeSetReverbType(long var1, int var3);

    private native void nativeSetSpeedRate(long var1, float var3);

    private native void nativeSetVolume(long var1, int var3);

    private native boolean nativeStartPlay(long var1, String var3, int var4, boolean var5, boolean var6);

    private native void nativeStartPlayRange(long var1, long var3, long var5);

    private native void nativeStopPlay(long var1);

    public static void onEffectFinish(long l10, int n10) {
        Handler handler = mMainHandler;
        TXAudioEffectManagerImpl$3 tXAudioEffectManagerImpl$3 = new TXAudioEffectManagerImpl$3(l10, n10);
        handler.post((Runnable)tXAudioEffectManagerImpl$3);
    }

    public static void onEffectProgress(long l10, long l11, long l12) {
        Handler handler = mMainHandler;
        TXAudioEffectManagerImpl$5 tXAudioEffectManagerImpl$5 = new TXAudioEffectManagerImpl$5(l10, l11, l12);
        handler.post((Runnable)tXAudioEffectManagerImpl$5);
    }

    public static void onEffectStart(long l10, int n10) {
        Handler handler = mMainHandler;
        TXAudioEffectManagerImpl$4 tXAudioEffectManagerImpl$4 = new TXAudioEffectManagerImpl$4(l10, n10);
        handler.post((Runnable)tXAudioEffectManagerImpl$4);
    }

    public void enableVoiceEarMonitor(boolean bl2) {
        TXCAudioEngine.enableAudioEarMonitoring(bl2);
    }

    public long getAvailableBGMBytes(int n10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        return this.nativeGetAvailableBGMBytes(l10);
    }

    public long getMusicCurrentPosInMS(int n10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        return this.nativeGetCurrentPositionInMs(l10);
    }

    public long getMusicDurationInMS(String string2) {
        return TXAudioEffectManagerImpl.nativeGetDurationMSByPath(string2);
    }

    public void interruptAllMusics() {
        boolean bl2;
        Object object = "interruptAllMusics";
        TXCLog.i("AudioCenter:TXAudioEffectManager", (String)object);
        Iterator iterator2 = this.mPlayingMusicIDList.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Long)iterator2.next();
            long l10 = (Long)object;
            this.nativePause(l10);
        }
    }

    public void pausePlayMusic(int n10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        List list = this.mPlayingMusicIDList;
        Long l11 = l10;
        list.remove(l11);
        this.nativePause(l10);
    }

    public void recoverAllMusics() {
        boolean bl2;
        Object object = "recoverAllMusics";
        TXCLog.i("AudioCenter:TXAudioEffectManager", (String)object);
        Iterator iterator2 = this.mPlayingMusicIDList.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Long)iterator2.next();
            long l10 = (Long)object;
            this.nativeResume(l10);
        }
    }

    public void resumePlayMusic(int n10) {
        List list = this.mPlayingMusicIDList;
        int n11 = this.mIdType;
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(n11, n10);
        Long l11 = l10;
        if ((n10 = (int)(list.contains(l11) ? 1 : 0)) == 0) {
            list = this.mPlayingMusicIDList;
            l11 = l10;
            list.add(l11);
        }
        this.nativeResume(l10);
    }

    public void seekMusicToPosInBytes(int n10, long l10) {
        long l11 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSeekToPosition(l11, l10);
    }

    public void seekMusicToPosInMS(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSeekToTime(l10, n11);
    }

    public void setAllMusicVolume(int n10) {
        this.nativeSetAllVolume(n10);
    }

    public void setAudioPlayoutVolume(int n10) {
        float f10 = (float)n10 / 100.0f;
        TXCAudioEngine.getInstance().setMixingPlayoutVolume(f10);
    }

    public void setMusicChangerType(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetChangerType(l10, n11);
    }

    public void setMusicObserver(int n10, TXAudioEffectManager$TXMusicPlayObserver tXAudioEffectManager$TXMusicPlayObserver) {
        Looper looper;
        TXAudioEffectManagerImpl$1 tXAudioEffectManagerImpl$1 = new TXAudioEffectManagerImpl$1(this, tXAudioEffectManager$TXMusicPlayObserver, n10);
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = (tXAudioEffectManager$TXMusicPlayObserver = mMainHandler).getLooper())) {
            tXAudioEffectManagerImpl$1.run();
        } else {
            tXAudioEffectManager$TXMusicPlayObserver.post(tXAudioEffectManagerImpl$1);
        }
    }

    public void setMusicPitch(int n10, float f10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetPitch(l10, f10);
    }

    public void setMusicPlayoutSpeedRate(int n10, float f10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetPlayoutSpeedRate(l10, f10);
    }

    public void setMusicPlayoutVolume(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetPlayoutVolume(l10, n11);
    }

    public void setMusicPublishVolume(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetPublishVolume(l10, n11);
    }

    public void setMusicReverbType(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetReverbType(l10, n11);
    }

    public void setMusicSpeedRate(int n10, float f10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetSpeedRate(l10, f10);
    }

    public void setMusicVolume(int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setMusicVolume ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.i("AudioCenter:TXAudioEffectManager", (String)charSequence);
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetVolume(l10, n11);
    }

    public void setMuteDataDurationToPublish(int n10, int n11) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        this.nativeSetMuteDataDurationToPublish(l10, n11);
    }

    public void setVoiceCaptureVolume(int n10) {
        float f10 = (float)n10 / 100.0f;
        TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f10);
    }

    public void setVoiceChangerType(TXAudioEffectManager$TXVoiceChangerType tXAudioEffectManager$TXVoiceChangerType) {
        TXCAudioEngine.getInstance().setVoiceChangerType(tXAudioEffectManager$TXVoiceChangerType);
    }

    public void setVoiceEarMonitorVolume(int n10) {
        TXCAudioEngine.setAudioEarMonitoringVolume(n10);
    }

    public void setVoiceReverbType(TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType) {
        TXCAudioEngine.getInstance().setReverbType(tXAudioEffectManager$TXVoiceReverbType);
    }

    public boolean startPlayMusic(TXAudioEffectManager$AudioMusicParam tXAudioEffectManager$AudioMusicParam) {
        Object object = "AudioCenter:TXAudioEffectManager";
        Object object2 = "startPlay";
        TXCLog.i((String)object, (String)object2);
        long l10 = tXAudioEffectManager$AudioMusicParam.startTimeMS;
        long l11 = tXAudioEffectManager$AudioMusicParam.endTimeMS;
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        long l14 = l13 < 0 ? l12 : l10;
        long l15 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        long l16 = l15 < 0 ? l12 : l11;
        l15 = this.mIdType;
        int n10 = tXAudioEffectManager$AudioMusicParam.id;
        long l17 = TXAudioEffectManagerImpl.convertIdToInt64((int)l15, n10);
        object = this.mPlayingMusicIDList;
        object2 = l17;
        l15 = (long)object.contains(object2);
        if (l15 == false) {
            object = this.mPlayingMusicIDList;
            object2 = l17;
            object.add(object2);
        }
        this.nativeStartPlayRange(l17, l14, l16);
        String string2 = tXAudioEffectManager$AudioMusicParam.path;
        l13 = tXAudioEffectManager$AudioMusicParam.loopCount;
        boolean bl2 = tXAudioEffectManager$AudioMusicParam.publish;
        boolean bl3 = tXAudioEffectManager$AudioMusicParam.isShortFile;
        return this.nativeStartPlay(l17, string2, (int)l13, bl2, bl3);
    }

    public void stopAllMusics() {
        boolean bl2;
        Object object = "stopAllMusics";
        TXCLog.i("AudioCenter:TXAudioEffectManager", (String)object);
        Iterator iterator2 = this.mPlayingMusicIDList.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (Long)iterator2.next();
            long l10 = (Long)object;
            this.nativeStopPlay(l10);
            Handler handler = mMainHandler;
            TXAudioEffectManagerImpl$2 tXAudioEffectManagerImpl$2 = new TXAudioEffectManagerImpl$2(this, l10);
            handler.post((Runnable)tXAudioEffectManagerImpl$2);
        }
        this.mPlayingMusicIDList.clear();
    }

    public void stopPlayMusic(int n10) {
        long l10 = TXAudioEffectManagerImpl.convertIdToInt64(this.mIdType, n10);
        List list = this.mPlayingMusicIDList;
        Long l11 = l10;
        list.remove(l11);
        this.nativeStopPlay(l10);
    }
}

