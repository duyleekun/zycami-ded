/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.twitter;

import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.twitter.b;
import com.mob.tools.log.NLog;

public class b$2
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;

    public b$2(b b10, String string2) {
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

