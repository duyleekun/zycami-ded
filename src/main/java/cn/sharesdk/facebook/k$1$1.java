/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Instrumentation
 */
package cn.sharesdk.facebook;

import android.app.Instrumentation;
import cn.sharesdk.facebook.k;
import cn.sharesdk.facebook.k$1;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;

public class k$1$1
extends Thread {
    public final /* synthetic */ k$1 a;

    public k$1$1(k$1 var1_1) {
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
            PlatformActionListener platformActionListener = k.a(this.a.a);
            n10 = 0;
            platformActionListener.onCancel(null, 0);
        }
    }
}

