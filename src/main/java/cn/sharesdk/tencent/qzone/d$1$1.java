/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Instrumentation
 */
package cn.sharesdk.tencent.qzone;

import android.app.Instrumentation;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.d;
import cn.sharesdk.tencent.qzone.d$1;

public class d$1$1
extends Thread {
    public final /* synthetic */ d$1 a;

    public d$1$1(d$1 var1_1) {
        this.a = var1_1;
    }

    public void run() {
        Instrumentation instrumentation = new Instrumentation();
        int n10 = 4;
        try {
            instrumentation.sendKeyDownUpSync(n10);
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            this.a.a.finish();
            PlatformActionListener platformActionListener = d.a(this.a.a);
            n10 = 0;
            platformActionListener.onCancel(null, 0);
        }
    }
}

