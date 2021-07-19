/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

public class TXAudioEffectManagerImpl$AudioEffectManagerCacheHolder {
    private static final TXAudioEffectManagerImpl INSTANCE;

    static {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl;
        INSTANCE = tXAudioEffectManagerImpl = new TXAudioEffectManagerImpl(2, null);
    }

    private TXAudioEffectManagerImpl$AudioEffectManagerCacheHolder() {
    }

    public static /* synthetic */ TXAudioEffectManagerImpl access$200() {
        return INSTANCE;
    }
}

