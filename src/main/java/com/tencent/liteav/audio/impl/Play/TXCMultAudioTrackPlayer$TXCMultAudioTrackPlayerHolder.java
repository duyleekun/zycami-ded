/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.Play;

import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;

public class TXCMultAudioTrackPlayer$TXCMultAudioTrackPlayerHolder {
    private static TXCMultAudioTrackPlayer instance;

    static {
        TXCMultAudioTrackPlayer tXCMultAudioTrackPlayer;
        instance = tXCMultAudioTrackPlayer = new TXCMultAudioTrackPlayer(null);
    }

    private TXCMultAudioTrackPlayer$TXCMultAudioTrackPlayerHolder() {
    }

    public static TXCMultAudioTrackPlayer getInstance() {
        return instance;
    }
}

