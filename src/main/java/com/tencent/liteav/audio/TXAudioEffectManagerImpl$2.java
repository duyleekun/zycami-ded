/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import java.util.HashMap;

public class TXAudioEffectManagerImpl$2
implements Runnable {
    public final /* synthetic */ TXAudioEffectManagerImpl this$0;
    public final /* synthetic */ long val$finalId;

    public TXAudioEffectManagerImpl$2(TXAudioEffectManagerImpl tXAudioEffectManagerImpl, long l10) {
        this.this$0 = tXAudioEffectManagerImpl;
        this.val$finalId = l10;
    }

    public void run() {
        HashMap hashMap = TXAudioEffectManagerImpl.access$600();
        Long l10 = this.val$finalId;
        hashMap.remove(l10);
    }
}

