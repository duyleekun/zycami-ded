/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.audio.impl.earmonitor;

import android.content.Context;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.a;
import com.tencent.liteav.basic.log.TXCLog;

public class HuaweiAudioKit$1
implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ HuaweiAudioKit c;

    public HuaweiAudioKit$1(HuaweiAudioKit huaweiAudioKit, a a10, Context context) {
        this.c = huaweiAudioKit;
        this.a = a10;
        this.b = context;
    }

    public void run() {
        Object object = HuaweiAudioKit.access$000(this.c);
        Object object2 = "HuaweiAudioKit";
        if (object != null) {
            TXCLog.e((String)object2, "it's already initialized.");
            return;
        }
        TXCLog.i((String)object2, "start initialize audio kit");
        HuaweiAudioKit.access$102(this.c, true);
        object = this.c;
        object2 = this.a;
        HuaweiAudioKit.access$202((HuaweiAudioKit)object, (a)object2);
        object = this.c;
        Context context = this.b.getApplicationContext();
        HuaweiAudioKit huaweiAudioKit = this.c;
        object2 = new HwAudioKit(context, huaweiAudioKit);
        HuaweiAudioKit.access$002((HuaweiAudioKit)object, (HwAudioKit)object2);
        HuaweiAudioKit.access$000(this.c).o();
    }
}

