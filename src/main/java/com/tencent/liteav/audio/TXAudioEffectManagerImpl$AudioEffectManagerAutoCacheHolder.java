/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

public class TXAudioEffectManagerImpl$AudioEffectManagerAutoCacheHolder {
    private static final TXAudioEffectManagerImpl INSTANCE;

    static {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl;
        INSTANCE = tXAudioEffectManagerImpl = new TXAudioEffectManagerImpl(1, null);
    }

    private TXAudioEffectManagerImpl$AudioEffectManagerAutoCacheHolder() {
    }

    public static /* synthetic */ TXAudioEffectManagerImpl access$300() {
        return INSTANCE;
    }
}

