/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager$AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCUGCBGMPlayer$1;
import com.tencent.liteav.audio.TXCUGCBGMPlayer$a;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer
implements TXAudioEffectManager$TXMusicPlayObserver {
    private static final int PLAY_ERR_OPEN = 255;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
    private int mBGMId;
    private long mEndTimeMS;
    private boolean mIsRunning = false;
    private long mSeekBytes;
    private float mSpeedRate;
    private long mStartTimeMS;
    private float mVolume;
    private WeakReference mWeakListener = null;

    static {
        com.tencent.liteav.basic.util.g.f();
    }

    private TXCUGCBGMPlayer() {
        long l10;
        float f10;
        this.mVolume = f10 = 1.0f;
        this.mSpeedRate = f10;
        this.mStartTimeMS = l10 = 0L;
        this.mEndTimeMS = l10;
        this.mSeekBytes = l10;
        this.mBGMId = -1 << -1;
        TXCMultAudioTrackPlayer.getInstance();
    }

    public /* synthetic */ TXCUGCBGMPlayer(TXCUGCBGMPlayer$1 tXCUGCBGMPlayer$1) {
        this();
    }

    public static TXCUGCBGMPlayer getInstance() {
        return TXCUGCBGMPlayer$a.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPlayEnd(int n10) {
        Object object;
        synchronized (this) {
            object = this.mWeakListener;
            if (object == null) return;
            object = ((Reference)object).get();
            object = (g)object;
        }
        if (object == null) return;
        object.a(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPlayProgress(long l10, long l11) {
        Object object;
        synchronized (this) {
            object = this.mWeakListener;
            if (object == null) return;
            object = ((Reference)object).get();
            object = (g)object;
        }
        if (object == null) return;
        object.a(l10, l11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPlayStart() {
        Object object;
        synchronized (this) {
            object = this.mWeakListener;
            if (object == null) return;
            object = ((Reference)object).get();
            object = (g)object;
        }
        if (object == null) return;
        object.a();
    }

    public long getDurationMS(String string2) {
        return TXAudioEffectManagerImpl.getCacheInstance().getMusicDurationInMS(string2);
    }

    public void onComplete(int n10, int n11) {
        this.onPlayEnd(n11);
    }

    public void onPlayProgress(int n10, long l10, long l11) {
        this.onPlayProgress(l10, l11);
    }

    public void onStart(int n10, int n11) {
        this.onPlayStart();
    }

    public void pause() {
        TXCLog.i(TAG, "pause");
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.pausePlayMusic(n10);
    }

    public void playFromTime(long l10, long l11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("startPlayRange:");
        charSequence.append(l10);
        charSequence.append(", ");
        charSequence.append(l11);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        this.mStartTimeMS = l10;
        this.mEndTimeMS = l11;
    }

    public void resume() {
        TXCLog.i(TAG, "resume");
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.resumePlayMusic(n10);
    }

    public void seekBytes(long l10) {
        int n10;
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl;
        long l11;
        long l12;
        long l13;
        long l14 = 0L;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        String string2 = TAG;
        if (l15 < 0) {
            String string3 = "seek bytes can not be negative. change to 0";
            TXCLog.e(string2, string3);
            l10 = l14;
        }
        if ((l13 = (l12 = (l11 = (tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance()).getAvailableBGMBytes(n10 = this.mBGMId)) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            l10 %= l11;
        }
        this.mSeekBytes = l10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("mSeekBytes:");
        long l16 = this.mSeekBytes;
        ((StringBuilder)object).append(l16);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string2, (String)object);
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n11 = this.mBGMId;
        ((TXAudioEffectManagerImpl)object).seekMusicToPosInBytes(n11, l10);
    }

    public void setChangerType(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("changerType:");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n11 = this.mBGMId;
        ((TXAudioEffectManagerImpl)object).setMusicChangerType(n11, n10);
    }

    public void setOnPlayListener(g g10) {
        synchronized (this) {
            WeakReference<g> weakReference;
            if (g10 == null) {
                weakReference = null;
                this.mWeakListener = null;
            }
            weakReference = new WeakReference<g>(g10);
            this.mWeakListener = weakReference;
            return;
        }
    }

    public void setReverbType(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("int reverbType:");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n11 = this.mBGMId;
        ((TXAudioEffectManagerImpl)object).setMusicReverbType(n11, n10);
    }

    public void setSpeedRate(float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setSpeedRate:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        this.mSpeedRate = f10;
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n10 = this.mBGMId;
        ((TXAudioEffectManagerImpl)object).setMusicPlayoutSpeedRate(n10, f10);
    }

    public void setVolume(float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setVolume:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        this.mVolume = f10;
        object = TXAudioEffectManagerImpl.getCacheInstance();
        int n10 = this.mBGMId;
        int n11 = (int)(f10 * 100.0f);
        ((TXAudioEffectManagerImpl)object).setMusicVolume(n10, n11);
    }

    public void startPlay(String object, boolean bl2) {
        int n10;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("startPlay:");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("record:");
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        if (object != null && (n10 = ((String)object).isEmpty()) == 0) {
            long l10;
            long l11;
            n10 = this.mIsRunning;
            if (n10 != 0) {
                charSequence = "BGM is playing, restarting...";
                TXCLog.w(string2, (String)charSequence);
                this.stopPlay();
            }
            this.mSeekBytes = l11 = 0L;
            this.mIsRunning = n10 = 1;
            int n11 = this.mBGMId;
            TXAudioEffectManager$AudioMusicParam tXAudioEffectManager$AudioMusicParam = new TXAudioEffectManager$AudioMusicParam(n11, (String)object);
            tXAudioEffectManager$AudioMusicParam.publish = bl2;
            tXAudioEffectManager$AudioMusicParam.loopCount = 0;
            tXAudioEffectManager$AudioMusicParam.startTimeMS = l10 = this.mStartTimeMS;
            tXAudioEffectManager$AudioMusicParam.endTimeMS = l10 = this.mEndTimeMS;
            tXAudioEffectManager$AudioMusicParam.isShortFile = n10;
            charSequence = new StringBuilder();
            String string3 = "start bgm play : filePath = ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" publish:");
            ((StringBuilder)charSequence).append(bl2);
            ((StringBuilder)charSequence).append(" startTimeMS:");
            l10 = this.mStartTimeMS;
            ((StringBuilder)charSequence).append(l10);
            ((StringBuilder)charSequence).append(" endTimeMS:");
            l10 = this.mEndTimeMS;
            ((StringBuilder)charSequence).append(l10);
            ((StringBuilder)charSequence).append(" isShortFile:");
            boolean bl3 = tXAudioEffectManager$AudioMusicParam.isShortFile;
            ((StringBuilder)charSequence).append(bl3);
            ((StringBuilder)charSequence).append("mVolume:");
            float f10 = this.mVolume;
            ((StringBuilder)charSequence).append(f10);
            object = ((StringBuilder)charSequence).toString();
            TXCLog.i(string2, (String)object);
            object = TXAudioEffectManagerImpl.getCacheInstance();
            n10 = this.mBGMId;
            float f11 = this.mVolume;
            n11 = 1120403456;
            float f12 = 100.0f;
            int n12 = (int)(f11 * f12);
            ((TXAudioEffectManagerImpl)object).setMusicVolume(n10, n12);
            object = TXAudioEffectManagerImpl.getCacheInstance();
            n10 = this.mBGMId;
            f11 = this.mSpeedRate;
            ((TXAudioEffectManagerImpl)object).setMusicPlayoutSpeedRate(n10, f11);
            if (bl2) {
                object = TXAudioEffectManagerImpl.getCacheInstance();
                int n13 = this.mBGMId;
                n10 = 200;
                ((TXAudioEffectManagerImpl)object).setMuteDataDurationToPublish(n13, n10);
            }
            object = TXAudioEffectManagerImpl.getCacheInstance();
            bl3 = ((TXAudioEffectManagerImpl)object).startPlayMusic(tXAudioEffectManager$AudioMusicParam);
            TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
            n10 = this.mBGMId;
            tXAudioEffectManagerImpl.setMusicObserver(n10, this);
            if (!bl3) {
                this.onPlayEnd(-1);
                return;
            }
            this.onPlayStart();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopPlay() {
        String string2 = "stopPlay";
        TXCLog.i(TAG, string2);
        String string3 = null;
        this.mIsRunning = false;
        long l10 = System.currentTimeMillis();
        synchronized (this) {
            TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
            int n10 = this.mBGMId;
            tXAudioEffectManagerImpl.setMusicObserver(n10, null);
            tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getCacheInstance();
            n10 = this.mBGMId;
            tXAudioEffectManagerImpl.stopPlayMusic(n10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stopBGMPlay cost(MS): ");
        long l11 = System.currentTimeMillis() - l10;
        stringBuilder.append(l11);
        string3 = stringBuilder.toString();
        TXCLog.i(TAG, string3);
    }
}

