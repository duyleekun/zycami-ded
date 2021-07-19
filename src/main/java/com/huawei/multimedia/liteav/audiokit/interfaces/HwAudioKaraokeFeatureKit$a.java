/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.tencent.liteav.basic.log.TXCLog;
import d.j.e.a.a.b;
import d.j.e.a.a.b$a;

public class HwAudioKaraokeFeatureKit$a
implements ServiceConnection {
    public final /* synthetic */ HwAudioKaraokeFeatureKit a;

    public HwAudioKaraokeFeatureKit$a(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        this.a = hwAudioKaraokeFeatureKit;
    }

    public void onServiceConnected(ComponentName object, IBinder iBinder) {
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceConnected");
        object = this.a;
        Object object2 = b$a.o(iBinder);
        HwAudioKaraokeFeatureKit.b((HwAudioKaraokeFeatureKit)object, (b)object2);
        object = HwAudioKaraokeFeatureKit.a(this.a);
        if (object != null) {
            HwAudioKaraokeFeatureKit.c(this.a, true);
            object = HwAudioKaraokeFeatureKit.d(this.a);
            int n10 = 1000;
            ((d.j.e.a.b.b.b)object).f(n10);
            object = this.a;
            object2 = HwAudioKaraokeFeatureKit.e((HwAudioKaraokeFeatureKit)object).getPackageName();
            HwAudioKaraokeFeatureKit.f((HwAudioKaraokeFeatureKit)object, (String)object2);
            object = this.a;
            HwAudioKaraokeFeatureKit.g((HwAudioKaraokeFeatureKit)object, iBinder);
        }
    }

    public void onServiceDisconnected(ComponentName object) {
        TXCLog.i("HwAudioKit.HwAudioKaraokeFeatureKit", "onServiceDisconnected");
        object = this.a;
        int n10 = 0;
        HwAudioKaraokeFeatureKit.c((HwAudioKaraokeFeatureKit)object, false);
        object = HwAudioKaraokeFeatureKit.d(this.a);
        if (object != null) {
            object = HwAudioKaraokeFeatureKit.d(this.a);
            n10 = 1001;
            ((d.j.e.a.b.b.b)object).f(n10);
        }
    }
}

