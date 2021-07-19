/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;

public class c$1
extends Thread {
    public final /* synthetic */ c a;

    public c$1(c c10) {
        this.a = c10;
    }

    public void run() {
        c c10 = this.a;
        boolean bl2 = MobSDK.isForb();
        try {
            c.a(c10, bl2);
        }
        catch (Throwable throwable) {
            NLog nLog = SSDKLog.b();
            nLog.w(throwable);
        }
    }
}

