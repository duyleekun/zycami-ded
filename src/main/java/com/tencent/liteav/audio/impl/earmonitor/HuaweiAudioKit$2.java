/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.earmonitor;

import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;
import com.tencent.liteav.basic.log.TXCLog;

public class HuaweiAudioKit$2
implements Runnable {
    public final /* synthetic */ HuaweiAudioKit a;

    public HuaweiAudioKit$2(HuaweiAudioKit huaweiAudioKit) {
        this.a = huaweiAudioKit;
    }

    public void run() {
        TXCLog.i("HuaweiAudioKit", "uninitialize");
        Object object = HuaweiAudioKit.access$300(this.a);
        if (object != null) {
            HuaweiAudioKit.access$300(this.a).l();
            object = this.a;
            HuaweiAudioKit.access$302((HuaweiAudioKit)object, null);
        }
        if ((object = HuaweiAudioKit.access$000(this.a)) != null) {
            HuaweiAudioKit.access$000(this.a).m();
            object = this.a;
            HuaweiAudioKit.access$002((HuaweiAudioKit)object, null);
        }
        HuaweiAudioKit.access$102(this.a, false);
    }
}

