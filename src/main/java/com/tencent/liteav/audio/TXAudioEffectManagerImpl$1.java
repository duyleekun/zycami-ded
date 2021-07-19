/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.basic.log.TXCLog;

public class TXAudioEffectManagerImpl$1
implements Runnable {
    public final /* synthetic */ TXAudioEffectManagerImpl this$0;
    public final /* synthetic */ int val$id;
    public final /* synthetic */ TXAudioEffectManager$TXMusicPlayObserver val$observer;

    public TXAudioEffectManagerImpl$1(TXAudioEffectManagerImpl tXAudioEffectManagerImpl, TXAudioEffectManager$TXMusicPlayObserver tXAudioEffectManager$TXMusicPlayObserver, int n10) {
        this.this$0 = tXAudioEffectManagerImpl;
        this.val$observer = tXAudioEffectManager$TXMusicPlayObserver;
        this.val$id = n10;
    }

    public void run() {
        Object object;
        Object object2 = this.val$observer;
        if (object2 == null) {
            object2 = TXAudioEffectManagerImpl.access$600();
            int n10 = TXAudioEffectManagerImpl.access$400(this.this$0);
            int n11 = this.val$id;
            long l10 = TXAudioEffectManagerImpl.access$500(n10, n11);
            Long l11 = l10;
            object2.remove(l11);
        } else {
            object2 = TXAudioEffectManagerImpl.access$600();
            int n12 = TXAudioEffectManagerImpl.access$400(this.this$0);
            int n13 = this.val$id;
            long l12 = TXAudioEffectManagerImpl.access$500(n12, n13);
            Long l13 = l12;
            object = this.val$observer;
            object2.put(l13, object);
        }
        object2 = new Object[]{object = Integer.valueOf(TXAudioEffectManagerImpl.access$600().size())};
        TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", object2);
    }
}

