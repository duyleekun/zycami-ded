/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;

public class TXAudioEffectManagerImpl$AudioEffectManagerHolder {
    private static final TXAudioEffectManagerImpl INSTANCE;

    static {
        TXAudioEffectManagerImpl tXAudioEffectManagerImpl;
        INSTANCE = tXAudioEffectManagerImpl = new TXAudioEffectManagerImpl(0, null);
    }

    private TXAudioEffectManagerImpl$AudioEffectManagerHolder() {
    }

    public static /* synthetic */ TXAudioEffectManagerImpl access$100() {
        return INSTANCE;
    }
}

