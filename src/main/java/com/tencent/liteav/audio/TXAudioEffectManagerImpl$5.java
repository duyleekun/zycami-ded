/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import java.util.HashMap;

public final class TXAudioEffectManagerImpl$5
implements Runnable {
    public final /* synthetic */ long val$curPtsMS;
    public final /* synthetic */ long val$durationMS;
    public final /* synthetic */ long val$id;

    public TXAudioEffectManagerImpl$5(long l10, long l11, long l12) {
        this.val$id = l10;
        this.val$curPtsMS = l11;
        this.val$durationMS = l12;
    }

    public void run() {
        HashMap hashMap = TXAudioEffectManagerImpl.access$600();
        long l10 = this.val$id;
        Object object = l10;
        if ((hashMap = hashMap.get(object)) != null) {
            hashMap = TXAudioEffectManagerImpl.access$600();
            l10 = this.val$id;
            object = l10;
            hashMap = hashMap.get(object);
            object = hashMap;
            object = (TXAudioEffectManager$TXMusicPlayObserver)((Object)hashMap);
            long l11 = this.val$id;
            int n10 = (int)l11;
            long l12 = this.val$curPtsMS;
            long l13 = this.val$durationMS;
            object.onPlayProgress(n10, l12, l13);
        }
    }
}

