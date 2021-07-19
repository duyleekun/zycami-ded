/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.tencent.qq;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.tencent.qq.b;
import com.mob.tools.log.NLog;

public class b$1
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public b$1(b b10, String string2) {
        this.b = b10;
        this.a = string2;
    }

    public void run() {
        b b10 = this.b;
        Object object = this.a;
        try {
            b10.onComplete((String)object);
        }
        catch (Throwable throwable) {
            object = SSDKLog.b();
            ((NLog)object).d(throwable);
        }
    }
}

