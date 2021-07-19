/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qzone.a;
import com.mob.tools.log.NLog;

public class a$1
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ a b;

    public a$1(a a10, String string2) {
        this.b = a10;
        this.a = string2;
    }

    public void run() {
        a a10 = this.b;
        Object object = this.a;
        try {
            a10.onComplete((String)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
        }
    }
}

