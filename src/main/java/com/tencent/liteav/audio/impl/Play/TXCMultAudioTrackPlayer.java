/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer$1;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer$AudioTrackThread;
import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer$TXCMultAudioTrackPlayerHolder;
import com.tencent.liteav.basic.log.TXCLog;

public class TXCMultAudioTrackPlayer {
    private static final String TAG;
    private int mAudioMode = 0;
    private TXCMultAudioTrackPlayer$AudioTrackThread mAudioThread = null;
    private volatile boolean mAudioTrackStarted = false;
    private int mBits = 16;
    private int mChannel = 2;
    private Context mContext = null;
    private volatile boolean mIsStarted = false;
    private boolean mMute = false;
    private int mSampleRate = 48000;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioCenter:");
        String string2 = TXCMultAudioTrackPlayer.class.getSimpleName();
        stringBuilder.append(string2);
        TAG = stringBuilder.toString();
    }

    private TXCMultAudioTrackPlayer() {
        this.nativeClassInit();
    }

    public /* synthetic */ TXCMultAudioTrackPlayer(TXCMultAudioTrackPlayer$1 var1_1) {
        this();
    }

    public static /* synthetic */ int access$100(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mChannel;
    }

    public static /* synthetic */ int access$200(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mBits;
    }

    public static /* synthetic */ int access$300(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mSampleRate;
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ boolean access$502(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer, boolean bl2) {
        tXCMultAudioTrackPlayer.mAudioTrackStarted = bl2;
        return bl2;
    }

    public static /* synthetic */ Context access$600(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mContext;
    }

    public static /* synthetic */ int access$700(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mAudioMode;
    }

    public static /* synthetic */ byte[] access$800(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.nativeGetMixedTracksDataToAudioTrack();
    }

    public static /* synthetic */ boolean access$900(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer) {
        return tXCMultAudioTrackPlayer.mMute;
    }

    public static TXCMultAudioTrackPlayer getInstance() {
        return TXCMultAudioTrackPlayer$TXCMultAudioTrackPlayerHolder.getInstance();
    }

    private native void nativeClassInit();

    private native byte[] nativeGetMixedTracksDataToAudioTrack();

    public boolean isPlaying() {
        return this.mIsStarted;
    }

    public void setAudioMode(Context object, int n10) {
        synchronized (this) {
            this.mContext = object;
            this.mAudioMode = n10;
            boolean bl2 = this.mAudioTrackStarted;
            if (bl2) {
                object = TAG;
                String string2 = "mult-track-player setAudioRoute~";
                TXCLog.w((String)object, string2);
            } else {
                object = TAG;
                String string3 = "mult-track-player do'not setAudioRoute~";
                TXCLog.w((String)object, string3);
            }
            return;
        }
    }

    public void setMute(boolean bl2) {
        this.mMute = bl2;
    }

    public void start() {
        String string2 = TAG;
        Object object = "mult-track-player start!";
        TXCLog.w(string2, (String)object);
        int n10 = this.mIsStarted;
        if (n10 != 0) {
            TXCLog.e(string2, "mult-track-player can not start because of has started!");
            return;
        }
        n10 = this.mSampleRate;
        if (n10 != 0 && (n10 = this.mChannel) != 0) {
            n10 = 1;
            this.mIsStarted = n10;
            object = this.mAudioThread;
            if (object == null) {
                String string3 = "AUDIO_TRACK";
                this.mAudioThread = object = new TXCMultAudioTrackPlayer$1(this, string3);
                ((TXCMultAudioTrackPlayer$AudioTrackThread)object).startLoop();
                object = this.mAudioThread;
                ((Thread)object).start();
            }
            TXCLog.w(string2, "mult-track-player thread start finish!");
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("strat mult-track-player failed with invalid audio info , samplerate:");
        int n11 = this.mSampleRate;
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(", channels:");
        n11 = this.mChannel;
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        TXCLog.e(string2, (String)object);
    }

    public void stop() {
        String string2 = TAG;
        Object object = "mult-track-player stop!";
        TXCLog.w(string2, (String)object);
        boolean bl2 = this.mIsStarted;
        if (!bl2) {
            TXCLog.w(string2, "mult-track-player can not stop because of not started yet!");
            return;
        }
        object = this.mAudioThread;
        if (object != null) {
            ((TXCMultAudioTrackPlayer$AudioTrackThread)object).stopLoop();
            this.mAudioThread = null;
        }
        this.mAudioMode = 0;
        this.mContext = null;
        this.mAudioTrackStarted = false;
        this.mIsStarted = false;
        TXCLog.w(string2, "mult-track-player stop finish!");
    }
}

