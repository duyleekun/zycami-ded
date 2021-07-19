/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.Play;

import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;

public class TXCMultAudioTrackPlayer$AudioTrackThread
extends Thread {
    public volatile boolean mIsLooping;
    public final /* synthetic */ TXCMultAudioTrackPlayer this$0;

    public TXCMultAudioTrackPlayer$AudioTrackThread(TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer, String string2) {
        this.this$0 = tXCMultAudioTrackPlayer;
        super(string2);
        this.mIsLooping = false;
    }

    public void startLoop() {
        this.mIsLooping = true;
    }

    public void stopLoop() {
        this.mIsLooping = false;
    }
}

