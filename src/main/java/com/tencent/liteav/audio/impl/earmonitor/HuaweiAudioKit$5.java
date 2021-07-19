/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.earmonitor;

import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;

public class HuaweiAudioKit$5
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ HuaweiAudioKit b;

    public HuaweiAudioKit$5(HuaweiAudioKit huaweiAudioKit, int n10) {
        this.b = huaweiAudioKit;
        this.a = n10;
    }

    public void run() {
        HuaweiAudioKit huaweiAudioKit = this.b;
        int n10 = this.a;
        HuaweiAudioKit.access$800(huaweiAudioKit, n10);
    }
}

