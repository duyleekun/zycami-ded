/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.HashMap;

public final class TXAudioEffectManagerImpl$4
implements Runnable {
    public final /* synthetic */ int val$errCode;
    public final /* synthetic */ long val$id;

    public TXAudioEffectManagerImpl$4(long l10, int n10) {
        this.val$id = l10;
        this.val$errCode = n10;
    }

    public void run() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onEffectStart -> effect id = ");
        long l10 = this.val$id;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(", errCode = ");
        int n10 = this.val$errCode;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i("AudioCenter:TXAudioEffectManager", (String)object);
        object = TXAudioEffectManagerImpl.access$600();
        l10 = this.val$id;
        Long l11 = l10;
        object = ((HashMap)object).get(l11);
        if (object != null) {
            object = TXAudioEffectManagerImpl.access$600();
            l11 = this.val$id;
            object = (TXAudioEffectManager$TXMusicPlayObserver)((HashMap)object).get(l11);
            l10 = this.val$id;
            n10 = (int)l10;
            int n11 = this.val$errCode;
            object.onStart(n10, n11);
        }
    }
}

