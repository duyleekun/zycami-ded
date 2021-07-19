/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.os.IBinder;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.tencent.liteav.basic.log.TXCLog;

public class HwAudioKit$b
implements IBinder.DeathRecipient {
    public final /* synthetic */ HwAudioKit a;

    public HwAudioKit$b(HwAudioKit hwAudioKit) {
        this.a = hwAudioKit;
    }

    public void binderDied() {
        IBinder iBinder = HwAudioKit.i(this.a);
        IBinder.DeathRecipient deathRecipient = HwAudioKit.h(this.a);
        iBinder.unlinkToDeath(deathRecipient, 0);
        HwAudioKit.d(this.a).f(6);
        TXCLog.e("HwAudioKit.HwAudioKit", "service binder died");
        HwAudioKit.j(this.a, null);
    }
}

