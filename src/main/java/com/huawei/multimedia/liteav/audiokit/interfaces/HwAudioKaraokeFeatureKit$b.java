/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.os.IBinder;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.tencent.liteav.basic.log.TXCLog;

public class HwAudioKaraokeFeatureKit$b
implements IBinder.DeathRecipient {
    public final /* synthetic */ HwAudioKaraokeFeatureKit a;

    public HwAudioKaraokeFeatureKit$b(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        this.a = hwAudioKaraokeFeatureKit;
    }

    public void binderDied() {
        TXCLog.e("HwAudioKit.HwAudioKaraokeFeatureKit", "binderDied");
        IBinder iBinder = HwAudioKaraokeFeatureKit.i(this.a);
        IBinder.DeathRecipient deathRecipient = HwAudioKaraokeFeatureKit.h(this.a);
        iBinder.unlinkToDeath(deathRecipient, 0);
        HwAudioKaraokeFeatureKit.d(this.a).f(1003);
        HwAudioKaraokeFeatureKit.j(this.a, null);
    }
}

