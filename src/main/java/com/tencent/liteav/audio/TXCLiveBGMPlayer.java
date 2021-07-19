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
import com.tencent.liteav.audio.TXAudioEffectManager$AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXCLiveBGMPlayer$1;
import com.tencent.liteav.audio.TXCLiveBGMPlayer$2;
import com.tencent.liteav.audio.TXCLiveBGMPlayer$3;
import com.tencent.liteav.audio.TXCLiveBGMPlayer$a;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
implements TXAudioEffectManager$TXMusicPlayObserver {
    private static final int PLAY_ERR_OPEN = 255;
    private static final int PLAY_SUCCESS = 0;
    private static final String TAG = "AudioCenter:TXCLiveBGMPlayer";
    private int mBGMId = -1 >>> 1;
    private final Handler mHandler;
    private boolean mIsPause = false;
    private boolean mIsRunning = false;
    private WeakReference mWeakListener = null;

    static {
        com.tencent.liteav.basic.util.g.f();
    }

    private TXCLiveBGMPlayer() {
        Handler handler;
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
    }

    public /* synthetic */ TXCLiveBGMPlayer(TXCLiveBGMPlayer$1 tXCLiveBGMPlayer$1) {
        this();
    }

    public static TXCLiveBGMPlayer getInstance() {
        return TXCLiveBGMPlayer$a.a();
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
            if (object != null) {
                object = ((Reference)object).get();
                object = (g)object;
            } else {
                object = null;
            }
        }
        Handler handler = this.mHandler;
        TXCLiveBGMPlayer$2 tXCLiveBGMPlayer$2 = new TXCLiveBGMPlayer$2(this, (g)object, n10);
        handler.post((Runnable)tXCLiveBGMPlayer$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPlayProgress(long l10, long l11) {
        WeakReference weakReference;
        Object object;
        synchronized (this) {
            object = this.mWeakListener;
            if (object != null) {
                object = ((Reference)object).get();
                object = (g)object;
            } else {
                object = null;
            }
            weakReference = object;
        }
        object = this.mHandler;
        TXCLiveBGMPlayer$3 tXCLiveBGMPlayer$3 = new TXCLiveBGMPlayer$3(this, (g)((Object)weakReference), l10, l11);
        object.post((Runnable)tXCLiveBGMPlayer$3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onPlayStart(int n10) {
        Object object;
        synchronized (this) {
            object = this.mWeakListener;
            if (object != null) {
                object = ((Reference)object).get();
                object = (g)object;
            } else {
                object = null;
            }
        }
        Handler handler = this.mHandler;
        TXCLiveBGMPlayer$1 tXCLiveBGMPlayer$1 = new TXCLiveBGMPlayer$1(this, (g)object);
        handler.post((Runnable)tXCLiveBGMPlayer$1);
    }

    public int getBGMDuration(String string2) {
        return (int)TXAudioEffectManagerImpl.getInstance().getMusicDurationInMS(string2);
    }

    public long getBGMGetCurrentProgressInMs(String object) {
        if (object == null) {
            object = TXAudioEffectManagerImpl.getInstance();
            int n10 = this.mBGMId;
            return ((TXAudioEffectManagerImpl)object).getMusicCurrentPosInMS(n10);
        }
        return 0L;
    }

    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public boolean isRunning() {
        boolean bl2 = this.mIsRunning;
        bl2 = bl2 && !(bl2 = this.mIsPause);
        return bl2;
    }

    public void onComplete(int n10, int n11) {
        this.onPlayEnd(n11);
    }

    public void onPlayProgress(int n10, long l10, long l11) {
        this.onPlayProgress(l10, l11);
    }

    public void onStart(int n10, int n11) {
        this.onPlayStart(n11);
    }

    public boolean pause() {
        boolean bl2;
        TXCLog.i(TAG, "pause");
        this.mIsPause = bl2 = true;
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.pausePlayMusic(n10);
        return bl2;
    }

    public boolean resume() {
        TXCLog.i(TAG, "resume");
        this.mIsPause = false;
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.resumePlayMusic(n10);
        return true;
    }

    public void setBGMPosition(int n10) {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n11 = this.mBGMId;
        tXAudioEffectManagerImpl.seekMusicToPosInMS(n11, n10);
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

    public void setPitch(float f10) {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.setMusicPitch(n10, f10);
    }

    public boolean setPlayoutVolume(float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setPlayoutVolume:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        object = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        int n11 = (int)(f10 * 100.0f);
        ((TXAudioEffectManagerImpl)object).setMusicPlayoutVolume(n10, n11);
        return true;
    }

    public boolean setPublishVolume(float f10) {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        int n11 = (int)(f10 * 100.0f);
        tXAudioEffectManagerImpl.setMusicPublishVolume(n10, n11);
        return true;
    }

    public boolean setVolume(float f10) {
        TXCLog.i(TAG, "setVolume");
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        int n11 = (int)(f10 * 100.0f);
        tXAudioEffectManagerImpl.setMusicVolume(n10, n11);
        return true;
    }

    public boolean startPlay(String string2) {
        boolean bl2;
        String string3 = TAG;
        StringBuilder stringBuilder = null;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            this.mIsRunning = bl2 = true;
            int n10 = this.mBGMId;
            TXAudioEffectManager$AudioMusicParam tXAudioEffectManager$AudioMusicParam = new TXAudioEffectManager$AudioMusicParam(n10, string2);
            tXAudioEffectManager$AudioMusicParam.publish = bl2;
            tXAudioEffectManager$AudioMusicParam.loopCount = 0;
            boolean bl3 = TXAudioEffectManagerImpl.getInstance().startPlayMusic(tXAudioEffectManager$AudioMusicParam);
            TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
            int n11 = this.mBGMId;
            tXAudioEffectManagerImpl.setMusicObserver(n11, this);
            if (!bl3) {
                this.onPlayEnd(-1);
                return false;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("start bgm play : filePath = ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            TXCLog.i(string3, string2);
            return bl2;
        }
        TXCLog.e(string3, "start live bgm failed! invalid params!");
        return false;
    }

    public void stopAll() {
        TXAudioEffectManagerImpl.getInstance().stopAllMusics();
        TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
        TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
    }

    public boolean stopPlay() {
        this.mIsRunning = false;
        long l10 = System.currentTimeMillis();
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        int n10 = this.mBGMId;
        tXAudioEffectManagerImpl.setMusicObserver(n10, null);
        tXAudioEffectManagerImpl = TXAudioEffectManagerImpl.getInstance();
        n10 = this.mBGMId;
        tXAudioEffectManagerImpl.stopPlayMusic(n10);
        this.mIsPause = false;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("stopBGMPlay cost(MS): ");
        long l11 = System.currentTimeMillis() - l10;
        charSequence.append(l11);
        charSequence = charSequence.toString();
        TXCLog.i(TAG, (String)charSequence);
        return true;
    }
}

