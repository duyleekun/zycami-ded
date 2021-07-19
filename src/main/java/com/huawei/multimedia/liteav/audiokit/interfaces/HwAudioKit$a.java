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
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import d.j.e.a.a.a;
import d.j.e.a.a.a$a;

public class HwAudioKit$a
implements ServiceConnection {
    public final /* synthetic */ HwAudioKit a;

    public HwAudioKit$a(HwAudioKit hwAudioKit) {
        this.a = hwAudioKit;
    }

    public void onServiceConnected(ComponentName object, IBinder iBinder) {
        object = this.a;
        Object object2 = a$a.o(iBinder);
        HwAudioKit.b((HwAudioKit)object, (a)object2);
        object = "HwAudioKit.HwAudioKit";
        TXCLog.i((String)object, "onServiceConnected");
        object2 = HwAudioKit.a(this.a);
        if (object2 != null) {
            object2 = this.a;
            boolean bl2 = true;
            HwAudioKit.c((HwAudioKit)object2, bl2);
            TXCLog.i((String)object, "onServiceConnected, mIHwAudioEngine is not null");
            HwAudioKit.d(this.a).f(0);
            object = this.a;
            object2 = HwAudioKit.e((HwAudioKit)object).getPackageName();
            String string2 = "1.0.1";
            HwAudioKit.f((HwAudioKit)object, (String)object2, string2);
            object = this.a;
            HwAudioKit.g((HwAudioKit)object, iBinder);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        TXCLog.i("HwAudioKit.HwAudioKit", "onServiceDisconnected");
        HwAudioKit.b(this.a, null);
        HwAudioKit.c(this.a, false);
        HwAudioKit.d(this.a).f(4);
    }
}

